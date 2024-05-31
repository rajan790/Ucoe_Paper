package com.example.ucoe_p1;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    Button update_btn;
    FirebaseDatabase database;
    NetworkChangeLisetner networkChangeLisetner=new NetworkChangeLisetner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RelativeLayout relativeLayout;
        update update= new update(this);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button1);
        btn3=findViewById(R.id.button2);
        btn4=findViewById(R.id.button3);
        btn5=findViewById(R.id.button4);
        btn6=findViewById(R.id.button12);
        relativeLayout=findViewById(R.id.background);
        btn1.setOnClickListener( this);
        btn2.setOnClickListener( this);
        btn3.setOnClickListener( this);
        btn4.setOnClickListener( this);
        btn5.setOnClickListener( this);
        database=FirebaseDatabase.getInstance();
        int version=1;
        long new_version=getIntent().getLongExtra("version",0);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
                if(version != new_version)
                {
                    Handler handler =new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            update.show();
                            btn1.setEnabled(true);
                            btn2.setEnabled(true);
                            btn3.setEnabled(true);
                            btn4.setEnabled(true);
                            btn5.setEnabled(true);
                            btn6.setEnabled(true);
                            DatabaseReference reference =database.getReference().child("link");
                            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    String link= snapshot.getValue(String.class);
                                    update_btn= update.findViewById(R.id.update_btn);
                                    update_btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Uri uri =Uri.parse(link);
                                            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                                            startActivity(intent);
                                        }
                                    });
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                    },500);
                }
                Handler handler2= new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn1.setEnabled(true);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                        btn5.setEnabled(true);
                        btn6.setEnabled(true);
                    }
                },520);
        Intent intent=new Intent(this,query.class);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
//
     }
    public void onClick(View view)
    {
        Intent intent=new Intent(this,year.class);
        switch(view.getId())
        {
            case R.id.button:
                intent.putExtra("branch",1);
                startActivity(intent);
                break;
            case R.id.button1:
                intent.putExtra("branch",2);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.putExtra("branch",3);
                startActivity(intent);
                break;
            case R.id.button3:
                intent.putExtra("branch",4);
                startActivity(intent);
                break;
            case R.id.button4:
                intent.putExtra("branch",5);
                startActivity(intent);
                break;
        }
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
