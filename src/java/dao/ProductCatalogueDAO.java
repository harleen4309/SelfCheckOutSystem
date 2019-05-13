/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import business.ProductCatalogue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class containing methods to use ProductCatalogue table
 *
 * @author Harleen Kaur
 */
public class ProductCatalogueDAO {

    /**
     * Method to fetch items based on code
     *
     * @param conn -- uses conn established in listener
     * @param code -- code of product entered by user
     * @return ProductCatalogue -- returns product based on code entered, if
     * found
     */
    public static ProductCatalogue getProductByCode(Connection conn, String code) {
        String sqlQuery = "SELECT * FROM ProductCatalogue "
                + "WHERE code = ? GROUP BY code";
        ProductCatalogue prod = null;
        String result = "";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, code);
        } catch (SQLException ex) {

        }

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();

            while (rs.next()) {
                prod = new ProductCatalogue();
                prod.setCode(code);
                prod.setName(rs.getString("name"));
                prod.setPrice(rs.getDouble("price"));
                prod.setTaxable(rs.getBoolean("taxable"));

            }
        } catch (SQLException ex) {

        }
        return prod;

    }

    /**
     * Method which allows admin to add new products to database
     *
     * @param conn-- uses conn established in listener
     * @param code -- code of product entered by admin
     * @param name -- name of product entered by admin
     * @param price -- price of product entered by admin
     * @param taxable -- tells whether item is taxable or not
     * @return String -- returns String showing result if item was added
     * successfully or not
     */
    public static String addNewProduct(Connection conn, String code, String name, double price, boolean taxable) {
        ProductCatalogueDAO prodCat = new ProductCatalogueDAO();
        ProductCatalogue prod1 = prodCat.getProductByCode(conn, code);
        String result = "";
        if (prod1 == null) {
            ProductCatalogue prod = null;

            PreparedStatement ps = null;
            String sqlQuery1 = "INSERT INTO ProductCatalogue (Code, Name, Price, Taxable)"
                    + "VALUES (?,?,?,?) ";

            try {
                ps = conn.prepareStatement(sqlQuery1);
                ps.setString(1, code);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setBoolean(4, taxable);
            } catch (SQLException ex) {

            }

            int count = 0;
            try {
                count = ps.executeUpdate();
                if (count == 1) {
                    result = "Product added successfully";
                } else {
                    result = "error while adding new product";
                }
            } catch (SQLException ex) {

            }

        } else {
            result = "Product with same code already exists. Please enter a diff code";
        }
        return result;

    }
}
