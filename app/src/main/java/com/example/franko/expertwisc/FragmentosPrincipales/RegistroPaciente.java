package com.example.franko.expertwisc.FragmentosPrincipales;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.Usuario;
import com.example.franko.expertwisc.Home;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.Tools.PBDialog;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroPaciente.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroPaciente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroPaciente extends Fragment implements DatePickerDialog.OnShowListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;

    View view;
    TextInputEditText nombres, apellidos, motivoConsulta, antecedentes ,t1, t2;

    ImageView imageView;
    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;
    Bitmap thumbnail;

    CircularProgressButton circularProgressButton;

    Button empezar, calcular;
    ArrayList<Paciente> listaPacientes;
    ConexionHelper con;

    TextView Edad;
    int AñoNac, AñoEva, MesNac, MesEva, DiaNac, DiaEva, AñoTotal, MesTotal, DiaTotal, id_paciente;
    String EdadFinal;

    private OnFragmentInteractionListener mListener;


    public RegistroPaciente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroPaciente.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroPaciente newInstance(String param1, String param2) {
        RegistroPaciente fragment = new RegistroPaciente();
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
//        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
////            appCompatImageView.setEnabled(false);
//            ActivityCompat.requestPermissions(getActivity(), new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
//        }
//        else {
//            appCompatImageView.setEnabled(true);
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_registro_paciente, container, false);

        con = new ConexionHelper(getContext(),"bd_wisc", null, 1);

        nombres = view.findViewById(R.id.txtNombres);
        apellidos = view.findViewById(R.id.txtApellidos) ;
        motivoConsulta = view.findViewById(R.id.txtMotivoConsulta) ;
        antecedentes = view.findViewById(R.id.txtAntecedentes) ;
        empezar = view.findViewById(R.id.empezartest);
        circularProgressButton = view.findViewById(R.id.empezartest);
        calcular = view.findViewById(R.id.calcular);

        t1 = view.findViewById(R.id.txtFechaNacimiento);
        t2 = view.findViewById(R.id.txtFechaEvaluacion);
        Edad = view.findViewById(R.id.edad);

        imageView = view.findViewById(R.id.imgPaciente);

        final Calendar calendario = Calendar.getInstance();
        final int yy = calendario.get(Calendar.YEAR);
        final int mm = calendario.get(Calendar.MONTH);
        final int dd = calendario.get(Calendar.DAY_OF_MONTH);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =  new AlertDialog.Builder(getContext());
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
                                imageView.setImageResource(R.drawable.n_user);
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


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String fecha = String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear+1)
                                +"-"+String.valueOf(year);
                        t1.setText(fecha);
                        AñoNac = year;
                        MesNac =monthOfYear;
                        DiaNac = dayOfMonth;

                    }
                }, yy, mm, dd);

                datePicker.show();

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int yy = calendario.get(Calendar.YEAR);
//                int mm = calendario.get(Calendar.MONTH);
//                int dd = calendario.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String fecha = String.valueOf(dayOfMonth)+"-"+String.valueOf(monthOfYear+1)
                                +"-"+String.valueOf(year);
                        t2.setText(fecha);
                        AñoEva = year;
                        MesEva = monthOfYear;
                        DiaEva = dayOfMonth;
                    }
                }, yy, mm, dd);

                datePicker.show();

                calcular.setVisibility(View.VISIBLE);
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AñoTotal = AñoEva - AñoNac;
                if(MesEva>=MesNac){
                    MesTotal = MesEva - MesNac;
                    if (MesEva==MesNac){
                        if (DiaEva<DiaNac){
                            AñoTotal--;
                            MesTotal = 12 - ((MesNac+1) - MesEva);
                        }
                    }

                }else{
                    AñoTotal--;
                    MesTotal = 12 - (MesNac - MesEva);
                }

                EdadFinal = AñoTotal+"."+MesTotal; //Setteamos el formato de la edad
                String mes = "meses";
                if (MesTotal == 1){
                    mes = "mes";
                }
                Edad.setText("Edad: "+ AñoTotal+" años y "+MesTotal+" "+mes);

                Edad.setVisibility(View.VISIBLE);
                empezar.setVisibility(View.VISIBLE);
            }
        });

        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Registramos al nuevo Paciente
                registrarPaciente();

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("¿DESEA COMENZAR CON EL TEST?");
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SQLiteDatabase db = con.getWritableDatabase();

                        //Insertamos los datos del test en la tabla test
                        ContentValues test = new ContentValues();
                        test.put(Utilidades.CAMPO_FECHA_TEST,t2.getText().toString());
                        //Consultamos el usuario actual
                        int id = consultarUsuarioActivo();
                        Persona persona = null;

                        //Consultamos los datos de Persona del usuario actual
                        persona = consultarPersona(id);

                        test.put(Utilidades.CAMPO_EVALUADOR_TEST, persona.getNombre_persona()+" "+persona.getApellido_persona());
                        test.put(Utilidades.CAMPO_ID_PACIENTE, id_paciente);
                        test.put(Utilidades.CAMPO_ESTADO_TEST, "EN CURSO");
                        Long idTest = db.insert(Utilidades.TABLA_TEST,Utilidades.CAMPO_ID_TEST,test);
                        String a = Long.toString(idTest);
                        int idTestInt = Integer.parseInt(a);

                        //Actualizamos el CAMPO_ID_TEST de la tabla paciente
                        ContentValues paciente = new ContentValues();
                        paciente.put(Utilidades.CAMPO_ID_TEST,idTestInt);
                        int ResUpdatePaciente = db.update(Utilidades.TABLA_PACIENTE,paciente,Utilidades.CAMPO_ID_PACIENTE+"="+id_paciente ,null);
                        String res = Integer.toString(ResUpdatePaciente);

                        Toast.makeText(getContext(),"Id_Test "+a + " Update "+res,  Toast.LENGTH_SHORT).show();

                        Fragment fragment = new GeneralSubPruebas();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();

                        Bundle bundle = new Bundle();
                        bundle.putString("Nombres", nombres.getText().toString() + " "+apellidos.getText().toString());
                        bundle.putString("Edad", Edad.getText().toString());

                        Bundle bundleMaster = new Bundle();
                        bundleMaster.putBundle("datos",bundle);

                        fragment.setArguments(bundleMaster);

                        transaction.replace(R.id.content_main, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();

                    }
                }
                );
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Fragment fragment = new ListaPacientes();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.content_main, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        return view;
    }

    private Persona consultarPersona(int id) {
        SQLiteDatabase db = con.getReadableDatabase();
        Persona persona = null;

        Cursor cursor = db.rawQuery("SELECT * FROM persona WHERE id_persona="+id,null);
        while (cursor.moveToNext()){
            persona = new Persona();

            persona.setNombre_persona(cursor.getString(1));
            persona.setApellido_persona(cursor.getString(2));
        }

        return persona;
    }

    private int consultarUsuarioActivo() {
        SQLiteDatabase db = con.getReadableDatabase();
        int id = 0;
        Cursor cursor = db.rawQuery("SELECT id_usuario FROM usuario WHERE activo_usuario = 1",null );

        if (cursor.getCount()>0) {

            while (cursor.moveToNext()) {
                id = cursor.getInt(0);
            }
        }

        return id;
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

    @Override
    public void onShow(DialogInterface dialog) {

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


    private void registrarPaciente() {
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap =  imageView.getDrawingCache();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] data = baos.toByteArray();

        if (nombres.getText().toString().isEmpty()||apellidos.getText().toString().isEmpty())
        {
            Toast.makeText(getContext(),"Ingrese Valores", Toast.LENGTH_SHORT).show();
        }
        else {


            SQLiteDatabase db = con.getWritableDatabase();

            ContentValues persona = new ContentValues();
            persona.put(Utilidades.CAMPO_NOMBRE_PERSONA, nombres.getText().toString());
            persona.put(Utilidades.CAMPO_APELLIDO_PERSONA, apellidos.getText().toString());
            persona.put(Utilidades.CAMPO_EDAD_PERSONA, EdadFinal);
            persona.put(Utilidades.CAMPO_IMAGEN_PERSONA, data);
            persona.put(Utilidades.CAMPO_TIPO_PERSONA, "paciente");

            try {
                PBDialog PBDialog = new PBDialog(getContext());
                PBDialog.setProgressBar();

                //Insertamos en la tabla persona
                Long idPersona=db.insert(Utilidades.TABLA_PERSONA, Utilidades.CAMPO_ID_PERSONA, persona);
                //Obtenemos el id del Log y convertimos en String y luego en int
                String a = Long.toString(idPersona);
                int number = Integer.parseInt(a);

                ContentValues paciente = new ContentValues();
                paciente.put(Utilidades.CAMPO_MOTIVO_CONSULTA_PACIENTE, motivoConsulta.getText().toString());
                paciente.put(Utilidades.CAMPO_ANTECEDENTES_PACIENTE, antecedentes.getText().toString());
                paciente.put(Utilidades.CAMPO_ID_PERSONA, number);

                Long idPaciente=db.insert(Utilidades.TABLA_PACIENTE, Utilidades.CAMPO_ID_PACIENTE, paciente);
                //Obtenemos el id del Log y convertimos en String y luego en int
                String b = Long.toString(idPaciente);
                id_paciente = Integer.parseInt(b);
                Toast.makeText(getContext(),"Persona "+a + " Paciente "+b, Toast.LENGTH_SHORT).show();

                db.close();

            }catch (Exception e){

                Toast.makeText(getContext(),"Error al registrar paciente", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                imageView.setEnabled(true);
            }
        }
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
                    imageView.setImageBitmap(selectedImage);


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
        imageView.setImageBitmap(thumbnail);

    }
}
