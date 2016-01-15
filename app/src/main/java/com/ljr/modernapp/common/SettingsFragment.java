package com.ljr.modernapp.common;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.ljr.modernapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    private View mRootView;
    private RadioGroup mSettingsRadioGroup;
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_settings, container, false);

        mSharedPreference = getActivity().getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreference.edit();

        mSettingsRadioGroup = (RadioGroup) mRootView.findViewById(R.id.radioGroupSettings);


//        mSettingsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


        mSettingsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonNotepad:
                        //set Notepad as the default
                        mEditor.putInt(Constants.DEFAULT_APP, Constants.NOTEPAD);
                        mEditor.commit();
                        break;

                    case R.id.radioButtonTodoList:
                        //set Todo List as the default
                        mEditor.putInt(Constants.DEFAULT_APP, Constants.TODO);
                        mEditor.commit();
                        break;

                    case R.id.radioButtonReminder:
                        //set Reminder as the default
                        mEditor.putInt(Constants.DEFAULT_APP, Constants.REMINDER);
                        mEditor.commit();
                        break;

                    case R.id.radioButtonDrawing:
                        //set Drawing as the default
                        mEditor.putInt(Constants.DEFAULT_APP, Constants.DRAWING);
                        mEditor.commit();
                        break;

                    case R.id.radioButtonMovieList:
                        //set MovieList as the default
                        mEditor.putInt(Constants.DEFAULT_APP, Constants.MOVIE);
                        mEditor.commit();
                        break;

                }


            }
        });

        return mRootView;
    }

}
