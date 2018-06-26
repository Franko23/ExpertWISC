package com.example.franko.expertwisc.FragmentosPrincipales;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Adapters.AdapterTest;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestA;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestAd;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestAr;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestBS;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestC;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCC;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCF;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCl;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCo;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestI;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestLN;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestM;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestRD;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestS;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestV;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.FragmentosSubTest.V;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.BlurBuilder;
import com.example.franko.expertwisc.Tools.CalcularEdad;
import com.example.franko.expertwisc.Tools.PBDialog;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DatosPaciente.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DatosPaciente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatosPaciente extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="FireDatos";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;

    Bundle bundle;
    ArrayList<Test> listaTest;
    SwitchCompat switchCompat = null;
    View view;
    CircleImageView imgDatospaciente;
    ImageView up_paciente;
    EditText editNombres, editApellidos, editFechaNac, editMotivo, editAntecedentes;
    TextView  nombrePrincipal, txt_mensaje_test, cantidadTest;
    Button btn_actualizar_paciente;
    ConexionHelper con;
    FloatingActionButton nuevo_test;
    LinearLayout layout_datos_edit, linear_back;
    RecyclerView recyclerViewTest;

    Paciente paciente = null;
    Persona persona = null;
    Test test = null;

    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;

    private Boolean hasImageChanged = false;
    Bitmap thumbnail;

    private long backPressed;
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();
    private OnFragmentInteractionListener mListener;

    public DatosPaciente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatosPaciente.
     */
    // TODO: Rename and change types and number of parameters
    public static DatosPaciente newInstance(String param1, String param2) {
        DatosPaciente fragment = new DatosPaciente();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        con = new ConexionHelper(getContext(), "bd_wisc", null, 1);
        Utilidades.rotacionFab=1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datos_paciente, container, false);

        layout_datos_edit = view.findViewById(R.id.layout_datos_edit);
        linear_back = view.findViewById(R.id.linear_back);
        imgDatospaciente = view.findViewById(R.id.imgDatospaciente);
        up_paciente = view.findViewById(R.id.up_paciente);
        switchCompat = view.findViewById(R.id.swicth_profile);
        nombrePrincipal = view.findViewById(R.id.nombrePrincipal);
        editNombres = view.findViewById(R.id.EditNombres);
        editApellidos= view.findViewById(R.id.EditApellido);
        editFechaNac = view.findViewById(R.id.EditFechaNac);
        editMotivo = view.findViewById(R.id.EditMotivo);
        editAntecedentes = view.findViewById(R.id.EditAntecedentes);
        nuevo_test = view.findViewById(R.id.nuevo_test);
        btn_actualizar_paciente = view.findViewById(R.id.btn_actualizar_paciente);
