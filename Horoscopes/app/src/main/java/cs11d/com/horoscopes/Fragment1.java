package cs11d.com.horoscopes;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Julez on 1/17/15.
 */
public class Fragment1 extends Fragment
{
    public static final String TAG = Fragment1.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater li,ViewGroup vg, Bundle b)
    {
        View vw = li.inflate(R.layout.fragment1, vg, false);
        final String horoscopes[] = {"Aquarius","Pisces","Aries",
                "Taurus","Gemini","Cancer","Leo","Virgo","Libra",
                "Scorpio","Sagittarius","Capricorn"};
        ListView lv = (ListView)vw.findViewById(R.id.horoscopes_list);
        ArrayAdapter<String> ar = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,horoscopes);
        lv.setAdapter(ar);

        return vw;

//        lv.setOnClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?>parent, View v, int position, long id)
//            {
//                TextView tv = (TextView)getActivity().findViewById(R.id.selectedopt);
//                tv.setText(“You have selected” + ((TextView)v).getText().toString());
//            }
//        });

    }


}
