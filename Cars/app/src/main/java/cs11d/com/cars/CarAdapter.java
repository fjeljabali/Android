package cs11d.com.cars;

import android.app.Fragment;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by Julez on 1/27/15.
 */
public class CarAdapter implements ListAdapter
{
    private ListAndButtonsFragment fragment;
    private Car[] array;
    private Car selectedCar = null;

    public CarAdapter (ListAndButtonsFragment fragment, Car[] array) {
        super();
        this.fragment = fragment;
        this.array = array;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {}

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {}

    @Override
    public int getCount() {
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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.car_adapter_item, parent, false);
        //ArrayAdapter<String> ar = new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, cars);
        final TextView textView = (TextView) rowView.findViewById(R.id.car_name);
        final String carName = array[position].name;
        textView.setText(carName);
        textView.setOnClickListener(new View.OnClickListener()
        {
            // save what was clicked!
            @Override
            public void onClick(View v)
            {
                selectedCar = array[position];
            }
        });
        return rowView;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return array.length > 0;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }
}