/* Julian Eljabali */
/* Advanced Android */
/* Assigment # 3 */
/* February 25th 2015 */

/***************************************
 This app acts like a drawing board which
 allows you to draw by touching the screen.
 ***************************************/

package cs11d.com.drawingboard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void changeColor(int color)
    {
        BoardFragment boardFragment = (BoardFragment) getFragmentManager().findFragmentById(R.id.boardfragment);
        if (boardFragment != null)
        {
            boardFragment.changeColor(color);
        }
        else
        {
            Log.e(TAG, "can't find " + BoardFragment.TAG);
        }
    }
}
