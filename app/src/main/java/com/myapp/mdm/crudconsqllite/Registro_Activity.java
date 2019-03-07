package com.myapp.mdm.crudconsqllite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.mdm.crudconsqllite.utilidades.utilidades;

public class Registro_Activity extends AppCompatActivity {
    EditText nombre, app, apm, movil;
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_);
        nombre = findViewById(R.id.etNombr);
        app = findViewById(R.id.etapPaterno);
        apm = findViewById(R.id.etApMaterno);
        movil = findViewById(R.id.etMovil);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegitrarEstudiantes();
            }
        });
    }
    ConexionSQL con = new ConexionSQL(this, "bd_Escuela", null, 1);
    private void  RegitrarEstudiantes(){
        SQLiteDatabase db=con.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_NOMBRE,nombre.getText().toString());
        values.put(utilidades.CAMPO_APPATERNO,app.getText().toString());
        values.put(utilidades.CAMPO_APMATERNO,apm.getText().toString());
        values.put(utilidades.CAMPO_NUMEROMOVIL,movil.getText().toString());
        Long idResultante=db.insert(utilidades.TABLA_ESTUDIANTE,utilidades.CAMPO_NOMBRE,values);
        Toast.makeText(this, "Registrado"+ idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
