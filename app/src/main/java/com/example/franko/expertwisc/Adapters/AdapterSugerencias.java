package com.example.franko.expertwisc.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

public class AdapterSugerencias extends RecyclerView.Adapter<AdapterSugerencias.ViewHolderSugerencias> implements View.OnClickListener {

    private View.OnClickListener listener;
    ArrayList<String> resultado;
    String info_test, info_test_paciente;
    public AdapterSugerencias(ArrayList<String> resultado) {
        this.resultado = resultado;
    }

    @NonNull
    @Override
    public AdapterSugerencias.ViewHolderSugerencias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_information, null, false);
        view.setOnClickListener(this);
        return new ViewHolderSugerencias(view);
    }
    public class ViewHolderSugerencias extends RecyclerView.ViewHolder {
        private TextView titulo_test;
        private LinearLayout test_information;
        private TextView info_test;
        private TextView info_test_paciente;
        public ViewHolderSugerencias(View itemView) {
            super(itemView);
            titulo_test = itemView.findViewById(R.id.titulo_test);
            test_information = itemView.findViewById(R.id.test_information);
            info_test = itemView.findViewById(R.id.info_test);
            info_test_paciente = itemView.findViewById(R.id.info_test_paciente);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterSugerencias.ViewHolderSugerencias holder, int position) {

            holder.titulo_test.setText((position+1)+". "+resultado.get(position));
            if (resultado.get(position).equals("LEE")){
                info_test = Utilidades.LEE;
            }
            if (resultado.get(position).equals("PROLEC")){
                info_test = Utilidades.PROLEC;
            }
            if (resultado.get(position).equals("BENDER")){
                info_test = Utilidades.BENDER;
            }
            if (resultado.get(position).equals("TEPSI")){
                info_test = Utilidades.TEPSI;
            }
            if (resultado.get(position).equals("Pre-Cálculo")){
                info_test = Utilidades.PRECALCULO;
            }
            if (resultado.get(position).equals("Pro-Cálculo")){
                info_test = Utilidades.PROCALCULO;
            }
            if (resultado.get(position).equals("RAVEN-G, PMA")){
                info_test = Utilidades.RAVEN_G;
            }

            holder.info_test.setText(info_test);
            holder.info_test_paciente.setText(info_test_paciente);



    }

    @Override
    public int getItemCount() {
        return resultado.size();
    }

    public void setOnClickListener(View.OnClickListener listener){this.listener = listener;}

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }


}
