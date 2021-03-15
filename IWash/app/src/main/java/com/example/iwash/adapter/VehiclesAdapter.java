package com.example.iwash.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iwash.R;
import com.example.iwash.model.Vehicles;

import java.util.ArrayList;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {
    Context context;
    ArrayList<Vehicles> arrayList;

    public VehiclesAdapter(Context context, ArrayList<Vehicles> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vehicles, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehicles vehicles = arrayList.get(position);
        holder.tvBienSo.setText(vehicles.getBienSo());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBienSo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBienSo = itemView.findViewById(R.id.itemVehicles);
        }
    }
}
