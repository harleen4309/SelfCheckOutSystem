/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 * Javabean to map ProductCatalogue table from database contains all attributes
 * of ProductCatalogue table
 *
 * @author Harleen Kaur
 */
public class ProductCatalogue implements Serializable {

    private String code;
    private String name;
    private double price;
    private boolean taxable;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public ProductCatalogue(String code, String name, double price, boolean taxable) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.taxable = taxable;
    }

    public ProductCatalogue() {
    }

}
