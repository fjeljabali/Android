//**************************************************
//Name: Julian Eljabali                           **
//Assignment: #4                                  **
//July 10th 2013                                  **
//**************************************************

package com.showweb;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class ShowWeb extends Activity
{
   EditText url;
   WebView wv;
   Button gobutton;
   Button forward;
   Button back;

//************************onCreate()********************************//       
   @Override
   protected void onCreate(Bundle b) 
   {
      super.onCreate(b);
      setContentView(R.layout.activity_show_web);
      wv = (WebView)findViewById(R.id.webview); 
      wv.getSettings().setJavaScriptEnabled(true);
      wv.loadUrl("http://www.google.com/");
      wv.getSettings().setLoadWithOverviewMode(true);
      wv.getSettings().setUseWideViewPort(true); 
      wv.setWebViewClient(new wvClient());
      url = (EditText)findViewById(R.id.edittext);
      Button gobutton = (Button)findViewById(R.id.gobutton);
      Button forward = (Button)findViewById(R.id.forward);
      Button back = (Button)findViewById(R.id.back);      
//*************************goClickListener()*************************//     
      gobutton.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
            String urlString = url.getText().toString();
            wv.loadUrl(urlString);
    	 }
      });
//***********************forwardClickListener()**********************//     
      forward.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
            if(wv.canGoForward())
            wv.goForward();
    	 }
      });
//***********************backClickListener()************************//     
      back.setOnClickListener(new OnClickListener()
      {
         @Override
    	 public void onClick(View v)
    	 {
            if(wv.canGoBack())
            wv.goBack();
    	 }
      });     
   }
//***********************onCreateOptionsMenu()**********************//     
   @Override
   public boolean onCreateOptionsMenu(Menu menu) 
   {
	   // Inflate the menu; this adds items to the action bar if it is present.
	   getMenuInflater().inflate(R.menu.show_web, menu);
	   return true;
   }
}
