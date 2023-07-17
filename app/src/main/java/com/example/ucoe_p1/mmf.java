package com.example.ucoe_p1;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class mmf extends AppCompatActivity implements View.OnClickListener {
private Button b11;
    NetworkChangeLisetner networkChangeLisetner=new NetworkChangeLisetner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmf);
        b11=findViewById(R.id.button11);

        b11.setOnClickListener(this);
    }

    public void onClick(View view)
    {

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