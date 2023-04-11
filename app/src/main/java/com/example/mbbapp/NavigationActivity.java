package com.example.mbbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.mbbapp.Test.Model_mainScreen;
import com.example.mbbapp.Test.TestActivity;
import com.example.mbbapp.Test.main_Screen_Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
                                                        , BottomNavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        DrawerLayout drawerLayout = findViewById(R.id.drawLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        gridView = findViewById(R.id.idGridMainScreen);
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

        main_Screen_Adapter adapter = new main_Screen_Adapter(this, model_mainScreenArrayList);
        gridView.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.TrangChu);



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuAssignmentList) {
            startActivity(new Intent(NavigationActivity.this, TestActivity.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}