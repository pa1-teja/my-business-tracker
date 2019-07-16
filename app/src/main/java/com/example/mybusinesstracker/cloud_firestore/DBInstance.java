package com.example.mybusinesstracker.cloud_firestore;

import android.annotation.SuppressLint;

import com.google.firebase.firestore.FirebaseFirestore;

public abstract class DBInstance implements DBInstanceInterface {
    public static String BASE_COLLECTION_FACTORY="factory";
    public static String BASE_DIRECTORY_CUSTOMER="CUSTOMER";
    public static String BASE_DIRECTORY_DETAILS="DETAILS";
    @SuppressLint("StaticFieldLeak")
    private static FirebaseFirestore myDB;

    public static FirebaseFirestore getDBInstance() {
        if(null == myDB) {
            myDB = FirebaseFirestore.getInstance();
        }
        return myDB;
    }
}
