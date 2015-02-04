package cs11d.com.horoscopes;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Julez on 1/30/15.
 */
public class HoroscopeDescription extends Fragment
{
    public static final String TAG = HoroscopeDescription.class.getSimpleName();
    public static final String NAME_KEY = "name-key";
    public static final String DESCRIPTION_KEY = "description-key";
    public static final String DATES_KEY = "dates-key";
    private Horoscope horoscope;

    public static HoroscopeDescription newInstance (Horoscope horoscope)
    {
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, horoscope.name);
        bundle.putString(DESCRIPTION_KEY, horoscope.description);
        bundle.putString(DATES_KEY, horoscope.dates);
        HoroscopeDescription horoscopeDescription = new HoroscopeDescription();
        horoscopeDescription.setArguments(bundle);
        return horoscopeDescription;

    }

    @Override
    public void onCreate (Bundle savedData)
    {
        super.onCreate(savedData);
        Bundle arguments = getArguments();
        if (arguments != null)
        {
            String name = arguments.getString(NAME_KEY);
            String description = arguments.getString(DESCRIPTION_KEY);
            String dates = arguments.getString(DATES_KEY);
            horoscope = new Horoscope(name, description, dates);
        }
    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        Context context = getActivity();
        View view = li.inflate(R.layout.horoscope_description, vg, false);
        TextView name = (TextView) view.findViewById(R.id.horoscope_name);
        TextView description = (TextView) view.findViewById(R.id.horoscope_description);
        TextView dates = (TextView) view.findViewById(R.id.horoscope_dates);
        name.setText(horoscope.name);
        description.setText(horoscope.description);
        dates.setText(horoscope.dates);
        return (view);
    }


}
