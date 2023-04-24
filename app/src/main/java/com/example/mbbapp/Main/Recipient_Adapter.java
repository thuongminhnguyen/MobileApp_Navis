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
import com.example.mbbapp.Main.Model.RecipientModel;
import com.example.mbbapp.R;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class Recipient_Adapter extends RecyclerView.Adapter<Recipient_Adapter.ViewHolder>{

    private static List<RecipientModel>  recipientModelList;

    public Recipient_Adapter(List<RecipientModel> recipientModelList) {
        this.recipientModelList = recipientModelList;
    }

    @NonNull
    @Override
    public Recipient_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipient,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recipient_Adapter.ViewHolder holder, int position) {
        if(recipientModelList != null && getItemCount() > 0){
            RecipientModel recipientModel = recipientModelList.get(position);
            holder.name_recipient.setText(recipientModel.getName());
            holder.numberPhone_recipient.setText(recipientModel.getPhone());
            holder.unit_name.setText(recipientModel.getUnitName());
           // holder.status.setText(recipientModel.isStatus());
            if(recipientModel.isStatus() == true){
                holder.status.setText("Đã nghỉ việc");
            }else{
                holder.status.setText("Đang làm việc");
            }
            holder.staff_recipient.setText(recipientModel.getStaffCode());
            holder.email_recipient.setText(recipientModel.getEmail());
            holder.position.setText(recipientModel.getPosition());
            String avatarUrl = recipientModel.getAvatar();
            if (avatarUrl != null && !avatarUrl.isEmpty()) {
                new DownloadImageTask(holder.avatar).execute(avatarUrl);
            }

            boolean isExpandable = recipientModelList.get(position).isExpandble();
            holder.item_infor_recipient.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return recipientModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name_recipient,unit_name,numberPhone_recipient,status,staff_recipient,position,email_recipient;
        private final ImageView avatar;
        private final LinearLayout click_visible;
        private final FrameLayout item_infor_recipient;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_recipient = itemView.findViewById(R.id.name_recipient);
            unit_name = itemView.findViewById(R.id.unit_name);
            numberPhone_recipient = itemView.findViewById(R.id.numberPhone_recipient);
            avatar = itemView.findViewById(R.id.avatar);
            email_recipient = itemView.findViewById(R.id.email_recipient);
            position = itemView.findViewById(R.id.position_recipient);
            staff_recipient = itemView.findViewById(R.id.code_recipient);
            status = itemView.findViewById(R.id.status_recipient);
            item_infor_recipient = itemView.findViewById(R.id.item_infor_recipient);
            click_visible = itemView.findViewById(R.id.click_visible);
            click_visible.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecipientModel recipientAdapter = recipientModelList.get(getAdapterPosition());
                    recipientAdapter.setExpandble(!recipientAdapter.isExpandble());
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
