package cs11d.com.statetheobvious;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Julez on 4/6/15.
 */
public class MainFragment extends Fragment
{
    public static final String TAG = MainFragment.class.getSimpleName();
    public static final String [] STATES = {"Alabama",
            "Alaska" ,
            "Arizona" ,
            "Arkansas" ,
            "California" ,
            "Colorado" ,
            "Connecticut" ,
            "Delaware" ,
            "Florida" ,
            "Georgia" ,
            "Hawaii" ,
            "Idaho" ,
            "Illinois" ,
            "Indiana" ,
            "Iowa" ,
            "Kansas" ,
            "Kentucky" ,
            "Louisiana" ,
            "Maine" ,
            "Maryland" ,
            "Massachusetts" ,
            "Michigan" ,
            "Minnesota" ,
            "Mississippi" ,
            "Missouri" ,
            "Montana" ,
            "Nebraska" ,
            "Nevada" ,
            "New Hampshire" ,
            "New Jersey" ,
            "New Mexico" ,
            "New York" ,
            "North Carolina" ,
            "North Dakota" ,
            "Ohio" ,
            "Oklahoma" ,
            "Oregon" ,
            "Pennsylvania" ,
            "Rhode Island" ,
            "South Carolina" ,
            "South Dakota" ,
            "Tennessee" ,
            "Texas" ,
            "Utah" ,
            "Vermont" ,
            "Virginia" ,
            "Washington" ,
            "West Virginia" ,
            "Wisconsin" ,
            "Wyoming" ,
            "District of Columbia" ,
            "Puerto Rico" ,
            "Guam" ,
            "American Samoa",
            "U.S. Virgin Islands" ,
            "Northern Mariana Islands"};

    ArrayList<String> results = new ArrayList<>();    // can dynamically grow
    String [] results2 = {"1", "2"};                  // limited with 2 slots


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        final EditText edit_text = (EditText) view.findViewById(R.id.edit_text);
        Button button = (Button) view.findViewById(R.id.button);
        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),R.layout.state_textview);

        listView.setAdapter(arrayAdapter);


        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Pattern pattern = Pattern.compile(edit_text.getText().toString());
                for (int i = 0; i < STATES.length; i++)
                {
                    Matcher matcher = pattern.matcher(STATES[i]);
                    boolean b = matcher.matches();

                    if (b)
                    {
                        Toast.makeText(getActivity(), "It's a match! " + STATES[i], Toast.LENGTH_SHORT).show();
                        results.add(STATES[i]);
                    }
                }
                arrayAdapter.addAll(results);
            }

        });

        return view;
    }
}

