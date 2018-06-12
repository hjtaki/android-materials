package com.example.morningclass.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String MOVIE_EXTRA = "movieName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.grid_movies);
        for(int i =0; i<gridLayout.getChildCount(); i++){
            ImageButton imgbutton = (ImageButton) gridLayout.getChildAt(i);
            imgbutton.setOnClickListener(this);
        }
    }

    private void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        //1. second detail activities
        // - Intent, putExtra(movie name) -> Img, text

        String imgTag = v.getTag().toString(); // movie name
        toast(imgTag);


        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(MOVIE_EXTRA,imgTag);
        startActivity(intent);


    }
}
