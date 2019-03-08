package com.myapp.mdm.crudconsqllite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.myapp.mdm.crudconsqllite.entidades.Estudiante;
import com.myapp.mdm.crudconsqllite.utilidades.utilidades;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView rvEstudiante;
    public static ArrayList<Estudiante> estudiantes;
    ConexionSQL con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = new ConexionSQL(this, "bd_Escuela", null, 1);
        estudiantes = new ArrayList<>();
        ConsultarEstudiantes();
        this.fab = findViewById(R.id.floBtnIngresar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Registro_Activity.class
                );startActivity(intent);            }        });
        this.Cargar();
    }
    private void ConsultarEstudiantes() {
        SQLiteDatabase db = con.getReadableDatabase();
        Estudiante estudiante = null;
        estudiantes = new ArrayList<Estudiante>();
        Cursor cursor = db.rawQuery("Select * from " + utilidades.TABLA_ESTUDIANTE, null);
        while (cursor.moveToNext()) {

            estudiante = new Estudiante();
            estudiante.setNombre(cursor.getString(0));
            estudiante.setApPaterno(cursor.getString(1));
            estudiante.setApMaterno(cursor.getString(2));
            estudiante.setNumeroMovil(cursor.getString(3));
            estudiantes.add(estudiante);
        }
    }
    public void Cargar() {
        this.rvEstudiante = findViewById(R.id.rvEstudi);
        this.rvEstudiante.setHasFixedSize(true);
        this.rvEstudiante.setLayoutManager
                (new LinearLayoutManager(getApplicationContext()));
        this.rvEstudiante.setAdapter
                (new EstudiantesAdapter(this.estudiantes, this));
    }
    @Override
    protected void onResume() {
        super.onResume();
        this.ConsultarEstudiantes();
        this.Cargar();
    }


}

