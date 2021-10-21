package com.example.itsaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PuntuacionFinal extends AppCompatActivity {

    public static int puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion_final);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}