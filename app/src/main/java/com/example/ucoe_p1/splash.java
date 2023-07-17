package com.example.ucoe_p1;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class splash extends AppCompatActivity{
    NetworkChangeLisetner networkChangeLisetner=new NetworkChangeLisetner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(this , MainActivity.class);
        new Handler().postDelayed(() -> {
            startActivity(intent);
            finish();
        },1500);
    }
    @Override
    protected void onStart()
    {
        IntentFilter filter= new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeLisetner,filter);
        super.onStart();
    }
    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeLisetner);
        super.onStop();
    }
}