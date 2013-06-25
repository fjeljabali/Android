package com.randomcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircle extends View 
{
/*********************************rand()*********************************/
	public static int rand(int a, int b)
	{
	   return((int)((b-a+1)*Math.random())+a);
	}
	
    Paint paint = new Paint();
/******************************DrawCircle()******************************/
    public DrawCircle(Context context, AttributeSet attrs) 
    {
       super(context, attrs);
       paint.setColor(Color.YELLOW);
    }
/******************************onDraw()******************************/
    @Override
    public void onDraw(Canvas canvas) 
    {
       canvas.drawCircle(rand(30,400), rand(30,400), 20, paint);       
    }

}