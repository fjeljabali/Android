package cs11d.com.usermessageactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Julez on 5/10/15.
 */
public class MessageBroadcastReceiver extends BroadcastReceiver
{
    private final String TAG = MessageBroadcastReceiver.class.getName();

    public static final String MSG_ACTION = "com.cs311d_MSG_ACTION";
    public static final String USER_MSG = "key_user_msg";


    //***********************************onReceive()********************************
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent != null)
        {
            String action = intent.getAction();
            if(MSG_ACTION.equals(action))
                Log.d(TAG, "MSG_ACTION: " + intent.getStringExtra(USER_MSG));
        }

    }
}
