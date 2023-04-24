package com.example.mbbapp.Main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mbbapp.R;

import java.util.ArrayList;

public class Fragment_Main extends Fragment {

    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment__main, container, false);
        gridView = view.findViewById(R.id.idGridMainScreen);
        ArrayList<Model_mainScreen> model_mainScreenArrayList = new ArrayList<Model_mainScreen>();
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Phân công tuyến", R.drawable.phan_cong_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Danh sách xe", R.drawable.baseline_directions_car_24));
        model_mainScreenArrayList.add(new Model_mainScreen("Lịch sử", R.drawable.lich_su));
        model_mainScreenArrayList.add(new Model_mainScreen("Lái xe", R.drawable.lai_xe));
        model_mainScreenArrayList.add(new Model_mainScreen("Chủ hàng", R.drawable.chu_hang));
        model_mainScreenArrayList.add(new Model_mainScreen("Thống kê", R.drawable.thong_ke));
        model_mainScreenArrayList.add(new Model_mainScreen("Báo cáo", R.drawable.bao_cao));
        // model_mainScreenArrayList.add(new Model_mainScreen("Tài khoản", R.drawable.tai_khoan));

        main_Screen_Adapter adapter = new main_Screen_Adapter(getContext(), model_mainScreenArrayList);
        gridView.setAdapter(adapter);
        return view;
    }
}