//        listView = view.findViewById(R.id.listv_pruebas);
        txt_mensaje_test = view.findViewById(R.id.txt_mensaje_test);
        cantidadTest = view.findViewById(R.id.cantidad_test);


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchCompat.isChecked()){
                    layout_datos_edit.setVisibility(View.VISIBLE);
                    imgDatospaciente.setEnabled(true);

                }else{
                    layout_datos_edit.setVisibility(View.GONE);
                    imgDatospaciente.setEnabled(false);
                }
            }
        });

        bundle = getArguments();


        if (bundle!= null){

            paciente = (Paciente) bundle.getBundle("Paciente").getSerializable("paciente");
            persona = (Persona) bundle.getBundle("Persona").getSerializable("persona");

            nombrePrincipal.setText(persona.getNombre_persona() + " "+persona.getApellido_persona());

            editNombres.setText(persona.getNombre_persona());
            editApellidos.setText(persona.getApellido_persona());
            editFechaNac.setText(persona.getFecha_nacimiento_persona());
            CalcularEdad calcularEdad = new CalcularEdad(persona.getFecha_nacimiento_persona());
            calcularEdad.CalcularEdad();
            byte[] image = persona.getImagen_persona();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
            imgDatospaciente.setImageBitmap(bitmap);
            editMotivo.setText(paciente.getMotivoConsulta_paciente());
            editAntecedentes.setText(paciente.getAntecedentes_paciente());
            //Enviamos el bitmap para recibir un BlurImage
            Bitmap imageBlur = BlurBuilder.blur(getContext(), bitmap);
            try{
                Drawable newImage = ConvertBitmapToDrawable(imageBlur);
                linear_back.setBackground(newImage);
            }catch (Exception e){

            }
            if (persona.getUp_persona().equals("NO")){
                up_paciente.setVisibility(View.VISIBLE);
            }

        }

        recyclerViewTest = view.findViewById(R.id.recv_pruebas);
        recyclerViewTest.setLayoutManager(new LinearLayoutManager(getContext()));
        //Enviamos fecha de prueba y el estado
        //Consultamos desde la tabla test la fecha y el estado de acuerdo al id paciente

        listaTest = consultarTablaTest(paciente.getId_paciente());

        AdapterTest adapterTest = new AdapterTest(listaTest);
        recyclerViewTest.setAdapter(adapterTest);
        cantidadTest.setText(listaTest.size()+"");

        if (listaTest.isEmpty()){
            recyclerViewTest.setVisibility(View.INVISIBLE);
        }else{
            txt_mensaje_test.setVisibility(View.GONE);
        }


        adapterTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView up = v.findViewById(R.id.up_test);
                TextView estado = v.findViewById(R.id.estado);

                up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//
                        if (up_paciente.getVisibility()==View.VISIBLE){
                            Toast.makeText(getContext(),"PRIMERO DEBE DE SUBIR LOS DATOS DEL PACIENTE" ,Toast.LENGTH_SHORT).show();
                        }else if(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getUp_test().equals("NO")) {


                            Map<String, Object> newTest = new HashMap<>();

                            Calendar calendar = Calendar.getInstance();
                            SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
                            String fechaActual = mdformat.format(calendar.getTime());

                            newTest.put("fechaTest",fechaActual);
                            newTest.put("edadPaciente",Utilidades.edadActual);


                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString()).collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .set(newTest)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "Test actualizado corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SQLiteDatabase db = con.getWritableDatabase();
                                            ContentValues personaUpdate = new ContentValues();
                                            personaUpdate.put(Utilidades.CAMPO_UP_TEST,"SI");
                                            try {
                                                int okTest=db.update(Utilidades.TABLA_TEST,personaUpdate,Utilidades.CAMPO_ID_TEST+"="+listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test(),null);
                                                if (okTest==1){
                                                    Snackbar.make(view, "Test actualizado corectamente, ya puede subir los SubTest", Snackbar.LENGTH_LONG).show();
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar Test", Toast.LENGTH_SHORT).show();
                                            }



                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo test", e);
                                        }
                                    });
                        }else{
                            Test test = new Test();
                            test.Valores();
                            ConsultaView(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());

                            Map<String, Object> subTestCC = new HashMap<>();
                            subTestCC.put("ResultadoCC",Utilidades.R_cc);
                            subTestCC.put("ResultadoCCS","");
                            Map<String, Object> subTestS = new HashMap<>();
                            subTestS.put("S",Utilidades.R_s);
                            Map<String, Object> subTestRD = new HashMap<>();
                            subTestRD.put("RD",Utilidades.R_rd);
                            Map<String, Object> subTestCo = new HashMap<>();
                            subTestCo.put("Co",Utilidades.R_co);
                            Map<String, Object> subTestCl = new HashMap<>();
                            subTestCl.put("Cl",Utilidades.R_cl);
                            Map<String, Object> subTestV = new HashMap<>();
                            subTestV.put("V",Utilidades.R_v);
                            Map<String, Object> subTestLN = new HashMap<>();
                            subTestLN.put("LN",Utilidades.R_ln);
                            Map<String, Object> subTestM= new HashMap<>();
                            subTestM.put("M",Utilidades.R_m);
                            Map<String, Object> subTestC = new HashMap<>();
                            subTestC.put("C",Utilidades.R_c);
                            Map<String, Object> subTestBS = new HashMap<>();
                            subTestBS.put("BS",Utilidades.R_bs);
                            Map<String, Object> subTestCF = new HashMap<>();
                            subTestCF.put("CF",Utilidades.R_cf);
                            Map<String, Object> subTestA = new HashMap<>();
                            subTestA.put("A",Utilidades.R_a);
                            Map<String, Object> subTestI = new HashMap<>();
                            subTestI.put("I",Utilidades.R_i);
                            Map<String, Object> subTestAr = new HashMap<>();
                            subTestAr.put("Ar",Utilidades.R_ar);
                            Map<String, Object> subTestAd = new HashMap<>();
                            subTestAd.put("Ad",Utilidades.R_ad);


                            SQLiteDatabase db = con.getWritableDatabase();

                            //Subimos el SubTest CC
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("CC")
                                    .set(subTestCC)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestCC subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestCC testCC = new SubTestCC();
                                            testCC.ConsultaCC(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_CC,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CC,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_CC+"="+testCC.getId_CC(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestCC actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestCC", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestC", e);
                                        }
                                    });

                            //Subimos el SubTest S
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("S")
                                    .set(subTestCC)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestS subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestS testS = new SubTestS();
                                            testS.ConsultaS(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_S,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_S,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_S+"="+testS.getId_S(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestS actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestS", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestS ", e);
                                        }
                                    });


                            //Subimos el SubTest RD
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("RD")
                                    .set(subTestRD)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestRD subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestRD testRD = new SubTestRD();
                                            testRD.ConsultaRD(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_RD,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_RD,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_RD+"="+testRD.getId_RD(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestRD actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestRD", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestRD ", e);
                                        }
                                    });


                            //Subimos el SubTest Co
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("Co")
                                    .set(subTestCo)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestCo subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestCo testCo = new SubTestCo();
                                            testCo.ConsultaCo(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_CO,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CO,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_CO+"="+testCo.getId_Co(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestCo actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestCo", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestCo ", e);
                                        }
                                    });



                            //Subimos el SubTest Cl
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("Cl")
                                    .set(subTestCl)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestCl subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestCl testCl = new SubTestCl();
                                            testCl.ConsultaCl(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_CL,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CL,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_CL+"="+testCl.getId_Cl(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestCl actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestCl", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestCL ", e);
                                        }
                                    });



                            //Subimos el SubTest V
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("V")
                                    .set(subTestV)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestV subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestV testV = new SubTestV();
                                            testV.ConsultaV(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_V,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_V,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_V+"="+testV.getId_V(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestV actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestV", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestV ", e);
                                        }
                                    });

                            //Subimos el SubTest LN
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("LN")
                                    .set(subTestLN)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestLN subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestLN testLN = new SubTestLN();
                                            testLN.ConsultaLN(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_LN,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_LN,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_LN+"="+testLN.getId_LN(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestLN actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestLN", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestLN ", e);
                                        }
                                    });


                            //Subimos el SubTest M
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("M")
                                    .set(subTestM)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestM subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestM testM = new SubTestM();
                                            testM.ConsultaM(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_M,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_M,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_M+"="+testM.getId_M(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestM actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestM", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestM ", e);
                                        }
                                    });



                            //Subimos el SubTest C
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("C")
                                    .set(subTestC)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestC subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestC testC = new SubTestC();
                                            testC.ConsultaC(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_C,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_C,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_C+"="+testC.getId_C(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestC actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestC", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestC ", e);
                                        }
                                    });

                            //Subimos el SubTest BS
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("BS")
                                    .set(subTestBS)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestBS subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestBS testBS = new SubTestBS();
                                            testBS.ConsultaBS(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_BS,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_BS,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_BS+"="+testBS.getId_BS(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestBS actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestBS", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestBS ", e);
                                        }
                                    });


                            //Subimos el SubTest CF
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("CF")
                                    .set(subTestCF)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestCF subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestCF testCF = new SubTestCF();
                                            testCF.ConsultaCF(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_CF,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_CF,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_CF+"="+testCF.getId_CF(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestCF actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestCF", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestCF ", e);
                                        }
                                    });


                            //Subimos el SubTest A
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("A")
                                    .set(subTestA)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestA subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestA testA = new SubTestA();
                                            testA.ConsultaA(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_A,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_A,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_A+"="+testA.getId_A(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestA actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestA", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestA ", e);
                                        }
                                    });



                            //Subimos el SubTest I
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("I")
                                    .set(subTestI)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestI subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestI testI = new SubTestI();
                                            testI.ConsultaI(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_I,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_I,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_I+"="+testI.getId_I(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestI actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestI", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestI", e);
                                        }
                                    });


                            //Subimos el SubTest Ad
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("Ad")
                                    .set(subTestAd)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestAd subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestAd testAd = new SubTestAd();
                                            testAd.ConsultaAd(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_AD,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_AD,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_AD+"="+testAd.getId_Ad(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestAd actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestAd", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestAd ", e);
                                        }
                                    });


                            //Subimos el SubTest Ar
                            dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                                    .collection("test").document(listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test().toString())
                                    .collection("subTest").document("Ar")
                                    .set(subTestAr)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "SubTestAr subido corectamente");
                                            up.setVisibility(View.INVISIBLE);

                                            SubTestAr testAr = new SubTestAr();
                                            testAr.ConsultaAr(getContext(),listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test());


                                            ContentValues subTestUpdate = new ContentValues();
                                            subTestUpdate.put(Utilidades.CAMPO_UP_AR,"SI");

                                            try {
                                                int okTest=db.update(Utilidades.TABLA_PUNTUACIONES_AR,subTestUpdate,Utilidades.CAMPO_ID_PUNTUACION_AR+"="+testAr.getId_Ar(),null);
                                                if (okTest==1){
                                                    Log.d(TAG, "SubTestAr actualizado corectamente");
                                                }
                                            }catch (Exception e){
                                                Toast.makeText(getContext(),"Error al actualizar SubTestAr", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error subiendo SubTestA ", e);
                                        }
                                    });
                        }

                    }
                });

                estado.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(getContext(),"ESTADO"+String.valueOf(recyclerViewTest.getChildAdapterPosition(v)),Toast.LENGTH_SHORT).show();
                        String estado = listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getEstado_test();
                        int id_test = listaTest.get(recyclerViewTest.getChildAdapterPosition(v)).getId_test();
                        Utilidades.currentTest=id_test;
                        if (estado.equals("EN CURSO")){
                            PBDialog PBDialog = new PBDialog(getContext());
                            PBDialog.setProgressBar();
                            Test test = new Test();
                            test.Valores();
                            ConsultaView(id_test);
                            Persona persona =  new Persona();
                            persona.setNombre_persona(editNombres.getText().toString());
                            persona.setFecha_nacimiento_persona(editFechaNac.getText().toString());
                            Fragment fragment =  new GeneralSubPruebas();
                            getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

                        }else if (estado.equals("FINALIZADO")){
                            PBDialog PBDialog = new PBDialog(getContext());
                            PBDialog.setProgressBar();
                            Test test = new Test();
                            test.Valores();
                            ConsultaView(id_test);

                            Fragment fragment =  new Resultados();
                            getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        //                    Toast.makeText(getContext(),estado,Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        nuevo_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new GeneralSubPruebas();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Test test = new Test();
                test.Valores();
                //Registro de nuevo test
                RegistroTest();

                //Registramos los SubTest de el Test Actual
                RegistrarSubTest();

                Persona persona =  new Persona();
                persona.setNombre_persona(editNombres.getText().toString());
                persona.setFecha_nacimiento_persona(editFechaNac.getText().toString());

                transaction.replace(R.id.content_main, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        btn_actualizar_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarPaciente();
            }
        });

        editFechaNac.setOnClickListener(new View.OnClickListener() {
            final Calendar calendario = Calendar.getInstance();
            final int yy = calendario.get(Calendar.YEAR);
            final int mm = calendario.get(Calendar.MONTH);
            final int dd = calendario.get(Calendar.DAY_OF_MONTH);
            @Override
            public void onClick(View view) {

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        editFechaNac.setText( String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear+1)
                                +"-"+String.valueOf(year));

                    }
                }, yy, mm, dd);
                datePicker.show();

            }
        });

        imgDatospaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(false);
                builder.setTitle("Selecciona una opción:");
                builder.setItems(R.array.uploadImages, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                                photoPickerIntent.setType("image/*");
                                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                                break;
                            case 1:
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, CAPTURE_PHOTO);
                                break;
                            case 2:
                                imgDatospaciente.setImageResource(R.drawable.n_user);
                                break;
                        }

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //the user clicked on Cancel
                    }
                });
                builder.show();
            }
        });


        up_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirPaciente();
            }
        });

        return view;
    }

    private void RegistrarSubTest() {

        SubTestCC testCC = new SubTestCC();
        testCC.RegistrarCC(getContext());
        SubTestS subTestS = new SubTestS();
        subTestS.RegistrarS(getContext());
        SubTestRD subTestRD= new SubTestRD();
        subTestRD.RegistrarRD(getContext());
        SubTestCo subTestCo = new SubTestCo();
        subTestCo.RegistrarCo(getContext());
        SubTestCl subTestCl = new SubTestCl();
        subTestCl.RegistrarCl(getContext());
        SubTestV subTestV = new SubTestV();
        subTestV.RegistrarV(getContext());
        SubTestLN subTestLN = new SubTestLN();
        subTestLN.RegistrarLN(getContext());
        SubTestM subTestM = new SubTestM();
        subTestM.RegistrarM(getContext());
        SubTestC subTestC= new SubTestC();
        subTestC.RegistrarC(getContext());
        SubTestBS subTestBS = new SubTestBS();
        subTestBS.RegistrarBS(getContext());
        SubTestCF subTestCF = new SubTestCF();
        subTestCF.RegistrarCF(getContext());
        SubTestA subTestA = new SubTestA();
        subTestA.RegistrarA(getContext());
        SubTestI subTestI= new SubTestI();
        subTestI.RegistrarI(getContext());
        SubTestAr subTestAr = new SubTestAr();
        subTestAr.RegistrarAr(getContext());
        SubTestAd subTestAd = new SubTestAd();
        subTestAd.RegistrarAd(getContext());

    }

    private void subirPaciente() {
        Map<String, Object> newPersona = new HashMap<>();

        newPersona.put("nombres",editNombres.getText().toString());
        newPersona.put("apellidos",editApellidos.getText().toString());
        newPersona.put("fechaNacimiento",editFechaNac.getText().toString());

        Bitmap bitmap =  imgDatospaciente.getDrawingCache();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] data = baos.toByteArray();

        newPersona.put("imagen",String.valueOf(data));
        newPersona.put("motivo", editMotivo.getText().toString());
        newPersona.put("antecedentes",editAntecedentes.getText().toString());

        dbFire.collection("usuarios").document(Utilidades.currentUser).collection("pacientes").document(paciente.getId_paciente().toString())
                .set(newPersona)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Paciente subido corectamente");
                        up_paciente.setVisibility(View.INVISIBLE);

                        SQLiteDatabase db = con.getWritableDatabase();
                        ContentValues personaUpdate = new ContentValues();
                        personaUpdate.put(Utilidades.CAMPO_UP_PERSONA,"SI");
                        try {
                            int okPersona=db.update(Utilidades.TABLA_PERSONA,personaUpdate,Utilidades.CAMPO_ID_PERSONA+"="+persona.getId_persona(),null);
                            if (okPersona==1){
                                Snackbar.make(view, "Datos subidos correctamente", Snackbar.LENGTH_LONG).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getContext(),"Error al actualizar Datos del paciente", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error subiendo paciente", e);
                    }
                });
    }

    private void ConsultaView(int id_test) {
        SQLiteDatabase db = con.getReadableDatabase();

        SubTestCC subTestCC = new SubTestCC();
        subTestCC.ConsultaCC(getContext(), id_test);
        SubTestS subTestS = new SubTestS();
        subTestS.ConsultaS(getContext(),id_test);
        SubTestRD subTestRD= new SubTestRD();
        subTestRD.ConsultaRD(getContext(),id_test);
        SubTestCo subTestCo = new SubTestCo();
        subTestCo.ConsultaCo(getContext(),id_test);
        SubTestCl subTestCl = new SubTestCl();
        subTestCl.ConsultaCl(getContext(),id_test);
        SubTestV subTestV = new SubTestV();
        subTestV.ConsultaV(getContext(),id_test);
        SubTestLN subTestLN = new SubTestLN();
        subTestLN.ConsultaLN(getContext(),id_test);
        SubTestM subTestM = new SubTestM();
        subTestM.ConsultaM(getContext(),id_test);
        SubTestC subTestC= new SubTestC();
        subTestC.ConsultaC(getContext(),id_test);
        SubTestBS subTestBS = new SubTestBS();
        subTestBS.ConsultaBS(getContext(),id_test);
        SubTestCF subTestCF = new SubTestCF();
        subTestCF.ConsultaCF(getContext(),id_test);
        SubTestA subTestA = new SubTestA();
        subTestA.ConsultaA(getContext(),id_test);
        SubTestI subTestI= new SubTestI();
        subTestI.ConsultaI(getContext(),id_test);
        SubTestAr subTestAr = new SubTestAr();
        subTestAr.ConsultaAr(getContext(),id_test);
        SubTestAd subTestAd = new SubTestAd();
        subTestAd.ConsultaAd(getContext(),id_test);

        Test test = new Test();
        test.ConsultaIntervalo(getContext(),id_test);

    }

    private Drawable ConvertBitmapToDrawable(Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(getResources(),bitmap);
        return drawable;
    }

    private void actualizarPaciente() {

        imgDatospaciente.setDrawingCacheEnabled(true);
        imgDatospaciente.buildDrawingCache();

        Bitmap bitmap =  imgDatospaciente.getDrawingCache();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] data = baos.toByteArray();

        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues personaUpdate = new ContentValues();
        ContentValues pacienteUpdate = new ContentValues();

        personaUpdate.put(Utilidades.CAMPO_NOMBRE_PERSONA, editNombres.getText().toString());
        personaUpdate.put(Utilidades.CAMPO_APELLIDO_PERSONA, editApellidos.getText().toString());
        personaUpdate.put(Utilidades.CAMPO_FECHA_NACIMIENTO_PERSONA, editFechaNac.getText().toString());
        personaUpdate.put(Utilidades.CAMPO_IMAGEN_PERSONA, data);
        personaUpdate.put(Utilidades.CAMPO_UP_PERSONA,"NO");

        pacienteUpdate.put(Utilidades.CAMPO_MOTIVO_CONSULTA_PACIENTE, editMotivo.getText().toString());
        pacienteUpdate.put(Utilidades.CAMPO_ANTECEDENTES_PACIENTE, editAntecedentes.getText().toString());

        try{
            int okPersona=db.update(Utilidades.TABLA_PERSONA,personaUpdate,Utilidades.CAMPO_ID_PERSONA+"="+persona.getId_persona(),null);
            int okPaciente=db.update(Utilidades.TABLA_PACIENTE,pacienteUpdate,Utilidades.CAMPO_ID_PACIENTE+"="+paciente.getId_paciente(),null);

            if (okPaciente == 1 && okPersona == 1){
//                Toast.makeText(getContext(),"Datos actualizados satisfactoriamente", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Datos actualizados satisfactoriamente", Snackbar.LENGTH_LONG).show();
                nombrePrincipal.setText(editNombres.getText().toString()+" "+editApellidos.getText().toString());
                layout_datos_edit.setVisibility(View.GONE);
                switchCompat.setChecked(false);
                up_paciente.setVisibility(View.VISIBLE);
            }


        }catch (Exception e){
            Toast.makeText(getContext(),"Error al actualizar Datos del paciente", Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

    private void RegistroTest() {
        SQLiteDatabase db = con.getWritableDatabase();

        //Insertamos los datos del test en la tabla test
        ContentValues test = new ContentValues();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = mdformat.format(calendar.getTime());

        test.put(Utilidades.CAMPO_FECHA_TEST,fechaActual);
        test.put(Utilidades.CAMPO_EDAD_TEST, Utilidades.edadActual);

        Persona persona = null;

        //Consultamos los Datos de Persona del usuario actual
        persona = consultarPersona(Utilidades.currentUserIdPersona);

        test.put(Utilidades.CAMPO_EVALUADOR_TEST, persona.getNombre_persona()+" "+persona.getApellido_persona());
        test.put(Utilidades.CAMPO_ESTADO_TEST, "EN CURSO");
        test.put(Utilidades.CAMPO_EDAD_TEST, Utilidades.edadActual);
        test.put(Utilidades.CAMPO_UP_TEST, "NO");
        test.put(Utilidades.CAMPO_ID_PACIENTE, paciente.getId_paciente());

        Long idTest = db.insert(Utilidades.TABLA_TEST,Utilidades.CAMPO_ID_TEST,test);
        String a = Long.toString(idTest);
        int id_test = Integer.parseInt(a);
        Utilidades.currentTest = id_test;

        db.close();

    }

    private Persona consultarPersona(int id) {
        SQLiteDatabase db = con.getReadableDatabase();
        Persona persona = null;

        Cursor cursor = db.rawQuery("SELECT * FROM persona WHERE id_persona="+id,null);
        while (cursor.moveToNext()){
            persona = new Persona();

            persona.setNombre_persona(cursor.getString(1));
            persona.setApellido_persona(cursor.getString(2));
            persona.setFecha_nacimiento_persona(cursor.getString(3));
        }

        return persona;
    }

    private ArrayList<Test> consultarTablaTest(Integer id_paciente) {
        SQLiteDatabase db = con.getReadableDatabase();
        Test test = null;
        listaTest = new ArrayList<>();


        Cursor cursor = db.rawQuery("SELECT * FROM test WHERE id_paciente"+"="+id_paciente,null);

        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                test = new Test();

                test.setId_test(cursor.getInt(0));
                test.setFecha_test(cursor.getString(1));
                test.setEvaluador_test(cursor.getString(2));
                test.setEstado_test(cursor.getString(3));
                test.setIntervalo_confianza(cursor.getString(4));
                test.setEdad_test(cursor.getString(5));
                test.setUp_test(cursor.getString(6));

                listaTest.add(test);
            }
        }
        db.close();
        return listaTest;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO){
            if(resultCode == RESULT_OK) {
                final Uri imageUri = data.getData();
                try {

//                    final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                    final InputStream imageStream = mContext.getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    //set Progress Bar
//                    setProgressBar();
                    //set profile picture form gallery
                    PBDialog PBDialog = new PBDialog(mContext);
                    PBDialog.setProgressBar();
                    imgDatospaciente.setImageBitmap(selectedImage);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }else if(requestCode == CAPTURE_PHOTO){
            if(resultCode == RESULT_OK) {
                onCaptureImageResult(data);
            }
        }
    }

    private void onCaptureImageResult(Intent data) {
        thumbnail = (Bitmap) data.getExtras().get("data");

        PBDialog PBDialog = new PBDialog(getContext());
        PBDialog.setProgressBar();
        //set Progress Bar
//        setProgressBar();
        //set profile picture form camera
//        appCompatImageView.setMaxWidth(300);
        imgDatospaciente.setImageBitmap(thumbnail);

    }

    @Override
    public void onResume() {
        super.onResume();
        if(getView() == null){
            return;
        }

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Fragment inicio = new ListaPacientes();
                    getFragmentManager().beginTransaction().replace(R.id.content_main,inicio).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
