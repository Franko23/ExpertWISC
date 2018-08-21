package com.example.franko.expertwisc.Adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.CalcularEdad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AdapterPacientes extends RecyclerView.Adapter<AdapterPacientes.ViewHolderPacientes> implements View.OnClickListener{

    ArrayList<Persona> listaPersonas;
    ArrayList<Paciente> listaPacientes;
    private View.OnClickListener listener;

    public AdapterPacientes(ArrayList<Persona> listaPersonas, ArrayList<Paciente> listaPacientes) {
        this.listaPersonas = listaPersonas;
        this.listaPacientes = listaPacientes;
    }

    @NonNull
    @Override
    public ViewHolderPacientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_pacientes, null, false);
        view.setOnClickListener(this);
        return new ViewHolderPacientes(view);
    }

    public class ViewHolderPacientes extends RecyclerView.ViewHolder {

        private TextView txtNombres, txtEdad;
        private ImageView Imagen, alertCloud;

        public ViewHolderPacientes(View itemView) {
            super(itemView);
            txtNombres = itemView.findViewById(R.id.txtListaPacienteNombres);
            txtEdad = itemView.findViewById(R.id.txtListaPacienteEdad);
            Imagen =  itemView.findViewById(R.id.imgListaPaciente);
            alertCloud = itemView.findViewById(R.id.alert_cloud);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderPacientes holder, int position) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = mdformat.format(calendar.getTime());

        holder.txtNombres.setText(listaPersonas.get(position).getNombre_persona()+ "  "+listaPersonas.get(position).getApellido_persona());
        CalcularEdad calcularEdad = new CalcularEdad(listaPersonas.get(position).getFecha_nacimiento_persona(), fechaActual);
        String edad = calcularEdad.CalcularEdad();
        holder.txtEdad.setText(edad);
        byte[] image = listaPersonas.get(position).getImagen_persona();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
        holder.Imagen.setImageBitmap(bitmap);

        if (listaPersonas.get(position).getUp_persona().equals("NO") || listaPacientes.get(position).getUp_paciente().equals("NO")){
            holder.alertCloud.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }


}
