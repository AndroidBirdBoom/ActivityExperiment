package com.example.activityexperiment.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PurchaseDialogFragment extends DialogFragment {

    public static final String DIALOG_TAG = "com.example.activityexperiment.fragment.dialog";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog dialog = new AlertDialog.Builder(requireContext()).setTitle("警告！!!").setMessage("这是一个警告框！").setPositiveButton("好的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(requireContext(), "好的", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).setNegativeButton("不好的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(requireContext(), "不好的", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).create();
        return dialog;
    }
}
