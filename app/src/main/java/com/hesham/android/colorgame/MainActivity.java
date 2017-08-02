package com.hesham.android.colorgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private TextView scoreTextView;
    private TextView colorTextView;
    private int colorsLength;
    private String colorNames[];
    private int colorsArray[];
    private Boolean answer = false;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = (TextView)findViewById(R.id.scoreTextView);
        colorTextView = (TextView)findViewById(R.id.colorTextView);
        trueButton = (Button)findViewById(R.id.trueButton);
        falseButton = (Button)findViewById(R.id.falseButton);

        colorsArray = getResources().getIntArray(R.array.colors);
        colorsLength = colorsArray.length;
        colorNames = getResources().getStringArray(R.array.colorNames);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
                checkAnswer(false);
            }
        });

        nextQuestion();

    }

    private void nextQuestion(){

        Random random = new Random();

        int colorIndex = random.nextInt(colorsLength);
        int colorTextIndex = random.nextInt(colorsLength);

        colorTextView.setTextColor(colorsArray[colorIndex]);
        colorTextView.setText(colorNames[colorTextIndex]);
        if (colorIndex == colorTextIndex)
            answer = true;
        else
            answer = false;

    }

    private void checkAnswer(boolean userChoice){
        if (userChoice == answer) {
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();

            score++;
            scoreTextView.setText("SCORE: " + String.valueOf(score));
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }
    }

}
