package com.example.duncan.duncanvrosch_pset2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.imageView);
        Drawable picture = getResources().getDrawable(R.drawable.madlibs, null);
        logo.setImageDrawable(picture);
    }

    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, ChooseStory.class);
        startActivity(intent);
    }
}
