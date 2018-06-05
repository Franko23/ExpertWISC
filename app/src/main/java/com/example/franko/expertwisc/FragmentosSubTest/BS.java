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
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.SubTest;
import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BS.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BS extends Fragment {
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
    EditText res_bs;
    private OnFragmentInteractionListener mListener;

    public BS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BS.
     */
    // TODO: Rename and change types and number of parameters
    public static BS newInstance(String param1, String param2) {
        BS fragment = new BS();
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
        view =inflater.inflate(R.layout.fragment_bs, container, false);
        res_bs = view.findViewById(R.id.res_bs);
        guardar = view.findViewById(R.id.guardar_bs);
        imageView = view.findViewById(R.id.show_bs);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtclose;
                Button btnFollow;
                myDialog.setContentView(R.layout.pop_up_bs);
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

        res_bs.addTextChangedListener(new TextWatcher() {
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
//                SubTest subTest = new SubTest();
                Utilidades.R_bs = (res_bs.getText().toString());
                guardar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Toast.makeText(getContext(),Utilidades.R_bs+" GUARDADO",Toast.LENGTH_SHORT).show();

                DialogResultados(view);

            }
        });

        return view;
    }

    private void DialogResultados(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_pre_resultados, null);

        final TextView result_cc = alertLayout.findViewById(R.id.result_cc);
        final TextView result_s = alertLayout.findViewById(R.id.result_s);
        final TextView result_rd = alertLayout.findViewById(R.id.result_rd);
        final TextView result_co = alertLayout.findViewById(R.id.result_co);
        final TextView result_cl = alertLayout.findViewById(R.id.result_cl);
        final TextView result_v= alertLayout.findViewById(R.id.result_v);
        final TextView result_ln = alertLayout.findViewById(R.id.result_ln);
        final TextView result_m = alertLayout.findViewById(R.id.result_m);
        final TextView result_c = alertLayout.findViewById(R.id.result_c);
        final TextView result_bs = alertLayout.findViewById(R.id.result_bs);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setTitle("PUNTUACIÓN TOTAL");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
//                DialogIntervalo();

            }
        });

        alert.setPositiveButton("SI", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
//                String user = etUsername.getText().toString();
//                String pass = etEmail.getText().toString();
//                Toast.makeText(getBaseContext(), "Username: " + user + " Email: " + pass, Toast.LENGTH_SHORT).show();
//                CargarFragments(SubTest);
//                Toast.makeText(getBaseContext(), "true", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getBaseContext(), "Cancelado", Toast.LENGTH_SHORT).show();
//                SubTest = 10;
            }
        });

        result_cc.setText(Utilidades.R_cc);
        result_s.setText(Utilidades.R_s);
        result_rd.setText(Utilidades.R_rd);
        result_co.setText(Utilidades.R_co);
        result_cl.setText(Utilidades.R_cl);
        result_v.setText(Utilidades.R_v);
        result_ln.setText(Utilidades.R_ln);
        result_m.setText(Utilidades.R_m);
        result_c.setText(Utilidades.R_c);
        result_bs.setText(Utilidades.R_bs);

        AlertDialog dialog = alert.create();
        dialog.show();

    }

    private void enableSubmitIfReady() {
        boolean isReady = res_bs.getText().toString().length() > 1;
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
