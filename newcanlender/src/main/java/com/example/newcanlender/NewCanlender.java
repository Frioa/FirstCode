package com.example.newcanlender;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

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
        bindControl(context);// 查找控件
        bindControlEvent();// 点击事件
        renderCalender();
    }


    private void bindControl(Context context)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.canlender_view, this);
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
    // 日历控件的绘制
    private void renderCalender(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
        textdate.setText(sdf.format(curDate.getTime()));

        ArrayList<Date> cells = new ArrayList<>();
        Calendar calender = (Calendar) curDate.clone();

        calender.set(Calendar.DAY_OF_MONTH, 1);
        int prevDays = calender.get(Calendar.DAY_OF_WEEK) - 1;
        calender.add(Calendar.DAY_OF_MONTH, -prevDays);

        int maxCellCount = 6*7;
        while(cells.size() < maxCellCount){
            cells.add(calender.getTime());
            calender.add(Calendar.DAY_OF_MONTH, 1);
        }

        gridView.setAdapter(new CalenderAdapter(getContext(),cells ));
    }

    private class CalenderAdapter extends ArrayAdapter<Date>{
        LayoutInflater inflater;
        public CalenderAdapter(Context context, ArrayList<Date> days) {
            super(context, R.layout.calender_text_day, days);
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           Date date = getItem(position);
            if(convertView == null){
                convertView = inflater.inflate(R.layout.calender_text_day, parent, false);
            }

            int day = date.getDate();
            ((TextView)convertView).setText(String.valueOf(day));

            return convertView;
        }
    }

}
