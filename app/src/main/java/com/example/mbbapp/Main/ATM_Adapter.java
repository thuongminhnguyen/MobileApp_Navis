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

import com.example.mbbapp.Main.Model.OwnerATMModel;
import com.example.mbbapp.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class ATM_Adapter extends RecyclerView.Adapter<ATM_Adapter.ViewHolder>{

    private static List<OwnerATMModel>  ownerATMModelList;

    public ATM_Adapter(List<OwnerATMModel> ownerATMModelList) {
        this.ownerATMModelList = ownerATMModelList;
    }

    @NonNull
    @Override
    public ATM_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_owner_atm,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ATM_Adapter.ViewHolder holder, int position) {
        if(ownerATMModelList != null && getItemCount() > 0){
            OwnerATMModel ownerATMModel = ownerATMModelList.get(position);
            holder.name_ownerATM.setText(ownerATMModel.getName());
            holder.numberPhone_ownerATM.setText(ownerATMModel.getPhone());
            holder.unit_name.setText(ownerATMModel.getUnitName());
            holder.card_number_ownerATM.setText(ownerATMModel.getCardNumber());
            holder.code_ownerATM.setText(ownerATMModel.getEmployeeCode());
            holder.email_ownerATM.setText(ownerATMModel.getEmail());

            String avatarUrl = ownerATMModel.getAvatar();
            if (avatarUrl != null && !avatarUrl.isEmpty()) {
                new DownloadImageTask(holder.avatar).execute(avatarUrl);
            }

            boolean isExpandable = ownerATMModelList.get(position).isExpandble();
            holder.item_infor_ownerATM.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return ownerATMModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_ownerATM,unit_name,numberPhone_ownerATM,email_ownerATM,code_ownerATM,card_number_ownerATM;
        private final ImageView avatar;
        private final LinearLayout click_visible;
        private final FrameLayout item_infor_ownerATM;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_ownerATM = itemView.findViewById(R.id.name_ownerATM);
            unit_name = itemView.findViewById(R.id.unit_name);
            numberPhone_ownerATM = itemView.findViewById(R.id.numberPhone_ownerATM);
            avatar = itemView.findViewById(R.id.avatar);
            email_ownerATM = itemView.findViewById(R.id.email_ownerATM);
            card_number_ownerATM = itemView.findViewById(R.id.card_number_ownerATM);
            code_ownerATM = itemView.findViewById(R.id.code_ownerATM);
            item_infor_ownerATM = itemView.findViewById(R.id.item_infor_ownerATM);
            click_visible = itemView.findViewById(R.id.click_visible);
            click_visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OwnerATMModel ownerATMAdapter = ownerATMModelList.get(getAdapterPosition());
                    ownerATMAdapter.setExpandble(!ownerATMAdapter.isExpandble());
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
