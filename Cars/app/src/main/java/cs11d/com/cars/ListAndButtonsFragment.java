package cs11d.com.cars;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Julez on 1/27/15.
 */
public class ListAndButtonsFragment extends Fragment
{
    public static final String TAG = ListAndButtonsFragment.class.getSimpleName();
    // or public static final String TAG = "ListAndButtonsFragment";
    final Car cars[] = {new Car("Fiat500", "$16,645", "101 to 160 HP"), new Car("Mini Cooper","$21,700", "121 to 208 HP"),
                       new Car("Toyota Prius", "$19,080", "134 HP"), new Car("Smart", "$12,490", "70 HP"),
                       new Car("Volkswagen Beetle","$20,195", "150 to 210 HP")};


    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        Context context = getActivity().getApplicationContext();
        View view = li.inflate(R.layout.list_and_buttons_fragment, vg, false);
        ListView listView = (ListView) view.findViewById(R.id.CarListView);
        final CarAdapter carAdapter = new CarAdapter(ListAndButtonsFragment.this, cars);
        listView.setAdapter(carAdapter);

        Button price = (Button) view.findViewById(R.id.Price);
        price.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Car car = carAdapter.getSelectedCar();
                onSelectedCarPrice(car);
            }
        });

        Button horsepower = (Button) view.findViewById(R.id.HorsePower);
        horsepower.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                Car car = carAdapter.getSelectedCar();
                onSelectedCarHorsePower(car);
            }

        });

        return view;
    }

    public void onSelectedCarPrice(Car car)
    {
        ((MainActivity)getActivity()).showPriceFragment(car);
    }

    public void onSelectedCarHorsePower(Car car)
    {
        ((MainActivity)getActivity()).showHorsePowerFragment(car);
    }


}
