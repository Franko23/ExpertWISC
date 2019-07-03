package com.example.franko.expertwisc.FragmentosSubTest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AlertDialog;
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

import com.example.franko.expertwisc.Entidades.SubTest.SubTestA;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestBS;
import com.example.franko.expertwisc.Entidades.SubTest.SubTestCl;
import com.example.franko.expertwisc.Entidades.Test;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link A.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link A#newInstance} factory method to
 * create an instance of this fragment.
 */
public class A extends Fragment {
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
    EditText res_a;
    RadioButton radioButtonCl, radioButtonBs;
    TextView txt_titulo;
    private OnFragmentInteractionListener mListener;

    public A() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment A.
     */
    // TODO: Rename and change types and number of parameters
    public static A newInstance(String param1, String param2) {
        A fragment = new A();
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
        view =inflater.inflate(R.layout.fragment_a, container, false);
        res_a = view.findViewById(R.id.res_a);
        guardar = view.findViewById(R.id.guardar_a);
        imageView = view.findViewById(R.id.show_a);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtclose;
                Button btnFollow;
                myDialog.setContentView(R.layout.pop_up_a);
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
        res_a.setText(Utilidades.R_a);
        res_a.addTextChangedListener(new TextWatcher() {
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
                hideKeyboardwithoutPopulate(getActivity());
                if (Integer.parseInt(res_a.getText().toString())<=136){
                    SubTestA subTestA = new SubTestA();
                    subTestA.setPuntuacionDirectaTotalA(res_a.getText().toString());
                    subTestA.UpdateA(getContext());
                    Utilidades.R_a = (res_a.getText().toString());
                    Test test = new Test();
                    test.UpdateTestUp(getContext());
                    guardar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                    Toast.makeText(getContext(),Utilidades.R_a+" GUARDADO",Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, Utilidades.R_a +" puntos guardado", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).setActionTextColor(Color.RED).show();
                    Dialogreemplazo();
                }else{
//                    Toast.makeText(getContext(),"El valor no debe de ser mayor a 136",Toast.LENGTH_SHORT).show();
                    Snackbar.make(view, "El valor no debe de ser mayor a 136", Snackbar.LENGTH_LONG)
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
        View alertLayout = inflater.inflate(R.layout.dialog_vp, null);

        radioButtonCl = alertLayout.findViewById(R.id.radioButtonCl);
        radioButtonBs = alertLayout.findViewById(R.id.radioButtonBs);

        radioButtonCl.setText("5. Claves - "+Utilidades.R_cl);
        radioButtonBs.setText("10. Búsqueda de Simbolos - "+Utilidades.R_bs);

        txt_titulo = alertLayout.findViewById(R.id.txt_titulo);

        txt_titulo.setText("Selecciona la prueba a que será reemplazada por la nueva puntuacion de "+Utilidades.R_a);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);

        alert.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Guardar en bd la inhabilitación de la selección
                if (radioButtonCl.isChecked()){
                    Utilidades.R_cl = Utilidades.R_cl+"r";
                    SubTestCl subTestCl = new SubTestCl();
                    subTestCl.setPuntuacionDirectaTotalCl(Utilidades.R_cl);
                    subTestCl.UpdateCl(getContext());
//                    Toast.makeText(getContext(),"Cc",Toast.LENGTH_SHORT).show();
                }
                if (radioButtonBs.isChecked()){
                    Utilidades.R_bs = Utilidades.R_bs+"r";
                    SubTestBS subTestBS = new SubTestBS();
                    subTestBS.setPuntuacionDirectaTotalBS(Utilidades.R_bs);
                    subTestBS.UpdateBS(getContext());
//                    Toast.makeText(getContext(),"Co",Toast.LENGTH_SHORT).show();
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
        boolean isReady = res_a.getText().toString().length() >= 1;
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
