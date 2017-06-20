/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form.servlets;

import com.form.Customer;
import com.form.CustomerDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author venkatesh
 */
public class UpdateData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer cus = new Customer();
        resp.setContentType("text/html");

        String cid = req.getParameter("CustomerID");
        String cname = req.getParameter("CustomerName");
        String cemail = req.getParameter("CustomerEmail");
        String ccountry = req.getParameter("CustomerCountry");

        cus.setId(Integer.parseInt(cid));
        cus.setCustomerName(cname);
        cus.setCustomerEmail(cemail);
        cus.setCustomerCountry(ccountry);

        CustomerDB.update(cus);

        //resp.getWriter().println("Updated Succesfully");

    }

}
