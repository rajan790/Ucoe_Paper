package com.example.ucoe_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class year extends AppCompatActivity implements View.OnClickListener{
private Button b5,b6,b7,b8;
int branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        Intent forbranch=getIntent();
        branch=forbranch.getIntExtra("branch",0);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent =new Intent(this,MainSubject.class);
        switch(view.getId())
        {
            case R.id.button5:
                intent.putExtra("year",1);
                intent.putExtra("branch",branch);
                startActivity(intent);
                break;
            case R.id.button6:
                intent.putExtra("year",2);
                intent.putExtra("branch",branch);
                startActivity(intent);
                break;
            case R.id.button7:
                intent.putExtra("year",3);
                intent.putExtra("branch",branch);
                startActivity(intent);
                break;
            case R.id.button8:
                intent.putExtra("year",4);
                intent.putExtra("branch",branch);
                startActivity(intent);
                break;

        }
    }
}