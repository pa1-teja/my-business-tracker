package com.example.mybusinesstracker.viewmodels;

import androidx.databinding.BaseObservable;

import com.example.mybusinesstracker.customer.ui.customer.Customer;

import java.io.Serializable;

public class SalesViewModel extends BaseObservable implements Serializable {
    private int ID;
    private Long date ;
    private String cabinID = null;
    private String customerID = null;
    private String salesType = null;
    private float totalBlocks = 0;
    private int iceAmount = 0;
    private int labourCharges = 0;
    private int otherAmount = 0;
    private int totalAmount = 0;
    private int paidAmount = 0;
    private int dueAmount = 0;
    private String note = null;
    private String dateString;
    private Customer selectedCustomer;

    public int getID() {
        return ID;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getCabinID() {
        return cabinID;
    }

    public void setCabinID(String cabinID) {
        this.cabinID = cabinID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public float getTotalBlocks() {
        return totalBlocks;
    }

    public void setTotalBlocks(float totalBlocks) {
        this.totalBlocks = totalBlocks;
        setIceAmount((int) (selectedCustomer.getAmount()*totalBlocks));
        setLabourCharges((int) (selectedCustomer.getLaborCharge()*totalBlocks));
        setTotalAmount(getIceAmount()+getLabourCharges()+getOtherAmount());
    }

    public int getIceAmount() {
        return iceAmount;
    }

    public void setIceAmount(int iceAmount) {
        this.iceAmount = iceAmount;
        notifyChange();
    }

    public int getLabourCharges() {
        return labourCharges;
    }

    public void setLabourCharges(int labourCharges) {
        this.labourCharges = labourCharges;
        setTotalAmount(getIceAmount()+getLabourCharges()+getOtherAmount());
        notifyChange();
    }

    public int getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(int otherAmount) {
        this.otherAmount = otherAmount;
        setTotalAmount(getIceAmount()+getLabourCharges()+getOtherAmount());
        notifyChange();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        setDueAmount(getTotalAmount()-getPaidAmount());
        notifyChange();
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
        setDueAmount(getTotalAmount()-getPaidAmount());
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
        notifyChange();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }
}
