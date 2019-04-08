package com.example.directorioempleado.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.directorioempleado.DatosEmpleado;
import com.example.directorioempleado.MainActivity;
import com.example.directorioempleado.R;
import com.example.directorioempleado.model.Empleado;

import java.util.List;

public class AdapterEmpleado extends RecyclerView.Adapter<AdapterEmpleado.RVEmpleadoAdapterViewHolder> {
    private Context context;
    private List<Empleado> empleados;

    //Constructor del adapter
    public AdapterEmpleado(Context context, List<Empleado> empleados){
        this.context = context;
        this.empleados = empleados;
    }

    //Creación del item principal que se reciclará en cada uno de los elementos
    @NonNull
    @Override
    public RVEmpleadoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Inflar la vista del item
        View view = LayoutInflater.from(context).inflate(R.layout.lista_empleado, viewGroup, false);

        //Retornar una instancia del viewHolder pasandole como parametro la vista anteriormente creada
        return new RVEmpleadoAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEmpleado.RVEmpleadoAdapterViewHolder rvEmpleadoAdapterViewHolder, int i) {
        //Crear una instanca de tipo "Empleado" dependiendo del lugar de la lista en el que este
        final Empleado empleado = empleados.get(i);

        //Asignamos a las vistas del viewholder los textos del mensaje en esa posición
        rvEmpleadoAdapterViewHolder.txv_rvid.setText(String.valueOf(empleado.getId()));
        rvEmpleadoAdapterViewHolder.txv_rvnombre.setText(empleado.getNombre());
        rvEmpleadoAdapterViewHolder.txv_rvapellido.setText(empleado.getApellido());

        //Asignamos a ese item en particular un listener para cuando el usuario haga click en el
        rvEmpleadoAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle(empleado.getNombre());
                alertDialog.setMessage(empleado.getApellido());

                alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();*/

                final Intent intent = new Intent(context, DatosEmpleado.class);
                intent.putExtra("id",empleado.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return empleados.size();
    }

    public class RVEmpleadoAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txv_rvid;
        TextView txv_rvnombre;
        TextView txv_rvapellido;

        public RVEmpleadoAdapterViewHolder(View view) {
            super(view);

            //Instanciamos nuestros objetos que seran buscados según si id en la vista pasada por el constructor
            txv_rvid = view.findViewById(R.id.txv_rvid);
            txv_rvnombre = view.findViewById(R.id.txv_rvnombre);
            txv_rvapellido = view.findViewById(R.id.txv_rvapellido);
        }
    }
}