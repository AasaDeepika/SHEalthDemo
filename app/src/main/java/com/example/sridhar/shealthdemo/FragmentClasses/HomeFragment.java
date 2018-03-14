package com.example.sridhar.shealthdemo.FragmentClasses;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import static com.example.sridhar.shealthdemo.JavaClasses.GlobalClass.isHome;
import com.example.sridhar.shealthdemo.R;

/**
 * Created by sridhar on 3/8/2018.
 */

public class HomeFragment extends Fragment {
/*Alt + Insert to get a list of method*/

    private Toolbar toolbar;
    String Header, Content;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageButton Exercise;

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_layout, container, false);
        isHome = true;

        return myView;


    }
}

