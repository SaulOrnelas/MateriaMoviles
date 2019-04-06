package com.example.directorioempleado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.directorioempleado.adapters.AdapterEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterEmpleado adapter;
    private Button btn_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_agregar = (Button) findViewById(R.id.btn_agregar);


        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado(1, "Saul", "Ornelas"));

        recyclerView = (RecyclerView) findViewById(R.id.rv_lista_empleado);

        adapter = new AdapterEmpleado(this,empleados);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false));
    }
    public void agregar (View view){
        Intent intent = new Intent(this, DatosEmpleado.class);
        //Intent intent = new Intent(this, InfoPersonal.class);
        startActivity(intent);
    }
}
