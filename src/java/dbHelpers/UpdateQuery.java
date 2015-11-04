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
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Products;

/**
 *
 * @author Shuo
 */
public class UpdateQuery {
    private Connection conn;
    public UpdateQuery () {
    Properties props = new Properties();//MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}
    
    public void doUpdate (Products product){
    
        try {
            String query = "UPDATE product SET PRODUCTNAME = ?, PRICE = ?, UNITINSTOCK = ? WHERE PRODUCTID= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString (1, product.getPRODUCTNAME());
            ps.setDouble (2, product.getPRICE());
            ps.setInt (3, product.getUNITINSTOCK());
            ps.setInt (4, product.getPRODUCTID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
