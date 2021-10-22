package com.example.itsaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Respuestas extends AppCompatActivity {

    ListView lista;
    List<String> listarespuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);

        lista = findViewById(R.id.lista);

        listarespuestas = new ArrayList<>();
        listarespuestas.add("1.¿Qué tenía Salvador Dalí de característico?  Su bigote");
        listarespuestas.add("2.¿Quién postuló la ley del principio de inercia?  Isaac Newton");
        listarespuestas.add("3.¿De quien viene la frase: Cree en el plan?  Fernando Alonso");
        listarespuestas.add("4.¿En qué saga de videojuegos aparece la entrega Ocarina Of Time?  Legend of Zelda");
        listarespuestas.add("5.¿Qué imagen corresponde al año 1945?  La primera");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listarespuestas);

        lista.setAdapter(adapter);
    }

    public void Menu (View v){
        Intent como = new Intent(this,Menu.class);
        startActivity(como);
    }
}