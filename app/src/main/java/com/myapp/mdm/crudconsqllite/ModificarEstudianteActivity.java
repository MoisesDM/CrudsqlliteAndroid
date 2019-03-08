package com.myapp.mdm.crudconsqllite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.mdm.crudconsqllite.utilidades.utilidades;

public class ModificarEstudianteActivity extends AppCompatActivity {
    TextView nombre,app,apm,movil;
    public static int position;
    Button btnmodificar,btnCancelar ;
    ConexionSQL con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_estudiante);
        nombre=findViewById(R.id.etNombre);
        app=findViewById(R.id.etapPaterno);
        apm=findViewById(R.id.etApMaterno);
        movil=findViewById(R.id.etMovil);
        btnmodificar=findViewById(R.id.btnModificar);
        btnCancelar=findViewById(R.id.btnCancelar1);
        Intent intent = getIntent();
        this.nombre.setText(intent.getExtras().getString("nombre"));
        this.app.setText(intent.getExtras().getString("app"));
        this.apm.setText(intent.getExtras().getString("apm"));
        this.movil.setText(intent.getExtras().getString("Movil"));

        con = new ConexionSQL(this, "bd_Escuela", null, 1);




        btnmodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=con.getWritableDatabase();
                String[] parametros={nombre.getText().toString()};
                ContentValues values=new ContentValues();
                values.put(utilidades.CAMPO_APPATERNO,app.getText().toString());
                values.put(utilidades.CAMPO_APMATERNO,apm.getText().toString());
                values.put(utilidades.CAMPO_NUMEROMOVIL,movil.getText().toString());
                db.update(utilidades.TABLA_ESTUDIANTE,values,utilidades.CAMPO_NOMBRE+"=?",parametros);
                Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
                db.close();

                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);

            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                       MainActivity.class
                );
                startActivity(intent);
            }
        });
    }
}
