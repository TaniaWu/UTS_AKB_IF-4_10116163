package com.example.uts;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // kita set default nya Home Fragment
        loadFragment(new ProfilFragment());

        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    //method untuk load fragement yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
            return false;
        }

    // method listener untuk logika pemilihan
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.profil_menu:
                fragment = new ProfilFragment();
                break;
            case R.id.kontak_menu:
                fragment = new KontakFragment();
                break;
            case R.id.daftarteman_menu:
                fragment = new DaftarTemanFragment();
                break;
        }
        return loadFragment(fragment);
    }

    }

