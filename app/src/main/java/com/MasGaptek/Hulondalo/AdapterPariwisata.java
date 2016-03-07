package com.MasGaptek.Hulondalo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterPariwisata extends BaseAdapter {
    private Context mContext;
    private List<ItemPariwisata> mItems;

    public AdapterPariwisata(Context context, List<ItemPariwisata> items) {
        mContext = context;
        mItems = items;
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.row_pariwisata, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.inIcon = (ImageView) convertView.findViewById(R.id.icon_row);
            viewHolder.tvTittle = (TextView) convertView.findViewById(R.id.row_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemPariwisata item = mItems.get(position);
        viewHolder.inIcon.setImageDrawable(item.icon);
        viewHolder.tvTittle.setText(item.title);
        return convertView;
    }

    private class ViewHolder {
        ImageView inIcon;
        TextView tvTittle;
    }
}
