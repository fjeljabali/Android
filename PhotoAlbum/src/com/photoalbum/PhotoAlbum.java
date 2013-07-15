package com.photoalbum;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PhotoAlbum extends Activity 
{
   ImageView iv;
   Integer counter=0;
   
   Integer pics[] = {
		               R.drawable.pic1, 
		               R.drawable.pic2, 
		               R.drawable.pic3,
		               R.drawable.pic4, 
		               R.drawable.pic5,
		               R.drawable.pic6,
		               R.drawable.pic7,
		            };

//*********************************onCreate()*********************************//
   @Override
   protected void onCreate(Bundle b) 
   {
      super.onCreate(b);
	  setContentView(R.layout.activity_photo_album);
	  iv = (ImageView)findViewById(R.id.images);
	  
	  ImageButton nextbutton = (ImageButton)findViewById(R.id.nextbutton);
	  ImageButton prevbutton = (ImageButton)findViewById(R.id.prevbutton);
    
//*************************goClickListener()*************************//     

      nextbutton.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {        	 
            if (counter < pics.length)
    	    {
    	       counter++;
    	    }
    	    iv.setImageResource(pics[counter]);
    	 }
      });
      
//*************************goClickListener()*************************//     
	  prevbutton.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
        	 if(counter>0)
   	         {
   	            counter--;
   	         }
   	         iv.setImageResource(pics[counter]);
    	 }
      });
   }
   

//****************************onCreateOptionMenu()****************************/
   @Override
   public boolean onCreateOptionsMenu(Menu menu) 
   {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.photo_album, menu);
      return true;
   }   
      
}
