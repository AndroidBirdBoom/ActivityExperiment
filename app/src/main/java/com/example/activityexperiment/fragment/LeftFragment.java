package com.example.activityexperiment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.activityexperiment.R;
import com.example.activityexperiment.bean.ShareBean;
import com.example.activityexperiment.model.ShareViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LeftFragment extends Fragment {

    private ShareViewModel viewModel;

    private EditText edit_left;
    private Button btn_left, btn_parent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        edit_left = view.findViewById(R.id.edit_left);
        btn_left = view.findViewById(R.id.btn_left);
        btn_parent = view.findViewById(R.id.btn_parent);
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareBean shareBean = viewModel.getShares().getValue();
                shareBean.setRight(edit_left.getText().toString());
                viewModel.setShares(shareBean);
            }
        });
        btn_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareBean shareBean = viewModel.getShares().getValue();
                shareBean.setParent(edit_left.getText().toString());
                viewModel.setShares(shareBean);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        viewModel.getShares().observe(getViewLifecycleOwner(), new Observer<ShareBean>() {
            @Override
            public void onChanged(ShareBean shareBean) {
                edit_left.setText(shareBean.getLeft());
            }
        });
    }
}
