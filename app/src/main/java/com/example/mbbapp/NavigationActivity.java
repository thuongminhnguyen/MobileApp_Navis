package com.example.mbbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mbbapp.Main.Fragment_Driver;
import com.example.mbbapp.Main.Fragment_Escort;
import com.example.mbbapp.Main.Fragment_Main;
import com.example.mbbapp.Main.Fragment_Notification;
import com.example.mbbapp.Main.Fragment_Owner_ATM;
import com.example.mbbapp.Main.TestActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class NavigationActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
                                                        , BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Fragment_Escort fragment_escort = new Fragment_Escort();
    Fragment_Owner_ATM fragment_owner_atm = new Fragment_Owner_ATM();
    Fragment_Main fragmentMain = new Fragment_Main();
    Fragment_Driver fragment_driver = new Fragment_Driver();

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment_owner_atm).commit();
                        return true;
                  case R.id.taikhoan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_escort).commit();
                        return true;
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