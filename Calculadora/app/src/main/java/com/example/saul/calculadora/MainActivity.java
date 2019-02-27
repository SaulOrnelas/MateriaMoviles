package com.example.saul.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_pantalla;
    private Button btn_num1, btn_num2, btn_num3, btn_num4, btn_num5, btn_num6, btn_num7, btn_num8,
            btn_num9, btn_num0, btn_punto, btn_mask, btn_igual, btn_borrar, btn_limpiar, btn_arriba,
            btn_abajo, btn_izquierda, btn_derecha, btn_subneteo, btn_suma, btn_resta,
            btn_multiplicacion, btn_division, btn_potencia, btn_raiz, btn_factorial, btn_porcentage,
            btn_recuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_pantalla = (EditText) findViewById(R.id.edt_pantalla);
        btn_num0 = (Button) findViewById(R.id.btn_num0);
        btn_num1 = (Button) findViewById(R.id.btn_num1);
        btn_num2 = (Button) findViewById(R.id.btn_num2);
        btn_num3 = (Button) findViewById(R.id.btn_num3);
        btn_num4 = (Button) findViewById(R.id.btn_num4);
        btn_num5 = (Button) findViewById(R.id.btn_num5);
        btn_num6 = (Button) findViewById(R.id.btn_num6);
        btn_num7 = (Button) findViewById(R.id.btn_num7);
        btn_num8 = (Button) findViewById(R.id.btn_num8);
        btn_num9 = (Button) findViewById(R.id.btn_num9);

        btn_punto = (Button) findViewById(R.id.btn_punto);
        btn_mask = (Button) findViewById(R.id.btn_mask);
        btn_igual = (Button) findViewById(R.id.btn_igual);
        btn_borrar = (Button) findViewById(R.id.btn_borrar);
        btn_limpiar = (Button) findViewById(R.id.btn_limpiar);
        btn_arriba = (Button) findViewById(R.id.btn_arriba);
        btn_abajo = (Button) findViewById(R.id.btn_abajo);
        btn_izquierda = (Button) findViewById(R.id.btn_izquierda);
        btn_derecha = (Button) findViewById(R.id.btn_derecha);
        btn_subneteo = (Button) findViewById(R.id.btn_subneteo);
        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_resta = (Button) findViewById(R.id.btn_resta);
        btn_multiplicacion = (Button) findViewById(R.id.btn_multiplicacion);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_potencia = (Button) findViewById(R.id.btn_potencia);
        btn_raiz = (Button) findViewById(R.id.btn_raiz);
        btn_factorial = (Button) findViewById(R.id.btn_factorial);
        btn_porcentage = (Button) findViewById(R.id.btn_porcentage);
        btn_recuperar = (Button) findViewById(R.id.btn_recuperar);


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_num0:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"0");
                break;
            case R.id.btn_num1:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"1");
                break;
            case R.id.btn_num2:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"2");
                break;
            case R.id.btn_num3:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"3");
                break;
            case R.id.btn_num4:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"4");
                break;
            case R.id.btn_num5:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"5");
                break;
            case R.id.btn_num6:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"6");
                break;
            case R.id.btn_num7:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"7");
                break;
            case R.id.btn_num8:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"8");
                break;
            case R.id.btn_num9:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"9");
                break;

            case R.id.btn_punto:
                edt_pantalla.setText(edt_pantalla.getText().toString()+".");
                break;
            case R.id.btn_mask:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"/");
                break;
            case R.id.btn_igual:
                break;
            case R.id.btn_borrar:

                break;
            case R.id.btn_limpiar:
                edt_pantalla.setText("");
                break;
            case R.id.btn_arriba:

                break;
            case R.id.btn_abajo:

                break;
            case R.id.btn_izquierda:

                break;
            case R.id.btn_derecha:

                break;
            case R.id.btn_subneteo:

                break;
            case R.id.btn_suma:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"+");
                break;
            case R.id.btn_resta:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"-");
                break;
            case R.id.btn_multiplicacion:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"*");
                break;
            case R.id.btn_division:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"/");
                break;
            case R.id.btn_potencia:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"^");
                break;
            case R.id.btn_raiz:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"¬");
                break;
            case R.id.btn_factorial:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"!");
                break;
            case R.id.btn_porcentage:
                edt_pantalla.setText(edt_pantalla.getText().toString()+"%");
                break;
            case R.id.btn_recuperar:

                break;
        }
    }



    //Metodos para subneteo
    public String [] separarCadena(String cadena){
        //Arreglo que guardará la red y la máscara
        String [] mascara = cadena.split("/");
        //Arreglo que guardará en distintas posiciones los octetos de la red
        String [] octetos = mascara[0].split("[.]");
        //Datos de la red
        String [] datos = new String[5];
        System.arraycopy(octetos, 0, datos, 0, 4);
        datos[4] = mascara[1];
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i]);

        }
        return octetos;
    }


}
