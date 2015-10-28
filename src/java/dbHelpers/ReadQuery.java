/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
       Properties props = new Properties();//MWC
   InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
 
    public void doRead(){
        try {
            String query = "Select * from product";
            PreparedStatement ps = conn.prepareStatement(query);    
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable(){
        
        String table = "";
        table += "<table border=1>";
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
                
                table += "</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
         
             return table;
 }
}