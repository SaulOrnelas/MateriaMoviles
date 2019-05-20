package com.example.practicalaravel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private final String BASEURL = "http://192.168.137.1:8000/api/products/";
    private EditText edt_id_buscar,edt_id,edt_nombre,edt_precio,edt_descripcion;
    private Button btn_agregar,btn_modificar,btn_eliminar,btn_buscar,btn_limpiar;
    private Context ctx;
    private StringRequest strq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        requestQueue = Volley.newRequestQueue(ctx);
        edt_id_buscar = (EditText) findViewById(R.id.edt_id_buscar);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        edt_precio = (EditText) findViewById(R.id.edt_precio);
        edt_descripcion = (EditText) findViewById(R.id.edt_descripcion);

        btn_agregar = (Button) findViewById(R.id.btn_agregar);
        btn_modificar = (Button) findViewById(R.id.btn_modificar);
        btn_eliminar = (Button) findViewById(R.id.btn_eliminar);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);
        btn_limpiar = (Button) findViewById(R.id.btn_limpiar);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crear();
            }
        });
        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificar();
            }
        });
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminar();
            }
        });
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar();
            }
        });
        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarCampos();
            }
        });
    }

    private void crear() {

        strq = new StringRequest(Request.Method.POST, BASEURL+"insertar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Producto agregado", Toast.LENGTH_LONG).show();
                        obtenerDatos(response);
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Error", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", edt_nombre.getText().toString());
                parametros.put("precio", edt_precio.getText().toString());
                parametros.put("descripcion", edt_descripcion.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);

    }

    private void modificar() {

        strq = new StringRequest(Request.Method.POST, BASEURL+"actualizar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Registro actualizado", Toast.LENGTH_LONG).show();
                        obtenerDatos(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Registro inexistente", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("id", edt_id.getText().toString());
                parametros.put("nombre", edt_nombre.getText().toString());
                parametros.put("precio", edt_precio.getText().toString());
                parametros.put("descripcion", edt_descripcion.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);
    }



    private void eliminar() {

        strq = new StringRequest(Request.Method.DELETE, BASEURL+"eliminar/"+edt_id.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Producto eliminado", Toast.LENGTH_SHORT).show();
                        edt_id.setText("");
                        edt_nombre.setText("");
                        edt_precio.setText("");
                        edt_descripcion.setText("");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "Producto inexistente", Toast.LENGTH_LONG).show();
                edt_id.setText("");
                edt_nombre.setText("");
                edt_precio.setText("");
                edt_descripcion.setText("");
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", edt_nombre.getText().toString());
                parametros.put("precio", edt_precio.getText().toString());
                parametros.put("descripcion", edt_descripcion.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    private void buscar() {

        strq = new StringRequest(Request.Method.GET, BASEURL+edt_id_buscar.getText().toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, "Mostrando producto", Toast.LENGTH_SHORT).show();
                        obtenerDatos(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
                Toast.makeText(ctx, "El producto no existe", Toast.LENGTH_SHORT).show();
                edt_id.setText("");
                edt_nombre.setText("");
                edt_precio.setText("");
                edt_descripcion.setText("");
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                parametros.put("nombre", edt_nombre.getText().toString());
                parametros.put("precio", edt_precio.getText().toString());
                parametros.put("descripcion", edt_descripcion.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }
    private void limpiarCampos(){
        edt_id_buscar.setText("");
        edt_id.setText("");
        edt_nombre.setText("");
        edt_precio.setText("");
        edt_descripcion.setText("");
    }

/*
    public void responseHandler(String res){
        try {
            JSONArray response = new JSONArray(res);
            //Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            for(int i = 0, e = response.length(); i < e; i++){
                JSONObject producto = (JSONObject) response.get(i);

                String nombre = producto.get("nombre").toString();

                Product cat = new Product(
                        Integer.parseInt(producto.get("id").toString()),
                        (String) producto.get("nombre")
                );


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/

    public void obtenerDatos(String res) {
        try {
            JSONObject objetc = new JSONObject(res);
            String success = objetc.get("success").toString();
            String result = objetc.get("result").toString();
            String errors = objetc.get("errors").toString();

            if (success.equals("true")){
                JSONObject json_result = new JSONObject(result);
                edt_id.setText(json_result.get("id").toString());
                edt_nombre.setText(json_result.get("nombre").toString());
                edt_precio.setText(json_result.get("precio").toString());
                edt_descripcion.setText(json_result.get("descripcion").toString());
            }else{
                Toast.makeText(ctx, "Error: " + errors, Toast.LENGTH_SHORT).show();
            }

        }catch (JSONException e){
            e.getMessage();
            Toast.makeText(ctx, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }
}
