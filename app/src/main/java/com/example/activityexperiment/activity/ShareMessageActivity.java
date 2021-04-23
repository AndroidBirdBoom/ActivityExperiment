package com.example.activityexperiment.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.activityexperiment.R;
import com.example.activityexperiment.bean.ShareBean;
import com.example.activityexperiment.fragment.LeftFragment;
import com.example.activityexperiment.fragment.RightFragment;
import com.example.activityexperiment.model.ShareViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class ShareMessageActivity extends AppCompatActivity {

    private int FLAG = 0;
    private FrameLayout fl_containl, fl_containr;
    private FragmentManager manager;
    private TextView tvMessagel, tvMessager;

    private ShareViewModel viewModel;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharemes);
        fl_containl = findViewById(R.id.fl_contain_l);
        fl_containr = findViewById(R.id.fl_contain_r);
        tvMessagel = findViewById(R.id.tv_messagel);
        tvMessager = findViewById(R.id.tv_messager);
        FLAG = getIntent().getIntExtra(FirstActivity.SHARE_FRAGMENT, 0);
        mContext = getApplicationContext();

        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fl_contain_l, new LeftFragment()).commit();
        manager.beginTransaction().replace(R.id.fl_contain_r, new RightFragment()).commit();

        viewModel = new ViewModelProvider(this).get(ShareViewModel.class);
        viewModel.getShares().observe(this, new Observer<ShareBean>() {
            @Override
            public void onChanged(ShareBean shareBean) {
                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });*/
                tvMessager.setText(shareBean.getParent());
                tvMessagel.setText(shareBean.getParent());
            }
        });
    }
}
