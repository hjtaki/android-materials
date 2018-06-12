package com.example.morningclass.firstapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int rand1;
    private int rand2;
    private int rand3;
    private int score;
    private Button leftButton;
    TextView colorView;

    static Map<String,Integer> colorsAndNum = new HashMap<>();
    static List<String> colors = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // right after the activity gets created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftButton = findViewById(R.id.leftButton);

        colors.add("BLACK");
        colors.add("DKGRAY");
        colors.add("GRAY");
        colors.add("LTGRAY");
        colors.add("WHITE");
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        colors.add("YELLOW");
        colors.add("TRANSPARENT");

        colorsAndNum.put("BLACK", 0xFF000000);
        colorsAndNum.put("DKGRAY", 0xFF444444);
        colorsAndNum.put("GRAY", 0xFF888888);
        colorsAndNum.put("LTGRAY", 0xFFCCCCCC);
        colorsAndNum.put("WHITE", 0xFFFFFFFF);
        colorsAndNum.put("RED", 0xFFFF0000);
        colorsAndNum.put("GREEN", 0xFF00FF00);
        colorsAndNum.put("BLUE", 0xFF0000FF);
        colorsAndNum.put("YELLOW", 0xFFFFFF00);
        colorsAndNum.put("TRANSPARENT", 0);


        // initial settings
        score = 0;
        generateRandomColors();

    }



    private void generateRandomColors() {
        rand1 = (int) (Math.random() * 10) ; // 0 <=    < 10
        rand2 = (int) (Math.random() * 10) ;
        while (rand1 == rand2) {
            rand2 = (int) (Math.random() * 10) ;
        }
        Button leftButt = findViewById(R.id.leftButton);
        Button rightButt = findViewById(R.id.rightButton);

        leftButt.setBackgroundColor(colorsAndNum.get(colors.get(rand1)));
        rightButt.setBackgroundColor(colorsAndNum.get(colors.get(rand2)));



         colorView = findViewById(R.id.color);

        rand3 = (int) (Math.random() * 2) ; // 0 or 1
        if(rand3 ==0){
            colorView.setText(colors.get(rand1));}
        else{
            colorView.setText(colors.get(rand2));}


    }


    public void buttonClicked(View view) {
        String show = "";
        if (view.getId() == R.id.leftButton) {
            // left button clicked
            if (colors.get(rand1) == colorView.getText()) {
                score++;
                show = "RIGHT!";
            } else {
                score--;
                show = "WRONG!";
            }
        } else {
            if (colors.get(rand2) == colorView.getText()) {
                score++;
                show = "RIGHT!";
            } else {
                score--;
                show = "WRONG!";
            }
        }

        Toast.makeText(this, "YOU ARE " + show, Toast.LENGTH_SHORT).show();
        TextView scoreView = findViewById(R.id.score);
        scoreView.setText("Score: " + score);
        generateRandomColors();
    }
}