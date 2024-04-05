package com.example.beatbuddy.ui.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.example.beatbuddy.R;
import com.example.beatbuddy.ui.Data.Artists;
import com.example.beatbuddy.ui.Services.Songs;

import java.util.ArrayList;

public class ArtistsFragment extends Fragment {
private ArrayList<Artists> artists = new ArrayList<>();
private  ArrayList<String>  artistNameList = new ArrayList<>();
private Songs songs;
    private RequestQueue q;
    private ArrayAdapter arrayAdapter;
    View view;
    ListView artistListView;

    public ArtistsFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_artists, container, false);
        artistListView = view.findViewById(R.id.Artist_listview);

        songs = new Songs(getContext());
        getArtistsForListView();

        arrayAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.row_artist,
                artistNameList
        );
        return view;
    }

    private void getArtistsForListView() {
        songs.getTopArtists(() -> {
            artists = songs.getArtists();
            updateListView(artists);
        });
    }

    private void updateListView(ArrayList<Artists> a) {
        artists = a ;
        for (Artists artist : a) {
            artistNameList.add(artist.getName());
        }
        if (artistListView != null) {
            artistListView.setAdapter(arrayAdapter);
            artistListView.setOnItemClickListener((parent, view1, position, id) -> {
                String name = artistNameList.get(position);
            });
        }
    }
}