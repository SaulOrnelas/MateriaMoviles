package com.example.saul.registropersonas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    private ArrayList<Persona> lista_personas;

    private EditText edt_nombre;
    private EditText edt_apellido_paterno;
    private EditText edt_apellido_materno;
    private EditText edt_edad;

    private Intent main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edt_nombre = (EditText)  findViewById(R.id.edt_nombre);
        edt_apellido_paterno = (EditText)  findViewById(R.id.edt_apellido_paterno);
        edt_apellido_materno = (EditText)  findViewById(R.id.edt_apellido_materno);
        edt_edad = (EditText)  findViewById(R.id.edt_edad);

        main = new Intent(this, MainActivity.class);

        if(getIntent().hasExtra("lista_personas")){
            this.lista_personas = (ArrayList<Persona>)getIntent().getExtras().getSerializable("lista_personas") ;
        }
    }

    public void guardar(View view){
        if(!this.validar_vacios()){
            Toast.makeText(this,"Debes ingresar todos los campos",Toast.LENGTH_LONG).show();
        } else {
            lista_personas.add(new Persona(
                    edt_nombre.getText().toString().trim(),
                    edt_apellido_paterno.getText().toString().trim(),
                    edt_apellido_materno.getText().toString().trim(),
                    Integer.valueOf(edt_edad.getText().toString().trim()))
            );
            main.putExtra("lista_personas",this.lista_personas);
            startActivity(main);
        }
    }
    public void cancelar(View view){
        main.putExtra("lista_personas", this.lista_personas);
        startActivity(main);
    }
    private boolean validar_vacios(){
        return (edt_nombre.getText().toString().trim().length() > 0 &&
                edt_apellido_paterno.getText().toString().trim().length() > 0 &&
                edt_apellido_materno.getText().toString().trim().length() > 0 &&
                edt_edad.getText().toString().trim().length() > 0);
    }

}
