package com.form.servlets;

import com.form.Customer;
import com.form.CustomerDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author venkatesh
 */
public class InsertData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer cus = new Customer();
        String cname = request.getParameter("CustomerName");
        String cemail = request.getParameter("CustomerEmail");
        cemail+="@gmail.com";
        String ccountry = request.getParameter("CustomerCountry");
        
        cus.setCustomerName(cname);
        cus.setCustomerEmail(cemail);
        cus.setCustomerCountry(ccountry);
        
        CustomerDB.add(cus);
        
        //response.getWriter().println("Data Added Succesfully");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
