package com.example.franko.expertwisc.FragmentosSubTest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.SubTest.SubTestC;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestI;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestS;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestV;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link I.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link I#newInstance} factory method to
 * create an instance of this fragment.
 */
public class I extends Fragment {
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
    Button guardar;
    EditText res_i;
    RadioButton radioButtonS, radioButtonV, radioButtonC;
    TextView txt_titulo;
    private OnFragmentInteractionListener mListener;

    public I() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment I.
     */
    // TODO: Rename and change types and number of parameters
    public static I newInstance(String param1, String param2) {
        I fragment = new I();
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
        view =inflater.inflate(R.layout.fragment_i, container, false);
        res_i = view.findViewById(R.id.res_i);
        guardar = view.findViewById(R.id.guardar_i);
        imageView = view.findViewById(R.id.show_i);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtclose;
                Button btnFollow;
                myDialog.setContentView(R.layout.pop_up_i);
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
        res_i.setText(Utilidades.R_i);
        res_i.addTextChangedListener(new TextWatcher() {
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

        if (Utilidades.disable.equals(true)){
            res_i.setEnabled(false);
        }else{
            res_i.setEnabled(true);
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardwithoutPopulate(getActivity());
                if (Integer.parseInt(res_i.getText().toString())<=33){
                    SubTestI subTestI = new SubTestI();
                    subTestI.setPuntuacionDirectaTotalI(res_i.getText().toString());
                    subTestI.UpdateI(getContext());
                    Utilidades.R_i = (res_i.getText().toString());
                    Test test = new Test();
                    test.UpdateTestUp(getContext());
                    guardar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                    Toast.makeText(getContext(),Utilidades.R_i+" GUARDADO",Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, Utilidades.R_i +" puntos guardado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).setActionTextColor(Color.RED).show();
                    Dialogreemplazo();
                }else{
//                    Toast.makeText(getContext(),"El valor no debe de ser mayor a 33",Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "El valor no debe de ser mayor a 33", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).setActionTextColor(Color.RED).show();
                }

            }
        });

        return view;
    }

    public static void hideKeyboardwithoutPopulate(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    private void Dialogreemplazo() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_cv, null);

        radioButtonS = alertLayout.findViewById(R.id.radioButtonS);
        radioButtonV = alertLayout.findViewById(R.id.radioButtonV);
        radioButtonC = alertLayout.findViewById(R.id.radioButtonC);

        radioButtonS.setText("2. Semejanzas - "+Utilidades.R_s);
        radioButtonV.setText("6. Vocabulario - "+Utilidades.R_v);
        radioButtonC.setText("9. Conceptos - "+Utilidades.R_c);

        txt_titulo = alertLayout.findViewById(R.id.txt_titulo);

        txt_titulo.setText("Selecciona la prueba a que será reemplazada por la nueva puntuacion de "+Utilidades.R_i);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        alert.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Guardar en bd la inhabilitación de la selección
                if (radioButtonS.isChecked()){
                    Utilidades.R_s = Utilidades.R_s+"r";
                    SubTestS subTestS = new SubTestS();
                    subTestS.setPuntuacionDirectaTotalS(Utilidades.R_s);
                    subTestS.UpdateS(getContext());
//                    Toast.makeText(getContext(),"Cc",Toast.LENGTH_SHORT).show();
                }
                if (radioButtonV.isChecked()){
                    Utilidades.R_v = Utilidades.R_v+"r";
                    SubTestV subTestV = new SubTestV();
                    subTestV.setPuntuacionDirectaTotalV(Utilidades.R_v);
                    subTestV.UpdateV(getContext());
//                    Toast.makeText(getContext(),"Co",Toast.LENGTH_SHORT).show();
                }
                if (radioButtonC.isChecked()){
                    Utilidades.R_c = Utilidades.R_c+"r";
                    SubTestC subTestC = new SubTestC();
                    subTestC.setPuntuacionDirectaTotalC(Utilidades.R_c);
                    subTestC.UpdateC(getContext());
//                    Toast.makeText(getContext(),"Co",Toast.LENGTH_SHORT).show();
                }

                Utilidades.disable=true;

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
        boolean isReady = res_i.getText().toString().length() >= 1;
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
