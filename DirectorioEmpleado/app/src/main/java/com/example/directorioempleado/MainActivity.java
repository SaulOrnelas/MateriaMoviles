package com.example.directorioempleado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.directorioempleado.adapters.AdapterEmpleado;
import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterEmpleado adapter;
    private EditText edt_buscar;
    ArrayList<Empleado> empleados;
    DAOEmpleado dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao= new DAOEmpleado(MainActivity.this);
        edt_buscar = (EditText) findViewById(R.id.edt_buscar);

        //ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        empleados = dao.verTodos();

        //empleados.add(new Empleado(4, "Saul", "Ornelas"));
        //empleados.add(new Empleado(1, "Luis", "Ornelas"));
        //empleados.add(new Empleado(2, "Saul", "Ornelas"));

        recyclerView = (RecyclerView) findViewById(R.id.rv_lista_empleado);

        adapter = new AdapterEmpleado(this,empleados);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
    }
    public void agregarEmpleado (View view){
        Intent intent = new Intent(this, AgregarEmpleado.class);
        //Intent intent = new Intent(this, InfoPersonal.class);
        startActivity(intent);
    }
    public void buscar (View view){
        empleados = dao.buscar(edt_buscar.getText().toString());

        //Log.e("Empleados", "" +empleados.size());

        recyclerView = (RecyclerView) findViewById(R.id.rv_lista_empleado);

        adapter = new AdapterEmpleado(this,empleados);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
    }

    public void recargar (View view){
        empleados = dao.verTodos();

        recyclerView = (RecyclerView) findViewById(R.id.rv_lista_empleado);

        adapter = new AdapterEmpleado(this,empleados);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
    }
}
