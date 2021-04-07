package com.example.lab5_3;

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

        if(mParam1.equals("batteryLow")){
            builder.setTitle("Battery");
            builder.setMessage("Battery low");
        }
        if (mParam1.equals("tookPhoto")){
            builder.setTitle("Camera");
            builder.setMessage("You took a photo");
        }
        if (mParam1.equals("onAirplane")) {
            builder.setTitle("Airplane");
            builder.setMessage("Airplane mode was turned on");
        }
        if (mParam1.equals("offAirplane")) {
            builder.setTitle("Airplane");
            builder.setMessage("Airplane mode was turned off");
        }



        return builder.create();
    }
}
