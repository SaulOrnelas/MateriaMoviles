package com.example.saul.registroalumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarAlumno extends AppCompatActivity {

    private EditText etxApellido;
    private EditText edtApellido, edtNombre, edtCarrera, edtSemestre;
    private Button btnAgregar;
    Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_alumno);

        btnAgregar = (Button) findViewById(R.id.btnAdd);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtCarrera = (EditText) findViewById(R.id.edtCarrera);
        edtSemestre = (EditText) findViewById(R.id.edtSemestre);
/*
        Bundle objAlumno = getIntent().getExtras();
        Alumno alumno= null;
        if (objAlumno!=null){
            alumno = (Alumno) objAlumno.getSerializable("alumno");
        }
        String datos = alumno.getApellido() + " " + alumno.getNombre();
        Toast.makeText(this, datos, Toast.LENGTH_LONG).show();*/
    }
    public void añadirAlumno(View v){
        String apellido = edtApellido.getText().toString();
        String nombre = edtNombre.getText().toString();
        String carrera = edtCarrera.getText().toString();
        String semestre = edtSemestre.getText().toString();

        alumno = new Alumno(apellido, nombre, carrera, semestre);

        Intent intent = new Intent (this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("alumno",alumno);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
