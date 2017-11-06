package com.laluhilman.titlescroolview.customview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.laluhilman.titlescroolview.R;

import java.util.ArrayList;

/**
 * Created by laluhilman on 06/11/17.
 */

public class TitleAdapter extends ArrayAdapter<String> {

    Context context;
     ArrayList<String> list = new ArrayList<>();
    int layoutId;
    Holder holder;
    public View view;
    public int width;
    private TitleSelectedListener listener;
    private TitleSelectedListener reAddItemListener;
     int activeTitle;

    public TitleAdapter(Context context, ArrayList<String> title , TitleSelectedListener listener,  int width) {
        super(context, android.R.layout.simple_list_item_1, title);
        this.context = context;

        this.list.add("");
        this.list.addAll(title);
        this.list.add("");

        layoutId = R.layout.adapter_title;
        this.width=width;
        this.listener = listener;
        this.activeTitle = 1;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;
        if (convertView == null) {
            layout = (RelativeLayout) View.inflate(context, layoutId, null);
            holder = new Holder();
            holder.title = (TextView) layout.findViewById(R.id.titleTextView);
            layout.setTag(holder);

        } else {
            layout = (RelativeLayout) convertView;
            view = layout;
            holder = (Holder) layout.getTag();
        }
        String newsSource = getItem(position);
        holder.title.setText(newsSource);
        holder.title.setWidth(width);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listener.onClick(position);
                reAddItemListener.onClick(position);
                setActivePosition(position);

            }
        });
        holder.title.setTextColor(Color.BLACK);
        if(this.activeTitle == position)
            holder.title.setTextColor(getContext().getResources().getColor(R.color.active_color_title));
        else
            holder.title.setTextColor(getContext().getResources().getColor(R.color.in_active_color_title));
        return layout;
    }

    public void setReAddItemListener(TitleSelectedListener listener){
        this.reAddItemListener = listener;
    }

    private void setActivePosition(int position){
        this.activeTitle = position;
    }


    private class Holder {
        public TextView title;
    }

}
