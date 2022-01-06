package com.busrayalcin.rungonzyrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class startScreen extends AppCompatActivity {

    ImageView imageView5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView5 = findViewById(R.id.imageView5);
    }

    public void play (View view){

        Intent intent = new Intent(startScreen.this,MainActivity.class);
        startActivity(intent);

    }

}