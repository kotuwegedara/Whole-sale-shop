/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.views.utl;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Nawanjana
 */
public class ReportTester {

       
    public static void main(String[] args){
        
        try {
            //JasperReport compiledReport = JasperCompileManager.compileReport(ReportTester.class.getResourceAsStream("/lk/ijse/jasperreport1/reports/Hello_Jasper.jrxml"));
            
//            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(ReportTester.class.getResourceAsStream("/lk/ijse/jasperreport1/reports/Hello_Jasper.jrxml"));
//            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, new HashMap<String, Object>(), new JREmptyDataSource());
//            
//            JasperReportViewer myViewer = new JasperReportViewer(filledReport);
//            myViewer.setVisible(true);
            Class.forName("com.mysql.jdbc.Driver");
       
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Company" , "root" , "amilanuwan");
    
            
            JasperReport MainReport = (JasperReport) JRLoader.loadObject(ReportTester.class.getResourceAsStream("/lk/ijse/thogakade/reports/AddCustomerReport.jasper"));
//            JasperReport SubReport = (JasperReport) JRLoader.loadObject(ReportTester.class.getResourceAsStream("/lk/ijse/jasperreport1/reports/Hello_Report.jasper"));
            
            HashMap<String, Object> params = new HashMap<>();
//            params.put("SubReport",SubReport);
            
            JasperPrint filledReport = JasperFillManager.fillReport(MainReport, params, new JREmptyDataSource());
            JasperReportViewer myViewer = new JasperReportViewer(filledReport);
            myViewer.setVisible(true);

            //JasperViewer.viewReport(filledReport);
        } catch (JRException ex) {
            Logger.getLogger(ReportTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
