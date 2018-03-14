package com.example.sridhar.shealthdemo.FragmentClasses;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sridhar.shealthdemo.R;

/**
 * Created by sridhar on 3/8/2018.
 */

public class AskDoctorFragment extends Fragment {
/*Alt + Insert to get a list of method*/

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.ask_doctor_layout,container,false);
        return myView;
    }
}
