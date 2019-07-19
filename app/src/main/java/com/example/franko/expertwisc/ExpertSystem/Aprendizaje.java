package com.example.franko.expertwisc.ExpertSystem;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import static android.widget.Toast.LENGTH_LONG;

public class Aprendizaje extends Activity {
    ConexionHelper con;

    public void insertInitData(Context context){
        con = new ConexionHelper(context,"bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        //Datos iniciales de ICV
        ContentValues baseICV = new ContentValues();
        baseICV.put(Utilidades.CAMPO_CONCLUSIONES_ICV,"Los niños con bajas puntuaciones en ICV " +
                "normalmente presentan trastornos neurológicos");
        baseICV.put(Utilidades.CAMPO_CONCLUSIONES_KEY_ICV,"trastornos neurológicos");

        //Datos iniciales de IRP
        ContentValues baseIRP = new ContentValues();
        baseIRP.put(Utilidades.CAMPO_CONCLUSIONES_IRP,"Los niños con bajas puntuaciones en IRP " +
                "normalmente presentan trastornos de aprendizaje no verbal");
        baseIRP.put(Utilidades.CAMPO_CONCLUSIONES_KEY_IRP,"trastornos de aprendizaje no verbal");

        //Datos iniciales de IMO
        ContentValues baseIMO = new ContentValues();
        baseIMO.put(Utilidades.CAMPO_CONCLUSIONES_IMO,"Los niños con bajas puntuaciones en IMO " +
                "normalmente presentan trastornos de lectura y trastornos de lenguaje");
        baseIMO.put(Utilidades.CAMPO_CONCLUSIONES_KEY_IMO,"trastornos de lectura, trastornos de lenguaje");

        //Datos iniciales de IVP
        ContentValues baseIVP = new ContentValues();
        baseIVP.put(Utilidades.CAMPO_CONCLUSIONES_IVP,"Los niños con bajas puntuaciones en IVP " +
                "normalmente presentan ADH, trastornos de aprendizaje y daño cerebral traumático");
        baseIVP.put(Utilidades.CAMPO_CONCLUSIONES_KEY_IVP,"ADH, trastornos de aprendizaje, daño cerebral traumático");

        try {
            db.insert(Utilidades.TABLA_ICV, Utilidades.CAMPO_ID_ICV, baseICV);
            db.insert(Utilidades.TABLA_IRP, Utilidades.CAMPO_ID_IRP, baseIRP);
            db.insert(Utilidades.TABLA_IMO, Utilidades.CAMPO_ID_IMO, baseIMO);
            db.insert(Utilidades.TABLA_IVP, Utilidades.CAMPO_ID_IVP, baseIVP);
        }catch (Exception e){
            Toast.makeText(context,"Error al insertar datos iniciales", LENGTH_LONG);
        }

        db.close();
    }

    public void insertDataBase(String edad, String motivo, String antecedentes, String[] area, Context context){
        con = new ConexionHelper(context,"bd_wisc", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        for (int i=0; i < 4; i++){
            //Si el valor del 1er índice es menor a 90
            if (Integer.parseInt(Utilidades.listResultCompuesta.get(i))<90){
                ContentValues base = new ContentValues();
                base.put("edad_"+area[i],edad);
                base.put("motivo_"+area[i],motivo);
                base.put("antecedentes_"+area[i],antecedentes);
                base.put("sugerencias_key_"+area[i],Utilidades.Sugerencias_key);
                base.put("conclusiones_key_"+area[i],Utilidades.Conclusiones_key);

                //Nueva conclusión
                String [] nC = Utilidades.Conclusiones_key.split(",");
                String nConclusion="";
                for (int j=0; j < nC.length; j++){
                    if (nC.length>1){
                        if (j< nC.length-1){
                            nConclusion += nC[j]+", ";
                        }else {
                            nConclusion += " y " + nC[j]+".";
                        }
                    }else{
                        nConclusion += nC[j]+".";
                    }
                }
                nConclusion = "Los niños con bajas puntuaciones en "+area[i]+" normalmente presentan " + nConclusion;

                //NuevaSugerencia
                String [] nS = Utilidades.Sugerencias_key.split(",");
                String nSugerencia="";
                for (int j=0; j < nS.length; j++){
                    if (nS.length>1){
                        if (j< nS.length-1){
                            nSugerencia += nS[j]+", ";
                        }else {
                            nSugerencia += " y " + nS[j]+".";
                        }
                    }else{
                        nSugerencia += nS[j]+".";
                    }
                }
                nSugerencia = "Se recomienda el uso de las siguientes pruebas: "+nSugerencia;

                base.put("sugerencias_"+area[i], nSugerencia);
                base.put("conclusiones_"+area[i], nConclusion);

                Toast.makeText(context, "Un nuevo registro se ha guardado",LENGTH_LONG).show();
//                Intent intent = new Intent(context, Home.class);
//                startActivity(intent);


                try {
                    db.insert(area[i],"id_"+area[i], base);
                }catch (Exception e){
                    Toast.makeText(context,"Error al insertar nuevos datos claves", LENGTH_LONG);
                }

                db.close();

            }
        }


    }


}
