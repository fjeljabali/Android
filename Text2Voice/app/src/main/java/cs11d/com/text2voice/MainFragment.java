package cs11d.com.text2voice;

import android.app.Fragment;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;

import java.util.Locale;

/**
 * Created by Julez on 2/6/15.
 */
public class MainFragment extends Fragment implements TextToSpeech.OnInitListener
{
    public static final String TAG = MainFragment.class.getSimpleName();
    TextToSpeech textToSpeech;
    Button button;
    EditText editText;


    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b)
    {
        View view = li.inflate(R.layout.main_fragment, vg,false);
        textToSpeech = new TextToSpeech(getActivity(), this);
        button = (Button)view.findViewById(R.id.angry_btn);
        editText = (EditText)view.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                speakOut();
            }
        });

        return view;


    }



    @Override
    public void onDestroy()
    {
        if(textToSpeech !=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

    }

    @Override
    public void onInit (int status)
    {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {

                Log.e("TTS", "This language is not supported");
            } else {
                button.setEnabled(true);
                speakOut();
            }
        }
        else
        {
            Log.e("TTS", "Initialization Failed");
        }




    }


    private void speakOut()
    {
        String text = editText.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }



}
