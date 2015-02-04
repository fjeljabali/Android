package cs11d.com.horoscopes;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Julez on 1/30/15.
 */
public class HoroscopeAdapter implements ListAdapter
{
    private Context context;
    private Horoscope[] array;
    private Horoscope selectedHoroscope = null;

    //Create a generic adapter that could take an array of any list.
    public HoroscopeAdapter (Context context, Horoscope[] array)
    {
        this.context = context;
        this.array = array;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }
    //POPULATE THE WHOLE ADAPTER WITH ALL HOROSCOPES IN ARRAY
    @Override
    public int getCount()
    {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    //INFLATE ADAPTER WITH VIEW
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.horoscope_adapter_item, parent, false);
        final TextView textView = (TextView) rowView.findViewById(R.id.horoscope_name);
        Horoscope horoscope = array[position];
        final String horoscopeName = horoscope.name;
        textView.setText(horoscopeName);
        final MainActivity mainActivity= (MainActivity) context;

        textView.setOnClickListener(new View.OnClickListener()
        {
            // save what was clicked!
            @Override
            public void onClick(View v)
            {
                selectedHoroscope = array[position];
                mainActivity.showHoroscopeDescription(selectedHoroscope);
            }
        });
        return rowView;
    }



    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
