/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shuo
 */
public class Products {
    private int PRODUCTID;
    private String PRODUCTNAME;
    private Double PRICE;
    private int UNITINSTOCK;
    
    public Products() {
        this.PRODUCTID = 0;
        this.PRODUCTNAME = "";
        this.PRICE = 0.00;
        this.UNITINSTOCK = 0;
    }

    public Products(int PRODUCTID, String PRODUCTNAME, Double PRICE, int UNITINSTOCK) {
        this.PRODUCTID = PRODUCTID;
        this.PRODUCTNAME = PRODUCTNAME;
        this.PRICE = PRICE;
        this.UNITINSTOCK = UNITINSTOCK;
    }

    public int getPRODUCTID() {
        return PRODUCTID;
    }

    public void setPRODUCTID(int PRODUCTID) {
        this.PRODUCTID = PRODUCTID;
    }

    public String getPRODUCTNAME() {
        return PRODUCTNAME;
    }

    public void setPRODUCTNAME(String PRODUCTNAME) {
        this.PRODUCTNAME = PRODUCTNAME;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public int getUNITINSTOCK() {
        return UNITINSTOCK;
    }

    public void setUNITINSTOCK(int UNITINSTOCK) {
        this.UNITINSTOCK = UNITINSTOCK;
    }

    @Override
    public String toString() {
        return "Products{" + "PRODUCTID=" + PRODUCTID + ", PRODUCTNAME=" + PRODUCTNAME + ", PRICE=" + PRICE + ", UNITINSTOCK=" + UNITINSTOCK + '}';
    }
    
}
