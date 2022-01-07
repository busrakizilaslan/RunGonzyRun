package com.busrayalcin.rungonzyrun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText ;
    TextView scoreText ;
    TextView topScoreText;
    int score ;
    ImageView imageView ;
    ImageView imageView2 ;
    ImageView imageView3 ;
    ImageView imageView4 ;
    ImageView[] imageArray ;
    Handler handler ;
    Runnable runnable ;
    SharedPreferences sharedPreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.busrayalcin.rungonzyrun", Context.MODE_PRIVATE);
        int storedScore = sharedPreferences.getInt("storedScore",0);
        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        topScoreText = findViewById(R.id.topScoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);


        imageArray = new ImageView[]{imageView,imageView2,imageView3,imageView4} ;

        hideImages();
        score = 0 ;

        topScoreText.setText("Top Score : "+storedScore);


        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                timeText.setText("Time : "+l/1000);

            }

            @Override
            public void onFinish() {

                timeText.setText("Time off!");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                //SCORE TOP SCOREDAN YUKSEKSE KAYDET
                if(score > storedScore){
                    sharedPreferences.edit().putInt("storedScore",score).apply();
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart");
                alert.setMessage("Do you want to restart?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Game Over!",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, startScreen.class);
                        startActivity(intent);
                    }
                });
                alert.show();

            }
        }.start();

    }

    public void increaseScore(View view){

        score++ ;
        scoreText.setText("Score : "+score);

    }

    public void hideImages(){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(4);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);


            }
        };
        handler.post(runnable);


    }
}