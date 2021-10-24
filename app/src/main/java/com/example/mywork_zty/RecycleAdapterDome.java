package com.example.mywork_zty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;
import java.util.Map;

public class RecycleAdapterDome extends RecyclerView.Adapter<RecycleAdapterDome.MyViewHolder> {
    private Context context;
    private List<Map<String, Object>> data;
    private View inflater;
    public RecycleAdapterDome(List<Map<String, Object>> data, Activity context){
        this.data=data;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item_dome,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(inflater);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(data.get(position).get("name").toString());
        holder.textView2.setText(data.get(position).get("price").toString());
        holder.textView3.setText(data.get(position).get("configure").toString());
        holder.imageView.setImageResource((Integer) data.get(position).get("imageView"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.textView1.getText() == "品牌：华为"){
                    Intent intent=new Intent(context,MainActivity4.class);
                    context.startActivity(intent);
                }
                if(holder.textView1.getText() == "品牌：苹果"){
                    Intent intent=new Intent(context,MainActivity5.class);
                    context.startActivity(intent);
                }
                if(holder.textView1.getText() == "品牌：小米"){
                    Intent intent=new Intent(context,MainActivity6.class);
                    context.startActivity(intent);
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
            textView1=(TextView) itemView.findViewById(R.id.text_view);
            textView2=(TextView) itemView.findViewById(R.id.text_view1);
            textView3=(TextView) itemView.findViewById(R.id.text_view2);
        }
    }
}
