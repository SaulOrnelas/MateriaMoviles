package com.example.saul.registroalumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Alumno alumno;
    TextView txvAlumnos;
    String allStundents = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvAlumnos = (TextView) findViewById(R.id.txvAlumnos);

        agregarAlumno();
        //alumno = new  Alumno("saulini","Ornelas");
    }
    /*
    public void activity2(View view){
        Intent intent = new Intent(this, activity2.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("alumno",alumno);
        intent.putExtras(bundle);
        //intent.putExtra("nombre", "Saul");
        //                              Serializable
        //intent.putExtra("nombre", alumno.getNombre());
        startActivity(intent);

    }*/

    public void agregarAlumno(){
        Bundle objAlumno = getIntent().getExtras();
        Alumno alumno= null;
        if (objAlumno!=null){
            alumno = (Alumno) objAlumno.getSerializable("alumno");
            String apellido = alumno.getApellido();
            String nombre = alumno.getNombre();
            String carrera = alumno.getCarrera();
            String semestre = alumno.getSemestre();
            allStundents = allStundents + apellido + " " + nombre + " " + carrera + " " + semestre + "\n";
            txvAlumnos.setText(allStundents);
        }
        //String datos = alumno.getApellido() + " " + alumno.getNombre();
    }

    public void irAFormulario(View view){
        Intent intent = new Intent (this,InsertarAlumno.class);
        intent.putExtra("nombre", "Saul");
        startActivity(intent);
    }
}
