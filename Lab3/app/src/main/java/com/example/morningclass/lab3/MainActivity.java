package com.example.morningclass.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = findViewById(R.id.imageView);
                TextView textView = findViewById(R.id.textView);


                String movieName = spinner.getItemAtPosition(position).toString();
                int id_draw = getResources().getIdentifier(movieName, "drawable", getPackageName());
                int id_raw = getResources().getIdentifier(movieName, "raw", getPackageName());

                if (parent.getSelectedItem().equals(movieName)) {
                    imageView.setImageResource(id_draw);
                    Scanner scan = new Scanner(getResources().openRawResource(id_raw));
                    String allText = "";
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        allText += line; }
                    textView.setText(allText);
                    scan.close();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }}
