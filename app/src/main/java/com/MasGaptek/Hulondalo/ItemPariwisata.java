package com.MasGaptek.Hulondalo;

import android.graphics.drawable.Drawable;

public class ItemPariwisata {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the GridView item title

    public ItemPariwisata(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }
}
