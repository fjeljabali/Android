package cs11d.com.framebyframe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class FrameByFrameActivity extends ActionBarActivity
{

    ImageView image_view;
    AnimationDrawable animation_drawable;
    int PROGRESS_SPEED = 100;
    final int MAX_SPEED = 500;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_frame_by_frame);
        image_view = (ImageView) findViewById(R.id.image_view);
        create_Animation();
        toggle_Button();
        seek_Bar();

    }


    /**********************************
            seek_bar()
    **********************************/
    public void seek_Bar()
    {
        final SeekBar seek_bar = (SeekBar)findViewById(R.id.seek_bar);
        final TextView maximum_text = (TextView)findViewById(R.id.maximum_text);

        maximum_text.setText("Covered: " + seek_bar.getProgress() + "/" + seek_bar.getMax());

        seek_bar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                PROGRESS_SPEED = progress;
                maximum_text.setText("Covered: " + progress + "/" + seek_bar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                maximum_text.setText("Covered: " + PROGRESS_SPEED + "/" + seek_bar.getMax());
            }
        });
    }

    /**********************************
            toggle_button()
    **********************************/

    public void toggle_Button()
    {
        final ToggleButton toggle_button = (ToggleButton)findViewById(R.id.toggle_button);
        toggle_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (toggle_button.isChecked()) animation_drawable.start();

                else
                animation_drawable.stop();
            }
        });


    }

    /**********************************
            create_Animation()
     **********************************/

    private void create_Animation()
    {
        animation_drawable = new AnimationDrawable();

        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file1), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file4), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file8), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file12), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file16), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file19), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file22), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file25), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file28), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file31), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file34), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file37), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file40), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file43), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file46), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file49), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file52), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file55), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file58), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file62), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file65), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file68), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file71), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file74), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file77), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file80), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file83), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file86), PROGRESS_SPEED);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file89), PROGRESS_SPEED);

        animation_drawable.setOneShot(false);
        image_view.setBackground(animation_drawable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frame_by_frame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
