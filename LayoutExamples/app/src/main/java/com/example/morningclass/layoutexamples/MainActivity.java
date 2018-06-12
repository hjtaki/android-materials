package com.example.morningclass.layoutexamples;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turtle);



        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = findViewById(R.id.topTv);
                String text = (String) parent.getSelectedItem();
                tv.setText(text);

                ImageView imageView = findViewById(R.id.imageView);

                if(text.equals("Leo")){
                    imageView.setImageDrawable(getDrawable(R.drawable.blue));
                }
                if(text.equals("Mich")){
                    imageView.setImageDrawable(getDrawable(R.drawable.orange));
                }
                if(text.equals("Donatello")){
                    imageView.setImageDrawable(getDrawable(R.drawable.purple));
                }
                if(text.equals("Raphael")){
                    imageView.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        RadioButton rd1 = findViewById(R.id.rd1);
        RadioButton rd2 = findViewById(R.id.rd2);
        RadioButton rd3 = findViewById(R.id.rd3);
        RadioButton rd4 = findViewById(R.id.rd4);


        String name = " ";
        String name1 = (String) rd1.getText();
        String name2 = (String) rd2.getText();
        String name3 = (String) rd3.getText();
        String name4 = (String) rd4.getText();

        ImageView imageView2 = findViewById(R.id.imageView2);

        if(name.equals(name1)){
            imageView2.setImageDrawable(getDrawable(R.drawable.blue));
        }
        if(rd2.isSelected()){
            imageView2.setImageDrawable(getDrawable(R.drawable.orange));
        }
        if(rd3.isSelected()){
            imageView2.setImageDrawable(getDrawable(R.drawable.purple));
        }
        if(rd4.isSelected()){
            imageView2.setImageDrawable(getDrawable(R.drawable.red));
        }
    }











    }



