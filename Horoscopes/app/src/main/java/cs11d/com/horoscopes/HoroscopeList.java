package cs11d.com.horoscopes;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Julez on 1/17/15.
 */
public class HoroscopeList extends Fragment
{
    //Creating name TAGs for references
    public static final String TAG = HoroscopeList.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater li,ViewGroup vg, Bundle b)
    {
        View view = li.inflate(R.layout.horoscope_list, vg,false);
        ListView listView = (ListView) view.findViewById(R.id.horoscope_list);
        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(getActivity(), Horoscope.ALL_HOROSCOPES);
        listView.setAdapter(horoscopeAdapter);
        return (view);
    }

}
