package com.example.julez.toadapp;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Julez on 11/29/14.
 */
public class ViewPhotoFragment extends Fragment {
    public static final String TAG = ViewPhotoFragment.class.getSimpleName();
    private final static int TOAD_SOUND = R.raw.toad03;
    private int counter = 0;
    private final Integer pics[] = {
            R.drawable.toad1,
            R.drawable.toad2,
            R.drawable.toad3,
            R.drawable.toad4,
            R.drawable.toad5,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_hello_world, container, false);
        final Button button = (Button) view.findViewById(R.id.nextbutton);
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        view.setOnTouchListener(new OnSwipeTouchListener(getActivity()) {
            @Override
            public void onSwipeFromRightToLeft() {
                counter++;
                counter = counter % pics.length;
                imageView.setImageResource(pics[counter]);
                playToadSound();
            }

            @Override
            public void onSwipeLeftToRight() {
                counter--;
                counter = Math.abs(counter % pics.length);
                imageView.setImageResource(pics[counter]);
                playToadSound();
            }

            private void playToadSound(){
                MediaPlayer.create(getActivity(), TOAD_SOUND).start();
            }
        });
        return  view;
    }
}