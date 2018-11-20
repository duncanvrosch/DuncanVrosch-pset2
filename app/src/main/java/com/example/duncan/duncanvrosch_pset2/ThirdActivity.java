package com.example.duncan.duncanvrosch_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");
        String storyText = story.toString();

        TextView storyView = findViewById(R.id.story);
        storyView.setText(storyText);
    }

    public void newStory(View v) {

        story.clear();

        Intent intent = new Intent(ThirdActivity.this, ChooseStory.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ThirdActivity.this, ChooseStory.class);
        startActivity(intent);
    }
}
