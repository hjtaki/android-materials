package com.example.morningclass.file;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private static final int RED_CODE_ADD_NAME = 1111;
    private static String TAG = "MenuActivity";
    private MediaPlayer mp ;
    private int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.v(TAG,"onCreate method got called");
        mp = MediaPlayer.create(this,R.raw.shape_of_you);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause method got called");
        length = mp.getCurrentPosition();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume method got called");

        mp.seekTo(length);
        mp.start();
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






    public void PlayButtonClicked(View view){
        // change activity(from, to)
        Intent intent = new Intent(this, MainActivity.class);

        //passing data
        intent.putExtra("secret","yeah"); //id -> data , it takes all type of data
        startActivity(intent);

    }


    public void addNameClicked(View view) {

        // start activity, but come back later when you are done

        Intent intent = new Intent(this, addNewName.class);
        startActivityForResult(intent, RED_CODE_ADD_NAME); // any number

    }

// I deed to overide to use startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1111){
            if(resultCode == RESULT_OK){
                String newName = data.getStringExtra("newName");
//                String[] names = newName.split(" ");
                toast(newName + " is added");

            }else{
                toast("name is not added");
            }
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
