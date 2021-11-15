package com.example.practica2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_2);
        actionBar.setDisplayShowHomeEnabled(true);

        mp = MediaPlayer.create(this, R.raw.homeaudio);
        mp.start();
        mp.setLooping(true);

        audio = (ImageButton) findViewById(R.id.pause);
    }

    public void jugar(View v){
        Intent jugar = new Intent(this, Builds.class);
        startActivity(jugar);
    }

    public void tutorial(View v){
        Intent tutorial = new Intent(this,HowToUse.class);
        startActivity(tutorial);
    }

    public void Salir (View v){
        finishAffinity();
        System.exit(0);
    }

    public void Silenciar (View v){
        if(mp.isPlaying()){
            mp.pause();
            audio.setImageResource(R.drawable.reproducir);
        }else{
            mp.start();
            audio.setImageResource(R.drawable.pausa);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}