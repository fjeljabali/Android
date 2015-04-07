package cs11d.com.statetheobvious;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Julez on 4/6/15.
 */
public class MainFragment extends Fragment
{
    public static final String TAG = MainFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        final EditText edit_text = (EditText) view.findViewById(R.id.edit_text);
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Pattern pattern = Pattern.compile(edit_text.getText().toString());
                Matcher matcher = pattern.matcher("California");

                boolean b = matcher.matches();

                if (b)
                {
                    Toast.makeText(getActivity(), "It's a match!", Toast.LENGTH_SHORT).show();
                }

            }

        });




        return view;
    }
}

