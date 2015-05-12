package cs11d.com.usermessageactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class UserMessageActivity extends ActionBarActivity
{
    private final String TAG = UserMessageActivity.class.getName();

    // User input
    private EditText userInput;

    //***********************************onCreate()*********************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_message);
        userInput = (EditText) findViewById(R.id.user_input);

        setDefaultMessage();

    }

    //***********************************setDefaultMessage()************************
    private void setDefaultMessage()
    {
        SimpleDateFormat sdf =
                new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        userInput.setText(currentDateandTime);

    }

    //***********************************broadcastMessage()*************************

    public void broadcastMessage(View v)
    {
        String msg = userInput.getText().toString();
        if(msg != null && !msg.isEmpty())
        {
            Log.d(TAG, "submitRequest");
            Intent i = new Intent(this, MessageBroadcastReceiver.class);
            i.setAction(MessageBroadcastReceiver.MSG_ACTION);
            i.putExtra(MessageBroadcastReceiver.USER_MSG, msg);
            this.sendBroadcast(i);
        } else
            Toast.makeText(this, "Please enter a message to broadcast.",
                    Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
