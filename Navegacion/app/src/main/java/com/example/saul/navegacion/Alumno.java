package com.example.saul.navegacion;

import java.io.Serializable;

public class Alumno implements Serializable {
    String nombre;
    String apellido;

    public Alumno(String nombre, String apellido){
        this.nombre= nombre;
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
