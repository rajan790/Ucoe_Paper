package com.example.ucoe_p1;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class pdf_view extends AppCompatActivity {

    // creating a variable for PDF view.
    PDFView pdfView;
    FloatingActionButton dow_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        Intent forLink = getIntent();
        String link = forLink.getStringExtra("url");
        String file_name = forLink.getStringExtra("name");

        pdfView = findViewById(R.id.idPDFView);
        dow_btn = findViewById(R.id.dow_btn);


        dow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadfile(pdf_view.this, file_name, Environment.DIRECTORY_DOWNLOADS, link);
            }
        });

        // Execute AsyncTask to load the PDF
        new RetrievePDFfromUrl().execute(link);
    }

    public void downloadfile(Context context, String filename, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
        downloadManager.enqueue(request);
        Toast.makeText(context, "Check Your Notification", Toast.LENGTH_SHORT).show();
    }

    // Create an AsyncTask class for loading PDF file from URL
    class RetrievePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // Create and open connection
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // Success response, get the input stream
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            if (inputStream != null) {
                pdfView.fromStream(inputStream).load();
                Toast.makeText(pdf_view.this, "yes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(pdf_view.this, "Failed to load PDF", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
