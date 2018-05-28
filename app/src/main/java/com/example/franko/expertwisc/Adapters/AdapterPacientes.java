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
import com.example.franko.expertwisc.R;

import java.util.ArrayList;

public class AdapterPacientes extends RecyclerView.Adapter<AdapterPacientes.ViewHolderPacientes> implements View.OnClickListener{

    ArrayList<Paciente> listaPacientes;
    private View.OnClickListener listener;

    public AdapterPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    @NonNull
    @Override
    public ViewHolderPacientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_list, null, false);
        view.setOnClickListener(this);
        return new ViewHolderPacientes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPacientes holder, int position) {
        holder.txtNombres.setText(listaPacientes.get(position).getNombres()+ "  "+listaPacientes.get(position).getApellidos());
        holder.txtEdad.setText(listaPacientes.get(position).getEdad());
        byte[] image = listaPacientes.get(position).getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
        holder.Imagen.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
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

    public class ViewHolderPacientes extends RecyclerView.ViewHolder {

        private TextView txtNombres, txtEdad;
        private ImageView Imagen;

        public ViewHolderPacientes(View itemView) {
            super(itemView);
            txtNombres = (TextView) itemView.findViewById(R.id.txtListaPacienteNombres);
            txtEdad = (TextView) itemView.findViewById(R.id.txtListaPacienteEdad);
            Imagen = (ImageView) itemView.findViewById(R.id.imgListaPaciente);
        }
    }
}
