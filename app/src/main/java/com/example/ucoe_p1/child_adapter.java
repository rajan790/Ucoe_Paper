package com.example.ucoe_p1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class child_adapter extends RecyclerView.Adapter<child_adapter.ViewHolder>
{
    List<child_model> child_modelList;
    Context context;

    public child_adapter(List<child_model> child_modelList, Context context)
    {
        this.child_modelList = child_modelList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view= LayoutInflater.from(context).inflate(R.layout.child_rv,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

        holder.btn1.setText(child_modelList.get(position).btn);
        String send=(String) child_modelList.get(position).btn;
        holder.btn1.setOnClickListener(view -> {
//                Toast.makeText(context, "s = "+send, Toast.LENGTH_SHORT).show();
            Intent ieven=new Intent(context,download.class);
            ieven.putExtra("paper",send);
            view.getContext().startActivity(ieven);
//                view.getContext().startActivity(new Intent(context,download.class));
        });
    }
    @Override
    public int getItemCount() {
        return child_modelList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        Button btn1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            btn1=itemView.findViewById(R.id.btn1);
        }
    }
}