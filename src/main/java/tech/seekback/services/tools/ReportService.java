package tech.seekback.services.tools;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author gkentaurus
 */

@Stateless
public class ReportService {



  public void generateReport(JasperDesign design, Collection<?> collection) throws JRException, IOException {

    JasperReport report = JasperCompileManager.compileReport(design);
    HashMap<String, Object> parameters = new HashMap<>();

    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
    hsr.addHeader("Content-disposition", "attachment; filename=reporte.pdf");

    OutputStream os = hsr.getOutputStream();

//    JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(collection));
//    JasperExportManager.exportReportToPdfFile(jasperPrint, String.valueOf(os));

    JasperFillManager.fillReportToStream(report, os, parameters, new JRBeanCollectionDataSource(collection));
    os.flush();
    os.close();
    fc.responseComplete();
  }
}
