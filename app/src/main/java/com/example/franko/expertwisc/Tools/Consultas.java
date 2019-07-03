package com.example.franko.expertwisc.Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

public class Consultas {
    ConexionHelper con;
    Context context;

    public Consultas() {

    }

    public int Contador (Context context){
        this.context = context;
        con = new ConexionHelper(context, "bd_wisc", null, 1);

        SQLiteDatabase db = con.getWritableDatabase();
        Cursor pw = db.rawQuery("SELECT id_persona FROM paciente " +
                "WHERE id_usuario = "+Utilidades.currentUserIdUsuario,null);

        return Utilidades.currentCounterPatients = pw.getCount();

    }
}
