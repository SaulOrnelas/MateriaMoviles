package com.example.saul.acceso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inp_numero;
    private Button btn_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inp_numero = (EditText) findViewById(R.id.inp_numero);
        inp_numero.setText("12345");

    }

    public void boton_presionado(View view){
        String texto = inp_numero.getText().toString();
        Toast toast = Toast.makeText(
                getApplicationContext(),
                texto,
                Toast.LENGTH_LONG);
        toast.show();
    }

}
