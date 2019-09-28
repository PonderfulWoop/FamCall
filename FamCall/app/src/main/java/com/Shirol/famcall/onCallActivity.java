package com.Shirol.famcall;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class onCallActivity extends AppCompatActivity {

    ImageView iv;
    ImageButton ib1, ib2;
    Chronometer chronometer;
    static int counter = 0;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oncall_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        iv = findViewById(R.id.imageView5);
        tv = findViewById(R.id.textView3);
        ib1 = findViewById(R.id.imageButton);
        ib2 = findViewById(R.id.imageButton2);
        chronometer = findViewById(R.id.ch);

        chronometer.start();

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String name = b.getString("name");
        tv.setText(name);
        setIV(name);
    }

    private void setIV(String name) {
        switch (name){
            case "Shashank":
                iv.setImageResource(R.drawable.shannu);
                return;
            case "Shruti":
                iv.setImageResource(R.drawable.shruti);
                return;
            case "Daddy":
                iv.setImageResource(R.drawable.papa);
                return;
            case "Mommy":
                iv.setImageResource(R.drawable.mom);
                return;
        }
    }

    public void toggleSpeaker(View v){
        counter++;
        if(counter%2 != 0){
            ib1.setBackgroundColor(Color.MAGENTA);
            setVolumeControlStream(AudioManager.USE_DEFAULT_STREAM_TYPE);
        }
        else{
            ib1.setBackgroundResource(android.R.drawable.btn_default);
            setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);
        }
    }

    public void endCall(View v){
        Intent returnIntent = new Intent();
        String s = chronometer.getText().toString();
        returnIntent.putExtra("call_time", s);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
