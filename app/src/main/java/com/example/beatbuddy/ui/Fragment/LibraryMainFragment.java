package com.example.beatbuddy.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beatbuddy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LibraryMainFragment extends Fragment {
View view;
BottomNavigationView librarynav_view;
Fragment fragment = null;

    public LibraryMainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_library_main, container, false);
        librarynav_view = view.findViewById(R.id.librarynav_view);
        librarynav_view.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.topartist) {
                fragment = new ArtistsFragment();
            } else if (id==R.id.playlist) {
                fragment = new PlaylistsFragment();
            } else {
                System.out.println("invalid Id");
                return false;
            }
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer2,fragment).commit();
            return true;
        });

        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, new  PlaylistsFragment()).commit();
        return  view;
    }
}