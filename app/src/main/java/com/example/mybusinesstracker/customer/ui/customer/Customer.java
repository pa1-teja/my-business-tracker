package com.example.mybusinesstracker.customer.ui.customer;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mybusinesstracker.BR;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Customer extends BaseObservable implements Serializable, Parcelable {
    private String customerName = "Depot";
    private String address = "Miryalguda";
    private String phoneNumber = "9246966692";
    private String emailID = "v@v.v";
    private int amount = 10;
    private int laborCharge = 10;
    private long colorID = 102221212;

    public Customer() {

    }
    public Customer(Map<String, Object> data) {
        customerName = (String) data.get("customerName");

        address = (String) data.get("address");
        phoneNumber = (String) data.get("phoneNumber");
        emailID = (String) data.get("emailID");
        amount = Integer.parseInt((String) data.get("amount"));
        laborCharge = Integer.parseInt((String)data.get("laborCharge"));
        colorID = Long.parseLong((String)data.get("colorID"));
    }

    protected Customer(Parcel in) {
        customerName = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
        emailID = in.readString();
        amount = in.readInt();
        laborCharge = in.readInt();
        colorID = in.readLong();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Bindable
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        notifyPropertyChanged(BR.customerName);
    }
    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }
    @Bindable
    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
        notifyPropertyChanged(BR.emailID);
    }
    @Bindable
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        notifyPropertyChanged(BR.amount);
    }
    @Bindable
    public int getLaborCharge() {
        return laborCharge;
    }

    public void setLaborCharge(int laborCharge) {
        this.laborCharge = laborCharge;
        notifyPropertyChanged(BR.laborCharge);
    }
    @Bindable
    public long getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
        notifyPropertyChanged(BR.colorID);
    }
    public HashMap<String, String> getHashMap() {
        HashMap<String, String> data = new HashMap<>();
        data.put("customerName",customerName);
        data.put("address",address);
        data.put("phoneNumber",phoneNumber);
        data.put("emailID",emailID);
        data.put("amount", String.valueOf(amount));
        data.put("laborCharge", String.valueOf(laborCharge));
        data.put("colorID", String.valueOf(colorID));
        return data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(emailID);
        dest.writeInt(amount);
        dest.writeInt(laborCharge);
        dest.writeLong(colorID);
    }
}
