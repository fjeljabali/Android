package cs11d.com.textme;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;


public class TextMeActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_me);
    }

    public void sendSMS(View v)     //onClick for send button
    {
        final EditText phone = (EditText) findViewById(R.id.phone);
        final EditText msg = (EditText) findViewById(R.id.msg);

        try
        {
            sendSMS(phone.getText().toString(), msg.getText().toString());
            Toast.makeText(this, "SMS sent", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {Toast.makeText(this, "ERROR! Message not sent", Toast.LENGTH_LONG).show();}

    }

    private void sendSMS(String phone, String msg) throws Exception
    {
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(phone, null, msg, null, null); //null1(configures provider),null2 and null3 are both Pending Intents for sending and delivering.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_me, menu);
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
