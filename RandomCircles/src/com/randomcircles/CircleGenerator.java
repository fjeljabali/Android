package com.randomcircles;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.util.AttributeSet;

//import android.graphics.Color;

public class CircleGenerator extends Activity 
{
	DrawCircle drawcircle;
	@Override
	protected void onCreate(Bundle b) 
	{
		super.onCreate(b);
		setContentView(R.layout.activity_circle_generator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.circle_generator, menu);
		return true;
	}
	
   public void pushmebutton(View v)
   {
      drawcircle = new DrawCircle(this, null);
	  drawcircle.invalidate();
      setContentView(R.layout.activity_circle_generator);
   }
	

}
