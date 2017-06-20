/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form;

/**
 *
 * @author venkatesh
 */
public class Customer {
    
    private int id;
    private String customerName;
    private String customerEmail;
    private String customerCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerCountry=" + customerCountry + '}';
    }
    
    
}
