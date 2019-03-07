package com.myapp.mdm.crudconsqllite.entidades;

public class Estudiante {
    private String Nombre;
    private String ApPaterno;
    private String ApMaterno;
    private String NumeroMovil;


    public Estudiante() {
    }

    public Estudiante(String nombre, String apPaterno, String apMaterno, String numeroMovil) {
        this.Nombre = nombre;
        this.ApPaterno = apPaterno;
        this.ApMaterno = apMaterno;
        this.NumeroMovil = numeroMovil;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApPaterno() {
        return ApPaterno;
    }

    public void setApPaterno(String apPaterno) {
        ApPaterno = apPaterno;
    }

    public String getApMaterno() {
        return ApMaterno;
    }

    public void setApMaterno(String apMaterno) {
        ApMaterno = apMaterno;
    }

    public String getNumeroMovil() {
        return NumeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        NumeroMovil = numeroMovil;
    }

}
