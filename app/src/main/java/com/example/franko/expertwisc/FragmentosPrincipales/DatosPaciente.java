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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Adapters.AdapterTest;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Tools.BlurBuilder;
import com.example.franko.expertwisc.Tools.PBDialog;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Context mContext;

    Bundle bundle;
    ArrayList<Test> listaTest;
    SwitchCompat switchCompat = null;
    View view;
    CircleImageView imgDatospaciente;
    EditText editNombres, editApellidos, editFechaNac, editMotivo, editAntecedentes;
    TextView  nombrePrincipal, txt_mensaje_test, cantidadTest;
    Button btn_actualizar_paciente;
    ListView listView;
    AdapterTest adapterTest;
    ConexionHelper con;
    FloatingActionButton nuevo_test;
    LinearLayout layout_datos_edit, linear_back;
    RecyclerView recyclerViewTest;

    Paciente paciente = null;
    Persona persona = null;

    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;

    private Boolean hasImageChanged = false;
    Bitmap thumbnail;

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datos_paciente, container, false);

        layout_datos_edit = view.findViewById(R.id.layout_datos_edit);
        linear_back = view.findViewById(R.id.linear_back);
        imgDatospaciente = view.findViewById(R.id.imgDatospaciente);
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
        }

        recyclerViewTest = view.findViewById(R.id.recv_pruebas);
        recyclerViewTest.setLayoutManager(new LinearLayoutManager(getContext()));
        //Enviamos fecha de prueba y el estado
        //Consultamos desde la tabla test la fecha y el estado de acuerdo al id paciente
        Test test = new Test();
        listaTest = consultarTablaTest(paciente.getId_paciente());

        cantidadTest.setText(listaTest.size()+"");

        if (listaTest.isEmpty()){
            recyclerViewTest.setVisibility(View.INVISIBLE);
        }else{
            txt_mensaje_test.setVisibility(View.GONE);
//            adapterTest =new AdapterTest(getContext(),R.layout.list_test,listaTest);

            AdapterTest adapterTest = new AdapterTest(listaTest);
            // Cargamos los datos al ListView

            recyclerViewTest.setAdapter(adapterTest);
//            listView.setAdapter(adapterTest);
        }


        nuevo_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new GeneralSubPruebas();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                //Registro de nuevo test
                RegistroTest();

                Persona persona =  new Persona();
                persona.setNombre_persona(editNombres.getText().toString());
                persona.setFecha_nacimiento_persona(editFechaNac.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putSerializable("Persona", persona);

                fragment.setArguments(bundle);

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


        return view;
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

        pacienteUpdate.put(Utilidades.CAMPO_MOTIVO_CONSULTA_PACIENTE, editMotivo.getText().toString());
        pacienteUpdate.put(Utilidades.CAMPO_ANTECEDENTES_PACIENTE, editAntecedentes.getText().toString());

        try{
            int okPersona=db.update(Utilidades.TABLA_PERSONA,personaUpdate,Utilidades.CAMPO_ID_PERSONA+"="+persona.getId_persona(),null);
            int okPaciente=db.update(Utilidades.TABLA_PACIENTE,pacienteUpdate,Utilidades.CAMPO_ID_PACIENTE+"="+paciente.getId_paciente(),null);

            if (okPaciente == 1 && okPersona == 1){
                Toast.makeText(getContext(),"Datos actualizados satisfactoriamente", Toast.LENGTH_SHORT).show();
            }



        }catch (Exception e){
            Toast.makeText(getContext(),"Error al actualizar datos del paciente", Toast.LENGTH_SHORT).show();
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


        Persona persona = null;

        //Consultamos los datos de Persona del usuario actual
        persona = consultarPersona(Utilidades.currentUserIdPersona);

        test.put(Utilidades.CAMPO_EVALUADOR_TEST, persona.getNombre_persona()+" "+persona.getApellido_persona());
        test.put(Utilidades.CAMPO_ESTADO_TEST, "EN CURSO");
        test.put(Utilidades.CAMPO_ID_PACIENTE, paciente.getId_paciente());
        Long idTest = db.insert(Utilidades.TABLA_TEST,Utilidades.CAMPO_ID_TEST,test);
        String a = Long.toString(idTest);
        int id_test = Integer.parseInt(a);
        Utilidades.currentTest = id_test;
        Toast.makeText(getContext(),"Test nro "+a,Toast.LENGTH_SHORT).show();

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
}
