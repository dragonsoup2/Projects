package com.example.drago.food;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by drago on 2016-01-20.
 */
public class MenuAdapter extends BaseAdapter
{
    private Context ct;
    private List<SlideMenu> lsm;

    public MenuAdapter(Context context, List<SlideMenu> sm) {
        this.ct = context;
        this.lsm = sm;
    }

    @Override
    public int getCount() {
        return lsm.size();
    }

    @Override
    public Object getItem(int position) {
        return lsm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = View.inflate(ct, R.layout.drawer_items, null);

        ImageView iv = (ImageView) v.findViewById(R.id.item_img);
        TextView tv = (TextView) v.findViewById(R.id.item_title);

        SlideMenu sm = lsm.get(position);
        iv.setImageResource(sm.getImgId());
        tv.setText(sm.getTitle());

        return v;
    }
}