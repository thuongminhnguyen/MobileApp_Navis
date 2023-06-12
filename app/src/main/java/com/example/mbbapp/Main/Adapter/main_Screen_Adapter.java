package com.example.mbbapp.Main.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mbbapp.Main.Model.Model_mainScreen;
import com.example.mbbapp.R;

import java.util.ArrayList;

public class main_Screen_Adapter extends ArrayAdapter<Model_mainScreen> {

    private OnItemClickListener listener;

    public main_Screen_Adapter(@NonNull Context context, ArrayList<Model_mainScreen> mainScreensModelArrayList) {
        super(context, 0, mainScreensModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder viewHolder;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_main_screen, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.courseTV = listItemView.findViewById(R.id.idTVCourse);
            viewHolder.courseIV = listItemView.findViewById(R.id.idIVcourse);
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        Model_mainScreen model_mainScreen = getItem(position);
        viewHolder.courseTV.setText(model_mainScreen.getItem_name());
        viewHolder.courseIV.setImageResource(model_mainScreen.getImgid());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(model_mainScreen);
                }
            }
        });

        return listItemView;
    }

    private static class ViewHolder {
        TextView courseTV;
        ImageView courseIV;
    }

    public interface OnItemClickListener {
        void onItemClick(Model_mainScreen item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
