package com.example.uts;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Tanggan Pengerjaan : 18 Mei 2019
 * NIM : 10116163
 * Nama : Anastasia Tania
 * Kelas : IF-4
 */

public class Listview extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] nama;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_daftarteman);

        Intent bundle = getIntent();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Contact List");

        nama = new String[]{"Emma", "Tiffany", "Chloe", "Yolan", "Rani", "Siti", "Savira"};
        icon = new int[]{R.drawable.splash_screen, R.drawable.splash_screen, R.drawable.splash_screen,
                R.drawable.splash_screen, R.drawable.splash_screen, R.drawable.splash_screen,
                R.drawable.splash_screen,};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < nama.length; i++){
            Model model = new Model(nama[i], icon[i]);
            //Bind all string in Array
            arrayList.add(model);
        }

        //Pass Result to ListViewAdapter
        adapter = new ListViewAdapter(this, arrayList);

        //Bind the adapter to the listView
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search){
            //Do your functionality here
            return true;
        }
        return super.onContextItemSelected(item);
    }


}