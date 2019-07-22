package com.example.mybusinesstracker.sales;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.mybusinesstracker.R;
import com.example.mybusinesstracker.cloud_firestore.tables.CustomerTable;
import com.example.mybusinesstracker.cloud_firestore.tables.SalesTable;
import com.example.mybusinesstracker.customer.ui.customer.Customer;
import com.example.mybusinesstracker.factory.FactoryBaseActivity;
import com.example.mybusinesstracker.sales.ui.sales.AddSaleFragment;
import com.example.mybusinesstracker.sales.ui.sales.DaySalesFragment;
import com.example.mybusinesstracker.viewmodels.SalesViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SalesActivity extends FactoryBaseActivity implements OnSalesInteractionListener{


    protected HashMap<String, Customer> mAllCustomers = new HashMap<>();
    protected HashMap<Long, SalesViewModel> mAllSales = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerTable = new CustomerTable();
        getCustomerList();
        getAllSalesList();

        if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.container, AddSaleFragment.newInstance("",""), "AddSaleFragment").commitNow();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, DaySalesFragment.newInstance("",""), "DaySalesFragment").commitNow();
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
    private void getAllSalesList() {
        if(null == mAllSales || mAllSales.size() <=0) {
            SalesTable salesTable = new SalesTable();
            salesTable.getSalesList(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(null != task.getResult()) {
                        for (DocumentSnapshot document : task.getResult()) {
                            Map<String, Object> data = document.getData();
                            assert data != null;
                            addSale(new SalesViewModel(data));
                        }
                    }
                    AddSaleFragment myFragment = (AddSaleFragment) getSupportFragmentManager().findFragmentByTag("AddSaleFragment");
                    // add your code here
                    if (myFragment != null) {
                        myFragment.updateCustomerSpinner(mAllCustomers);
                    }
                    DaySalesFragment fragment = (DaySalesFragment) getSupportFragmentManager().findFragmentByTag("DaySalesFragment");
                    // add your code here
                    if (fragment != null) {
                        fragment.updateAdapter(mAllSales);
                    }
                }
            }, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
    }
    protected void addCustomer(Customer customer) {
        mAllCustomers.put(customer.getCustomerName(), customer);
    }
    protected void addSale(SalesViewModel sale) {
        mAllSales.put(sale.getDate(), sale);
    }
    @Override
    public HashMap<String, Customer> getCustomers() {
        return mAllCustomers;
    }

    @Override
    public void onAddSaleRecordSuccess(SalesViewModel mViewModel) {
        onBackPressed();
    }

    @Override
    public void onUpdateSaleRecordSuccess() {
        onBackPressed();
    }

    @Override
    public void onDeleteSaleRecordSuccess() {
        onBackPressed();
    }

    @Override
    public HashMap<Long, SalesViewModel> getDaySales() {
        return mAllSales;
    }
}
