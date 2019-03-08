package com.myapp.mdm.crudconsqllite.utilidades;

public class utilidades {
    //contantes estudiantes
    public static final String TABLA_ESTUDIANTE = "Estudiante";

    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APPATERNO = "appaterno";
    public static final String CAMPO_APMATERNO = "apmaterno";
    public static final String CAMPO_NUMEROMOVIL = "numeromovil";


    public static final String Crear_Tabla_Estudiante = " create table" + " " +
            TABLA_ESTUDIANTE +
            " (" +CAMPO_NOMBRE + " " + " text," +
            CAMPO_APPATERNO + " text,"
            + CAMPO_APMATERNO + " text," +
            CAMPO_NUMEROMOVIL + " text)";


}
