package com.example.mbbapp.API_GetAllDevice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.R;

import java.util.List;

public class GetAllDeviceAdapter extends RecyclerView.Adapter<GetAllDeviceAdapter.GetAllDeviceViewHolder> {

    private final List<GetAlllDeviceModel> lisAllDevices;

    public GetAllDeviceAdapter(List<GetAlllDeviceModel> lisAllDevices) {
        this.lisAllDevices = lisAllDevices;
    }


    @NonNull
    @Override
    public GetAllDeviceAdapter.GetAllDeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_get_all_device, parent, false);
       return new GetAllDeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetAllDeviceAdapter.GetAllDeviceViewHolder holder, int position) {
       GetAlllDeviceModel getAlllDeviceModel = lisAllDevices.get(position);
       if(getAlllDeviceModel == null){
           return;
       }
        holder.id.setText(getAlllDeviceModel.getId());
        holder.deviceNumber.setText(getAlllDeviceModel.getDeviceNumber());
        holder.imei.setText(getAlllDeviceModel.getImei());
        holder.phone.setText(getAlllDeviceModel.getPhone());
        holder.carrierId.setText(getAlllDeviceModel.getCarrierId());
        holder.carrierName.setText(getAlllDeviceModel.getCarrierName());
        holder.activationTime.setText(getAlllDeviceModel.getActivationTime());
        holder.unitId.setText(getAlllDeviceModel.getUnitId());
        holder.unitName.setText(getAlllDeviceModel.getUnitName());
        holder.isActive.setText(String.valueOf(getAlllDeviceModel.isActive()));
        holder.allowUpdate.setText(String.valueOf(getAlllDeviceModel.isAllowUpdate()));
        holder.licensePlate.setText(getAlllDeviceModel.getLicensePlate());



    }

    @Override
    public int getItemCount() {
        if(lisAllDevices != null){
            return lisAllDevices.size();
        }
        return 0;
    }

    public static class GetAllDeviceViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView deviceNumber;
        private final TextView imei;
        private final TextView phone;
        private final TextView carrierId;
        private final TextView carrierName;
        private final TextView activationTime;
        private final TextView unitId;
        private final TextView unitName;
        private final TextView isActive;
        private final TextView allowUpdate;
        private final TextView licensePlate;

        public GetAllDeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (itemView).findViewById(R.id.id);
            deviceNumber = (itemView).findViewById(R.id.deviceNumber);
            imei = (itemView).findViewById(R.id.imei);
            phone = (itemView).findViewById(R.id.phone);
            carrierId = (itemView).findViewById(R.id.carrierId);
            carrierName = (itemView).findViewById(R.id.carrierName);
            activationTime = (itemView).findViewById(R.id.activationTime);
            unitId = (itemView).findViewById(R.id.unitId);
            unitName = (itemView).findViewById(R.id.unitName);
            isActive = (itemView).findViewById(R.id.isActive);
            allowUpdate = (itemView).findViewById(R.id.allowUpdate);
            licensePlate = (itemView).findViewById(R.id.licensePlate);

        }
    }
}
