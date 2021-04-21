package com.example.activityexperiment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.activityexperiment.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {

    public static final String TAG_CONTENTFRAGMENT = "com.example.activityexperiment.fragment.contentfragment";
    private String mContent;
    private TextView tvContent;

    public static ContentFragment newInstance(String content) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_CONTENTFRAGMENT, content);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(TAG_CONTENTFRAGMENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        if (mContent != null) {
            tvContent = view.findViewById(R.id.tv_content);
            tvContent.setText(mContent);
        }
        return view;
    }

}
