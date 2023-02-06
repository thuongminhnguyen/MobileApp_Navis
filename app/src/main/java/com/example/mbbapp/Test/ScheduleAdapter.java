package com.example.mbbapp.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.R;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    Context context;
    List<GetListScheduleByUnitModel> getListScheduleByUnitModelList;

    public ScheduleAdapter(Context context) {
        this.context = context;
    }

    public ScheduleAdapter(Context context, List<GetListScheduleByUnitModel> getListScheduleByUnitModelList) {
        this.context = context;
        this.getListScheduleByUnitModelList = getListScheduleByUnitModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_schedule,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(getListScheduleByUnitModelList != null && getListScheduleByUnitModelList.size() > 0){
            GetListScheduleByUnitModel getListScheduleByUnitModel = getListScheduleByUnitModelList.get(position);
            holder.scheduleName.setText(getListScheduleByUnitModel.getScheduleName());
            holder.unitName.setText(getListScheduleByUnitModel.getUnitName());
            holder.carPlateNumber.setText(getListScheduleByUnitModel.getCarPlateNumber());
            holder.securityName.setText(getListScheduleByUnitModel.getSecurityName());
            holder.driverName.setText(getListScheduleByUnitModel.getDriverName());
            holder.ownerName.setText(getListScheduleByUnitModel.getOwnerName());
            holder.escortName.setText(getListScheduleByUnitModel.getEscortName());
        }else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return getListScheduleByUnitModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView scheduleName,unitName,carPlateNumber
                ,securityName,driverName,ownerName,escortName;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            scheduleName = itemView.findViewById(R.id.scheduleName);
            unitName = itemView.findViewById(R.id.unitName);
            carPlateNumber = itemView.findViewById(R.id.carPlateNumber);
            securityName = itemView.findViewById(R.id.securityName);
            driverName = itemView.findViewById(R.id.driverName);
            ownerName = itemView.findViewById(R.id.ownerName);
            escortName = itemView.findViewById(R.id.escortName);




        }
    }
}
