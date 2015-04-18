package cs11d.com.simon;


import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


public class GameFragment extends Fragment
{
    public static final String TAG = GameFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        final ImageView imageYoshi = (ImageView) view.findViewById(R.id.yoshi);
        final ImageView imageToad = (ImageView) view.findViewById(R.id.toad);
        final ImageView imageWario = (ImageView) view.findViewById(R.id.wario);
        final ImageView imageMario = (ImageView) view.findViewById(R.id.mario);

        final int YOSHI = R.raw.yoshi;
        


        imageYoshi.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    imageYoshi.setImageResource(R.drawable.yoshiclick);
                    return true;


                }

                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    imageYoshi.setImageResource(R.drawable.yoshi2);

                    return true;
                }

                return false;
            }
        });

        imageToad.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    imageToad.setImageResource(R.drawable.toadclick);
                    return true;
                }

                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    imageToad.setImageResource(R.drawable.toad2);

                    return true;
                }

                return false;
            }
        });

        imageWario.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    imageWario.setImageResource(R.drawable.warioclick);
                    return true;
                }

                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    imageWario.setImageResource(R.drawable.wario2);

                    return true;
                }

                return false;
            }
        });


        imageMario.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    imageMario.setImageResource(R.drawable.marioclick);
                    return true;
                }

                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    imageMario.setImageResource(R.drawable.mario2);

                    return true;
                }

                return false;
            }
        });



        return view;

    }


}