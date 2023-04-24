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

import com.example.mbbapp.Main.Model.DriverModel;
import com.example.mbbapp.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder>{

    private static List<DriverModel> driverModelList;

    public DriverAdapter(List<DriverModel> driverModelList) {
        this.driverModelList = driverModelList;
    }

    @NonNull
    @Override
    public DriverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_driver,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverAdapter.ViewHolder holder, int position) {
        if(driverModelList != null && getItemCount() > 0){
            DriverModel driverModel = driverModelList.get(position);
            holder.name_driver.setText(driverModel.getName());
            holder.numberPhone_driver.setText(driverModel.getPhone());
            holder.unit_name.setText(driverModel.getUnitName());
            holder.card_number_driver.setText(driverModel.getCardNumber());
            holder.code_driver.setText(driverModel.getEmployeeCode());
            holder.email_driver.setText(driverModel.getEmail());

            String avatarUrl = driverModel.getAvatar();
            if (avatarUrl != null && !avatarUrl.isEmpty()) {
                new DownloadImageTask(holder.avatar).execute(avatarUrl);
            }

            boolean isExpandable = driverModelList.get(position).isExpandble();
            holder.item_infor_driver.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return driverModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_driver,unit_name,numberPhone_driver,email_driver,code_driver,card_number_driver;
        private final ImageView avatar;
        private final LinearLayout click_visible;
        private final FrameLayout item_infor_driver;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_driver = itemView.findViewById(R.id.name_driver);
            unit_name = itemView.findViewById(R.id.unit_name);
            numberPhone_driver = itemView.findViewById(R.id.numberPhone_driver);
            avatar = itemView.findViewById(R.id.avatar);
            email_driver = itemView.findViewById(R.id.email_driver);
            card_number_driver = itemView.findViewById(R.id.card_number_driver);
            code_driver = itemView.findViewById(R.id.code_driver);
            item_infor_driver = itemView.findViewById(R.id.item_infor_driver);
            click_visible = itemView.findViewById(R.id.click_visible);
            click_visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DriverModel driverAdapter = driverModelList.get(getAdapterPosition());
                    driverAdapter.setExpandble(!driverAdapter.isExpandble());
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
