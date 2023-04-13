package com.example.mbbapp.Test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {


    private static List<GetListScheduleByUnitModel> getListScheduleByUnitModelList;

    public ScheduleAdapter(List<GetListScheduleByUnitModel> getListScheduleByUnitModelList) {
        this.getListScheduleByUnitModelList = getListScheduleByUnitModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit_schedule,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(getListScheduleByUnitModelList != null && getListScheduleByUnitModelList.size() > 0){
            GetListScheduleByUnitModel getListScheduleByUnitModel = getListScheduleByUnitModelList.get(position);
            holder.tableLayout.setBackgroundResource(R.drawable.item_background);
            holder.itemLinearLayout.setBackgroundResource(R.drawable.item_layout_background);
            holder.scheduleName.setText(getListScheduleByUnitModel.getScheduleName());
            holder.carPlateNumber.setText(getListScheduleByUnitModel.getCarPlateNumber());
            holder.securityName.setText(getListScheduleByUnitModel.getSecurityName());
            holder.driverName.setText(getListScheduleByUnitModel.getDriverName());
            holder.ownerName.setText(getListScheduleByUnitModel.getOwnerName());
            holder.escortName.setText(getListScheduleByUnitModel.getEscortName());
            holder.ownerPhone.setText(getListScheduleByUnitModel.getOwnerPhone());
            holder.drivePhone.setText(getListScheduleByUnitModel.getDriverPhone());
            holder.ktvPhone.setText(getListScheduleByUnitModel.getKtvPhone());
            holder.escortPhone.setText(getListScheduleByUnitModel.getEscortPhone());
            holder.timeDate.setText(convertTime(getListScheduleByUnitModel.getRunningDate(),2));
            holder.startTime.setText(convertTime(getListScheduleByUnitModel.getStartTime(),1));
            holder.finishTime.setText(convertTime(getListScheduleByUnitModel.getEndTime(),1));

            boolean isExpandable = getListScheduleByUnitModelList.get(position).isExpandble();
            holder.tableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        }else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return getListScheduleByUnitModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView scheduleName,carPlateNumber
                ,securityName,driverName,ownerName,escortName,startTime, finishTime, drivePhone, ownerPhone, escortPhone,ktvPhone;
        private final TextView timeDate;
        private final TableLayout tableLayout;
        private final LinearLayoutCompat itemLinearLayout;
        private final ImageView click_Visible;
        private final LinearLayoutCompat linearLayoutCompat;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            scheduleName = itemView.findViewById(R.id.id_nameSchedule);
            carPlateNumber = itemView.findViewById(R.id.id_CarPlateNumber);
            securityName = itemView.findViewById(R.id.id_securityName);
            driverName = itemView.findViewById(R.id.id_nameDrive);
            ownerName = itemView.findViewById(R.id.id_nameOwner);
            escortName = itemView.findViewById(R.id.id_escortName);
            timeDate = itemView.findViewById(R.id.id_date);
            startTime = itemView.findViewById(R.id.id_timeStart);
            finishTime = itemView.findViewById(R.id.id_timeFinish);
            tableLayout = itemView.findViewById(R.id.item_detailShecduler);
            itemLinearLayout= itemView.findViewById(R.id.item_layout);
            click_Visible = itemView.findViewById(R.id.click_visible);
            linearLayoutCompat = itemView.findViewById(R.id.item_dateInforSchedule);
            escortPhone = itemView.findViewById(R.id.id_phoneEscort);
            ownerPhone = itemView.findViewById(R.id.id_phoneOwner);
            drivePhone = itemView.findViewById(R.id.id_phoneDrive);
            ktvPhone = itemView.findViewById(R.id.id_phoneSercur);

            click_Visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GetListScheduleByUnitModel scheduleAdapter = getListScheduleByUnitModelList.get(getAdapterPosition());
                    scheduleAdapter.setExpandble(!scheduleAdapter.isExpandble());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
    public String convertTime(String timeDateString, int check){

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inputDateFormat.parse(timeDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String hourMinuteString = String.format("%02d:%02d", hour, minute);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String newDateString = newFormat.format(date);
        if(check == 1){
            return hourMinuteString;
        }
        if(check == 2){
            return newDateString;
        }
        return null;
    }
}
