package com.example.activityexperiment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.activityexperiment.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SingleInstanceAcitivty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_stop, btn_stask, btn_sinstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_sinstance);
        btn_stop = findViewById(R.id.btn_launch_stop);
        btn_stask = findViewById(R.id.btn_launch_stask);
        btn_sinstance = findViewById(R.id.btn_launch_sinstance);
        btn_stop.setOnClickListener(this);
        btn_stask.setOnClickListener(this);
        btn_sinstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_launch_stop:
                Intent intent = new Intent(this, SingleTopAcitivty.class);
                startActivity(intent);
                break;
            case R.id.btn_launch_stask:
                Intent intent1 = new Intent(this, SingleTaskAcitivty.class);
                startActivity(intent1);
                break;
            case R.id.btn_launch_sinstance:
                Intent intent2 = new Intent(this, SingleInstanceAcitivty.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
