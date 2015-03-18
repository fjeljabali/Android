/* Julian Eljabali */
/* Advanced Android */
/* Assigment # 5 */
/* March 18th 2015 */

/***************************************
 This app takes picture selfies with the
 front camera ONLY, and allows you to save
 and display them.
 ***************************************/


package cs11d.com.mypersonalcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;

import static cs11d.com.mypersonalcamera.R.id.edit_text;


public class MPCActivity extends ActionBarActivity
{
    int TAKE_PHOTO_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpc);

        final String directory = Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_PICTURES) +
        "/MyPersonalCamera/";


        /**********************************
         capture()
         **********************************/
        ImageButton capture = (ImageButton)findViewById(R.id.camera_button);
        capture.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                final String picture_name =((EditText) findViewById(edit_text)).getText().toString();
                String file = directory + picture_name + ".jpg";
                File new_picture = new File(file);
                try
                {
                    new_picture.createNewFile();
                }
                catch(IOException e){}

                Uri outFileUri = Uri.fromFile(new_picture);
                Intent cameraIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);//intent for camera
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outFileUri);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        });


        /**********************************
         load()
         **********************************/
        ImageButton load = (ImageButton)findViewById(R.id.load_button);
        load.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                final String picture_name =((EditText) findViewById(edit_text)).getText().toString();

                File imageFile = new File (directory + picture_name + ".jpg");

                if(imageFile.exists())
                {
                    Bitmap myBitmap = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory
                            (Environment.DIRECTORY_PICTURES) + "/MyPersonalCamera/" + picture_name + ".jpg");
                    ImageView myImage = (ImageView) findViewById(R.id.image_view);
                    myImage.setImageBitmap(myBitmap);
                }



            }
        });
    }

    /**********************************
     onActivityResult()
     **********************************/
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data)
    {
        super.onActivityResult(reqCode, resCode, data);
        if(reqCode==TAKE_PHOTO_CODE && resCode==RESULT_OK)
        {
            Log.d("CameraDemo", "pic saved");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mpc, menu);
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


