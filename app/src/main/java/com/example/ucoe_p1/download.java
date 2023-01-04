package com.example.ucoe_p1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.Locale;

public class download extends AppCompatActivity
{
    Button mst1,mst2,mst3;
    String receive;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Intent forselection = getIntent();
        receive = forselection.getStringExtra("paper");
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
//        Toast.makeText(this, ""+select, Toast.LENGTH_SHORT).show();
        storageReference = firebaseStorage.getInstance().getReference();
        ref=storageReference.child(select);
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri)
            {
                String url= uri.toString();
                Toast.makeText(download.this, "Check Notifaction Bar", Toast.LENGTH_SHORT).show();
                downloadfile(download.this,select, Environment.DIRECTORY_DOWNLOADS,url);
            }
        }).addOnFailureListener(new OnFailureListener()
        {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(download.this, "Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void downloadfile(Context context,String filename,String destinationDirectory,String url)
    {
        DownloadManager downloadManager= (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri =Uri.parse(url);
        DownloadManager.Request request= new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,filename);
        downloadManager.enqueue(request);
    }
}