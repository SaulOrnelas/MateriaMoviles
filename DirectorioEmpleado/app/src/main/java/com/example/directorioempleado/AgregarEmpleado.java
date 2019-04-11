package com.example.directorioempleado;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AgregarEmpleado extends AppCompatActivity {

    Empleado empleado;
    DAOEmpleado dao;
    List<Empleado> lista;

    String ruta_imagen;
    byte[] ruta;
    private ImageView imgv_agregar;
    private EditText edt_add_nombre;
    private EditText edt_add_apellido;
    private EditText edt_add_nacimiento;
    private EditText edt_add_telefono;
    private EditText edt_add_correo;
    private EditText edt_add_direccion;
    private EditText edt_add_nomina;
    private EditText edt_add_area;
    private EditText edt_add_puesto;
    private EditText edt_add_estado_civil;
    private EditText edt_add_curp;
    private EditText edt_add_nss;
    private EditText edt_add_cronicas;
    private EditText edt_add_contacto_emergencia;
    private EditText edt_add_escolaridad;
    private EditText edt_add_nacionalidad;
    private EditText edt_add_status;
    private Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_empleado);

        dao = new DAOEmpleado(AgregarEmpleado.this);

        imgv_agregar = (ImageView) findViewById(R.id.imgv_agregar);

        edt_add_nombre = (EditText) findViewById(R.id.edt_add_nombre);
        edt_add_apellido = (EditText) findViewById(R.id.edt_add_apellido);
        edt_add_nacimiento = (EditText) findViewById(R.id.edt_add_nacimiento);
        edt_add_telefono = (EditText) findViewById(R.id.edt_add_telefono);
        edt_add_correo = (EditText) findViewById(R.id.edt_add_correo);
        edt_add_direccion = (EditText) findViewById(R.id.edt_add_direccion);
        edt_add_nomina = (EditText) findViewById(R.id.edt_add_nomina);
        edt_add_area = (EditText) findViewById(R.id.edt_add_area);
        edt_add_puesto = (EditText) findViewById(R.id.edt_add_puesto);
        edt_add_estado_civil = (EditText) findViewById(R.id.edt_add_estado_civil);
        edt_add_curp = (EditText) findViewById(R.id.edt_add_curp);
        edt_add_nss = (EditText) findViewById(R.id.edt_add_nss);
        edt_add_cronicas = (EditText) findViewById(R.id.edt_add_cronicas);
        edt_add_contacto_emergencia = (EditText) findViewById(R.id.edt_add_contacto_emergencia);
        edt_add_escolaridad = (EditText) findViewById(R.id.edt_add_escolaridad);
        edt_add_nacionalidad = (EditText) findViewById(R.id.edt_add_nacionalidad);
        edt_add_status = (EditText) findViewById(R.id.edt_add_status);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);

        if(ContextCompat.checkSelfPermission(AgregarEmpleado.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(AgregarEmpleado.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AgregarEmpleado.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
    }

    public void agregar(View view){

        try{
            saveImage();
            empleado = new Empleado(edt_add_nombre.getText().toString(),
                    edt_add_apellido.getText().toString(),
                    edt_add_nacimiento.getText().toString(),
                    edt_add_telefono.getText().toString(),
                    edt_add_correo.getText().toString(),
                    edt_add_direccion.getText().toString(),
                    Integer.parseInt(edt_add_nomina.getText().toString()),
                    edt_add_area.getText().toString(),
                    edt_add_puesto.getText().toString(),
                    edt_add_estado_civil.getText().toString(),
                    edt_add_curp.getText().toString(),
                    edt_add_nss.getText().toString(),
                    edt_add_cronicas.getText().toString(),
                    edt_add_contacto_emergencia.getText().toString(),
                    ruta,
                    edt_add_escolaridad.getText().toString(),
                    edt_add_nacionalidad.getText().toString(),
                    edt_add_status.getText().toString());
            dao.insertar(empleado);


        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(),"Error", Toast.LENGTH_SHORT).show();
        }
    }

    private File crearArchivoImagen() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "Backup_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,".jpg",storageDir);
        return image;
    }

    static final int REQUEST_TAKE_PHOTO = 1;
    public void tomarFoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            try {
                photoFile = crearArchivoImagen();
            } catch (IOException ex) {
                // Manejo errores
            }

            if(photoFile != null){
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider3",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI.toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                //startActivity(takePictureIntent);
            }
        }
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgv_agregar.setImageBitmap(imageBitmap);
        }else{
            if(requestCode == REQUEST_SHOW_IMAGE && resultCode == RESULT_OK){
                Uri path = data.getData();
                ruta_imagen= path.toString();
                Log.e("Imagen",ruta_imagen);
                //Toast.makeText(getApplicationContext(),path.toString(),Toast.LENGTH_LONG).show();
                imgv_agregar.setImageURI(path);
            }
        }
    }
    static final int REQUEST_SHOW_IMAGE = 10;
    public void seleccionarImagen(View view){
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser
                        (intent,"Seleccionar aplicación"),
                REQUEST_SHOW_IMAGE);
    }


    public void saveImage() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(20480);
        imgv_agregar.buildDrawingCache();
        Bitmap bitmap =imgv_agregar.getDrawingCache();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, baos);
        byte[] blob = baos.toByteArray();
        ruta= blob;
        //FileInputStream fis = new FileInputStream("/document/primary:DCIM/Camera/IMG_20190408_151150.jpg");
        //FileInputStream fis = new FileInputStream("/storage/emulated/0/Pictures/empleados/empleado1.jpg");
        //byte[] image = new byte[fis.available()];
        //fis.read(image);


    }

    public void getImage(View view){

    }
}
