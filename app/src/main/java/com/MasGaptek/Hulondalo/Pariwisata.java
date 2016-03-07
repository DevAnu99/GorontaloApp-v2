package com.MasGaptek.Hulondalo;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Pariwisata extends Fragment implements AdapterView.OnItemClickListener{
    private List<ItemPariwisata> mItems;    // GridView items list
    private AdapterPariwisata mAdapter;

    public Pariwisata() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<ItemPariwisata>();
        Resources resources = getResources();

        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));
        mItems.add(new ItemPariwisata(resources.getDrawable(R.drawable.pariwisata_main), getString(R.string.app_name)));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.content_frag_pariwisata, container, false);

        View fragmentView = inflater.inflate(R.layout.content_frag_pariwisata, container, false);

        mAdapter = new AdapterPariwisata(getActivity(), mItems);
        GridView gridView = (GridView) fragmentView.findViewById(R.id.gridView);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(this);
        return fragmentView;
    }

    @Override
    public void onItemClick(final AdapterView<?> parent,final View v, final int position,final long id) {
        ItemPariwisata item = mItems.get(position);
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}
