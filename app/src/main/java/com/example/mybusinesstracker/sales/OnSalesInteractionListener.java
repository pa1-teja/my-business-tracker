package com.example.mybusinesstracker.sales;

import com.example.mybusinesstracker.customer.ui.customer.Customer;

import java.util.HashMap;

public interface OnSalesInteractionListener {
    HashMap<String, Customer> getCustomers();
}
