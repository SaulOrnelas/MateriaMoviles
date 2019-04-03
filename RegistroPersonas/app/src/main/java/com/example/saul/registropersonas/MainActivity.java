package com.example.saul.registropersonas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txvListaPersonas;
    private ArrayList<Persona> lista_personas;
    @Override
    /**
     * @author Luis Saul Ornelas Pérez
     * @version RegistroPersonas 1.3 (Viernes, 22 de Marzo)
     * @param Bundle
     * @return void
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvListaPersonas = (TextView) findViewById(R.id.txvListaPersonas);
        lista_personas = new ArrayList<>();

        if ( getIntent().hasExtra("lista_personas")){
            lista_personas = (ArrayList<Persona>)getIntent().getExtras().getSerializable("lista_personas");
        }
        this.muestra_personas();
    }
    /**
     * Método que sirve para abrir otra vista, agregando una lista de personas
     * @author Luis Saul Ornelas Pérez
     * @version RegistroPersonas 1.3 (Viernes, 22 de Marzo)
     * @param view, vista a la cual se desea abrir
     * @return void
     *
     */
    public void agregar(View view){
        Intent registro = new Intent(this,Registro.class);
        registro.putExtra("lista_personas", this.lista_personas);
        startActivity(registro);

    }

    /**
     * @author Luis Saul Ornelas Pérez
     * @version RegistroPersonas 1.3 (Viernes, 22 de Marzo)
     * @return void
     * Método que regresa la lista de personas, la lista esta hecha con el objeto de Persona
     */

    private void muestra_personas(){
        if (this.lista_personas.isEmpty()) {
            txvListaPersonas.setText("No hay personas registradas");
        }else {
            String listaPersona = "";
            for (Persona persona_temp : this.lista_personas) {
                listaPersona +=
                        persona_temp.getNombre() + " " +
                                persona_temp.getApellidoP() + " " +
                                persona_temp.getApellidoM() + " " +
                                persona_temp.getEdad() + " " +
                                "\n                               \n";
            }
            txvListaPersonas.setText(listaPersona);
        }
    }
/*
    public void buscar(View view){
        if (this.lista_personas.isEmpty()) {

            Toast.makeText(this,"No hay elementos en la lista", Toast.LENGTH_LONG).show();
        }else{
            String encontrados = this.filtrar_personas;
            if(encontrados.length() > 0){
                txvListaPersonas.setText(encontrados);
            }else {
                Toast.makeText(this, "No se encontraron coincidencias", Toast.LENGTH_LONG).show();
            }
        }
    }*/
}
