package com.elegantwizardry.onlineattendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoresAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Stores.Data> dataList;
    private MyClickListener myClickListener;

    public StoresAdapter(Context context, List<Stores.Data> dataList, MyClickListener myClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.myClickListener = myClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new VirticleCellViewHolder(inflater.inflate(R.layout.stores_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VirticleCellViewHolder holder1 = (VirticleCellViewHolder) holder;
        holder1.name.setText(dataList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class VirticleCellViewHolder extends RecyclerView.ViewHolder{
        private TextView name;

        VirticleCellViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.store_name);


            itemView.setOnClickListener(v -> {
                if (dataList != null && dataList.size() > 0) {
                    myClickListener.myOnClick(dataList.get(getAdapterPosition()));
                }
            });
        }
    }
}
