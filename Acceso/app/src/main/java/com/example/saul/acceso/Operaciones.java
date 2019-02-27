package com.example.saul.acceso;

public class Operaciones {

    public int [] separarCadena(String cadena){
        /*Creación de arreglo que contendrá los números necesarios para hacer
        el subneteo*/
        int [] datosSub = new int[5];
        //Arreglo que guardará la red y la máscara
        String [] mascara = cadena.split("/");
        //Arreglo que guardará en distintas posiciones los octetos de la red
        String [] octetos = mascara[0].split("[.]");
        //Ciclo que convierte los octetos de tipo String a int
        for (int i = 0; i < octetos.length; i++) {
            datosSub[i] = Integer.parseInt(octetos[i]);
        }
        //Guardar la máscara en la última posición del arreglo
        datosSub[4] = Integer.parseInt(mascara[1]);
        //Regresar el arreglo entero
        return datosSub;
    }
}
