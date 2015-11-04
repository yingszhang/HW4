
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Products;

/**
 *
 * @author Shuo
 */
public class SearchQuery {
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
    Properties props = new Properties();//MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String PRODUCTNAME){
        
        try {
            String query = "SELECT * FROM PRODUCT WHERE UPPER(PRODUCTNAME) LIKE ? ORDER BY PRODUCTID ASC";
            
            PreparedStatement ps = conn. prepareStatement(query);
            ps.setString(1, "%" + PRODUCTNAME.toUpperCase() + "%");
            this.results = ps. executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        
        
        
    
    
    }
    
    public String getHTMLTable(){
        
        String table = "";
        table += "<table>";
        table += "<tr>";
                table += "<th>";
                table += "Product ID";
                table += "</th>";
                
                table += "<th>";
                table += "Product Name";
                table += "</th>";
           
                table += "<th>";
                table += "Price";
                table += "</th>";
                
                table += "<th>";
                table += "Unit in Stock";
                table += "</th>";
                
                table += "<th>";
                table += "";
                table += "</th>";
                
                table += "</tr>";
                
                
        
        try {
            while(this.results.next()){
                
                Products product =new Products();
                product.setPRODUCTID(this.results.getInt("PRODUCTID"));
                product.setPRODUCTNAME(this.results.getString("PRODUCTNAME"));
                product.setPRICE(this.results.getDouble("PRICE"));
                product.setUNITINSTOCK(this.results.getInt("UNITINSTOCK"));
             
                
                table += "<tr>";
                
                table += "<td>";
                table += product.getPRODUCTID(); 
                table += "</td>";
                
                table += "<td>";
                table += product.getPRODUCTNAME(); 
                table += "</td>";
                
                table += "<td>";
                table += product.getPRICE(); 
                table += "</td>";
                
                table += "<td>";
                table += product.getUNITINSTOCK(); 
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?PRODUCTID=" + product.getPRODUCTID() + "> Update </a>" + "<a href=delete?PRODUCTID=" + product.getPRODUCTID() + "> Delete </a>";
                table += "</td>";
                
                
                table += "</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
         
             return table;
 }
}
