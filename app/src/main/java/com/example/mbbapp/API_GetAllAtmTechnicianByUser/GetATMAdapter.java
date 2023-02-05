package com.example.mbbapp.API_GetAllAtmTechnicianByUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.R;

import java.util.List;

public class GetATMAdapter extends RecyclerView.Adapter<GetATMAdapter.GetATMViewHolder> {

    private final List<ATMTechByUserModel> mListATMTech;

    public GetATMAdapter(List<ATMTechByUserModel> mListATMTech) {
        this.mListATMTech = mListATMTech;
    }

    @NonNull
    @Override
    public GetATMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atm_tech_by_user,parent,false);

        return new GetATMViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetATMViewHolder holder, int position) {
        ATMTechByUserModel atmTechByUser = mListATMTech.get(position);
        if(atmTechByUser == null){
            return;
        }
        holder.id.setText(atmTechByUser.getId());
        holder.avatar.setText(atmTechByUser.getAvatar());
        holder.employeeCode.setText(atmTechByUser.getEmployeeCode());
        holder.name.setText(atmTechByUser.getName());
        holder.sexStr.setText(atmTechByUser.getSexStr());
        holder.phone.setText(atmTechByUser.getPhone());
        holder.email.setText(atmTechByUser.getEmail());
        holder.status.setText(atmTechByUser.getStatus());
        holder.unitId.setText(atmTechByUser.getUnitId());
        holder.unitName.setText(atmTechByUser.getUnitName());
        holder.rfidId.setText(atmTechByUser.getRfidId());
        holder.cardNumber.setText(atmTechByUser.getCardNumber());
    }

    @Override
    public int getItemCount() {
        if(mListATMTech != null){
            return mListATMTech.size();
        }
        return 0;
    }

    public static class GetATMViewHolder extends RecyclerView.ViewHolder{
        private final TextView id;
        private final TextView avatar;
        private final TextView employeeCode;
        private final TextView name;
        private final TextView sexStr;
        private final TextView phone;
        private final TextView email;
        private final TextView status;
        private final TextView unitId;
        private final TextView unitName;
        private final TextView rfidId;
        private final TextView cardNumber;
        public GetATMViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            avatar = itemView.findViewById(R.id.avatar);
            employeeCode = itemView.findViewById(R.id.employeeCode);
            name = itemView.findViewById(R.id.name);
            sexStr = itemView.findViewById(R.id.sexStr);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            status = itemView.findViewById(R.id.status);
            unitId = itemView.findViewById(R.id.unitId);
            unitName = itemView.findViewById(R.id.unitName);
            rfidId = itemView.findViewById(R.id.rfidId);
            cardNumber = itemView.findViewById(R.id.cardNumber);

        }
    }
}
