package com.example.mbbapp.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mbbapp.R;

import java.util.ArrayList;

public class main_Screen_Adapter extends ArrayAdapter<Model_mainScreen> {

    public main_Screen_Adapter(@NonNull Context context, ArrayList<Model_mainScreen> mainScreensModelArrayList){
        super(context, 0, mainScreensModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.item_main_screen, parent, false);
        }

        Model_mainScreen model_mainScreen = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);

        courseTV.setText(model_mainScreen.getItem_name());
        courseIV.setImageResource(model_mainScreen.getImgid());
        return listitemView;
    }
}
