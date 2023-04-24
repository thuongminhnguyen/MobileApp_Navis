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

import com.example.mbbapp.Model.DriverModel;
import com.example.mbbapp.Model.EscortModel;
import com.example.mbbapp.Model.OwnerATMModel;
import com.example.mbbapp.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class Escort_Adapter extends RecyclerView.Adapter<Escort_Adapter.ViewHolder>{

    private static List<EscortModel>  escortModelList;

    public Escort_Adapter(List<EscortModel> escortModelList) {
        this.escortModelList = escortModelList;
    }

    @NonNull
    @Override
    public Escort_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_escort,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Escort_Adapter.ViewHolder holder, int position) {
        if(escortModelList != null && getItemCount() > 0){
            EscortModel escortModel = escortModelList.get(position);
            holder.name_escort.setText(escortModel.getName());
            holder.numberPhone_escort.setText(escortModel.getPhone());
            holder.unit_name.setText(escortModel.getUnitName());
            holder.card_number_escort.setText(escortModel.getCardNumber());
            holder.code_escort.setText(escortModel.getEmployeeCode());
            holder.email_escort.setText(escortModel.getEmail());

            String avatarUrl = escortModel.getAvatar();
            if (avatarUrl != null && !avatarUrl.isEmpty()) {
                new DownloadImageTask(holder.avatar).execute(avatarUrl);
            }

            boolean isExpandable = escortModelList.get(position).isExpandble();
            holder.item_infor_escort.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return escortModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_escort,unit_name,numberPhone_escort,email_escort,code_escort,card_number_escort;
        private final ImageView avatar;
        private final LinearLayout click_visible;
        private final FrameLayout item_infor_escort;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_escort = itemView.findViewById(R.id.name_escort);
            unit_name = itemView.findViewById(R.id.unit_name);
            numberPhone_escort = itemView.findViewById(R.id.numberPhone_escort);
            avatar = itemView.findViewById(R.id.avatar);
            email_escort = itemView.findViewById(R.id.email_escort);
            card_number_escort = itemView.findViewById(R.id.card_number_escort);
            code_escort = itemView.findViewById(R.id.code_escort);
            item_infor_escort = itemView.findViewById(R.id.item_infor_escort);
            click_visible = itemView.findViewById(R.id.click_visible);
            click_visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EscortModel escortAdapter = escortModelList.get(getAdapterPosition());
                    escortAdapter.setExpandble(!escortAdapter.isExpandble());
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
