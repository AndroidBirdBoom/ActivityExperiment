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
    public static final String SHARE_FRAGMENT = "com.example.activityexperiment.activity.share_fragment";

    private EditText ed_show;
    private Button btn_back, btn_vm, btn_api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ed_show = findViewById(R.id.et_name);
        btn_back = findViewById(R.id.btn_back);
        btn_vm = findViewById(R.id.btn_sfd_vm);
        btn_api = findViewById(R.id.btn_sfd_api);
        btn_back.setOnClickListener(this);
        btn_vm.setOnClickListener(this);
        btn_api.setOnClickListener(this);
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
            case R.id.btn_sfd_vm:
                Intent intent1 = new Intent(this, ShareMessageActivity.class);
                intent1.putExtra(SHARE_FRAGMENT, -1);
                startActivity(intent1);
                break;
            case R.id.btn_sfd_api:
                Intent intent2 = new Intent(this, ShareMessageActivity.class);
                intent2.putExtra(SHARE_FRAGMENT, 1);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
