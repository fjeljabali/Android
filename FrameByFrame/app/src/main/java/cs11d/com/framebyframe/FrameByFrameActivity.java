/* Julian Eljabali */
/* Advanced Android */
/* Assigment # 4 */
/* March 4th 2015 */

/***************************************
 This app plays an animation of a boy
 doing a back flip where the frames-per-second
 is adjustable to go fast/slow
 ***************************************/

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
    int progress_speed;
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
        final TextView speed_text = (TextView)findViewById(R.id.speed_text);

        speed_text.setText("Speed: " + seek_bar.getProgress() + "/" + seek_bar.getMax());

        seek_bar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                progress_speed = progress;
                speed_text.setText("Speed: " + progress + "/" + seek_bar.getMax());
                create_Animation();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                speed_text.setText("Speed: " + progress_speed + "/" + seek_bar.getMax());
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

        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file1), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file4), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file8), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file12), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file16), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file19), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file22), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file25), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file28), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file31), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file34), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file37), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file40), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file43), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file46), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file49), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file52), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file55), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file58), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file62), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file65), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file68), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file71), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file74), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file77), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file80), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file83), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file86), progress_speed);
        animation_drawable.addFrame(getResources().getDrawable(R.drawable.file89), progress_speed);

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
