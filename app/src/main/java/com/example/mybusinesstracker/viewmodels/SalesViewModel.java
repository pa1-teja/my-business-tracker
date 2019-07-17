package com.example.mybusinesstracker.viewmodels;

import androidx.databinding.BaseObservable;

import java.io.Serializable;

public class SalesViewModel extends BaseObservable implements Serializable {
    private int ID;
    private Long date ;
    private String cabinID = null;
    private String customerID = null;
    private String salesType = null;
    private float totalBlocks = 4;
    private int iceAmount = 400;
    private int labourCharges = 100;
    private int otherAmount = 20;
    private int totalAmount = 520;
    private int paidAmount = 520;
    private int dueAmount = 0;
    private String note = null;
    private String dateString;

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
    }

    public int getIceAmount() {
        return iceAmount;
    }

    public void setIceAmount(int iceAmount) {
        this.iceAmount = iceAmount;
    }

    public int getLabourCharges() {
        return labourCharges;
    }

    public void setLabourCharges(int labourCharges) {
        this.labourCharges = labourCharges;
    }

    public int getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(int otherAmount) {
        this.otherAmount = otherAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
