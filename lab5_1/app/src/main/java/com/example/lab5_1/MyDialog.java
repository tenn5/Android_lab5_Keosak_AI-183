package com.example.lab5_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static MyDialog newInstance(String param1) {
        MyDialog fragment = new MyDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mParam1 = getArguments() == null ? "null" : getArguments().getString(ARG_PARAM1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Number");
        builder.setMessage("You choose number: " + mParam1);

        return builder.create();
    }
}
