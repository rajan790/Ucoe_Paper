package com.example.ucoe_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button1);
        btn3=findViewById(R.id.button2);
        btn4=findViewById(R.id.button3);
        btn5=findViewById(R.id.button4);
        btn6=findViewById(R.id.button12);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        Intent intent=new Intent(this,query.class);
        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(intent);
            }
        });
     }
    @Override
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
}
