package com.example.sridhar.shealthdemo.PageClasses;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.View;

import com.example.sridhar.shealthdemo.FragmentClasses.AboutAppFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.AskDoctorFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.ContentFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.FaqsFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.HomeFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.QuoteFragment;
import com.example.sridhar.shealthdemo.R;
import com.example.sridhar.shealthdemo.FragmentClasses.TandCFragment;
import com.example.sridhar.shealthdemo.FragmentClasses.VideoGalleryFragment;
import static com.example.sridhar.shealthdemo.JavaClasses.GlobalClass.isHome;
import static com.example.sridhar.shealthdemo.JavaClasses.GlobalClass.package_name;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    String Header,Content;
    //To load fragments
    private static android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        package_name = getPackageName();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting up navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Initialising navigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        isHome = true;
        toolbar.setTitle(R.string.app_name);
        fragment = new HomeFragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frags, fragment);
        fragmentTransaction.commit();

        //Initialisation of header layout of navigation drawer to modify it
//        View header   = navigationView.getHeaderView(0);

    }

    //On pressing back button
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(isHome){
                //In Home Screen
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }else{
                //Go to home Screen
                isHome = true;
                toolbar.setTitle(R.string.app_name);
                fragment = new HomeFragment();
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Frags, fragment);
                fragmentTransaction.commit();
                //super.onBackPressed();
            }
        }
    }//onBackPressed

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Displays the appropriate fragment, based on the list item selected
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        for(int i = 1; i < fragmentManager.getBackStackEntryCount(); i++){

            Log.d("backstack count","" + fragmentManager.getBackStackEntryCount());
            fragmentManager.popBackStack();
        }


        switch(id) {
            case R.id.nav_home:
                isHome = true;
                fragment = new HomeFragment();
                toolbar.setTitle(R.string.app_name);
                break;

            case R.id.nav_doctor:
                fragment = new AskDoctorFragment();
                toolbar.setTitle(R.string.ask_doctor);
                break;

            case R.id.nav_faqs:
                fragment = new FaqsFragment();
                toolbar.setTitle(R.string.faq_screen);
                break;

            case R.id.nav_videoGallery:
                isHome = false;
                fragment = new VideoGalleryFragment();
                toolbar.setTitle(R.string.video_gallery_screen);
                break;

            case R.id.nav_quote:
                fragment = new QuoteFragment();
                toolbar.setTitle(R.string.quote_screen);
                break;

            case R.id.nav_aboutApp:
                fragment = new AboutAppFragment();
                toolbar.setTitle(R.string.about_screen);
                break;
            case R.id.nav_TandC:
                fragment = new TandCFragment();
                toolbar.setTitle(R.string.TandC_screen);
                break;
            default:
                fragment = new HomeFragment();
                toolbar.setTitle(R.string.about_screen);
                isHome = true;
                break;
        }

        fragmentTransaction.replace(R.id.Frags, fragment ,null).addToBackStack(null).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }//onNavigationItemSelected

    //called by buttons when touched (through XML file)
    @Override
    public void onClick(View v) {

        //To store the fragment to be opened
        Bundle bundle = new Bundle();
        fragment = new ContentFragment();
        isHome = false;
        switch (v.getId()) {

            case R.id.id_healthy_women:
                toolbar.setTitle(R.string.Healthy_Female);
                Header = "H_Healthy_Female";
                Content = "C_Healthy_Female";

                break;
            case R.id.id_bmi:
                toolbar.setTitle(R.string.bmi);
                Header = "H_bmi";
                Content = "C_bmi";
                break;
            case R.id.id_glands:
                Header = "H_glands";
                Content = "C_glands";
                toolbar.setTitle(R.string.glands);
                break;
            case R.id.id_reproduction:
                Header = "H_Reproductive_system";
                Content = "C_Reproductive_system";
                toolbar.setTitle(R.string.Reproductive_system);
                break;
            case R.id.id_hormone:
                Header = "H_Hormones";
                Content = "C_Hormones";
                toolbar.setTitle(R.string.Hormones);
                break;
            case R.id.id_growing_old:
                Header = "H_get_old";
                Content = "C_get_old";
                toolbar.setTitle(R.string.get_old);
                break;
            case R.id.id_teen_girl :
                Header = "H_Adolescence";
                Content = "C_Adolescence";
                toolbar.setTitle(R.string.Adolescence);
                break;
            case R.id.id_puberty :
                Header = "H_puberty";
                Content = "C_puberty";
                toolbar.setTitle(R.string.puberty);
                break;
            case R.id.id_menstrual_cycle :
                Header = "H_Menstrual_cycle";
                Content = "C_Menstrual_cycle";
                toolbar.setTitle(R.string.Menstrual_cycle);
                break;
            case R.id.id_hormone_imbalance :
                Header = "H_Hormone_swings";
                Content = "C_Hormone_swings";
                toolbar.setTitle(R.string.Hormone_swings);
                break;
            case R.id.id_acne :
                Header = "H_Acne";
                Content = "C_Acne";
                toolbar.setTitle(R.string.Acne);
                break;
            case R.id.id_teen_pregnant :
                Header = "H_Teenage_pregnancy";
                Content = "C_Teenage_pregnancy";
                toolbar.setTitle(R.string.Teenage_pregnancy);
                break;
            case R.id.id_fertility :
                Header = "H_Fertility";
                Content = "C_Fertility";
                toolbar.setTitle(R.string.Fertility);
                break;
            case R.id.id_safe_sex :
                Header = "H_safe_sex";
                Content = "C_safe_sex";
                toolbar.setTitle(R.string.safe_sex);
                break;
            case R.id.id_pergnant :
                Header = "H_pregnancy";
                Content = "C_pregnancy";
                toolbar.setTitle(R.string.pregnancy);
                break;
            case R.id.id_abortion :
                Header = "H_abortion";
                Content = "C_abortion";
                toolbar.setTitle(R.string.abortion);
                break;
            case R.id.id_postpartum :
                Header = "H_postpartum";
                Content = "C_postpartum";
                toolbar.setTitle(R.string.postpartum);
                break;
            case R.id.id_baby :
                Header = "H_child_care";
                Content = "C_child_care";
                toolbar.setTitle(R.string.child_care);
                break;
            case R.id.id_motivation :
                Header = "H_Motivation";
                Content = "C_Motivation";
                toolbar.setTitle(R.string.Motivation);
                break;
            case R.id.id_empower :
                Header = "H_empower";
                Content = "C_empower";
                toolbar.setTitle(R.string.empower);
                break;
            case R.id.id_tackle_stress :
                Header = "H_tackle_stress";
                Content = "C_tackle_stress";
                toolbar.setTitle(R.string.tackle_stress);
                break;
            case R.id.id_girl_to_girl :
                Header = "H_girl_for_girl";
                Content = "C_girl_for_girl";
                toolbar.setTitle(R.string.girl_for_girl);
                break;
            case R.id.id_no_drugs :
                Header = "H_no_drugs";
                Content = "C_no_drugs";
                toolbar.setTitle(R.string.no_drugs);
                break;
            case R.id.id_be_the_change:
                Header = "H_be_the_change";
                Content = "C_be_the_change";
                toolbar.setTitle(R.string.be_the_change);
                break;
            case R.id.id_support :
                Header = "H_get_support";
                Content = "C_get_support";
                toolbar.setTitle(R.string.get_support);
                break;
            case R.id.id_obesity :
                Header = "H_obesity";
                Content = "C_obesity";
                toolbar.setTitle(R.string.obesity);
                break;
            case R.id.id_hormone_disorder :
                Header = "H_Hormonal_disorders";
                Content = "C_Hormonal_disorders";
                toolbar.setTitle(R.string.Hormonal_disorders);
                break;
            case R.id.id_pcod :
                Header = "H_pcod";
                Content = "C_pcod";
                toolbar.setTitle(R.string.pcod);
                break;
            case R.id.id_infertility :
                Header = "H_InFertility";
                Content = "C_InFertility";
                toolbar.setTitle(R.string.InFertility);
                break;
            case R.id.id_child_birth :
                Header = "H_childBirth";
                Content = "C_childBirth";
                toolbar.setTitle(R.string.childBirth);
                break;
            case R.id.id_aids :
                Header = "H_hiv";
                Content = "C_hiv";
                toolbar.setTitle(R.string.hiv);
                break;
            case R.id.id_std :
                Header = "H_STDs";
                Content = "C_STDs";
                toolbar.setTitle(R.string.STDs);
                break;
            case R.id.id_cancer :
                Header = "H_cancer";
                Content = "C_cancer";
                toolbar.setTitle(R.string.cancer);
                break;
            case R.id.id_menopause :
                Header = "H_Menopause";
                Content = "C_Menopause";
                toolbar.setTitle(R.string.Menopause);
                break;
            case R.id.id_stress :
                Header = "H_stress";
                Content = "C_stress";
                toolbar.setTitle(R.string.stress);
                break;
            case R.id.id_physical_violence :
                Header = "H_Violence";
                Content = "C_Violence";
                toolbar.setTitle(R.string.Violence);
                break;
            case R.id.id_abuse :
                Header = "H_Sexual_Abuse";
                Content = "C_Sexual_Abuse";
                toolbar.setTitle(R.string.Sexual_Abuse);
                break;
            default:
                fragment = new HomeFragment();
                toolbar.setTitle(R.string.app_name);
                isHome = true;
                break;
        }
        bundle.putString("Header", Header);
        bundle.putString("Content", Content);
        fragment.setArguments(bundle);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frags, fragment);
        fragmentTransaction.commit();
    }


}
