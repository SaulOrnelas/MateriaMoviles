package com.example.saul.directorioempleado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_agregar = (Button) findViewById(R.id.btn_agregar);


    }
    public void agregar (View view){
        Intent intent = new Intent(this, InfoPersonal.class);
        startActivity(intent);
    }
}
