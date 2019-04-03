package com.example.saul.registropersonas;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;

    /**
     * @author Luis Saul Ornelas Pérez
     * @version RegistroPersonas 1.3 (Viernes, 22 de Marzo)
     * @param Persona(String, String, String int)
     * @return getNombre(), setNombre(String), getApellido(), setApellidoP(String), getApellidoM(),
     * setApellidoM(String), getEdad(), setEdad(int)
     */
    public Persona(String nombre, String apellidoP, String apellidoM, int edad) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
    }

    /**
     * @author Luis Saul Ornelas Pérez
     * @version RegistroPersonas 1.3 (Viernes, 22 de Marzo)
     * @return getNombre(), setNombre(String), getApellido(), setApellidoP(String), getApellidoM(),
     * setApellidoM(String), getEdad(), setEdad(int)
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
