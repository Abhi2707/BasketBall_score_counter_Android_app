package com.example.hp.score_counter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointsA = 0;
    int pointsB = 0;
    private int seconds = 0;
    private boolean startRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            startRun = savedInstanceState.getBoolean("startRun");
        }

        Timer();
    }
    public void inc_A_1(View view) {
        pointsA = pointsA + 2;
        displayA(pointsA);
    }

    public void inc_B_1(View view) {
        pointsB = pointsB + 2;
        displayB(pointsB);
    }

    public void inc_B_3(View view) {
        pointsB = pointsB + 3;
        displayB(pointsB);
    }

    public void inc_A_3(View view) {
        pointsA = pointsA + 3;
        displayA(pointsA);
    }

    public void inc_A_throw(View view) {
        pointsA = pointsA + 1;
        displayA(pointsA);
    }

    public void inc_B_throw(View view) {
        pointsB = pointsB + 1;
        displayB(pointsB);
    }

    public void inc_A_d(View view) {
        pointsA = pointsA - 1;
        displayA(pointsA);
    }

    public void inc_B_d(View view) {
        pointsB = pointsB - 1;
        displayB(pointsB);
    }


    public void reset(View view) {
        pointsA = 0;
        pointsB = 0;
        displayA(pointsA);
        displayB(pointsB);
    }

    private void displayA(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.text14);
        quantityTextView.setText("" + number);
    }

    private void displayB(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.text15);
        quantityTextView.setText("" + number);
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("startRun", startRun);
    }

    public void onClickStart(View view) {
        startRun = true;
    }

    public void onClickStop(View view) {
        startRun = false;
    }

    public void onClickReset(View view) {
        startRun = false;
        seconds = 0;
    }

    private void Timer() {
        final TextView timeView = (TextView) findViewById(R.id.text16);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);

                if (startRun) {
                    seconds++;
                }

            }
        });

    }
}
