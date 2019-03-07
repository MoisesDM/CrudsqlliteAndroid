package com.myapp.mdm.crudconsqllite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.myapp.mdm.crudconsqllite.utilidades.utilidades;

public class ConexionSQL extends SQLiteOpenHelper {

    public ConexionSQL(Context context,
                        String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(utilidades.Crear_Tabla_Estudiante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists Estudiante");
        onCreate(db);
    }
}
