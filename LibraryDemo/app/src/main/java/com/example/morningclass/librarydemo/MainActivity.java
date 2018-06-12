package com.example.morningclass.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goGetJokes(View view) {
        //1. go to URl, get jokes
        Ion.with(this)
                .load("https://api.chucknorris.io/jokes/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        //2. display to text View
                        TextView textView = findViewById(R.id.joketv);
                        textView.setText(result.get("value").getAsString());






                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .repeat(5)
                                .playOn(findViewById(R.id.joketv));




                    }
                });

        YoYo.with(Techniques.Flash)
                .duration(700)
                .repeat(5)
                .playOn(findViewById(R.id.getJoke));


    }
}
