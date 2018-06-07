package com.example.franko.expertwisc.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ViewHolderTest> {

    ArrayList<Test> listaTest;
    Context context;
    View root;

    public AdapterTest(ArrayList<Test> listatest) {
        this.listaTest = listatest;
    }

    @NonNull
    @Override
    public ViewHolderTest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_test, null, false);
        root = view.getRootView();
        return new ViewHolderTest(view);

    }
    public class ViewHolderTest extends RecyclerView.ViewHolder {
        private TextView fecha_prueba;
        private TextView estado;
        private TextView nroTest;
        public ViewHolderTest(View itemView) {
            super(itemView);
            fecha_prueba= (TextView) itemView.findViewById(R.id.fecha_prueba);
            estado= (TextView) itemView.findViewById(R.id.estado);
            nroTest= (TextView) itemView.findViewById(R.id.nro_test);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderTest holder, int position) {
        holder.nroTest.setText(Integer.toString(position+1));
        holder.fecha_prueba.setText(listaTest.get(position).getFecha_test());
        holder.estado.setText(listaTest.get(position).getEstado_test());

        if (listaTest.get(position).getEstado_test().equals("EN CURSO")){
            holder.estado.setBackgroundColor(Color.parseColor("#e73922"));
        }else {
            holder.estado.setBackgroundColor(Color.parseColor("#0d9318"));
        }
    }

    @Override
    public int getItemCount() {
        return listaTest.size();
    }


}
