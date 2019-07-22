package com.example.mybusinesstracker.sales;

import com.example.mybusinesstracker.customer.ui.customer.Customer;
import com.example.mybusinesstracker.viewmodels.SalesViewModel;

import java.util.HashMap;

public interface OnSalesInteractionListener {
    HashMap<String, Customer> getCustomers();
    void onAddSaleRecordSuccess(SalesViewModel mViewModel);
    void onUpdateSaleRecordSuccess();
    void onDeleteSaleRecordSuccess();

    HashMap<Long, SalesViewModel> getDaySales();
}
