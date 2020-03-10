package com.example.crudammi.ui.aktivitasfisik;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.crudammi.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SingleChoiceDialogFragment extends DialogFragment {

    int position=0; //default selected position

    String[] list;

    public interface SingleChoiceListener{
        void onPositivButtonClicked(String[] list,int position);
        void onNegativeButtonClicked();
    }

    SingleChoiceListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener= (SingleChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString()+" SingleChoiceListener must implemented");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        //list=getActivity().getResources().getStringArray(R.array.lama_beraktivitas);
        list = AktivitasfisikActivity.list;

        builder.setTitle("Select Lama Beraktivitas Anda")
                .setSingleChoiceItems(list, position, (dialogInterface, i) -> position = i)
                .setPositiveButton("OK", (dialogInterface, i) -> mListener.onPositivButtonClicked(list,position))
                .setNegativeButton("Cancel", (dialogInterface, i) -> mListener.onNegativeButtonClicked());

        return builder.create();
    }
}

