package com.example.beatbuddy.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.beatbuddy.R;
import com.example.beatbuddy.ui.Fragment.HomeFragment;
import com.example.beatbuddy.ui.Fragment.LibraryMainFragment;
import com.example.beatbuddy.ui.Fragment.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               int id = item.getItemId();
               if (id == R.id.home) {
                   fragment = new HomeFragment();
               } else if (id== R.id.search) {
                   fragment = new Search();
               } else if (id== R.id.library) {
                   fragment = new LibraryMainFragment();
               } else {
                   System.out.println("Invalid button");
                   return false;
               }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }
}