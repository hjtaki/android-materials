package com.example.android.songdetailstart;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.songdetailstart.content.SongUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends Fragment {
    public SongUtils.Song mSong;


    public static SongDetailFragment newInstance(int selectedSong){
        SongDetailFragment fragment = new SongDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(SongUtils.SONG_ID_KEY,selectedSong);
        fragment.setArguments(arguments);
        return fragment;
    }



    public SongDetailFragment() {

        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(SongUtils.SONG_ID_KEY)){
            mSong = SongUtils.SONG_ITEMS.get(getArguments().getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_song_detail, container, false);
        // Show the detail information in a TextView.
        if (mSong != null) {
            ((TextView) rootView.findViewById(R.id.song_detail))
                    .setText(mSong.details);
        }
        return rootView;
    }

}
