package com.example.saul.registroalumnos;

import java.io.Serializable;

public class Alumno implements Serializable {

    String apellido;
    String nombre;
    String carrera;
    String semestre;

    public Alumno(String apellido, String nombre, String carrera, String semestre){

        this.apellido = apellido;
        this.nombre= nombre;
        this.carrera = carrera;
        this.semestre = semestre;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
