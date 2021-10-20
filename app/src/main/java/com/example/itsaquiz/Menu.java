package com.example.itsaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Jugar (View v){
        Intent play = new Intent(this,ComoJugar.class);
        startActivity(play);
    }

    public void ComoJugar (View v){
        Intent como = new Intent(this,ComoJugar.class);
        startActivity(como);
    }
}