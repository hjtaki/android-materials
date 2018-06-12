package com.example.morningclass.lab2listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView listview = findViewById(R.id.listview);

        String[] values = new String[] {
                "Android",
                "iPhone",
                "WindowMobile",
                "Blackberry",
                "webOS",
                "Ubuntu",
                "Windows7",
                "Max OS X"
        };

        Integer[] images = new Integer[] {
                R.drawable.ad,
                R.drawable.ip,
                R.drawable.wd,
                R.drawable.bb,
                R.drawable.ad,
                R.drawable.ip,
                R.drawable.wd,
                R.drawable.bb

        };




        Myadapter adapter3 = new Myadapter(this, R.layout.mylayout, values, images);
        

        // Assign adapter to ListView
        listview.setAdapter(adapter3);



        // ListView Item Click Listener
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listview.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position :"+position+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

    private class Myadapter extends ArrayAdapter<Object>{
        private int layoutResourceId;
        private String[] data;
        private Integer[] imgs;

        public Myadapter(@NonNull Context context, int resource,@NonNull String[] data, Integer[] imgs) {
            super(context, resource, data);
            this.layoutResourceId = resource;
            this.data = data;
            this.imgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            //1. inflate out xml layout
            convertView = getLayoutInflater().inflate(layoutResourceId,parent,false);
            //2. set img view and test view
            ImageView imgv = convertView.findViewById(R.id.imageView);
            TextView textv = convertView.findViewById(R.id.textView);

            imgv.setImageResource(imgs[position]);
            textv.setText(data[position]);

            return convertView;
        }
    }
    }



