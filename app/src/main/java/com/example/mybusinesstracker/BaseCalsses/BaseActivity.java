package com.example.mybusinesstracker.BaseCalsses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements OnBaseAppListener {


    protected static String TAG ="BaseActivity";
    boolean isWifiConnected = false;
    boolean isMobileDataConnected = false;


    /*
     * setTagName() method is usefull in finding out which activity or module has raised a particular log accross the whole application
     */
    public void setTagName(String name){
        String classpath[] = name.split("\\.");
        TAG = classpath[classpath.length -1];
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isWifiConnected = false;
        isMobileDataConnected = false;
        unregisterReceiver(networkChangeReceiver);
    }

    BroadcastReceiver networkChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkNetworkConnection();
        }
    };


    @Override
    public void onNetworkConnected() {
        //TODO: Perform any tasks when the network is connected.
    }

    @Override
    public void onNetworkChanging() {
        //TODO: handle network resources while switching network.
    }

    @Override
    public void onNetworkDisConnected() {
        //TODO: perform any data saving tasks.
    }

    @Override
    public void checkNetworkConnection() {
        isMobileDataConnected = false;
        isWifiConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        if (networkInfos != null){
            for (NetworkInfo ni: networkInfos) {
                if (ni.getState() == NetworkInfo.State.CONNECTED){
                    if (ni.getTypeName().equalsIgnoreCase("WIFI") && ni.isConnected()){
                        isWifiConnected = true;
                    }
                    if (ni.getTypeName().equalsIgnoreCase("MOBILE") && ni.isConnected()){
                        isMobileDataConnected = true;
                    }
                }
            }
        }

        if (isWifiConnected || isMobileDataConnected)
            onNetworkConnected();
        else
            onNetworkDisConnected();
    }

    @Override
    public boolean isNetworkAvailable() {
        return isMobileDataConnected || isWifiConnected;
    }

    public void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Network not Found");
        builder.setPositiveButton("Check Setting", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();
    }

    @Override
    public void setTagName() {

    }
}
