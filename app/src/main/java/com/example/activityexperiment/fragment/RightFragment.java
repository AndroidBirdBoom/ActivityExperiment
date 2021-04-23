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

public class RightFragment extends Fragment {

    private EditText edit_right;
    private Button btn_right, btn_parent;

    private ShareViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        edit_right = view.findViewById(R.id.edit_right);
        btn_right = view.findViewById(R.id.btn_right);
        btn_parent = view.findViewById(R.id.btn_parent);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareBean shareBean = viewModel.getShares().getValue();
                shareBean.setLeft(edit_right.getText().toString());
                viewModel.setShares(shareBean);
            }
        });

        btn_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareBean shareBean = viewModel.getShares().getValue();
                shareBean.setParent(edit_right.getText().toString());
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
                edit_right.setText(shareBean.getRight());
            }
        });
    }
}
