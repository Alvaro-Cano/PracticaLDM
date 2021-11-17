package com.example.practica2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Builds extends AppCompatActivity {


    private ListView listview;
    private ArrayList<String> lista;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builds);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_2);
        actionBar.setDisplayShowHomeEnabled(true);

        listview = (ListView) findViewById(R.id.listview);
        AdminSQLiteOpenHelper db = new AdminSQLiteOpenHelper(getApplicationContext(),"gestion",null,1);
        lista = db.llenar_lv();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String nombre = lista.get(position);
                mybuilds(view,nombre);
            }
        });
    }
    public void createBuild(View v){
        Intent create = new Intent(this, CreateBuilds.class);
        startActivity(create);
    }
    public void mybuilds(View v,String champ){
        Intent create = new Intent(this, MyBuilds.class);
        create.putExtra("Name",champ);
        startActivity(create);
    }
}