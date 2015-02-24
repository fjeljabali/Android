package cs11d.com.drawingboard;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Julez on 2/17/15.
 */
public class ControllersFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        View view = li.inflate(R.layout.controllers_layout, vg, false);
        return view;
    }
}
