/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form.servlets;

import com.form.Customer;
import com.form.CustomerDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author venkatesh
 */
public class DeleteData extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("CustomerID");
        int cid = Integer.parseInt(str);

        try (PrintWriter pw = resp.getWriter()) {
            Customer customer = CustomerDB.getCustomerById(cid);
            
            pw.println("<div class='form-group'>\n"
                    + "<label class='col-sm-2 control-label' for='uc_name'>Customer Name</label>\n"
                    + "<div class='col-sm-3'>\n"
                    + "<input class='form-control' type='text' name='dc_name' readonly value='" + customer.getCustomerName() + "' id='dc_name'/>\n"
                    + "</div>\n"
                    + "</div>\n"
                    + "<div class='form-group'>\n"
                    + "<label class='col-sm-2 control-label' for='uc_email'>Customer Email</label>\n"
                    + "<div class='col-sm-3'>\n"
                    + "<input class='form-control' type='text' name='dc_email' readonly value='" + customer.getCustomerEmail() + "' id='dc_email'/>\n"
                    + "</div>\n"
                    + "</div>\n"
                    + "<div class='form-group'>\n"
                    + "<label class='col-sm-2 control-label' for='uc_cntry'>Country</label>\n"
                    + "<div class='col-sm-3'>\n"
                    + "<input class='form-control' type='text' name='dc_cntry' readonly value='" + customer.getCustomerCountry() + "' id='dc_cntry'/>\n"
                    + "</div>\n"
                    + "</div>\n");
            
           /* pw.println("<label>Customer Name</label>\n"
                    + "<input type='text' name='u_name' class='form-control' id='dc_name' value='" + customer.getCustomerName() + "'/>\n"
                    + "<label>Customer Email</label>\n"
                    + "<input type='text' name='u_email' class='form-control' id='dc_email' value='" + customer.getCustomerEmail() + "'/>\n"
                    + "<label>Customer Country</label>\n"
                    + "<input type='text' name='u_cntry' class='form-control' id='dc_cntry' value='" + customer.getCustomerCountry() + "'/>\n"
                    + "<button type='submit'class='btn btn-default' id='update'>Delete</button>\n");*/
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer cus = new Customer();

        String cid = req.getParameter("CustomerID");

        cus.setId(Integer.parseInt(cid));

        CustomerDB.delete(cus.getId());

        resp.getWriter().println("Deleted Successfully");
    }

}
