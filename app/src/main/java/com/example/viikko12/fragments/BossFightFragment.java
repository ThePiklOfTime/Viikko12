package com.example.viikko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viikko12.R;


public class BossFightFragment extends Fragment {
    TextView bossText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = getView();
        bossText = view.findViewById(R.id.BossText);

        return inflater.inflate(R.layout.fragment_boss_fight, container, false);
    }
}