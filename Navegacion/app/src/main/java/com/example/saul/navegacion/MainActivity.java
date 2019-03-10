package com.example.saul.navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    Alumno alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alumno = new  Alumno("saulini","Ornelas");
    }
    public void activity2(View view){
        Intent intent = new Intent(this, activity2.class);
        intent.putExtra("nombre", "Saul");
        //                              Serializable
        intent.putExtra("nombre", alumno.getNombre());
        startActivity(intent);


    }
    /*public class Alumno(String nombre){
        String name = nombre;
    }*/
}
