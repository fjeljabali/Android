package cs11d.com.cars;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Julez on 1/28/15.
 */
public class HorsePowerFragment extends Fragment
{
    public static final String TAG = HorsePowerFragment.class.getSimpleName();
    public static final String NAME_KEY = "name-key";
    public static final String PRICE_KEY = "price-key";
    public static final String HORSEPOWER_KEY = "horsepower-key";
    private Car car;

    public static HorsePowerFragment newInstance(Car car)
    {
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, car.name);
        bundle.putString(HORSEPOWER_KEY, car.horsepower);
        HorsePowerFragment horsePowerFragment = new HorsePowerFragment();
        horsePowerFragment.setArguments(bundle);
        return horsePowerFragment;
    }

    @Override
    public void onCreate(Bundle savedState)
    {
        super.onCreate(savedState);
        Bundle arguments = getArguments();
        if (arguments != null)
        {
            String name = arguments.getString(NAME_KEY);
            String price = arguments.getString(PRICE_KEY);
            String horsepower = arguments.getString(HORSEPOWER_KEY);
            car = new Car(name, price, horsepower);
        }
    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        Context c = getActivity().getApplicationContext();
        View view = li.inflate(R.layout.horsepower_fragment, vg, false);
        TextView price = (TextView) view.findViewById(R.id.car_horsepower);
        TextView carName = (TextView) view.findViewById(R.id.car_name);
        carName.setText(car.name);
        price.setText(car.horsepower);
        return view;
    }
}
