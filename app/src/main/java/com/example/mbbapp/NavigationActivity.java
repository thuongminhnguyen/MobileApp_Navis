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

import com.example.mbbapp.Test.Fragment_Main;
import com.example.mbbapp.Test.Fragment_Notification;
import com.example.mbbapp.Test.Model_mainScreen;
import com.example.mbbapp.Test.TestActivity;
import com.example.mbbapp.Test.main_Screen_Adapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
                                                        , BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    Fragment_Notification fragmentNotification = new Fragment_Notification();
    Fragment_Main fragmentMain = new Fragment_Main();

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


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentMain).commit();

//        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.thongBao);
//        badgeDrawable.setVisible(true);
       // badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.TrangChu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMain).commit();
                        return true;
                    case R.id.thongBao:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentNotification).commit();
                        return true;
//                    case R.id.settings:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
//                        return true;
                }

                return false;
            }
        });


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