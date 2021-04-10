package tech.seekback.services.tools;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import tech.seekback.builders.JasperReports.*;
import tech.seekback.enums.JasperReports.OrientationEnum;
import tech.seekback.enums.JasperReportsEnum;
import tech.seekback.models.Usuario;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author gkentaurus
 */

@Stateless
public class ReportService {

  private JasperPrint jasperPrint;
  private JasperDesign design;
  private File jasperFile;
  private FacesContext fc;
  private ExternalContext ec;

  public void setDesign(JasperDesign design) {
    this.design = design;
  }

  /**
   * La estructura del array debe ser la siguiente:
   * [0] String: Nombre de la columna del como se quiere mostrar (entre mas corto, mejor)
   * [1] String: Nombre de la variable de la DATA (Colección de los DAOJPA)
   * [2] String: XXXXX.class.getName() donde XXXXX es la clase del tipo de dato que viene de la DATA
   * [3] String: Ancho de la columna
   *
   * @param columnValues
   * @throws JRException
   */
  private void JasperReportMaker(List<String[]> columnValues, String nombreReporte) throws JRException {
    JasperDesignBuilder designBuilder = JasperDesignBuilder.start();
    designBuilder.defaultSettings("name", OrientationEnum.VERTICAL_ORIENTATION);

    JRDesignStyle detailStyle = JasperStyleBuilder
      .start()
      .defaultSettings("detailStyle", 12f, true)
      .getStyle();

    JRDesignStyle columnStyle = JasperStyleBuilder
      .start()
      .defaultSettings("columnStyle", 15f, false)
      .getStyle();

    designBuilder.addStyle(detailStyle);
    designBuilder.addStyle(columnStyle);

    JasperBandBuilder columnHeader = JasperBandBuilder
      .start()
      .defaultSettings(JasperReportsEnum.SUBTITLE);

    JasperBandBuilder detailBand = JasperBandBuilder
      .start()
      .defaultSettings(20);

    JasperBandBuilder titleBandBuilder = JasperBandBuilder
      .start()
      .defaultSettings(JasperReportsEnum.TITLE);

    JasperStaticTextCommonBuilder titleText = JasperStaticTextCommonBuilder
      .start()
      .resetColumnStart()
      .defaultSettings(designBuilder.getColumnWidth(), 10, nombreReporte, JasperReportsEnum.TITLE);

    titleBandBuilder.addElement(titleText.getText());
    designBuilder.setTitle(titleBandBuilder.getBand());

    for (int i = 0; i < columnValues.size(); i++) {
      String[] column = columnValues.get(i);
      designBuilder.addField(JasperFieldBuilder
        .start()
        .setCompleteField(column[1], column[2])
        .getField());

      if (i == 0) {
        columnHeader.addElement(JasperStaticTextColumnBuilder
          .start()
          .resetColumnStart()
          .defaultSettings(Integer.parseInt(column[3]), 5, column[0], JasperReportsEnum.SUBTITLE, 0)
          .setFontSize(12f)
          .setStyle(columnStyle)
          .getText());

        detailBand.addElement(JasperTextFieldBuilder
          .start()
          .resetColumnStart()
          .defaultSettings(Integer.parseInt(column[3]), column[1], 0)
          .setStyle(detailStyle)
          .getText());
      } else {
        columnHeader.addElement(JasperStaticTextColumnBuilder
          .start()
          .defaultSettings(Integer.parseInt(column[3]), 0, column[0], JasperReportsEnum.SUBTITLE)
          .setFontSize(12f)
          .setStyle(columnStyle)
          .getText());

        detailBand.addElement(JasperTextFieldBuilder
          .start()
          .defaultSettings(Integer.parseInt(column[3]), column[1])
          .setStyle(detailStyle)
          .getText());
      }
    }

    designBuilder
      .addDetailBand(detailBand.getBand())
      .addColumnBand(columnHeader.getBand());

    this.design = designBuilder.getDesign();
  }

  private void generateReport(Collection<?> collection) throws JRException {
    JasperReport report = JasperCompileManager.compileReport(this.design);
    HashMap<String, Object> parameters = new HashMap<>();
    this.jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(collection));
  }

  public void exportPdfOnLocalDisk(String nombreReporte, List<String[]> columnValues, Collection<?> collection) throws JRException {
    this.JasperReportMaker(columnValues, nombreReporte);
    this.generateReport(collection);
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(this.jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\reporte.pdf"));
    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    exporter.setConfiguration(configuration);
    exporter.exportReport();
  }

  private void initializeInstances() {
    this.fc = FacesContext.getCurrentInstance();
    this.ec = fc.getExternalContext();
  }

  public void exportPdfOnWeb(String reportName, List<String[]> columnValues, Collection<?> collection) throws JRException, IOException {
    this.JasperReportMaker(columnValues, reportName);
    this.generateReport(collection);
    this.initializeInstances();
    this.response(fc, ec);
  }

  private void response(FacesContext fc, ExternalContext ec) throws IOException, JRException {
    HttpServletResponse response = (HttpServletResponse) ec.getResponse();
    Date now = new Date();
    response.addHeader("Content-disposition", "attachment; filename=report-" + now.getTime() + ".pdf");
    OutputStream outputStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(this.jasperPrint, outputStream);
    outputStream.flush();
    outputStream.close();
    fc.responseComplete();
  }

  public void exportPdfOnWeb(String templateName, Collection<?> collection, Usuario usuario) throws JRException, IOException {
    this.initializeInstances();
    this.jasperFile = new File(ec.getRealPath("/WEB-INF/reports/" + templateName + ".jasper"));
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("logo", ec.getRealPath("/WEB-INF/reports/seekback-logo.png"));
    parameters.put("NAME_USER", usuario.getPrimerNombre() + " " + usuario.getPrimerApellido());
    parameters.put("DATE_REPORT", new Date());
    this.jasperPrint = JasperFillManager.fillReport(this.jasperFile.getPath(), parameters, new JRBeanCollectionDataSource(collection));
    this.response(fc, ec);
  }

  public void exportPdfOnWeb(String templateName, Collection<?> collection) throws JRException, IOException {
    this.initializeInstances();
    this.jasperFile = new File(ec.getRealPath("/WEB-INF/reports/" + templateName + ".jasper"));
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("logo", ec.getRealPath("/WEB-INF/reports/logo.png"));
    parameters.put("DATE_REPORT", new Date());
    this.jasperPrint = JasperFillManager.fillReport(this.jasperFile.getPath(), parameters, new JRBeanCollectionDataSource(collection));
    this.response(fc, ec);
  }
}
