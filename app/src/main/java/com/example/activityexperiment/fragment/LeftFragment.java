package com.example.activityexperiment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activityexperiment.R;
import com.example.activityexperiment.bean.ShareBean;
import com.example.activityexperiment.model.ShareViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LeftFragment extends Fragment {

    private ShareViewModel viewModel;

    private EditText edit_left;
    private Button btn_left, btn_parent;

    private Toolbar mToolbar;

    private PurchaseDialogFragment dialogFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        edit_left = view.findViewById(R.id.edit_left);
        btn_left = view.findViewById(R.id.btn_left);
        btn_parent = view.findViewById(R.id.btn_parent);
        mToolbar = view.findViewById(R.id.myToolbar);
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

        mToolbar.setTitle("Fragment的新Title");
        mToolbar.inflateMenu(R.menu.menu_title);

        dialogFragment = new PurchaseDialogFragment();
        /*mToolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "toolbar", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onStart() {
        super.onStart();
        mToolbar.inflateMenu(R.menu.menu_title1);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_click:
                        dialogFragment.show(getChildFragmentManager(),PurchaseDialogFragment.DIALOG_TAG);
                        return true;
                    case R.id.action_check:
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
