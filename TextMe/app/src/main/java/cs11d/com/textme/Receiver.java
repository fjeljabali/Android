package cs11d.com.textme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/******************************************
This is the BroadcastReceiver class that
 I wasn't able to implement into the app.
 ******************************************/

public class Receiver extends BroadcastReceiver
{
    private static final String ACTION = "cs11d.com.textme";


    /**********************************

     onReceive()

     **********************************/
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = intent.getExtras();
        String actionName = intent.getAction();

        if (intent != null && intent.getAction()!=null && ACTION.compareToIgnoreCase(intent.getAction())==0)
        {
            //PDU - Protocol Description Unit is how the SMS message is represented in the industry.
            Object pduArray[] = (Object[])intent.getExtras().get(ACTION);
            SmsMessage msg[] = new SmsMessage [pduArray.length];

            for(int j = 0; j<pduArray.length;j++)
            {
                msg[j] = SmsMessage.createFromPdu((byte[])pduArray[j]);
                Log.d("mytag", "From: " + msg[j].getOriginatingAddress());
                Log.d("mytag", "Msg: " + msg[j].getMessageBody());
                //msg[j].getTimeStampMillis() can be put in a Log to say the time in which sent.
            }
            Log.d("mytag", "SMS message Received.");
        }
    }
}

