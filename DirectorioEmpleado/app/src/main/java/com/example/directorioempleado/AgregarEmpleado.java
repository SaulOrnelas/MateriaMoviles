package com.example.directorioempleado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.util.List;

public class AgregarEmpleado extends AppCompatActivity {

    Empleado empleado;
    DAOEmpleado dao;
    List<Empleado> lista;
    private EditText edt_add_nombre;
    private EditText edt_add_apellido;
    private EditText edt_add_nacimiento;
    private EditText edt_add_telefono;
    private EditText edt_add_correo;
    private EditText edt_add_direccion;
    private EditText edt_add_nomina;
    private EditText edt_add_area;
    private EditText edt_add_puesto;
    private EditText edt_add_estado_civil;
    private EditText edt_add_curp;
    private EditText edt_add_nss;
    private EditText edt_add_cronicas;
    private EditText edt_add_contacto_emergencia;
    private EditText edt_add_escolaridad;
    private EditText edt_add_nacionalidad;
    private EditText edt_add_status;
    private Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_empleado);

        dao = new DAOEmpleado(AgregarEmpleado.this);
        edt_add_nombre = (EditText) findViewById(R.id.edt_add_nombre);
        edt_add_apellido = (EditText) findViewById(R.id.edt_add_apellido);
        edt_add_nacimiento = (EditText) findViewById(R.id.edt_add_nacimiento);
        edt_add_telefono = (EditText) findViewById(R.id.edt_add_telefono);
        edt_add_correo = (EditText) findViewById(R.id.edt_add_correo);
        edt_add_direccion = (EditText) findViewById(R.id.edt_add_direccion);
        edt_add_nomina = (EditText) findViewById(R.id.edt_add_nomina);
        edt_add_area = (EditText) findViewById(R.id.edt_add_area);
        edt_add_puesto = (EditText) findViewById(R.id.edt_add_puesto);
        edt_add_estado_civil = (EditText) findViewById(R.id.edt_add_estado_civil);
        edt_add_curp = (EditText) findViewById(R.id.edt_add_curp);
        edt_add_nss = (EditText) findViewById(R.id.edt_add_nss);
        edt_add_cronicas = (EditText) findViewById(R.id.edt_add_cronicas);
        edt_add_contacto_emergencia = (EditText) findViewById(R.id.edt_add_contacto_emergencia);
        edt_add_escolaridad = (EditText) findViewById(R.id.edt_add_escolaridad);
        edt_add_nacionalidad = (EditText) findViewById(R.id.edt_add_nacionalidad);
        edt_add_status = (EditText) findViewById(R.id.edt_add_status);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);
    }

    public void agregar(View view){

        try{
            empleado = new Empleado(edt_add_nombre.getText().toString(),
                    edt_add_apellido.getText().toString(),
                    edt_add_nacimiento.getText().toString(),
                    edt_add_telefono.getText().toString(),
                    edt_add_correo.getText().toString(),
                    edt_add_direccion.getText().toString(),
                    Integer.parseInt(edt_add_nomina.getText().toString()),
                    edt_add_area.getText().toString(),
                    edt_add_puesto.getText().toString(),
                    edt_add_estado_civil.getText().toString(),
                    edt_add_curp.getText().toString(),
                    edt_add_nss.getText().toString(),
                    edt_add_cronicas.getText().toString(),
                    edt_add_contacto_emergencia.getText().toString(),
                    "Ruta de foto",
                    edt_add_escolaridad.getText().toString(),
                    edt_add_nacionalidad.getText().toString(),
                    edt_add_status.getText().toString());
            dao.insertar(empleado);


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(),"Error", Toast.LENGTH_SHORT).show();
        }
    }
}
