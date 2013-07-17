package com.guessthecapital;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class StartActivity extends Activity 
{
   EditText name;
   ImageButton start;
   ImageButton scoreboard;
      
//************************onCreate()************************//
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_start);
	  
      final EditText name = (EditText)findViewById(R.id.name);
	  ImageButton start = (ImageButton)findViewById(R.id.start);
      ImageButton scoreboard = (ImageButton)findViewById(R.id.scoreboard);
    
//***********************startClickListener()***********************//     
      start.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
            Intent i = new Intent (StartActivity.this, GameActivity.class);
            i.putExtra("UserName", name.getText().toString());
            startActivity(i);
            
    	 }
      });
      
//*********************scoreboardClickListener()*********************//     
      scoreboard.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
        	 
    	 }
      });

   }
   
//******************onCreateOptionsMenu()*******************//
   @Override
   public boolean onCreateOptionsMenu(Menu menu) 
   {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.start, menu);
      return true;
   }

}
