package com.example.mbbapp.Main;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mbbapp.Main.Model.TechATMModel;
import com.example.mbbapp.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ATM_Tech_Adapter extends RecyclerView.Adapter<ATM_Tech_Adapter.ViewHolder> {
    private static List<TechATMModel> techATMModelList;

    public ATM_Tech_Adapter(List<TechATMModel> techATMModelList) {
        this.techATMModelList = techATMModelList;
    }


    @NonNull
    @Override
    public ATM_Tech_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tech_atm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ATM_Tech_Adapter.ViewHolder holder, int position) {
        if(techATMModelList != null && getItemCount() > 0){
            TechATMModel techATMModel = techATMModelList.get(position);
            holder.name_techATM.setText(techATMModel.getName());
            holder.numberPhone_techATM.setText(techATMModel.getPhone());
            holder.email_techATM.setText(techATMModel.getEmail());
            holder.code_techATM.setText(techATMModel.getEmployeeCode());
            holder.card_number_techATM.setText(techATMModel.getCardNumber());
            holder.unit_name.setText(techATMModel.getUnitName());
            if(techATMModel.isStatus()){
                holder.status.setText("Đang làm việc");
            }else {
                holder.status.setText("Đã nghỉ việc");
            }

            String avatarUrl = techATMModel.getAvatar();
            if (avatarUrl != null && !avatarUrl.isEmpty()) {
                new ATM_Tech_Adapter.DownloadImageTask(holder.avatar).execute(avatarUrl);
            }

            boolean isExpandable = techATMModelList.get(position).isExpandble();
            holder.item_infor_techATM.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        }
    }



    @Override
    public int getItemCount() {
        return techATMModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_techATM,unit_name,numberPhone_techATM,email_techATM,status, code_techATM,card_number_techATM;
        private final ImageView avatar;
        private final LinearLayout click_visible;
        private final FrameLayout item_infor_techATM;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_techATM = itemView.findViewById(R.id.name_techATM);
            unit_name = itemView.findViewById(R.id.unit_name);
            numberPhone_techATM = itemView.findViewById(R.id.numberPhone_techATM);
            avatar = itemView.findViewById(R.id.avatar);
            status = itemView.findViewById(R.id.status_techATM);
            email_techATM = itemView.findViewById(R.id.email_techATM);
            card_number_techATM = itemView.findViewById(R.id.card_number_tech_ATM);
            code_techATM = itemView.findViewById(R.id.code_techATM);
            item_infor_techATM = itemView.findViewById(R.id.item_infor_techATM);
            click_visible = itemView.findViewById(R.id.click_visible);
            click_visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TechATMModel techATMModel = techATMModelList.get(getAdapterPosition());
                    techATMModel.setExpandble(!techATMModel.isExpandble());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bmp = null;
            try {
                URL imageUrl = new URL(url);
                bmp = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
