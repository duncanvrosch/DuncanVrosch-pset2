package com.example.duncan.duncanvrosch_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");

        TextView wordsLeft = findViewById(R.id.wordsLeft);
        int wordAmount = story.getPlaceholderRemainingCount();
        wordsLeft.setText("Still " + wordAmount + " word(s) left");

        EditText enterWord = findViewById(R.id.enterWord);
        enterWord.setHint(story.getNextPlaceholder());

        TextView prompt = findViewById(R.id.prompt);
        prompt.setText("Please enter a/an " + story.getNextPlaceholder() + " now!");
    }

    public void updateInfo(View v) {

        EditText enterWord = findViewById(R.id.enterWord);
        String word = enterWord.getText().toString();
        story.fillInPlaceholder(word);
        
        enterWord.setText("");
        TextView wordsLeft = findViewById(R.id.wordsLeft);
        int wordAmount = story.getPlaceholderRemainingCount();
        wordsLeft.setText(wordAmount + " word(s) left");

        enterWord.setHint(story.getNextPlaceholder());

        TextView prompt = findViewById(R.id.prompt);
        prompt.setText("please enter a/an " + story.getNextPlaceholder());

        if (story.getPlaceholderRemainingCount() == 0) {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("story", story);
            startActivity(intent);
        }
    }
}