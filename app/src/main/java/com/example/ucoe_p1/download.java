package com.example.ucoe_p1;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
public class download extends AppCompatActivity{
    Button mst1,mst2,mst3;
    String receive;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    int branch,year;
    NetworkChangeLisetner networkChangeLisetner=new NetworkChangeLisetner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Intent forselection = getIntent();
        receive = forselection.getStringExtra("paper");
        branch=forselection.getIntExtra("branch",0);
        year=forselection.getIntExtra("year",0);
        mst1=findViewById(R.id.button14);
        mst2=findViewById(R.id.button15);
        mst3=findViewById(R.id.button16);
        mst1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select;
                select= (String) receive.toLowerCase().replaceAll("\\s+"," ").trim()+" mst1.pdf";
                download(select);
            }
        });
        mst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select;
                select= (String) receive.toLowerCase().replaceAll("\\s+"," ").trim()+" mst2.pdf";
                download(select);
            }
        });
        mst3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String select;
                select= (String) receive.toLowerCase().replaceAll("\\s+"," ").trim()+" final.pdf";
                download(select);
            }
        });
    }
    public void download(String select)
    {
        if (year==1)
        {
            branch=1;
        }
        String br ="branch "+branch;
        String yr="year "+year;
//        Toast.makeText(this, ""+select, Toast.LENGTH_SHORT).show();
        storageReference = firebaseStorage.getInstance().getReference();
        ref=storageReference.child(br).child(yr).child(select);
        Intent pdf = new Intent(this, pdf_view.class);
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri)
            {
                String url= uri.toString();
                pdf.putExtra("url",url);
                pdf.putExtra("name",select);
                startActivity(pdf);
            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(download.this, "Not Found", Toast.LENGTH_SHORT).show();
            }
        });
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