package com.example.morningclass.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CustomDialog extends Dialog {

    public Activity mActivity;
    public Dialog mDialog;
    public Button cancel;
    public Button add;



    public CustomDialog(Activity activity) {
        super(activity);
        mActivity = activity;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customdialog);

        cancel = findViewById(R.id.cancel);
        add = findViewById(R.id.add);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add new fact to my existing data
            }
        });
    }
}
