package com.example.newcanlender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by q9163 on 12/09/2018.
 */

public class Calender_day_textview extends TextView {
    public boolean isToday = false;
    private Paint paint = new Paint();

    public Calender_day_textview(Context context) {
        super(context);
    }

    public Calender_day_textview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl();
    }

    public Calender_day_textview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl();
    }

    private void initControl(){
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#ff0000"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isToday){
            canvas.translate(getWidth()/2, getHeight()/2);
            canvas.drawCircle(0, 0, getWidth()/2, paint);
        }

    }
}
