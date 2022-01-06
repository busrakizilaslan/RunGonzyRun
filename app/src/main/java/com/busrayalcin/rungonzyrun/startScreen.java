package com.busrayalcin.rungonzyrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class startScreen extends AppCompatActivity {

    ImageView imageView5 ;
    TextView mainScoreText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView5 = findViewById(R.id.imageView5);
        mainScoreText = findViewById(R.id.mainScoreText);

        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE",0);
        mainScoreText.setText(""+score);
    }

    public void play (View view){
        Intent intent = new Intent(startScreen.this,MainActivity.class);
        startActivity(intent);
    }

}