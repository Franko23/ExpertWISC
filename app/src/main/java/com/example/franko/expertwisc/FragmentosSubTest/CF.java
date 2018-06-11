package com.example.franko.expertwisc.FragmentosSubTest;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.SubTest.SubTestC;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCC;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCF;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCo;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestM;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CF.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CF extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Dialog myDialog;
    ImageView imageView;
    View view;
    TextView txt_titulo;
    Button guardar;
    EditText res_cf;
    RadioButton radioButtonCC, radioButtonCo, radioButtonM;
    private OnFragmentInteractionListener mListener;

    public CF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CF.
     */
    // TODO: Rename and change types and number of parameters
    public static CF newInstance(String param1, String param2) {
        CF fragment = new CF();
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
        myDialog = new Dialog(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_cf, container, false);

        res_cf = view.findViewById(R.id.res_cf);
        guardar = view.findViewById(R.id.guardar_cf);
        imageView = view.findViewById(R.id.show_cf);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtclose;
                Button btnFollow;
                myDialog.setContentView(R.layout.pop_up_cf);
                txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });

        res_cf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableSubmitIfReady();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(res_cf.getText().toString())<=38){
                    SubTestCF subTestCF = new SubTestCF();
                    subTestCF.setPuntuacionDirectaTotalCF(res_cf.getText().toString());
                    subTestCF.RegistrarCF(getContext());
                    Utilidades.R_cf = (res_cf.getText().toString());
                    guardar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                    Toast.makeText(getContext(),Utilidades.R_cf+" GUARDADO",Toast.LENGTH_SHORT).show();
                    Dialogreemplazo();
                }else{
                    Toast.makeText(getContext(),"El valor no debe de ser mayor a 38",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void Dialogreemplazo() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_rp, null);

        radioButtonCC = alertLayout.findViewById(R.id.radioButtonCc);
        radioButtonCo = alertLayout.findViewById(R.id.radioButtonCo);
        radioButtonM = alertLayout.findViewById(R.id.radioButtonM);

        txt_titulo = alertLayout.findViewById(R.id.txt_titulo);

        radioButtonCC.setText("1. Construcción con Cubos - "+Utilidades.R_cc);
        radioButtonCo.setText("4. Conceptos - "+Utilidades.R_co);
        radioButtonM.setText("8. Matrices - "+Utilidades.R_m);



        txt_titulo.setText("Selecciona la prueba a que será reemplazada por la nueva puntuacion de "+Utilidades.R_cf);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        alert.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Guardar en bd la inhabilitación de la selección
                if (radioButtonCC.isChecked()){
                    Utilidades.R_cc = Utilidades.R_cc+"r";
                    SubTestCC subTestCC = new SubTestCC();
                    subTestCC.setPuntuacionDirectaTotalCC(Utilidades.R_cc);
                    subTestCC.RegistrarCC(getContext());
//                    Toast.makeText(getContext(),"Cc",Toast.LENGTH_SHORT).show();
                }
                if (radioButtonCo.isChecked()){
                    Utilidades.R_co = Utilidades.R_co+"r";
                    SubTestCo subTestCo = new SubTestCo();
                    subTestCo.setPuntuacionDirectaTotalCo(Utilidades.R_co);
                    subTestCo.RegistrarCo(getContext());
//                    Toast.makeText(getContext(),"Co",Toast.LENGTH_SHORT).show();
                }
                if (radioButtonM.isChecked()){
                    Utilidades.R_m = Utilidades.R_m+"r";
                    SubTestM subTestM = new SubTestM();
                    subTestM.setPuntuacionDirectaTotalM(Utilidades.R_m);
                    subTestM.RegistrarM(getContext());
//                    Toast.makeText(getContext(),"M",Toast.LENGTH_SHORT).show();
                }
            }
        });

        alert.setNeutralButton("REGRESAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//
            }
        });




        AlertDialog dialog = alert.create();
        dialog.show();
    }

    private void enableSubmitIfReady() {
        boolean isReady = res_cf.getText().toString().length() >= 1;
        guardar.setEnabled(isReady);
        if (isReady){
            guardar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }else{
            guardar.setBackgroundColor(getResources().getColor(R.color.cardview_shadow_start_color));
        }
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
}
