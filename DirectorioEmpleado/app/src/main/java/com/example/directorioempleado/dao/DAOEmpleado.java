package com.example.directorioempleado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.directorioempleado.model.Empleado;

import java.util.ArrayList;

public class DAOEmpleado {

    SQLiteDatabase cx;
    ArrayList<Empleado> lista = new ArrayList<Empleado>();
    Empleado empleado;
    Context context;
    String nombreBD = "BDEmpledo";
    String tabla = "create table if not exists empleado(id integer primary key autoincrement, nombre text, " +
            "apellido text, nacimiento text, telefono text, correo text, direccion text, numNomina integer, " +
            "area text, puesto text, estadoCivil text, curp text, nss text, cronicas text, " +
            "contEmergencia text, rutaFoto text, escolaridad text, nacionalidad text, status text)";

    public DAOEmpleado(Context context){
        this.context = context;
        cx = context.openOrCreateDatabase(nombreBD,Context.MODE_PRIVATE, null);
        cx.execSQL(tabla);
    }

    public boolean insertar(Empleado e) {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",e.getNombre());
        contenedor.put("apellido", e.getApellido());
        contenedor.put("nacimiento", e.getNacimiento());
        contenedor.put("telefono", e.getTelefono());
        contenedor.put("correo",e.getCorreo());
        contenedor.put("direccion", e.getDireccion());
        contenedor.put("numNomina", e.getNumNomnina());
        contenedor.put("area", e.getArea());
        contenedor.put("puesto", e.getPuesto());
        contenedor.put("estadoCivil", e.getEstadoCivil());
        contenedor.put("curp", e.getCurp());
        contenedor.put("nss", e.getNss());
        contenedor.put("cronicas", e.getCronicas());
        contenedor.put("contEmergencia", e.getContEmergencia());
        contenedor.put("rutaFoto", e.getRutaFoto());
        contenedor.put("escolaridad", e.getEscolaridad());
        contenedor.put("nacionalidad", e.getNacionalidad());
        contenedor.put("status", e.getStatus());

        return (cx.insert("empleado",null , contenedor))>0;

    }

    public boolean eliminar(int id){
        return true;
    }

    public boolean editar(Empleado e){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",e.getNombre());
        contenedor.put("apellido", e.getApellido());
        contenedor.put("nacimiento", e.getNacimiento());
        contenedor.put("telefono", e.getTelefono());
        contenedor.put("correo",e.getCorreo());
        contenedor.put("direccion", e.getDireccion());
        contenedor.put("numNomina", e.getNumNomnina());
        contenedor.put("area", e.getArea());
        contenedor.put("puesto", e.getPuesto());
        contenedor.put("estadoCivil", e.getEstadoCivil());
        contenedor.put("curp", e.getCurp());
        contenedor.put("nss", e.getNss());
        contenedor.put("cronicas", e.getCronicas());
        contenedor.put("contEmergencia", e.getContEmergencia());
        contenedor.put("rutaFoto", e.getRutaFoto());
        contenedor.put("escolaridad", e.getEscolaridad());
        contenedor.put("nacionalidad", e.getNacionalidad());
        contenedor.put("status", e.getStatus());

        return (cx.update("empleado",contenedor , "id="+e.getId(),null))>0;
    }

    public ArrayList<Empleado> verTodos() {
        Cursor cursor = cx.rawQuery("select id, nombre, apellido from empleado", null);
        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                lista.add(new Empleado(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public ArrayList<Empleado> buscar(String nombre) {
        Cursor cursor = cx.rawQuery("select id, nombre, apellido from empleado where nombre like '%"+nombre+"%'", null);
        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                lista.add(new Empleado(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public Empleado obtenerEmpleado(int id){
        Cursor cursor = cx.rawQuery("select * from empleado where id = "+id, null);
        cursor.moveToFirst();
        empleado = new Empleado(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getInt(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                cursor.getString(15),
                cursor.getString(16),
                cursor.getString(17),
                cursor.getString(18));
        return empleado;
    }

    public Empleado obtenerDatosPersonales(int id){

        Cursor cursor = cx.rawQuery("select id, nombre, apellido, nacimiento, telefono, correo, " +
                "direccion, estadoCivil, cronicas, rutaFoto, nacionalidad from empleado where id = "+ id, null);
        cursor.moveToFirst();
        empleado = new Empleado(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10));

        return empleado;
    }

    public Empleado obtenerDatosLaborales(int id) {
        Cursor cursor = cx.rawQuery("select id, nombre, apellido, numNomina, area, puesto, curp, " +
                "nss, contEmergencia, escolaridad, status from empleado where id = "+ id, null);
        cursor.moveToFirst();
        empleado = new Empleado(cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10));

        return empleado;
    }


}
