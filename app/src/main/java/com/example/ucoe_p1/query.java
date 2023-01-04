package com.example.ucoe_p1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.net.URI;
public class query extends AppCompatActivity implements View.OnClickListener{

ImageView i1,i2,i3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        i1=findViewById(R.id.imageView1);
        i2=findViewById(R.id.imageView2);
        i3=findViewById(R.id.imageView3);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {

        switch(view.getId())
        {
            case R.id.imageView1:
                Intent browse=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_._raj.an_._/"));
                startActivity(browse);
                break;
            case R.id.imageView3:
                Intent browse2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rajan-n-a-3b4887219"));
                startActivity(browse2);
                break;
            case R.id.imageView2:
                Intent browse3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100009826385002"));
                startActivity(browse3);
                break;
        }
    }
}