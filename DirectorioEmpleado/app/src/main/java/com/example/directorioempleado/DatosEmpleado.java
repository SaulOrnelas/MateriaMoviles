package com.example.directorioempleado;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.directorioempleado.dao.DAOEmpleado;

public class DatosEmpleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_empleado);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",1);

        //Recibir el id que se manda desde el adapter
        final Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        BottomNavigationView bottomBar = findViewById(R.id.bottombar);

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragmentSeleccionado = null;

                switch (menuItem.getItemId()){
                    case R.id.item_personal:
                        fragmentSeleccionado = new FragInfoPersonal();
                        fragmentSeleccionado.setArguments(bundle);
                        break;
                    case R.id.item_laboral:
                        fragmentSeleccionado = new FragInfoLaboral();
                        fragmentSeleccionado.setArguments(bundle);
                        break;
                    case R.id.item_editar:
                        fragmentSeleccionado = new FragEditar();
                        fragmentSeleccionado.setArguments(bundle);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();
                return true;
            }
        });
        //Primer fragment que iniciara al seleccionar el empleado
        Fragment fragmentPrincipal = new FragInfoPersonal();
        fragmentPrincipal.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentPrincipal).commit();
    }
}
