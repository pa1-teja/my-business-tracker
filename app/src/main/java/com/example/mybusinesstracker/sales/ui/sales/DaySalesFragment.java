package com.example.mybusinesstracker.sales.ui.sales;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybusinesstracker.BaseCalsses.BaseFragment;
import com.example.mybusinesstracker.R;
import com.example.mybusinesstracker.sales.OnSalesInteractionListener;
import com.example.mybusinesstracker.viewmodels.SalesViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DaySalesFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnSalesInteractionListener mListener;
    HashMap<String, CustomerSaleModel> saleModelHashMap = new HashMap<>();
    private RecyclerView recyclerView;
    private DayRecycleViewAdapter dayRecycleViewAdapter;
    private ArrayList<CustomerSaleModel> listOfCustomerSaleModel = new ArrayList<>();

    public DaySalesFragment() {
        // Required empty public constructor
    }
    public static DaySalesFragment newInstance(String param1, String param2) {
        DaySalesFragment fragment = new DaySalesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day_sales, container, false);
        recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        generateSalesHashMap(mListener.getDaySales());
        dayRecycleViewAdapter = new DayRecycleViewAdapter(listOfCustomerSaleModel);
        recyclerView.setAdapter(dayRecycleViewAdapter);
        return view;
    }

    private void generateSalesHashMap(HashMap<Long, SalesViewModel> hashMap) {
        listOfCustomerSaleModel.clear();
        Set it = hashMap.entrySet();
        for (Object o : it) {
            Map.Entry entry = (Map.Entry) o;
            SalesViewModel salesViewModel = (SalesViewModel) entry.getValue();
            if (saleModelHashMap.containsKey(salesViewModel.getCustomerID())) {
                Objects.requireNonNull(saleModelHashMap.get(salesViewModel.getCustomerID())).salesViewModels.add(salesViewModel);
            } else {
                CustomerSaleModel customerSaleModel = new CustomerSaleModel();
                customerSaleModel.salesViewModels.add(salesViewModel);
                customerSaleModel.customer = mListener.getCustomers().get(salesViewModel.getCustomerID());
                saleModelHashMap.put(salesViewModel.getCustomerID(), customerSaleModel);
            }
        }
        Collection<CustomerSaleModel> demoValues = saleModelHashMap.values();
        listOfCustomerSaleModel.addAll(demoValues);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSalesInteractionListener) {
            mListener = (OnSalesInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSalesInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void updateAdapter(HashMap<Long, SalesViewModel> mAllSales) {
        generateSalesHashMap(mAllSales);
        dayRecycleViewAdapter.notifyDataSetChanged();
    }
}
