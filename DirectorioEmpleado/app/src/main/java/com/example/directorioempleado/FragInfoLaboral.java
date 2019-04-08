package com.example.directorioempleado;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragInfoLaboral extends Fragment {
    View view;
    private int id;
    private DAOEmpleado dao;

    private TextView txv_laboral_id;
    private TextView txv_laboral_nombre;
    private TextView txv_laboral_apellido;
    private TextView txv_nomina;
    private TextView txv_area;
    private TextView txv_puesto;
    private TextView txv_curp;
    private TextView txv_nss;
    private TextView txv_contacto_emergencia;
    private TextView txv_escolaridad;
    private TextView txv_status;

    public FragInfoLaboral() {
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
        view = inflater.inflate(R.layout.fragment_info_laboral, container, false);

        txv_laboral_id = (TextView) view.findViewById(R.id.txv_laboral_id);
        txv_laboral_nombre = (TextView) view.findViewById(R.id.txv_laboral_nombre);
        txv_laboral_apellido = (TextView) view.findViewById(R.id.txv_laboral_apellido);
        txv_nomina = (TextView) view.findViewById(R.id.txv_nomina);
        txv_area = (TextView) view.findViewById(R.id.txv_area);
        txv_puesto = (TextView) view.findViewById(R.id.txv_puesto);
        txv_curp = (TextView) view.findViewById(R.id.txv_curp);
        txv_nss = (TextView) view.findViewById(R.id.txv_nss);
        txv_contacto_emergencia = (TextView) view.findViewById(R.id.txv_contacto_emergencia);
        txv_escolaridad = (TextView) view.findViewById(R.id.txv_escolaridad);
        txv_status = (TextView) view.findViewById(R.id.txv_status);

        Empleado empleado = dao.obtenerDatosLaborales(id);

        txv_laboral_id.setText(String.valueOf(empleado.getId()));
        txv_laboral_nombre.setText(empleado.getNombre());
        txv_laboral_apellido.setText(empleado.getApellido());
        txv_nomina.setText(String.valueOf(empleado.getNumNomnina()));
        txv_area.setText(empleado.getArea());
        txv_puesto.setText(empleado.getPuesto());
        txv_curp.setText(empleado.getCurp());
        txv_nss.setText(empleado.getNss());
        txv_contacto_emergencia.setText(empleado.getContEmergencia());
        txv_escolaridad.setText(empleado.getEscolaridad());
        txv_status.setText(empleado.getStatus());

        return view;
    }

}
