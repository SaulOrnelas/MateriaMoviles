package com.example.directorioempleado;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.directorioempleado.dao.DAOEmpleado;
import com.example.directorioempleado.model.Empleado;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragEditar extends Fragment {

    View view;
    private int id;
    private DAOEmpleado dao;
    ListView opciones;

    String ruta_imagen;
    byte[] ruta;
    private ImageView imgv_modificar;
    private EditText edt_edit_id;
    private EditText edt_edit_nombre;
    private EditText edt_edit_apellido;
    private EditText edt_edit_nacimiento;
    private EditText edt_edit_telefono;
    private EditText edt_edit_correo;
    private EditText edt_edit_direccion;
    private EditText edt_edit_nomina;
    private EditText edt_edit_area;
    private EditText edt_edit_puesto;
    private EditText edt_edit_estado_civil;
    private EditText edt_edit_curp;
    private EditText edt_edit_nss;
    private EditText edt_edit_cronicas;
    private EditText edt_edit_contacto_emergencia;
    private EditText edt_edit_escolaridad;
    private EditText edt_edit_nacionalidad;
    private EditText edt_edit_status;
    private Button btn_galeriaMod;
    private Button btn_editar;

    public FragEditar() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dao = new DAOEmpleado(getActivity().getApplicationContext());

        if(getArguments() != null){
            id = getArguments().getInt("id",0);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_editar, container, false);

        imgv_modificar = (ImageView) view.findViewById(R.id.imgv_modificar);
        edt_edit_id = (EditText) view.findViewById(R.id.edt_edit_id);
        edt_edit_nombre = (EditText) view.findViewById(R.id.edt_edit_nombre);
        edt_edit_apellido = (EditText) view.findViewById(R.id.edt_edit_apellido);
        edt_edit_nacimiento = (EditText) view.findViewById(R.id.edt_edit_nacimiento);
        edt_edit_telefono = (EditText) view.findViewById(R.id.edt_edit_telefono);
        edt_edit_correo = (EditText) view.findViewById(R.id.edt_edit_correo);
        edt_edit_direccion = (EditText) view.findViewById(R.id.edt_edit_direccion);
        edt_edit_nomina = (EditText) view.findViewById(R.id.edt_edit_nomina);
        edt_edit_area = (EditText) view.findViewById(R.id.edt_edit_area);
        edt_edit_puesto = (EditText) view.findViewById(R.id.edt_edit_puesto);
        edt_edit_estado_civil = (EditText) view.findViewById(R.id.edt_edit_estado_civil);
        edt_edit_curp = (EditText) view.findViewById(R.id.edt_edit_curp);
        edt_edit_nss = (EditText) view.findViewById(R.id.edt_edit_nss);
        edt_edit_cronicas = (EditText) view.findViewById(R.id.edt_edit_cronicas);
        edt_edit_contacto_emergencia = (EditText) view.findViewById(R.id.edt_edit_contacto_emergencia);
        edt_edit_escolaridad = (EditText) view.findViewById(R.id.edt_edit_escolaridad);
        edt_edit_nacionalidad = (EditText) view.findViewById(R.id.edt_edit_nacionalidad);
        edt_edit_status = (EditText) view.findViewById(R.id.edt_edit_status);
        btn_galeriaMod = (Button) view.findViewById(R.id.btn_galeriaMod);
        btn_editar = (Button) view.findViewById(R.id.btn_editar);

        Empleado empleado = dao.obtenerEmpleado(id);

        edt_edit_id.setText(String.valueOf(empleado.getId()));
        edt_edit_nombre.setText(empleado.getNombre());
        edt_edit_apellido.setText(empleado.getApellido());
        edt_edit_nacimiento.setText(empleado.getNacimiento());
        edt_edit_telefono.setText(empleado.getTelefono());
        edt_edit_correo.setText(empleado.getCorreo());
        edt_edit_direccion.setText(empleado.getDireccion());
        edt_edit_nomina.setText(String.valueOf(empleado.getNumNomnina()));
        edt_edit_area.setText(empleado.getArea());
        edt_edit_puesto.setText(empleado.getPuesto());
        edt_edit_estado_civil.setText(empleado.getEstadoCivil());
        edt_edit_curp.setText(empleado.getCurp());
        edt_edit_nss.setText(empleado.getNss());
        edt_edit_cronicas.setText(empleado.getCronicas());
        edt_edit_contacto_emergencia.setText(empleado.getContEmergencia());
        edt_edit_escolaridad.setText(empleado.getEscolaridad());
        edt_edit_nacionalidad.setText(empleado.getNacionalidad());
        edt_edit_status.setText(empleado.getStatus());


        btn_galeriaMod.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                seleccionarImagenEditar();
            }
        });
        btn_editar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    guardarImagen();
                    Empleado empleado = new Empleado(
                            Integer.parseInt(edt_edit_id.getText().toString()),
                            edt_edit_nombre.getText().toString(),
                            edt_edit_apellido.getText().toString(),
                            edt_edit_nacimiento.getText().toString(),
                            edt_edit_telefono.getText().toString(),
                            edt_edit_correo.getText().toString(),
                            edt_edit_direccion.getText().toString(),
                            Integer.parseInt(edt_edit_nomina.getText().toString()),
                            edt_edit_area.getText().toString(),
                            edt_edit_puesto.getText().toString(),
                            edt_edit_estado_civil.getText().toString(),
                            edt_edit_curp.getText().toString(),
                            edt_edit_nss.getText().toString(),
                            edt_edit_cronicas.getText().toString(),
                            edt_edit_contacto_emergencia.getText().toString(),
                            ruta,
                            edt_edit_escolaridad.getText().toString(),
                            edt_edit_nacionalidad.getText().toString(),
                            edt_edit_status.getText().toString());
                    dao.editar(empleado);

                    Toast.makeText(getActivity().getApplicationContext(),"Actualización correcta",Toast.LENGTH_SHORT).show();



                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getActivity().getApplicationContext(),"Error al actualizar",Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        return view;
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgv_modificar.setImageBitmap(imageBitmap);
        }else{
            if(requestCode == REQUEST_SHOW_IMAGE){
                Uri path = data.getData();
                ruta_imagen= path.toString();
                Log.e("Imagen",ruta_imagen);
                //Toast.makeText(getApplicationContext(),path.toString(),Toast.LENGTH_LONG).show();
                imgv_modificar.setImageURI(path);
            }
        }
    }

    static final int REQUEST_SHOW_IMAGE = 10;
    public void seleccionarImagenEditar(){
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser
                        (intent,"Seleccionar aplicación"),
                REQUEST_SHOW_IMAGE);
    }


    public void guardarImagen() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(20480);
        imgv_modificar.buildDrawingCache();
        Bitmap bitmap =imgv_modificar.getDrawingCache();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, baos);
        byte[] blob = baos.toByteArray();
        ruta= blob;
        //FileInputStream fis = new FileInputStream("/document/primary:DCIM/Camera/IMG_20190408_151150.jpg");
        //FileInputStream fis = new FileInputStream("/storage/emulated/0/Pictures/empleados/empleado1.jpg");
        //byte[] image = new byte[fis.available()];
        //fis.read(image);

    }

    public void editar (View view){

    }

}
