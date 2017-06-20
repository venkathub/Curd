/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author venkatesh
 */
public class CustomerDB {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static int add(Customer customer) {
        int status = 0;
        try {
            String sql = "INSERT INTO details (name,email,country)VALUES (?,?,?);";
            Connection con = CustomerDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerCountry());
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(Customer customer) {
        int status = 0;
        try {
            String sql = "UPDATE details SET name=?,email=?,country=? WHERE id=?";
            Connection con = CustomerDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerCountry());
            ps.setInt(4, customer.getId());
            status = ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static Customer getCustomerById(int id) {
        Customer cus = new Customer();
        try {
            String sql = "SELECT * FROM details WHERE id=?";
            try (Connection con = CustomerDB.getConnection()) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    cus.setId(rs.getInt(1));
                    cus.setCustomerName(rs.getString(2));
                    cus.setCustomerEmail(rs.getString(3));
                    cus.setCustomerCountry(rs.getString(4));
                }
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cus;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            String sql = "DELETE FROM details WHERE id=?";
            Connection con = CustomerDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static String showTable() {
        String str = "<thead>\n"
                + "<tr>\n"
                + "<th style='text-align:center'>Customer ID</th>\n"
                + "<th style='text-align:center'>Customer Name</th>\n"
                + "<th style='text-align:center'>Customer Email</th>\n"
                + "<th style='text-align:center'>Customer Country</th>\n"
                + "</tr>\n"
                + "</thead>\n"
                + "</tbody>\n";
        try {
            String sql = "SELECT * FROM details";
            Connection con = CustomerDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                str += "<tr>\n"
                        + "<td align='center'>" + rs.getInt(1) + "</td>\n"
                        + "<td align='center'>" + rs.getString(2) + "</td>\n"
                        + "<td align='center'>" + rs.getString(3) + "</td>\n"
                        + "<td align='center'>" + rs.getString(4) + "</td>\n"
                        + "</tr>\n";
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally{
            str+="</tbody>";
        }
        return str;
    }
}
