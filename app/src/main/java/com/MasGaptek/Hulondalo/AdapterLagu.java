package com.MasGaptek.Hulondalo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterLagu extends ArrayAdapter<ItemLagu> {

    public AdapterLagu(Context context, List<ItemLagu> items) {
        super(context, R.layout.row_lagu, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_lagu, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.imgPlay);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.txtJudul);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.txtPenyanyi);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        ItemLagu item = getItem(position);
        viewHolder.ivIcon.setImageResource(item.icon);
        viewHolder.tvTitle.setText(item.title);
        viewHolder.tvDescription.setText(item.singer);

        return convertView;
    }

    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvDescription;
    }

}
