package com.example.mybusinesstracker.viewmodels;

import androidx.lifecycle.ViewModel;

public class SalesViewModel extends ViewModel {
    public int ID;
    Long date ;
    String cabinID = null;
    String customerID = null;
    String salesType = null;
    float totalBlocks = 0;
    int iceAmount = 0;
    int labourCharges = 0;
    int otherAmount = 0;
    int totalAmount = 0;
    int paidAmount = 0;
    int dueAmount = 0;
    String note = null;
}
