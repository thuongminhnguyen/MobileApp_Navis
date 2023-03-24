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
import android.widget.GridView;

import com.example.mbbapp.Test.Model_mainScreen;
import com.example.mbbapp.Test.TestActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavigationActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
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


        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

        ArrayList<Model_mainScreen> model_mainScreenArrayList = new ArrayList<Model_mainScreen>();
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));
        model_mainScreenArrayList.add(new Model_mainScreen("Trực tuyến", R.drawable.truc_tuyen));



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