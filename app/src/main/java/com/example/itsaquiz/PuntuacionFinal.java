package com.example.itsaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PuntuacionFinal extends AppCompatActivity {

    public static int puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (puntuacion<0){
            setPuntuacion(0);
        }
        if (puntuacion<7) {
            setContentView(R.layout.derrota_puntuacionfinal);
            TextView textView = (TextView) findViewById(R.id.textViewPuntuacionD);
            textView.setText(puntuacion+" /15 puntos conseguidos");
        }else {
            setContentView(R.layout.activity_puntuacion_final);
            TextView textView = (TextView) findViewById(R.id.textViewPuntuacionV);
            textView.setText(puntuacion+" /15 puntos conseguidos");
        }
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void Menu (View v){
        Intent como = new Intent(this,Menu.class);
        startActivity(como);
    }

    public void Respuestas (View v){
        Intent como = new Intent(this,Respuestas.class);
        startActivity(como);
    }
    public void comprobarNegatividad(){
        if (this.getPuntuacion() <0){
            this.setPuntuacion(0);
        }
    }
}