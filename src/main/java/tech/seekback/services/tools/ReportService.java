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

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author gkentaurus
 */

@Stateless
public class ReportService {

  private JasperPrint jasperPrint;
  private JasperDesign design;

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
  public void JasperReportMaker(List<String[]> columnValues, String nombreReporte) throws JRException {
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
          .defaultSettings(Integer.parseInt(column[3]), 10, column[0], JasperReportsEnum.SUBTITLE, 0)
          .setFontSize(12f)
          .setStyle(columnStyle)
          .getText());

        detailBand.addElement(JasperTextFieldBuilder
          .start()
          .defaultSettings(Integer.parseInt(column[3]), column[1], 0)
          .setStyle(detailStyle)
          .getText());
      } else {
        columnHeader.addElement(JasperStaticTextColumnBuilder
          .start()
          .defaultSettings(Integer.parseInt(column[3]), 10, column[0], JasperReportsEnum.SUBTITLE)
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

  public void generateReport(Collection<?> collection) throws JRException {
    JasperReport report = JasperCompileManager.compileReport(this.design);
    HashMap<String, Object> parameters = new HashMap<>();
    this.jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(collection));
  }

  public void exportPdfOnLocalDisk() throws JRException {
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(this.jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\reporte.pdf"));
    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    exporter.setConfiguration(configuration);
    exporter.exportReport();
  }

  public void exportPdfOnWeb() throws JRException, IOException {
    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    HttpServletResponse response = (HttpServletResponse) ec.getResponse();
    Date now = new Date();
    response.addHeader("Content-disposition", "attachment; filename=report-" + now.getTime() + ".pdf");
    OutputStream outputStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(this.jasperPrint, outputStream);
    outputStream.flush();
    outputStream.close();
    fc.responseComplete();
  }
}
