package com.laluhilman.titlescroolview.customview;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.laluhilman.titlescroolview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laluhilman on 06/11/17.
 */



public class TitleView extends HorizontalScrollView {

    Context context;
    int prevIndex = 0;
    private int activeTitle=1;
    private ArrayList<String> listTitle = new ArrayList<>();
    private int width;


    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setSmoothScrollingEnabled(true);
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        LinearLayout layout  = new LinearLayout(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                1.0f
        );
        layout.setLayoutParams(param);
        addView(layout);

    }


    public void setUpView(ArrayList<String> titleList, int width) {
        this.listTitle.add("");
        this.listTitle.addAll(titleList);
        this.listTitle.add("");
        this.width = width;
        addChildView();

    }



    private void addChildView(){
        if (getChildCount() == 0 )
            return;

        ViewGroup parent = (ViewGroup) getChildAt(0);
        parent.removeAllViews();


        for (int i = 0; i < listTitle.size(); i++) {
            parent.addView(getViewItemPosition(i));
        }
    }

    public void setActiveItem(int index) {
        activeTitle = index;
        ViewGroup parent = (ViewGroup) getChildAt(0);
        View preView = parent.getChildAt(prevIndex);
        android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(5, 5, 5, 5);
        preView.setLayoutParams(lp);
        View view = parent.getChildAt(index);
        int screenWidth = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth();
        int scrollX = (view.getLeft() - (screenWidth / 2)) + (view.getWidth() / 2);
        this.smoothScrollTo(scrollX, 0);
        prevIndex = index;
        addChildView();
    }

    private View getViewItemPosition(final int position){
        RelativeLayout layout = (RelativeLayout) View.inflate(context, R.layout.adapter_title, null);
        Holder holder = new TitleView.Holder();
        holder.title = (TextView) layout.findViewById(R.id.titleTextView);
        layout.setTag(holder);

        String newsSource = listTitle.get(position);
        holder.title.setText(newsSource);
        holder.title.setWidth(width);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position!= 0 && position !=listTitle.size()-1){
                    activeTitle = position;
                    setActiveItem(position);
                    addChildView();

                }
            }
        });

        holder.title.setTextColor(Color.BLACK);
        if(this.activeTitle == position)
            holder.title.setTextColor(getContext().getResources().getColor(R.color.active_color_title));
        else
            holder.title.setTextColor(getContext().getResources().getColor(R.color.in_active_color_title));
        return layout;
    }

    private class Holder {
        public TextView title;
    }










}
