package com.MasGaptek.Hulondalo;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gordonwong.materialsheetfab.MaterialSheetFab;
import com.gordonwong.materialsheetfab.MaterialSheetFabEventListener;

public class Kebudayaan extends Fragment implements View.OnClickListener {

    private MaterialSheetFab materialSheetFab;
    private int statusBarColor;

    public Kebudayaan() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_frag_kebudayaan, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupFab();
    }

    private void setupFab() {
        Fab fab = (Fab) getView().findViewById(R.id.fab);
        View sheetView = getView().findViewById(R.id.fab_sheet);
        View overlay = getView().findViewById(R.id.overlay);
        int sheetColor = getResources().getColor(R.color.cardview_light_background);
        int fabColor = getResources().getColor(R.color.colorAccent);

        materialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay, sheetColor, fabColor);

        materialSheetFab.setEventListener(new MaterialSheetFabEventListener() {
            @Override
            public void onShowSheet() {
                super.onShowSheet();
            }

            @Override
            public void onHideSheet() {
                super.onHideSheet();
            }
        });

        getView().findViewById(R.id.fab1).setOnClickListener(this);
        getView().findViewById(R.id.fab2).setOnClickListener(this);
        getView().findViewById(R.id.fab3).setOnClickListener(this);
        getView().findViewById(R.id.fab4).setOnClickListener(this);
        getView().findViewById(R.id.fab5).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab1:
                Toast.makeText(getActivity(),"Rumah Adat Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2:
                Toast.makeText(getActivity(),"Pakaian Adat Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab3:
                Toast.makeText(getActivity(),"Tarian Tradisional Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4:
                Toast.makeText(getActivity(),"Senjata Tradisional Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab5:
                Toast.makeText(getActivity(),"Alat Musik Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        materialSheetFab.hideSheet();
    }
}
