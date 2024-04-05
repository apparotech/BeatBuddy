package com.example.beatbuddy.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beatbuddy.R;
import com.example.beatbuddy.ui.Adapter.ArtistsAdapter;
import com.example.beatbuddy.ui.Adapter.SongsAdapter;
import com.example.beatbuddy.ui.Data.HomeArtists;
import com.example.beatbuddy.ui.Data.HomeSongs;

import java.util.Arrays;

public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView topSongsRecycleView = view.findViewById(R.id.topSongsRecycleView);
        RecyclerView topSingersRecycleView = view.findViewById(R.id.topArtistsRecycleView);

        HomeSongs[] songs ={
                new HomeSongs(R.drawable.beatbuddy_icon, "So Far Away","Avenged Sevenfold"),
                new HomeSongs(R.drawable.beatbuddy_icon,"Ahora","Yeika"),
                new HomeSongs(R.drawable.beatbuddy_icon,"It Was a Good Day", "Ice Cub"),
                new HomeSongs(R.drawable.beatbuddy_icon, "The Law", "Leonard Cohen"),
                new HomeSongs(R.drawable.beatbuddy_icon,"Lovely Day", "Bill Withers"),

        };

        HomeArtists[] singers ={
                new HomeArtists(R.drawable.beatbuddy_icon,"Rihanna"),
                new HomeArtists(R.drawable.beatbuddy_icon,"Yeika"),
                new HomeArtists(R.drawable.beatbuddy_icon,"Ice Cub"),
                new HomeArtists(R.drawable.beatbuddy_icon,"Avenged Sevenfold"),
                new HomeArtists(R.drawable.beatbuddy_icon,"Blump"),
        };

        topSingersRecycleView.setAdapter(new SongsAdapter(songs));
        topSingersRecycleView.setAdapter(new ArtistsAdapter(Arrays.asList(singers)));

        topSongsRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topSingersRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return  view;

    }
}