package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static android.text.format.DateFormat.*;

/**
 * Created by user
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This is part of the fragment instance
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new CrimeTextWatcher());

        mDateButton = (Button) v.findViewById(R.id.crime_date);

        mDateButton.setText(format("EEEE, dd MMMM, yyyy", mCrime.getDate()));
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    //Set the crime's solved property
                    mCrime.setSolved(isChecked);
                });

        return v;
    }

    private final class CrimeTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //This space intentionally left blank
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mCrime.setTitle(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            //This one too
        }
    }
}