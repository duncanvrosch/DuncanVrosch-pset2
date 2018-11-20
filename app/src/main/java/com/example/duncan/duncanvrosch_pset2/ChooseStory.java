package com.example.duncan.duncanvrosch_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class ChooseStory extends AppCompatActivity {

    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);

    }

    public void checkClicked(View v) {

        Button button = (Button) v;

        switch (button.getText().toString()) {
            case "simple":  is = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case "tarzan":  is = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case "university":  is = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case "clothes":  is = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case "dance":  is = getResources().openRawResource(R.raw.madlib4_dance);
                break;
            case "family":  is = getResources().openRawResource(R.raw.madlib5_vanalles);
                break;
        }

        Story story = new Story(is);

        Intent intent = new Intent(ChooseStory.this, SecondActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
    }
}