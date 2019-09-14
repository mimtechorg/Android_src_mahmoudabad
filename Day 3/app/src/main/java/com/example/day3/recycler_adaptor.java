package com.example.day3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class recycler_adaptor extends RecyclerView.Adapter<recycler_adaptor.ViewHolder> {
    Context applicationContext;
    String[] colorlist;
    LayoutInflater inflater;

    public recycler_adaptor(Context applicationContext, String[] colorlist) {
        this.applicationContext = applicationContext;
        this.colorlist = colorlist;
        this.inflater = LayoutInflater.from(applicationContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(colorlist[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                view.setBackgroundColor(Color.argb(255,random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return colorlist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rec_text);
        }
    }
}
