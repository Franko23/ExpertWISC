package com.example.franko.expertwisc.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;

import java.util.ArrayList;

public class AdapterTest extends ArrayAdapter<String> {

    int groupid;
    ArrayList<Test> listaTest;
    Context context;

    //Recibimos la fecha y los items
    public AdapterTest(@NonNull Context context, int vg, ArrayList<Test> listaTest) {
        super(context,vg);
        this.context=context;
        groupid=vg;
        this.listaTest=listaTest;
    }

    static class ViewHolder {
        private TextView fecha_prueba;
        private TextView estado;
        private TextView nroTest;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // Inflamos el list_item.xml si convertView es null
        if(rowView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.fecha_prueba= (TextView) rowView.findViewById(R.id.fecha_prueba);
            viewHolder.estado= (TextView) rowView.findViewById(R.id.estado);
            viewHolder.nroTest= (TextView) rowView.findViewById(R.id.nro_test);
            rowView.setTag(viewHolder);
        }
        // Aquí llenamos cada TextView con los datos de las pruebas obtenidas de la base de datos
        ViewHolder holder = (ViewHolder) rowView.getTag();

            holder.nroTest.setText(position);
            holder.fecha_prueba.setText(listaTest.get(position).getFecha_test());
            holder.estado.setText(listaTest.get(position).getEstado_test());

            if (listaTest.get(position).getEstado_test().equals("EN CURSO")){
                holder.estado.setBackgroundColor(getContext().getResources().getColor(R.color.colorInProgress));
            }else{
                holder.estado.setBackgroundColor(getContext().getResources().getColor(R.color.colorFinished));

        }

        return rowView;
    }
}
