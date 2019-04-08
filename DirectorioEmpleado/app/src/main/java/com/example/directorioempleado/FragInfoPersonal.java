package com.example.directorioempleado;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.util.ArrayList;

public class FragInfoPersonal extends Fragment {

    View view;
    private int id;
    private DAOEmpleado dao;

    private TextView txv_id;
    private TextView txv_nombre;
    private TextView txv_apellido;
    private TextView txv_nacimiento;
    private TextView txv_telefono;
    private TextView txv_correo;
    private TextView txv_direccion;
    private TextView txv_estado_civil;
    private TextView txv_cronicas;
    //Ruta foto
    private TextView txv_nacionalidad;


    public FragInfoPersonal() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dao = new DAOEmpleado(getActivity().getApplicationContext());

        if(getArguments() != null){
            id = getArguments().getInt("id",0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_info_personal, container, false);

        txv_id = (TextView) view.findViewById(R.id.txv_id);
        txv_nombre = (TextView) view.findViewById(R.id.txv_nombre);
        txv_apellido = (TextView) view.findViewById(R.id.txv_apellido);
        txv_nacimiento = (TextView) view.findViewById(R.id.txv_nacimiento);
        txv_telefono = (TextView) view.findViewById(R.id.txv_telefono);
        txv_correo = (TextView) view.findViewById(R.id.txv_correo);
        txv_direccion = (TextView) view.findViewById(R.id.txv_direccion);
        txv_estado_civil = (TextView) view.findViewById(R.id.txv_estado_civil);
        txv_cronicas = (TextView) view.findViewById(R.id.txv_cronicas);
        txv_nacionalidad = (TextView) view.findViewById(R.id.txv_nacionalidad);

        Empleado empleado = dao.obtenerDatosPersonales(id);

        txv_id.setText(String.valueOf(empleado.getId()));
        txv_nombre.setText(empleado.getNombre());
        txv_apellido.setText(empleado.getApellido());
        txv_nacimiento.setText(empleado.getNacimiento());
        txv_telefono.setText(empleado.getTelefono());
        txv_correo.setText(empleado.getCorreo());
        txv_direccion.setText(empleado.getDireccion());
        txv_estado_civil.setText(empleado.getEstadoCivil());
        txv_cronicas.setText(empleado.getCronicas());
        txv_nacionalidad.setText(empleado.getNacionalidad());
        return view;


    }
}
