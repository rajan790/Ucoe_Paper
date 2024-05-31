package com.example.ucoe_p1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class splash extends AppCompatActivity{
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = new Intent(this , home.class);
        database=FirebaseDatabase.getInstance();
        final long[] new_version = new long[1];
        DatabaseReference reference = database.getReference().child("update");
        if(!check_internet.isConnectedToInternet(this))
        {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(splash.this, "Turn on Internet", Toast.LENGTH_SHORT).show();
                }
            },2000);

        }
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                new_version[0] = (long) snapshot.getValue();
                intent.putExtra("version",new_version[0]);
                startActivity(intent);
                finish();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }

}