package com.example.franko.expertwisc.Tools;

import android.content.Context;
import android.util.Log;

import com.example.franko.expertwisc.FragmentosSubTest.S;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PuntuacionCI {
    Context context ;
    String value;
    List<String> newValues;
    public PuntuacionCI() {
    }



    public List<String> PuntoCI(Context context, String value, String grupo){ //grupo = ICV, IRP, IMO, IVP, CIT
        this.context = context;
        this.value = value;

        try{
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.argentino)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null;) {
                jsonBuilder.append(line).append("\n");
            }

            //Parse Json
            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            JSONObject jsonObj = new JSONObject(tokener);
            JSONArray jsonArray = jsonObj.getJSONArray(grupo);

            for (int index = 0; index < jsonArray.length(); index++) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);

                if (value.equals(jsonObject.getString("Suma de Puntuaciones Escalares"))){
                    newValues.add(jsonObject.getString(grupo));
                    newValues.add(jsonObject.getString("Percentil"));
                    if(Utilidades.intervalo_confianza.equals("90")){
                        newValues.add(jsonObject.getString("90%"));
                    }else{
                        newValues.add(jsonObject.getString("95%"));
                    }
                }

            }

        }catch (FileNotFoundException e) {
            Log.e("jsonFile", "file not found");
        } catch (IOException e) {
            Log.e("jsonFile", "ioerror");
        } catch (JSONException e) {
            Log.e("jsonFile", "error while parsing json");
        }

        return newValues;
    }
}
