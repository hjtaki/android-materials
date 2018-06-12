package com.example.morningclass.file;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.SocketHandler;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "MainActivity";
    private HashMap<String, String> namesMap;
    private TextView mTextView;
    private MediaPlayer mp ;
    private int length= 0;
    private int currentScoce;
    private int hightestScoce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        currentScoce = 0;

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.getInt("highest",0);

        // Intent : put data from menu
        Intent intent = getIntent(); //returns intent
        String passed = intent.getStringExtra("secret"); // when input was String
//        intent.getIntExtra()
        toast(passed);


        setContentView(R.layout.activity_main);
        namesMap = new HashMap<>();
        readContentsFromFile();
        getQuestion();

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //store instance state before gets destroyed
        TextView textView = findViewById(R.id.firstName_tv);
        ListView listView = findViewById(R.id.lastName_lv);

        //get all nemes in listView
        ListAdapter listAdapter = listView.getAdapter();
        ArrayList<String> currentOptions = new ArrayList<>();

        for(int i =0; i< listAdapter.getCount(); i++){
            currentOptions.add(listAdapter.getItem(i).toString());
        }


        outState.putString("firstname",textView.getText().toString());
        outState.putStringArrayList("options",currentOptions);


        Person a = new Person();
        outState.putSerializable("person",a);

        outState.putInt("currentScore",currentScoce);




    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String savedName = savedInstanceState.getString("firstname","no name");
        ArrayList<String> savedOptions = savedInstanceState.getStringArrayList("options");


        TextView textView = findViewById(R.id.firstName_tv);
        textView.setText(savedName);

        ListView lv = findViewById(R.id.lastName_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, savedOptions);
        lv.setAdapter(adapter);


        Person a = (Person)savedInstanceState.getSerializable("person");


        currentScoce = savedInstanceState.getInt("currentScore");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause method got called");



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume method got called");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop method got called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart method got called");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart method got called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy method got called");

    }



    private void getQuestion() {

        // added new names to the map
        try {
            Scanner scan = new Scanner(openFileInput("new_names.txt"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String allText = "";
                allText += line;
                System.out.println(allText);
                String[] names= allText.split(" ");
                String newFirstName = names[0];
                String newLastName = names[1];

                if(Pattern.matches("[A-Za-z]+",newFirstName)
                        && Pattern.matches("[A-Za-z]+",newLastName)){
                    namesMap.put(newFirstName, newLastName);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //map to array
        ArrayList<String> firstnames = new ArrayList<>(namesMap.keySet());
        ArrayList<String> lastnames = new ArrayList<>(namesMap.values());

        int rand = (int) (Math.random() * firstnames.size());
        String fn = firstnames.get(rand);
        String ln = namesMap.get(fn);

        lastnames.remove(ln);
        Collections.shuffle(lastnames);

        ArrayList<String> options = new ArrayList<>(lastnames.subList(0, 4));
        options.add(ln);

        Collections.shuffle(options);

        mTextView = findViewById(R.id.firstName_tv);
        mTextView.setText(fn);
        ListView lv = findViewById(R.id.lastName_lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // check answer
        String question = mTextView.getText().toString();
        String answer = namesMap.get(question);
        String selected = parent.getItemAtPosition(position).toString();

        Log.d(TAG, "onItemClick: " + selected);
        if (answer.equals(selected)) {
              currentScoce ++;
              if(currentScoce > hightestScoce){
                  hightestScoce = currentScoce;
                  //store this highest score permanently
                  SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                  SharedPreferences.Editor prefsEditor = prefs.edit();

                  prefsEditor.putInt("highest", hightestScoce);
                  prefsEditor.apply();

              }
            toast("Right! score : " + currentScoce + "highest score : " + hightestScoce);
            getQuestion();
        } else {
            currentScoce --;
            toast("Wrong! score : "+ currentScoce + "highest score : " + hightestScoce);
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void readContentsFromFile() {
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.names));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] fullname = line.split("\t");
            namesMap.put(fullname[0], fullname[1]);
        }
        scan.close();
    }
}