package cs11d.com.drawingboard;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Julez on 2/17/15.
 */
public class BoardFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        return new Draw(getActivity());
    }

}
