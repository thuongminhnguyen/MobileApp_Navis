package com.example.mbbapp.Main.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mbbapp.Main.Adapter.main_Screen_Adapter;
import com.example.mbbapp.Main.Model.Model_mainScreen;
import com.example.mbbapp.Main.ScheduleActivity;
import com.example.mbbapp.R;

import java.util.ArrayList;

public class Fragment_Main extends Fragment implements main_Screen_Adapter.OnItemClickListener {

    private GridView gridView;
    private main_Screen_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__main, container, false);

        gridView = view.findViewById(R.id.idGridMainScreen);
        adapter = new main_Screen_Adapter(getContext(), getModel_mainScreenArrayList());
        adapter.setOnItemClickListener(this);
        gridView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(Model_mainScreen item) {
        // Xử lý sự kiện tương ứng với từng item được bấm
        switch (item.getItem_name()) {
            case "Trực tuyến":
                Intent intent = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(intent);
                break;
            case "Phân công tuyến":
                // Xử lý cho item "Phân công tuyến"
                Toast.makeText(getContext(), "Đã bấm vào Phân công tuyến", Toast.LENGTH_SHORT).show();
                break;
            // Thêm các trường hợp khác tương ứng với từng item
            case "Lịch sử":

                break;
            case "Danh sách xe":
                VehicelFragment vehicelFragment = new VehicelFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.container, vehicelFragment).commit();
                break;
            case "Lái xe":
                Fragment_Driver fragment_driver = new Fragment_Driver();
                getParentFragmentManager().beginTransaction().replace(R.id.container, fragment_driver).commit();
                break;
            case "Chủ hàng":
                Fragment_Owner_ATM fragment_owner_atm = new Fragment_Owner_ATM();
                getParentFragmentManager().beginTransaction().replace(R.id.container, fragment_owner_atm).commit();
                break;
            case "Hộ tống":
                Fragment_Escort fragment_escort = new Fragment_Escort();
                getParentFragmentManager().beginTransaction().replace(R.id.container, fragment_escort).commit();
                break;
            case "Nhận cảnh báo":
                Fragment_Recipient fragment_recipient = new Fragment_Recipient();
                getParentFragmentManager().beginTransaction().replace(R.id.container, fragment_recipient).commit();
                break;
            case "Kĩ thuật ATM":
                Fragment_Tech_ATM fragment_tech_atm = new Fragment_Tech_ATM();
                getParentFragmentManager().beginTransaction().replace(R.id.container, fragment_tech_atm).commit();
                break;
            case "Thống kê":

                break;

            case "Báo cáo":

                break;

        }
    }

    private ArrayList<Model_mainScreen> getModel_mainScreenArrayList() {
        ArrayList<Model_mainScreen> model_mainScreenArrayList = new ArrayList<>();
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Phân công tuyến", R.drawable.phan_cong_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Danh sách xe", R.drawable.baseline_directions_car_24));
        model_mainScreenArrayList.add(new Model_mainScreen("Lịch sử", R.drawable.lich_su));
        model_mainScreenArrayList.add(new Model_mainScreen("Lái xe", R.drawable.lai_xe));
        model_mainScreenArrayList.add(new Model_mainScreen("Chủ hàng", R.drawable.chu_hang));
        model_mainScreenArrayList.add(new Model_mainScreen("Kĩ thuật ATM", R.drawable.chu_hang));
        model_mainScreenArrayList.add(new Model_mainScreen("Hộ tống", R.drawable.chu_hang));
        model_mainScreenArrayList.add(new Model_mainScreen("Nhận cảnh báo", R.drawable.chu_hang));
        model_mainScreenArrayList.add(new Model_mainScreen("Thống kê", R.drawable.thong_ke));
        model_mainScreenArrayList.add(new Model_mainScreen("Báo cáo", R.drawable.bao_cao));
        // model_mainScreenArrayList.add(new Model_mainScreen("Tài khoản", R.drawable.tai_khoan));
        return model_mainScreenArrayList;
    }
}
