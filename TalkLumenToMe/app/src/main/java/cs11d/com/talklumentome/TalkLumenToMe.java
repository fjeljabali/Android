/* Julian Eljabali */
/* Advanced Android */
/* Assigment # 2 */
/* February 11th 2015 */

/***************************************
 This app measures luminosity through
 the light sensor and reads it to you
 ***************************************/


package cs11d.com.talklumentome;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Locale;


public class TalkLumenToMe extends Activity implements TextToSpeech.OnInitListener
{

    TextView lightAvailability;
    TextView lightReading;
    TextToSpeech textToSpeech;
    Button button;

    /**********************************

     onCreate()

     **********************************/

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_lumen_to_me);

        textToSpeech = new TextToSpeech(this, this);
        button = (Button) findViewById (R.id.button);

        lightAvailability
                = (TextView)findViewById(R.id.lightAvailability);
        lightReading
                = (TextView)findViewById(R.id.lightReading);

        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


        if(LightSensor != null)
        {
            lightAvailability.setText("Sensor.TYPE_LIGHT Available");
            mySensorManager.registerListener(
                    LightSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }

        else
        {
            lightAvailability.setText("Sensor.TYPE_LIGHT NOT Available");
        }

        /**********************************

         button.setOnClickListener()

         **********************************/

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                speakOut();
            }
        });
    }

    /**********************************

     SensorEventListener()

     **********************************/


    private final SensorEventListener LightSensorListener
            = new SensorEventListener()
    {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event)
        {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT)
            {
                lightReading.setText("The light is: " + event.values[0] + " lumens");
            }
        }

    };

    /**********************************

     OnInit()

     **********************************/

    @Override
    public void onInit(int status)
    {
        if (status == TextToSpeech.SUCCESS)
        {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED)
            {

                Log.e("TTS", "This language is not supported");
            }
            else
            {
                button.setEnabled(true);
                speakOut();
            }
        }
        else
        {
            Log.e("TTS", "Initialization Failed");
        }

    }

    /**********************************

     speakOut()

     **********************************/

    private void speakOut()
    {
        String text = lightReading.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}