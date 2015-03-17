 package cs11d.com.drawingboard;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BoardFragment extends Fragment
{
    public static final String TAG = BoardFragment.class.getSimpleName();

    Draw drawingCanvas;

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        drawingCanvas = new Draw(getActivity());
        return drawingCanvas;
    }

    public void changeColor(int color)
    {
        drawingCanvas.colorChanged(color);
    }

}
