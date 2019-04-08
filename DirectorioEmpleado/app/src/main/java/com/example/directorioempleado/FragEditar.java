package com.example.directorioempleado;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragEditar extends Fragment {

    View view;
    private int id;
    private DAOEmpleado dao;
    ListView opciones;

    private EditText edt_edit_id;
    private EditText edt_edit_nombre;
    private EditText edt_edit_apellido;
    private EditText edt_edit_nacimiento;
    private EditText edt_edit_telefono;
    private EditText edt_edit_correo;
    private EditText edt_edit_direccion;
    private EditText edt_edit_nomina;
    private EditText edt_edit_area;
    private EditText edt_edit_puesto;
    private EditText edt_edit_estado_civil;
    private EditText edt_edit_curp;
    private EditText edt_edit_nss;
    private EditText edt_edit_cronicas;
    private EditText edt_edit_contacto_emergencia;
    private EditText edt_edit_escolaridad;
    private EditText edt_edit_nacionalidad;
    private EditText edt_edit_status;
    private Button btn_editar;

    public FragEditar() {
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
        view = inflater.inflate(R.layout.fragment_editar, container, false);



        edt_edit_id = (EditText) view.findViewById(R.id.edt_edit_id);
        edt_edit_nombre = (EditText) view.findViewById(R.id.edt_edit_nombre);
        edt_edit_apellido = (EditText) view.findViewById(R.id.edt_edit_apellido);
        edt_edit_nacimiento = (EditText) view.findViewById(R.id.edt_edit_nacimiento);
        edt_edit_telefono = (EditText) view.findViewById(R.id.edt_edit_telefono);
        edt_edit_correo = (EditText) view.findViewById(R.id.edt_edit_correo);
        edt_edit_direccion = (EditText) view.findViewById(R.id.edt_edit_direccion);
        edt_edit_nomina = (EditText) view.findViewById(R.id.edt_edit_nomina);
        edt_edit_area = (EditText) view.findViewById(R.id.edt_edit_area);
        edt_edit_puesto = (EditText) view.findViewById(R.id.edt_edit_puesto);
        edt_edit_estado_civil = (EditText) view.findViewById(R.id.edt_edit_estado_civil);
        edt_edit_curp = (EditText) view.findViewById(R.id.edt_edit_curp);
        edt_edit_nss = (EditText) view.findViewById(R.id.edt_edit_nss);
        edt_edit_cronicas = (EditText) view.findViewById(R.id.edt_edit_cronicas);
        edt_edit_contacto_emergencia = (EditText) view.findViewById(R.id.edt_edit_contacto_emergencia);
        edt_edit_escolaridad = (EditText) view.findViewById(R.id.edt_edit_escolaridad);
        edt_edit_nacionalidad = (EditText) view.findViewById(R.id.edt_edit_nacionalidad);
        edt_edit_status = (EditText) view.findViewById(R.id.edt_edit_status);
        btn_editar = (Button) view.findViewById(R.id.btn_editar);

        Empleado empleado = dao.obtenerEmpleado(id);

        edt_edit_id.setText(String.valueOf(empleado.getId()));
        edt_edit_nombre.setText(empleado.getNombre());
        edt_edit_apellido.setText(empleado.getApellido());
        edt_edit_nacimiento.setText(empleado.getNacimiento());
        edt_edit_telefono.setText(empleado.getTelefono());
        edt_edit_correo.setText(empleado.getCorreo());
        edt_edit_direccion.setText(empleado.getDireccion());
        edt_edit_nomina.setText(String.valueOf(empleado.getNumNomnina()));
        edt_edit_area.setText(empleado.getArea());
        edt_edit_puesto.setText(empleado.getPuesto());
        edt_edit_estado_civil.setText(empleado.getEstadoCivil());
        edt_edit_curp.setText(empleado.getCurp());
        edt_edit_nss.setText(empleado.getNss());
        edt_edit_cronicas.setText(empleado.getCronicas());
        edt_edit_contacto_emergencia.setText(empleado.getContEmergencia());
        edt_edit_escolaridad.setText(empleado.getEscolaridad());
        edt_edit_nacionalidad.setText(empleado.getNacionalidad());
        edt_edit_status.setText(empleado.getStatus());

        btn_editar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    Empleado empleado = new Empleado(
                            Integer.parseInt(edt_edit_id.getText().toString()),
                            edt_edit_nombre.getText().toString(),
                            edt_edit_apellido.getText().toString(),
                            edt_edit_nacimiento.getText().toString(),
                            edt_edit_telefono.getText().toString(),
                            edt_edit_correo.getText().toString(),
                            edt_edit_direccion.getText().toString(),
                            Integer.parseInt(edt_edit_nomina.getText().toString()),
                            edt_edit_area.getText().toString(),
                            edt_edit_puesto.getText().toString(),
                            edt_edit_estado_civil.getText().toString(),
                            edt_edit_curp.getText().toString(),
                            edt_edit_nss.getText().toString(),
                            edt_edit_cronicas.getText().toString(),
                            edt_edit_contacto_emergencia.getText().toString(),
                            "Ruta de foto",
                            edt_edit_escolaridad.getText().toString(),
                            edt_edit_nacionalidad.getText().toString(),
                            edt_edit_status.getText().toString());
                    dao.editar(empleado);

                    Toast.makeText(getActivity().getApplicationContext(),"Actualización correcta",Toast.LENGTH_SHORT);

                }catch (Exception e){

                    Toast.makeText(getActivity().getApplicationContext(),"Error al actualizar",Toast.LENGTH_SHORT);
                }
            }
        });

        return view;
    }

    public void editar (View view){

    }

}
