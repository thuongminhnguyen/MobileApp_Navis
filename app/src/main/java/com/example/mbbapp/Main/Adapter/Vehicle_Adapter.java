package com.example.mbbapp.Main.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.Main.Model.VehicleModel;
import com.example.mbbapp.R;

import java.util.List;

public class Vehicle_Adapter extends RecyclerView.Adapter<Vehicle_Adapter.ViewHolder> {

    private List<VehicleModel> vehicleModelList;

    public Vehicle_Adapter(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (vehicleModelList != null && getItemCount() > 0) {
            VehicleModel vehicleModel = vehicleModelList.get(position);
            holder.driverName.setText(vehicleModel.getDriverName());
            holder.unitname.setText(vehicleModel.getUnitName());
            holder.licensePlate.setText(vehicleModel.getLicensePlate());
        }
    }

    @Override
    public int getItemCount() {
        return vehicleModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView driverName, unitname, licensePlate;
       // private final FrameLayout item_infor_escort;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            driverName = itemView.findViewById(R.id.driverName);
            unitname = itemView.findViewById(R.id.unitName);
            licensePlate = itemView.findViewById(R.id.licensePlate);
        }
    }
}
