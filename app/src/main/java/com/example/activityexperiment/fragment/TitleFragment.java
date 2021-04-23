package com.example.activityexperiment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.activityexperiment.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TitleFragment extends Fragment implements View.OnClickListener {

    private ImageButton ibTitle;

    private boolean isEdited;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);                     //添加菜单项必须设置该方法
        isEdited = false;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_title, menu);
    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItem = menu.findItem(R.id.action_done);
        menuItem.setVisible(isEdited);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                isEdited = true;
                requireActivity().invalidateOptionsMenu();
                Toast.makeText(requireContext(), "settting!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_done:
                Toast.makeText(requireContext(), "done！", Toast.LENGTH_SHORT).show();
                isEdited = false;
                requireActivity().invalidateOptionsMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        ibTitle = view.findViewById(R.id.ib_title_left);
        ibTitle.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_title_left:
                Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
