package com.example.activityexperiment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.activityexperiment.MainActivity;
import com.example.activityexperiment.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TEXT_MESSAGE = "com.example.activityexperiment.activity.message";

    private EditText ed_show;
    private Button btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ed_show = findViewById(R.id.et_name);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        String message = getIntent().getStringExtra(MainActivity.EDIT_TEXT_HINT_MESSAGE);
        ed_show.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                String ed_tv = ed_show.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(TEXT_MESSAGE, ed_tv);
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }
}
