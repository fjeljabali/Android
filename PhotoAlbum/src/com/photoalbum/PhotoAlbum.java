package com.photoalbum;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class PhotoAlbum extends Activity 
{
   Integer pics[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3+
		             R.drawable.pic4, R.drawable.pic5, R.drawable.pic6+
		             R.drawable.pic7};

/*********************************onCreate()*********************************/
   @Override
   protected void onCreate(Bundle b) 
   {
      super.onCreate(b);
	  setContentView(R.layout.activity_photo_album);
   }
   
/****************************onCreateOptionMenu()****************************/
   @Override
   public boolean onCreateOptionsMenu(Menu menu) 
   {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.photo_album, menu);
      return true;
   }
/******************************buttonHandler()******************************/
   public void buttonHandler(View v)
   {
      switch (v.getId())
      {
   	     case R.id.prevButton: countDown() ; break;
   	     case R.id.nextButton: countUp() ; break;
      }
   }
/******************************countUp()******************************/
   public void countUp()
   {
      for(Integer p:pics)
      {
         ImageView iv = (ImageView)findViewById(p);
    	 iv.setImageResource(p);
         sleep(500);
         p++;
      }
   }
/******************************countDown()******************************/
   public void countDown()
   {
      for(Integer p:pics)
	  {
         ImageView iv = (ImageView)findViewById(p);
    	 iv.setImageResource(p);
	     sleep(500);
	     p--;
	  }
   }
/*********************************sleep()*********************************/
   public static void sleep(long msec)
   {
      try
      {
         Thread.sleep(msec);
      }catch(InterruptedException e){}
   }
      
}
