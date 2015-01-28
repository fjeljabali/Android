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
public class ListAndButtonsFragment extends Fragment {
    public static final String TAG = ListAndButtonsFragment.class.getSimpleName();
    //public static final String TAG = "ListAndButtonsFragment";

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        Context context = getActivity().getApplicationContext();
        View view = li.inflate(R.layout.list_and_buttons_fragment, vg, false);
        final Car cars[] = {new Car("Fiat500", "$40"), new Car("Mini Cooper",""), new Car("Toyota Prius", "$10")};
        ListView listView = (ListView) view.findViewById(R.id.CarListView);
        final CarAdapter carAdapter = new CarAdapter(ListAndButtonsFragment.this, cars);
        listView.setAdapter(carAdapter);

        Button price = (Button) view.findViewById(R.id.Price);
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = carAdapter.getSelectedCar();
                onSelectedCar(car);
            }
        });

        return view;
    }

    public void onSelectedCar(Car car) {
        ((MainActivity)getActivity()).showPriceFragment(car);
    }


}
