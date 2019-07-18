package com.example.mybusinesstracker.sales;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.mybusinesstracker.R;
import com.example.mybusinesstracker.cloud_firestore.CustomerTable;
import com.example.mybusinesstracker.customer.ui.customer.Customer;
import com.example.mybusinesstracker.factory.FactoryBaseActivity;
import com.example.mybusinesstracker.sales.ui.sales.AddSaleFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SalesActivity extends FactoryBaseActivity implements OnSalesInteractionListener{


    protected HashMap<String, Customer> mAllCustomers = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerTable = new CustomerTable();
        getCustomerList();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, AddSaleFragment.newInstance(), "AddSaleFragment").commitNow();
        }
    }
    protected void getCustomerList() {
        if(null == mAllCustomers || mAllCustomers.size()<=0) {
            customerTable.getCustomerList(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(null != task.getResult()) {
                        for (DocumentSnapshot document : task.getResult()) {
                            Map<String, Object> data = document.getData();
                            assert data != null;
                            addCustomer(new Customer(data));
                        }
                    }
                    AddSaleFragment myFragment = (AddSaleFragment) getSupportFragmentManager().findFragmentByTag("AddSaleFragment");
                    // add your code here
                    if (myFragment != null) {
                        myFragment.updateCustomerSpinner(mAllCustomers);
                    }
                }
            });
        }
    }
    protected void addCustomer(Customer customer) {
        mAllCustomers.put(customer.getCustomerName(), customer);
    }

    @Override
    public HashMap<String, Customer> getCustomers() {
        return mAllCustomers;
    }
}
