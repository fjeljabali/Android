//**************************************************
//Name: Julian Eljabali                           **
//Assignment: #4                                  **
//July 10th 2013                                  **
//**************************************************

package com.showweb;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class wvClient extends WebViewClient 
{
//*****************shouldOverrideUrlLoading()*************************//       
   @Override
   public boolean shouldOverrideUrlLoading(WebView v, String url)
   {
      v.loadUrl(url);
      return true;
   }
}
