package cs11d.com.drawingboard;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.test.RenamingDelegatingContext;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ControllersFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        View view = li.inflate(R.layout.controllers_layout, vg, false);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);

        final RadioButton redbutton = (RadioButton) view.findViewById(R.id.redbutton);
        final RadioButton bluebutton = (RadioButton) view.findViewById(R.id.bluebutton);
        final RadioButton greenbutton = (RadioButton) view.findViewById(R.id.greenbutton);

        redbutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ((MainActivity) getActivity()).changeColor(Color.RED);
            }
        });

        bluebutton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ((MainActivity) getActivity()).changeColor(Color.BLUE);
            }
        });

        greenbutton.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v)
            {
                ((MainActivity) getActivity()).changeColor(Color.GREEN);
            }
        });



        return view;
    }
}
