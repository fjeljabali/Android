package com.randomcircles;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawCircle extends View 
{
   Paint paint = new Paint();
/*********************************rand()*********************************/
   public static int rand(int a, int b)
   {
      return((int)((b-a+1)*Math.random())+a);
   }
	
/******************************DrawCircle()******************************/
   public DrawCircle(Context context, AttributeSet attrs) 
   {
      super(context, attrs);
      paint.setColor(Color.rgb(rand(0,255), rand(0,255), rand(0,255)));
   }
/******************************onDraw()******************************/
   @Override
   public void onDraw(Canvas canvas) 
   {
      canvas.drawCircle(rand(30,600), rand(30,750), 25, paint); 
   }

}