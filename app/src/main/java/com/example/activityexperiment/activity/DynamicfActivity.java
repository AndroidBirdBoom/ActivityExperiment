package com.example.activityexperiment.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.activityexperiment.R;
import com.example.activityexperiment.bean.User;
import com.example.activityexperiment.fragment.ContentFragment;
import com.example.activityexperiment.model.MyViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class DynamicfActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;
    private FrameLayout fl_container;

    private FragmentManager fm;
    private FragmentTransaction transaction;

    private MyViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamicf);
        btn1 = findViewById(R.id.btn_na1);
        btn2 = findViewById(R.id.btn_na2);
        btn3 = findViewById(R.id.btn_na3);
        btn4 = findViewById(R.id.btn_na4);
        fl_container = findViewById(R.id.fl_contains);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_contains, new ContentFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        transaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.btn_na1:
                transaction.replace(R.id.fl_contains, ContentFragment.newInstance(btn1.getText().toString()));
                transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out);
                transaction.addToBackStack("but1");
                break;
            case R.id.btn_na2:
                transaction.replace(R.id.fl_contains, ContentFragment.newInstance(btn2.getText().toString()));
                transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out);
                transaction.addToBackStack("but2");
                break;
            case R.id.btn_na3:
                transaction.replace(R.id.fl_contains, ContentFragment.newInstance(btn3.getText().toString()));
                transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out);
                transaction.addToBackStack("but3");
                break;
            case R.id.btn_na4:
                transaction.replace(R.id.fl_contains, ContentFragment.newInstance(btn4.getText().toString()));
                transaction.setCustomAnimations(R.anim.slide_in, R.anim.fade_out);
                transaction.addToBackStack("but4");
                break;
            default:
                break;
        }
        transaction.setReorderingAllowed(true).commit();
    }
}
