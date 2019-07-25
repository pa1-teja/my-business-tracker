package com.example.mybusinesstracker.sales.ui.sales;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybusinesstracker.R;

import java.util.ArrayList;

public class DayRecycleViewAdapter extends RecyclerView.Adapter<DaySaleViewHolder> {
    private ArrayList<CustomerSaleModel> listOfCustomerSaleModel;
    DayRecycleViewAdapter(ArrayList<CustomerSaleModel> saleModelHashMap) {
        listOfCustomerSaleModel = saleModelHashMap;
    }

    /*private void getCustomerSaleList(HashMap<String, CustomerSaleModel> saleModelHashMap) {

    }*/


    @NonNull
    @Override
    public DaySaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.include_row_item_recycleview_name, parent, false);
        return new DaySaleViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull DaySaleViewHolder holder, int position) {
        CustomerSaleInfo temp = listOfCustomerSaleModel.get(position).getCustomerSale();
        holder.mCustomerName.setText(String.valueOf(temp.name));
        holder.mTotalBlocksString.setText(String.valueOf(temp.totalBlocksString));
        holder.mTotalIceBlocks.setText(String.valueOf(temp.totalBlock));
        holder.mTotalIceAmount.setText(String.valueOf(temp.totalICEAmount));
        holder.mTotalLabourCharges.setText(String.valueOf(temp.totalLabourCharges));
        holder.mTotalAmount.setText(String.valueOf(temp.totalAmount));
        holder.mTotalPaid.setText(String.valueOf(temp.totalPaid));
        holder.mTotalDue.setText(String.valueOf(temp.totalDue));

    }

    @Override
    public int getItemCount() {
        return listOfCustomerSaleModel.size();
    }
}
