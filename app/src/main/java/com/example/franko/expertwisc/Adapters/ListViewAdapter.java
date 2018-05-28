package com.example.franko.expertwisc.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.franko.expertwisc.R;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter {

    int groupid;
    String[] item_list;
    ArrayList<String> desc;
    Context context;

    public ListViewAdapter(@NonNull Context context, int vg, int id, String[] item_list) {
        super(context,vg, id, item_list);
        this.context=context;
        groupid=vg;
        this.item_list=item_list;
    }

    static class ViewHolder {
        private TextView textview;
        private Button button;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // Inflamos el list_item.xml si convertView es null
        if(rowView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textview= (TextView) rowView.findViewById(R.id.fecha_prueba);
            viewHolder.button= (Button) rowView.findViewById(R.id.bt);
            rowView.setTag(viewHolder);
        }
        // Aquí llenamos cada TextView con los datos de las pruebas obtenidas de la base de datos
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.textview.setText(item_list[position]);
        holder.button.setText(item_list[position]);
        return rowView;
    }
}
