package com.example.newcanlender;

import android.content.Context;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by q9163 on 12/09/2018.
 */

public class NewCanlender extends LinearLayout {

    private ImageView btnPrev,btNext;
    private TextView textdate;
    private GridView gridView;

    private Calendar curDate = Calendar.getInstance();

    public NewCanlender(Context context) {
        super(context);
    }

    public NewCanlender(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
    }

    public NewCanlender(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context);
    }
    private void initControl(Context context)
    {
        bindControl(context);
        bindControlEvent();
        renderCalender();
    }


    private void bindControl(Context context)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.canlender_view, this, false);
        btnPrev = (ImageView) findViewById(R.id.btnPrev);
        btNext = (ImageView) findViewById(R.id.btnNext);
        textdate = (TextView) findViewById(R.id.txtDate);
        gridView = (GridView) findViewById(R.id.calender_grid);
    }
    private void bindControlEvent() {
        btnPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                curDate.add(Calendar.MONTH, -1);
                renderCalender();
            }
        });
        btNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                curDate.add(Calendar.MONTH, 1);
                renderCalender();
            }
        });
    }

    private void renderCalender(){

    }

}
