package com.example.saul.pruebadebug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int numero_1;
    private int numero_2;
    private int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_1= 1;
        numero_2 = 2;
        //resultado = numero_1 + numero_2;
        factorial();
    }
    //
    public void factorial(){
        for (int i = 1; i < 7; i++) {
            numero_1 = numero_1*i;
        }
        /*
        if (numero_1>=200){
            return;
        }*/
        factorial();
    }

    public void setNumero_1(int numero_1) {
        this.numero_1 = numero_1;
    }
}
