package com.example.activityexperiment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.activityexperiment.activity.DynamicfActivity;
import com.example.activityexperiment.activity.FirstActivity;
import com.example.activityexperiment.activity.SingleTopAcitivty;
import com.example.activityexperiment.activity.StablefActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    private static final int CONTACT_REQUEST = 0;
    public static final String EDIT_TEXT_HINT_MESSAGE = "com.example.activityexperiment.edit.message";

    private Button btn_next, btn_stack_next, btn_stablef, btn_dynamicf, btn_intent;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);      //上述方法也可以
        btn_next = findViewById(R.id.btn_next);
        btn_stack_next = findViewById(R.id.btn_stack);
        tv_show = findViewById(R.id.tv_show);
        btn_next.setOnClickListener(this);
        btn_stack_next.setOnClickListener(this);
        btn_stablef = findViewById(R.id.btn_sfrgment);
        btn_stablef.setOnClickListener(this);
        btn_dynamicf = findViewById(R.id.btn_dfrgment);
        btn_dynamicf.setOnClickListener(this);
        btn_intent = findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(this);
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String str_tv = data.getStringExtra(FirstActivity.TEXT_MESSAGE);
                tv_show.setText(str_tv);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                Intent intent = new Intent(this, FirstActivity.class);
                intent.putExtra(EDIT_TEXT_HINT_MESSAGE, EDIT_TEXT_HINT_MESSAGE);
                startActivityForResult(intent, CONTACT_REQUEST);
                break;
            case R.id.btn_stack:
                Intent intent1 = new Intent(this, SingleTopAcitivty.class);
                startActivity(intent1);
                break;
            case R.id.btn_sfrgment:
                Intent intent2 = new Intent(this, StablefActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_dfrgment:
                Intent intent3 = new Intent(this, DynamicfActivity.class);
                startActivity(intent3);
            case R.id.btn_intent:
                /*Intent intent4 = new Intent(Intent.ACTION_VIEW);
//                Intent chooser = Intent.createChooser(intent4, "title1");
                try {
                    startActivity(intent4);
                } catch (ActivityNotFoundException e) {

                }*/
                Intent intent4 = new Intent();
                intent4.setAction("com.view.my_action");
                startActivity(intent4);
                break;
            default:
                break;
        }
    }


}