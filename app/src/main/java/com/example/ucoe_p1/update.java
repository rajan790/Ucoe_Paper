package com.example.ucoe_p1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class update extends Dialog{
        public update(@NonNull Context context) {
            super(context);
            WindowManager.LayoutParams params= getWindow().getAttributes();
            params.gravity= Gravity.CENTER;
            getWindow().setAttributes(params);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            setTitle(null);
            setCancelable(false);
            setOnCancelListener(null);
            View view;
            view=LayoutInflater.from(context).inflate(R.layout.update,null);
            setContentView(view);
        }
    }