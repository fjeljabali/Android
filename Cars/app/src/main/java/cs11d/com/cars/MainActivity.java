//Julian Eljabali
//Advanced Android
//Assignment #1
//January 28th 2015


package cs11d.com.cars;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity
{
    public void showPriceFragment(Car car)
    {
        PriceFragment priceFragment = PriceFragment.newInstance(car);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayoutContainer, priceFragment, PriceFragment.TAG)
                .addToBackStack(PriceFragment.TAG)
                .commit();
    }

    public void showHorsePowerFragment(Car car)
    {
        HorsePowerFragment horsePowerFragment = HorsePowerFragment.newInstance(car);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayoutContainer, horsePowerFragment, PriceFragment.TAG)
                .addToBackStack(PriceFragment.TAG)
                .commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAndButtonsFragment listAndButtonsFragment = new ListAndButtonsFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayoutContainer, listAndButtonsFragment, ListAndButtonsFragment.TAG)
                .addToBackStack(ListAndButtonsFragment.TAG)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
