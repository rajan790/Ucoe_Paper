package com.example.ucoe_p1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class parent_adapter extends RecyclerView.Adapter<parent_adapter.ViewHolder>
{
    List<parent_model> parent_modelsList;
    Context context;
    public parent_adapter(List<parent_model> parent_modelsList, Context context) {
        this.parent_modelsList = parent_modelsList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.coustom_desigen,null,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.t1.setText(parent_modelsList.get(position).title);
        child_adapter c1;
        c1=new child_adapter(parent_modelsList.get(position).child_modelList,context);
        holder.rv_child.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.rv_child.setAdapter(c1);
        c1.notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return parent_modelsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView rv_child;
        TextView t1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.text1);
            rv_child=itemView.findViewById(R.id.rv_child);
        }
    }
}