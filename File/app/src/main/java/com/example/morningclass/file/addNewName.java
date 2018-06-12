package com.example.morningclass.file;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class addNewName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_name);

    }



    public void AddNewName(View view) {

        //1. get names
        EditText first = findViewById(R.id.firstName_et);
        EditText last = findViewById(R.id.lastName_et);

        String fn = first.getText().toString();
        String ln = last.getText().toString();

        //2. valid check(RegEx)

        if(Pattern.matches("[A-Za-z]+",fn)
                && Pattern.matches("[A-Za-z]+",ln)){
            toast("new name added");

            //3. add new name to new file, we can not modify exist file
            // create new file(new_names.txt), use 2 files
            // generate questions from two files (Main)

            try {
                PrintStream output = new PrintStream(openFileOutput("new_names.txt", MODE_PRIVATE));
                output.println(fn + " " + ln);

                output.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //4. Send new data back to MenuActivity to alert that new names added

            Intent intent = new Intent();
                intent.putExtra("newName",fn+ " " + ln);
                setResult(RESULT_OK, intent);

             // sends data(intent) with result code
                 finish();


        }else{
            toast("name type is not okay");
        }

    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
