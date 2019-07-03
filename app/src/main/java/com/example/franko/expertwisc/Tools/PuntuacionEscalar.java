package com.example.franko.expertwisc.Tools;

import android.content.Context;
import android.util.Log;

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
import java.util.ArrayList;
import java.util.List;

public class PuntuacionEscalar {
    private String edad;
    Boolean r = false;
    List<String> values;
    String [] edades = {
                        "6.0-6.3","6.4-6.7","6.8-6.11",
                        "7.0-7.3","7.4-7.7","7.8-7.11",
                        "8.0-8.3","8.4-8.7","8.8-8.11",
                        "9.0-9.3","9.4-9.7","9.8-9.11",
                        "10.0-10.3","10.4-10.7","10.8-10.11",
                        "11.0-11.3","11.4-11.7","11.8-11.11",
                        "12.0-12.3","12.4-12.7","12.8-12.11",
                        "13.0-13.3","13.4-13.7","13.8-13.11",
                        "14.0-14.3","14.4-14.7","14.8-14.11",
                        "15.0-15.3","15.4-15.7","15.8-15.11",
                        "16.0-16.3","16.4-16.7","16-8-16.11"
                        };
    Context context ;

    ///List with values from activity

    public PuntuacionEscalar() {
    }


    public List<String> Punto(Context  context, List<String> values){
        this.context = context;
        String res;
        this.values = values;
        String [] sTest = {"CC","S","RD","Co","Cl","V","LN","M","C","BS","CF","A","I","Ar","Ad"};
        List<String> newValues = new ArrayList<>();

        try {
            //Load File
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.argentino)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null;) {
                jsonBuilder.append(line).append("\n");
            }

            //Parse Json
            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            JSONObject jsonObj = new JSONObject(tokener);

            for (int i = 0; i<edades.length;i++){
                String[] temp = edades[i].split("-");
                String valor = temp[1];
                //Separamos por el "."
                String [] uno = Utilidades.edadActual.split("\\.");
                String [] dos = valor.split("\\.");

                //Comparamos las edad del paciente con el grupo de edades
                if (Integer.parseInt(uno[0])<=Integer.parseInt(dos[0])){
                    if (Integer.parseInt(uno[1])<=Integer.parseInt(dos[1])){
                        edad = edades[i];
                        i=100;
                    }
                }
            }
            JSONArray jsonArray = jsonObj.getJSONArray(edad);

            for(int i = 0; i < values.size(); i++){
                for (int index = 0; index < jsonArray.length(); index++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(index);

                    String temp = jsonObject.getString(sTest[i]);
                    String[] datos;

                    if (temp.equals("")){

                    }else{
                        if (temp.contains("-")) {
                            datos = temp.split("-");
                            temp = datos[1];
                        }
                        if (values.get(i).isEmpty()){
                            res="0";
                            newValues.add(res);
                            index=100;
                        }else{
                            if (values.get(i).contains("r")){
                                r=true;
                                String[] sep = values.get(i).split("r");
                                values.set(i,sep[0]);
                            }
                            if (Integer.parseInt(values.get(i))<=Integer.parseInt(temp)){
                                if (r){
                                    res = ""+(index+1)+"r";
                                    r=false;
                                }else {
                                    res = ""+(index+1);
                                }
                                newValues.add(res);
                                index=100;
                            }else{
                                res = "Fuera de rango";
                            }
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            Log.e("jsonFile", "file not found");
        } catch (IOException e) {
            Log.e("jsonFile", "ioerror");
        } catch (JSONException e) {
            Log.e("jsonFile", "error while parsing json");
        }

        return newValues;
    }
}
