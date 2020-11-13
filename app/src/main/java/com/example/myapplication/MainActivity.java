package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int p = 0;
    String res = "";
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int count2 = gameState.length;
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2 && gameActive) {
            gameState[tappedCounter] = p;
            counter.setTranslationY(-1500);
            if (p == 0) {
                counter.setImageResource(R.drawable.x);
                p = 1;
            } else {
                counter.setImageResource(R.drawable.o);
                p = 0;
            }
            count2--;
            if(count2 == 0){
                res = "Game Drawn :(";
                TextView t = (TextView) findViewById(R.id.winner);
                t.setVisibility(View.VISIBLE);
                t.setText(res);
                Button b = (Button) findViewById(R.id.playAg);
                b.setVisibility(View.VISIBLE);
                gameActive = false;
            }else {
                for (int[] winningPosition : winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                        if (p == 0) {
                            res = "Mr.O has Won The Game!";
                        } else {
                            res = "Mr.X has Won The Game!";
                        }
                        TextView t = (TextView) findViewById(R.id.winner);
                        t.setVisibility(View.VISIBLE);
                        t.setText(res);
                        Button b = (Button) findViewById(R.id.playAg);
                        b.setVisibility(View.VISIBLE);
                        gameActive = false;
                    }
                }
            }
            counter.animate().translationYBy(1500).setDuration(400);
        }

    }
    public  void playAgain(View view){
        TextView t = (TextView) findViewById(R.id.winner);
        t.setVisibility(View.INVISIBLE);
        Button b = (Button) findViewById(R.id.playAg);
        b.setVisibility(View.INVISIBLE);
        ImageView i1 = findViewById(R.id.imageView1);
        ImageView i2 = findViewById(R.id.imageView2);
        ImageView i3 = findViewById(R.id.imageView3);
        ImageView i4 = findViewById(R.id.imageView4);
        ImageView i5 = findViewById(R.id.imageView5);
        ImageView i6 = findViewById(R.id.imageView6);
        ImageView i7 = findViewById(R.id.imageView7);
        ImageView i8 = findViewById(R.id.imageView8);
        ImageView i9 = findViewById(R.id.imageView9);
        i1.setImageDrawable(null);
        i2.setImageDrawable(null);
        i3.setImageDrawable(null);
        i4.setImageDrawable(null);
        i5.setImageDrawable(null);
        i6.setImageDrawable(null);
        i7.setImageDrawable(null);
        i8.setImageDrawable(null);
        i9.setImageDrawable(null);
        p = 0;
        Arrays.fill(gameState,2);
        gameActive = true;
        count2 = gameState.length;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}