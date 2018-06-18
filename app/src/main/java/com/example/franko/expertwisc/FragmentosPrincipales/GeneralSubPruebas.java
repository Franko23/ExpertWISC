package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Adapters.SeccionesAdapter;
import com.example.franko.expertwisc.ConexionHelper;
import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.FragmentosSubTest.A;
import com.example.franko.expertwisc.FragmentosSubTest.Ad;
import com.example.franko.expertwisc.FragmentosSubTest.Ar;
import com.example.franko.expertwisc.FragmentosSubTest.BS;
import com.example.franko.expertwisc.FragmentosSubTest.C;
import com.example.franko.expertwisc.FragmentosSubTest.CC;
import com.example.franko.expertwisc.FragmentosSubTest.CF;
import com.example.franko.expertwisc.FragmentosSubTest.Cl;
import com.example.franko.expertwisc.FragmentosSubTest.Co;
import com.example.franko.expertwisc.FragmentosSubTest.I;
import com.example.franko.expertwisc.FragmentosSubTest.LN;
import com.example.franko.expertwisc.FragmentosSubTest.M;
import com.example.franko.expertwisc.FragmentosSubTest.RD;
import com.example.franko.expertwisc.FragmentosSubTest.S;
import com.example.franko.expertwisc.FragmentosSubTest.V;
import com.example.franko.expertwisc.R;

import com.example.franko.expertwisc.Tools.CalcularEdad;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralSubPruebas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralSubPruebas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralSubPruebas extends Fragment implements Cl.OnFragmentInteractionListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ConexionHelper con;
    View view, view_cc, view_s, view_rd, view_co, view_cl, view_v, view_ln, view_m, view_c, view_bs, view_cf, view_a, view_i, view_ar, view_ad;

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button finalizar;

    Bundle bundle;
    TextView datoPaciente, valores, siguiente;
    int id_paciente;

    LinearLayout linearLayout;

    String EdadPaciente, Titulo, res_cl, AñoTotal;
    private EditText res_cc, res_s, res_rd, res_co, res_cl_a, res_v, res_ln, res_m, res_c, res_bs, res_cf, res_a, res_i, res_ar, res_ad;
    TextInputEditText res_cl_b;

    private OnFragmentInteractionListener mListener;

    public GeneralSubPruebas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeneralSubPruebas.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralSubPruebas newInstance(String param1, String param2) {
        GeneralSubPruebas fragment = new GeneralSubPruebas();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_general_sub_pruebas, container, false);
        viewPager = view.findViewById(R.id.sub_content);
        linearLayout = view.findViewById(R.id.l_finalizar);

        finalizar = view.findViewById(R.id.finalizar);

        if (Utilidades.rotacionG == 0){
            View parent = (View) container.getParent();
            if (appBarLayout == null){
                appBarLayout = parent.findViewById(R.id.appBar);
                tabLayout = new TabLayout(getActivity());
                appBarLayout.addView(tabLayout);


                llenarViewPager(viewPager);

                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });

                tabLayout.setupWithViewPager(viewPager);
                tabLayout.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
            }

            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        }else{
            Utilidades.rotacionG =1;
        }

        bundle = getArguments();
        Persona persona = null;
        if (bundle != null) {
            persona = (Persona) bundle.getSerializable("Persona") ;
//            Calculamos la fecha de nacimiento de la persona
            CalcularEdad calcularEdad = new CalcularEdad(persona.getFecha_nacimiento_persona());
            String edadPersona = calcularEdad.CalcularEdad();
            Titulo = persona.getNombre_persona() + " - " + edadPersona;
            Utilidades.currentPacienteName = persona.getNombre_persona();
        }

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Resultados();
                getFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            }
        });


        getActivity().setTitle(Titulo);



        return view;
    }


    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter seccionesAdapter = new SeccionesAdapter(getFragmentManager());

        if (Utilidades.pages==10){
            seccionesAdapter.addFragment(new CC(),"CC");
            seccionesAdapter.addFragment(new S(),"S");
            seccionesAdapter.addFragment(new RD(),"RD");
            seccionesAdapter.addFragment(new Co(),"Co");
            seccionesAdapter.addFragment(new Cl(),"Cl");
            seccionesAdapter.addFragment(new V(),"V");
            seccionesAdapter.addFragment(new LN(),"LN");
            seccionesAdapter.addFragment(new M(),"M");
            seccionesAdapter.addFragment(new C(),"C");
            seccionesAdapter.addFragment(new BS(),"BS");

        }
        if (Utilidades.pages==5){
            seccionesAdapter.addFragment(new CF(),"CF");
            seccionesAdapter.addFragment(new A(),"A");
            seccionesAdapter.addFragment(new I(),"I");
            seccionesAdapter.addFragment(new Ar(),"Ar");
            seccionesAdapter.addFragment(new Ad(),"Ad");
            Utilidades.pages=10;
            linearLayout.setVisibility(View.VISIBLE);
        }

        viewPager.setAdapter(seccionesAdapter);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (Utilidades.rotacionG == 0){
            appBarLayout.removeView(tabLayout);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
