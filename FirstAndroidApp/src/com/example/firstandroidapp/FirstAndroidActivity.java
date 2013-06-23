/*
  Julian Eljabali
  Assignment # 1
  activity
  Janu 19th 2013
*/

package com.example.firstandroidapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FirstAndroidActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_android);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_android, menu);
		return true;
	}

}
