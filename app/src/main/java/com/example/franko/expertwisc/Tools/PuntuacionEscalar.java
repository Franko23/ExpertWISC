package com.example.franko.expertwisc.Tools;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.franko.expertwisc.R;

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
    private String punto, edad  ="7.4-7.7", subTest = "CC";
    List<String> values;
    Context context ;

    ///List with values from activity

    public PuntuacionEscalar() {
    }


    public List<String> Punto(Context  context, List<String> values){
        this.punto = punto;
        this.context = context;
        String res="";
        this.values = values;
        String [] sTest = {"CC","S","RD","Co","Cl","V","LN","M","C","BS","CF","A","I","Ar","Ad"};
        List<String> newValues = new ArrayList<>();

        try {
            //Load File
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.edad)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null;) {
                jsonBuilder.append(line).append("\n");
            }

            //Parse Json
            JSONTokener tokener = new JSONTokener(jsonBuilder.toString());
            JSONObject jsonObj = new JSONObject(tokener);
            JSONArray jsonArray = jsonObj.getJSONArray(edad);

            for(int i = 0; i< values.size(); i++){
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

                        if (values.get(i).equals("Sin valor")){
                            res="0";
                            newValues.add(res);
                        }else{
                            if (values.get(i).contains("r")){
                                res = values.get(i);
                                newValues.add(res);
                            }else{
                                if (Integer.parseInt(values.get(i))<=Integer.parseInt(temp)){
                                    res = ""+(index+1)  ;
                                    newValues.add(res);
                                    index=100;
                                }else{
                                    res = "Fuera de rango";
                                }
                            }
                        }
//                        values.add(res);
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
