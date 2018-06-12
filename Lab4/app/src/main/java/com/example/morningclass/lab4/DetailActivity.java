package com.example.morningclass.lab4;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setContent();
    }

    private void setContent() {
        Intent intent = getIntent();
        String passedMovieName = intent.getStringExtra(MainActivity.MOVIE_EXTRA);


        //1. img set
        ImageView imageView = findViewById(R.id.detailImage);
        int id_draw = getResources().getIdentifier(passedMovieName,"drawable",getPackageName());
        imageView.setImageResource(id_draw);


        //2, text set -> scanner read text file
        int id_raw = getResources().getIdentifier(passedMovieName,"raw",getPackageName());

            Scanner scan = new Scanner(getResources().openRawResource(id_raw));

            String allText = "";
            while(scan.hasNextLine()){
                allText += scan.nextLine();

            }
        scan.close();
        TextView textView = findViewById(R.id.detailText);
        textView.setText(allText);
    }


    private void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
