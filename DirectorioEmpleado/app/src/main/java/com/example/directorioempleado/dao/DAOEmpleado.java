package com.example.directorioempleado.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.directorioempleado.model.Empleado;

import java.util.ArrayList;

public class DAOEmpleado {

    SQLiteDatabase cx;
    ArrayList<Empleado> lista;
    Empleado empleado;
    Context context;
    String nombreBD = "BDEmpledo";
    String tabla = "create table if not exists empleado(id integer primary key autoincrement, nombre text, " +
            "apellido text, nacimiento text, telefono text, correo text, direccion text, numNomina integer, " +
            "area text, puesto text, estadoCivil text, curp text, nss text, cronicas text, " +
            "contEmergencia text, rutaFoto text, escolaridad text, nacionalidad text, status text)";

    public DAOEmpleado(Context context){
        this.context = context;
        cx = context.openOrCreateDatabase(nombreBD,Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(tabla);
    }

    public boolean insertar(Empleado e){
        return true;
    }

    public boolean eliminar(int id){
        return true;
    }

    public boolean editar(Empleado e){
        return true;
    }
    public ArrayList<Empleado> verTodos(){
        return lista;
    }
    public Empleado obtenerEmpleado(int id){
        return empleado;
    }
}
