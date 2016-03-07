package com.MasGaptek.Hulondalo;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Lagu extends ListFragment {

    private List<ItemLagu> mItems;

    public Lagu() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<ItemLagu>();

        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 1","ListFragment Jones 1"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 2","ListFragment Jones 2"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 3","ListFragment Jones 3"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 4","ListFragment Jones 4"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 5","ListFragment Jones 5"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 6","ListFragment Jones 6"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 7","ListFragment Jones 7"));
        mItems.add(new ItemLagu(R.drawable.play,"Gorontalo 8","ListFragment Jones 8"));
        setListAdapter(new AdapterLagu(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);
        getListView().setVerticalScrollBarEnabled(false);
        getListView().setHorizontalScrollBarEnabled(false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ItemLagu item = mItems.get(position);
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}
