package com.busrayalcin.rungonzyrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class startScreen extends AppCompatActivity {

    ImageView imageView5 ;
    TextView mainScoreText ;
    SharedPreferences sharedPreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = this.getSharedPreferences("com.busrayalcin.rungonzyrun", Context.MODE_PRIVATE);
        //KAYDEDILMIS SCORE OKU
        int storedScore = sharedPreferences.getInt("storedScore",0);

        imageView5 = findViewById(R.id.imageView5);
        mainScoreText = findViewById(R.id.mainScoreText);

        //TOP SCORE YAZ
        mainScoreText.setText(""+storedScore);

    }

    public void play (View view){
        Intent intent = new Intent(startScreen.this,MainActivity.class);
        startActivity(intent);
    }

}