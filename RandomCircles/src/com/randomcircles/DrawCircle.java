package com.randomcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircle extends View 
{
    Paint paint = new Paint();

    public DrawCircle(Context context, AttributeSet attrs) 
    {
       super(context, attrs);
       paint.setColor(Color.YELLOW);
    }

    @Override
    public void onDraw(Canvas canvas) 
    {
       canvas.drawCircle(175, 275, 50, paint);       
    }

}