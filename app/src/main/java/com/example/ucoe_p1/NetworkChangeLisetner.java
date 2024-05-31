package com.example.ucoe_p1;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatButton;

public class NetworkChangeLisetner extends BroadcastReceiver
{
    Button mst1,mst2,mst3;
    ImageView img1;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!check_internet.isConnectedToInternet(context))
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(context, R.style.Theme_Ucoe_p1);
            View layout_dialog= LayoutInflater.from(context).inflate(R.layout.activity_check_internet_dialog,null);
            builder.setView(layout_dialog);
            AppCompatButton btnRetry = layout_dialog.findViewById(R.id.btnRetry);
            AlertDialog dialog=builder.create();
            dialog.show();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
            boolean click =true;
            btnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(check_internet.isConnectedToInternet(context))
                    {
                        dialog.dismiss();
                    }
                }
            });
        }
    }

}