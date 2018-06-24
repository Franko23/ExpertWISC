package com.example.franko.expertwisc.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ViewHolderTest> implements View.OnClickListener{

    ArrayList<Test> listaTest;
    Context context;
    View root;
    private View.OnClickListener listener;

    public  AdapterTest(ArrayList<Test> listatest) {
        this.listaTest = listatest;
    }

    @NonNull
    @Override
    public ViewHolderTest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_test, null, false);
        root = view.getRootView();
        view.setOnClickListener(this);
        return new ViewHolderTest(view);

    }


    public class ViewHolderTest extends RecyclerView.ViewHolder {
        private TextView fecha_prueba;
        private TextView estado;
        private TextView nroTest;
        private ImageView up_test;
        public ViewHolderTest(View itemView) {
            super(itemView);
            fecha_prueba = itemView.findViewById(R.id.fecha_prueba);
            estado =  itemView.findViewById(R.id.estado);
            nroTest = itemView.findViewById(R.id.nro_test);
            up_test = itemView.findViewById(R.id.up_test);
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
        if (listaTest.get(position).getUp_test().equals("NO")){
            holder.up_test.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listaTest.size();
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
