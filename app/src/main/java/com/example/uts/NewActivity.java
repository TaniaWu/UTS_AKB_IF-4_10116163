package com.example.uts;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        ActionBar actionBar = getSupportActionBar();
        TextView tvId = findViewById(R.id.editId);
        TextView tvName = findViewById(R.id.editName);
        TextView tvKelas = findViewById(R.id.editKelas);
        TextView tvPhone = findViewById(R.id.editPhone);
        TextView tvEmail = findViewById(R.id.editEmail);

        //Get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContentId = intent.getStringExtra("contentTvId");
        String mContentName = intent.getStringExtra("contentTvName");
        String mContentKelas = intent.getStringExtra("contentTvKelas");
        String mContentPhone = intent.getStringExtra("contentTvPhone");
        String mContentEmail = intent.getStringExtra("contentTvEmail");

        //Set ActionBar title
        actionBar.setTitle(mActionBarTitle);

        //Set text in textview
        tvId.setText(mContentId);
        tvName.setText(mContentName);
        tvKelas.setText(mContentKelas);
        tvPhone.setText(mContentPhone);
        tvEmail.setText(mContentEmail);
    }
}
