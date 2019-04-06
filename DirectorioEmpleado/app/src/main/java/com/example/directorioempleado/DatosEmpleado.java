package com.example.directorioempleado;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class DatosEmpleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_empleado);

        BottomNavigationView bottomBar = findViewById(R.id.bottombar);

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragmentSeleccionado = new FragInfoPersonal();

                switch (menuItem.getItemId()){
                    case R.id.item_personal:
                        fragmentSeleccionado = new FragInfoPersonal();
                        break;
                    case R.id.item_laboral:
                        fragmentSeleccionado = new FragInfoLaboral();

                        break;
                    case R.id.item_editar:
                        fragmentSeleccionado = new FragEditar();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();
                return true;
            }
        });
    }
}
