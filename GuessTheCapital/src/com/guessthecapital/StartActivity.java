//**************************************************
//Name: Julian Eljabali                           **
//Assignment: #5                                  **
//July 17th 2013                                  **
//**************************************************

package com.guessthecapital;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
   ArrayList<String> states = new ArrayList<String>();
   ArrayList<String> capitals = new ArrayList<String>();
   String[] split;
   Intent NameIntent;
      
//************************onCreate()************************//
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_start);
	  
	  ImageButton start = (ImageButton)findViewById(R.id.start);
      ImageButton scoreboard = (ImageButton)findViewById(R.id.scoreboard);
      
	  SQLiteDatabase db = openOrCreateDatabase("statesandcaps.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		
      String sqlcmd = "create table IF NOT EXISTS statesandcaps(_id integer " +
                    "primary Key autoincrement, state text " +
                    "not null, capital text);";
      db.execSQL(sqlcmd);
      
      Cursor c = db.query("statesandcaps",null, null, 
              null, null, null, null, null);
      Resources resources = getApplicationContext().getResources();
      InputStream is = resources.openRawResource(R.raw.us_states);
      
      Scanner sc = new Scanner(is);
      ContentValues cv = new ContentValues();
      c.moveToFirst();
      
      if(c.getCount()==0)
      {
          while(sc.hasNext())
          {
              String line = sc.nextLine();
              split = line.split("-");
              //Arrays of Strings
              states.add(split[0]);
              capitals.add(split[1]);
              //Filling database
              cv.put("state", split[0]);
              cv.put("capital", split[1]);
              db.insert("statesandcaps", null, cv);
          }            
      }
      
      NameIntent = new Intent(getApplicationContext(),
              GameActivity.class);
      name = (EditText)findViewById(R.id.name);
		
    
//***********************startClickListener()***********************//     
      start.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {

            
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
