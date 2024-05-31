package com.example.ucoe_p1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class child_adapter extends RecyclerView.Adapter<child_adapter.ViewHolder>
{
    List<child_model> child_modelList;
    Context context;
    int branch,year;
    public child_adapter(List<child_model> child_modelList, Context context,int branch,int year)
    {
        this.child_modelList = child_modelList;
        this.context = context;
        this.branch=branch;
        this.year=year;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.child_rv,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        int sizeid=child_modelList.get(position).change_size;
        if(sizeid==10)
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(1000, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.btn1.setLayoutParams(lp);
              holder.btn1.setBackgroundColor(Color.TRANSPARENT);
        }
        holder.btn1.setText(child_modelList.get(position).btn);

        String send=(String) child_modelList.get(position).btn;
            holder.btn1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
//                Toast.makeText(context, "s = "+send, Toast.LENGTH_SHORT).show();
                    if(sizeid!=10)
                    {
                        Intent ieven=new Intent(context,download.class);
                        ieven.putExtra("paper",send);
                        ieven.putExtra("branch",branch);
                        ieven.putExtra("year",year);
                        view.getContext().startActivity(ieven);
                    }
//                view.getContext().startActivity(new Intent(context,download.class));
                }
            });
    }
    @Override
    public int getItemCount() {
        return child_modelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        Button btn1;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            btn1=itemView.findViewById(R.id.btn1);
        }
    }
}