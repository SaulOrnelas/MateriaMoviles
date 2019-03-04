package com.example.saul.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edt_pantalla;
    private Button btn_num1, btn_num2, btn_num3, btn_num4, btn_num5, btn_num6, btn_num7, btn_num8,
            btn_num9, btn_num0, btn_punto, btn_igual, btn_borrar, btn_limpiar, btn_suma, btn_resta,
            btn_multiplicacion, btn_division, btn_potencia, btn_raiz, btn_factorial, btn_porcentage,
            btn_recuperar, btn_menosDec, btn_masDec;
    String num1, num2, signo, resultado = "", cantDecimal = "#.####";
    int cantDes=4;
    DecimalFormat decimal;
    Toast toast;
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
        btn_igual = (Button) findViewById(R.id.btn_igual);
        btn_borrar = (Button) findViewById(R.id.btn_borrar);
        btn_limpiar = (Button) findViewById(R.id.btn_limpiar);
        btn_menosDec = (Button) findViewById(R.id.btn_menosDec);
        btn_masDec = (Button) findViewById(R.id.btn_masDec);
        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_resta = (Button) findViewById(R.id.btn_resta);
        btn_multiplicacion = (Button) findViewById(R.id.btn_multiplicacion);
        btn_division = (Button) findViewById(R.id.btn_division);
        btn_potencia = (Button) findViewById(R.id.btn_potencia);
        btn_raiz = (Button) findViewById(R.id.btn_raiz);
        btn_factorial = (Button) findViewById(R.id.btn_factorial);
        btn_porcentage = (Button) findViewById(R.id.btn_porcentage);
        btn_recuperar = (Button) findViewById(R.id.btn_recuperar);

        decimal = new DecimalFormat(cantDecimal);
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
                String cadenaPunto;
                cadenaPunto = edt_pantalla.getText().toString();
                if (cadenaPunto.length()<=0){
                    edt_pantalla.setText("0.");
                } else{
                    if(!existePunto(edt_pantalla.getText().toString())){
                        edt_pantalla.setText(edt_pantalla.getText().toString()+".");
                    }
                }

                break;
            case R.id.btn_igual:
                num2= edt_pantalla.getText().toString();
                if(!num2.equals("")){
                    resultado=calcular(num1,num2,signo);
                    edt_pantalla.setText(decimal.format(Double.parseDouble(resultado)));
                }
                break;
            case R.id.btn_borrar:
                String cadenaBorrar;
                cadenaBorrar = edt_pantalla.getText().toString();
                if (cadenaBorrar.length()>0){
                    cadenaBorrar = cadenaBorrar.substring(0, cadenaBorrar.length()-1);
                    edt_pantalla.setText(cadenaBorrar);
                }
                break;
            case R.id.btn_limpiar:
                edt_pantalla.setText("");
                break;
            case R.id.btn_suma:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="+";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_resta:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="-";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_multiplicacion:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="*";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_division:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="/";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_potencia:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="^";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_porcentage:
                if(!edt_pantalla.getText().toString().equals("")){
                    num1= edt_pantalla.getText().toString();
                    signo="%";
                }
                edt_pantalla.setText("");
                break;
            case R.id.btn_factorial:
                int num, resFactorial=1;
                if(!existePunto(edt_pantalla.getText().toString())){
                    num = Integer.parseInt(edt_pantalla.getText().toString());
                    for (int i = 1; i <= num; i++) {
                        resFactorial = resFactorial*i;
                    }
                    edt_pantalla.setText(String.valueOf(resFactorial));
                    resultado = edt_pantalla.getText().toString();
                }
                break;
            case R.id.btn_raiz:
                Double raiz = Math.sqrt(Double.parseDouble(edt_pantalla.getText().toString()));
                edt_pantalla.setText(String.valueOf(raiz));
                resultado = edt_pantalla.getText().toString();
                edt_pantalla.setText(decimal.format(raiz));
                break;
            case R.id.btn_recuperar:
                edt_pantalla.setText(decimal.format(Double.parseDouble(resultado)));
                break;
            case R.id.btn_menosDec:
                if (cantDecimal.length()>2){
                    cantDecimal = cantDecimal.substring(0, cantDecimal.length()-1);
                    decimal = new DecimalFormat(cantDecimal);
                    if(!resultado.equals("")){
                        edt_pantalla.setText(decimal.format(Double.parseDouble(resultado)));
                    }
                    cantDes--;
                }
                toast = Toast.makeText(
                        getApplicationContext(),
                        cantDes + " Decimales",
                        Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.btn_masDec:
                if (cantDecimal.length()<12){
                    cantDecimal = cantDecimal + "#";
                    decimal = new DecimalFormat(cantDecimal);
                    if(!resultado.equals("")){
                        edt_pantalla.setText(decimal.format(Double.parseDouble(resultado)));
                    }
                    cantDes++;
                }
                toast = Toast.makeText(
                        getApplicationContext(),
                        cantDes + " Decimales",
                        Toast.LENGTH_LONG);
                toast.show();
                break;
        }
    }

    public boolean existePunto(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)=='.'){
                return true;
            }
        }
        return false;
    }

    public void factorial(){

        int num, resFactorial=1;
        num = Integer.parseInt(edt_pantalla.getText().toString());

        for (int i = 1; i < num; i++) {
            resFactorial = resFactorial*i;
        }
        edt_pantalla.setText(resFactorial);
    }
    public String calcular(String memoria1, String memoria2, String signo){
        Double resultado=0.0;
        String respuesta;
        if (signo.equals("+")){
            resultado= Double.parseDouble(memoria1)+Double.parseDouble(memoria2);
        } else if (signo.equals("-")){
            resultado= Double.parseDouble(memoria1)-Double.parseDouble(memoria2);
        } else if (signo.equals("*")){
            resultado= Double.parseDouble(memoria1)*Double.parseDouble(memoria2);
        } else if (signo.equals("/")){
            resultado= Double.parseDouble(memoria1)/Double.parseDouble(memoria2);
        } else if (signo.equals("^")){
            resultado = Math.pow(Double.parseDouble(memoria1),Double.parseDouble(memoria2));
        } else if (signo.equals("%")){
            resultado= Double.parseDouble(memoria1)*(Double.parseDouble(memoria2)/100);
        }
        respuesta = String.valueOf(resultado);
        return respuesta;
    }



}
