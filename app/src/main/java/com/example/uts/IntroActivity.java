package com.example.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.uts.activities.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make the Activity on Full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);
//BATASSS
 //When This Activity is about to Launch we need to Check if its open before or not
 if (restorePrefData()){
 Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
 startActivity(mainActivity);
 finish();
 }
 //BATASSS
        //Hide the Action Bar



        //Ini View
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        //Fill List Screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Profil", "Menampilkan informasi pribadi seperti foto, NIM, nama, kelas dan deskripsi diri ",R.drawable.img1));
        mList.add(new ScreenItem("Kontak", "Menampilkan informasi kontak pribadi seperti telepon, email, dan sosial media pribadi",R.drawable.img2));
        mList.add(new ScreenItem("Daftar Teman", "Berisi daftar teman yang disertakan informasi kontak.",R.drawable.img3));

        //Setup ViewPager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new com.example.uts.IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //Setup TabLayout
        tabIndicator.setupWithViewPager(screenPager);

        //Next Button Klik Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
                //When We Reach The Last Screen
                if (position == mList.size()-1){
                    //TODO : Show the GETSTARTED Button and Hide the Indicator and the Next Button
                    loadLastScreen();
                }
            }
        });
        //Tablayout Add Change Listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //GETSTARTED Button Click Listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Open The LoginActivity
                Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginActivity);

                //Also we need the save a boolean value to storage so next time when the user run
                //the app we could know that he is already checked the intro screen activity
                //so use the shared preference to that proses
                //BATASSS
                savePrefsData();
                //BATASSS
                finish();
            }
        });
    }
    //BATASS
        private boolean restorePrefData() {
     SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
     Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);
     return isIntroActivityOpenedBefore;
     }

     private void savePrefsData() {
     SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
     SharedPreferences.Editor editor = pref.edit();
     editor.putBoolean("isIntroOpened",true);
     editor.commit();
     }
     //BATASSS
    //Show the GETSTARTED Button and Hide the Indicator and the Next Button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        //TODO : ADD An Animnation to the GETSTARTED Button
        //Setup Animation
        btnGetStarted.setAnimation(btnAnim);

    }



}
