package com.example.practica2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyBuilds extends AppCompatActivity {

    private EditText et_nombre,et_campeon,et_descripcion,et_objeto1,et_objeto2,et_objeto3,et_objeto4,et_objeto5,et_objeto6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_builds);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher_2);
        actionBar.setDisplayShowHomeEnabled(true);

        et_nombre= (EditText) findViewById(R.id.txt_nombre);
        et_campeon= (EditText) findViewById(R.id.txt_campeon);
        et_descripcion= (EditText) findViewById(R.id.txt_descripcion);
        et_objeto1= (EditText) findViewById(R.id.txt_objeto1);
        et_objeto2= (EditText) findViewById(R.id.txt_objeto2);
        et_objeto3= (EditText) findViewById(R.id.txt_objeto3);
        et_objeto4= (EditText) findViewById(R.id.txt_objeto4);
        et_objeto5= (EditText) findViewById(R.id.txt_objeto5);
        et_objeto6= (EditText) findViewById(R.id.txt_objeto6);


        Buscar();
    }

    public void Buscar(){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"gestion",null,1);
        SQLiteDatabase BdD = admin.getWritableDatabase();
        String valor = getIntent().getStringExtra("Name");

        if(!valor.isEmpty()){
            Cursor fila = BdD.rawQuery("SELECT * FROM builds WHERE nombre="+valor,null);
            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString(1));
                et_campeon.setText(fila.getString(2));
                et_descripcion.setText(fila.getString(3));
                et_objeto1.setText(fila.getString(4));
                et_objeto2.setText(fila.getString(5));
                et_objeto3.setText(fila.getString(6));
                et_objeto4.setText(fila.getString(7));
                et_objeto5.setText(fila.getString(8));
                et_objeto6.setText(fila.getString(9));
            }
        }
        BdD.close();
    }

    public void Modificar(View view) {

        /*
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"gestion",null,1);
        SQLiteDatabase BdD = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String campeon = et_campeon.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String objeto1 = et_objeto1.getText().toString();
        String objeto2 = et_objeto2.getText().toString();
        String objeto3 = et_objeto3.getText().toString();
        String objeto4 = et_objeto4.getText().toString();
        String objeto5 = et_objeto5.getText().toString();
        String objeto6 = et_objeto6.getText().toString();

        if (!nombre.isEmpty() && !campeon.isEmpty() && !descripcion.isEmpty() && !objeto1.isEmpty() && !objeto2.isEmpty() && !objeto3.isEmpty() && !objeto4.isEmpty() && !objeto5.isEmpty() && !objeto6.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("nombre",nombre);
            registro.put("campeon",campeon);
            registro.put("descripcion",descripcion);
            registro.put("objeto1",objeto1);
            registro.put("objeto2",objeto2);
            registro.put("objeto3",objeto3);
            registro.put("objeto4",objeto4);
            registro.put("objeto5",objeto5);
            registro.put("objeto6",objeto6);

            BdD.insert("builds", null,registro);

            BdD.close();
            et_nombre.setText("");
            et_campeon.setText("");
            et_descripcion.setText("");
            et_objeto1.setText("");
            et_objeto2.setText("");
            et_objeto3.setText("");
            et_objeto4.setText("");
            et_objeto5.setText("");
            et_objeto6.setText("");

            Toast.makeText(this,"Registrado Correctamente",Toast.LENGTH_LONG).show();
            Intent salir = new Intent(this,Builds.class);
            startActivity(salir);
        } else {
            Toast.makeText(this,"Faltan campos por rellenar",Toast.LENGTH_LONG).show();
        }

         */
    }


    public void Eliminar(View view) {
        /*
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"gestion",null,1);
        SQLiteDatabase BdD = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String campeon = et_campeon.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String objeto1 = et_objeto1.getText().toString();
        String objeto2 = et_objeto2.getText().toString();
        String objeto3 = et_objeto3.getText().toString();
        String objeto4 = et_objeto4.getText().toString();
        String objeto5 = et_objeto5.getText().toString();
        String objeto6 = et_objeto6.getText().toString();

        if (!nombre.isEmpty() && !campeon.isEmpty() && !descripcion.isEmpty() && !objeto1.isEmpty() && !objeto2.isEmpty() && !objeto3.isEmpty() && !objeto4.isEmpty() && !objeto5.isEmpty() && !objeto6.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("nombre",nombre);
            registro.put("campeon",campeon);
            registro.put("descripcion",descripcion);
            registro.put("objeto1",objeto1);
            registro.put("objeto2",objeto2);
            registro.put("objeto3",objeto3);
            registro.put("objeto4",objeto4);
            registro.put("objeto5",objeto5);
            registro.put("objeto6",objeto6);

            BdD.insert("builds", null,registro);

            BdD.close();
            et_nombre.setText("");
            et_campeon.setText("");
            et_descripcion.setText("");
            et_objeto1.setText("");
            et_objeto2.setText("");
            et_objeto3.setText("");
            et_objeto4.setText("");
            et_objeto5.setText("");
            et_objeto6.setText("");

            Toast.makeText(this,"Registrado Correctamente",Toast.LENGTH_LONG).show();
            Intent salir = new Intent(this,Builds.class);
            startActivity(salir);
        } else {
            Toast.makeText(this,"Faltan campos por rellenar",Toast.LENGTH_LONG).show();
        }

         */
    }
}