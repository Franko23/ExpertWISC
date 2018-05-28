package com.example.franko.expertwisc.FragmentosPrincipales;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.franko.expertwisc.Adapters.SeccionesAdapter;
import com.example.franko.expertwisc.Entidades.Paciente;
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

import com.example.franko.expertwisc.Utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GeneralSubPruebas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GeneralSubPruebas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralSubPruebas extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    Bundle bundle;
    TextView datoPaciente, valores, siguiente;

    String EdadPaciente, Titulo, GrupoPaciente,valor;

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

        if (Utilidades.rotacion == 0){
            View parent = (View) container.getParent();
            if (appBarLayout == null){
                appBarLayout = parent.findViewById(R.id.appBar);
                tabLayout = new TabLayout(getActivity());
                appBarLayout.addView(tabLayout);

                viewPager = view.findViewById(R.id.sub_content);

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
            Utilidades.rotacion =1;
        }

//        valores = view.findViewById(R.id.valores);
//        datoPaciente = view.findViewById(R.id.DatoPaciente);
        siguiente = view.findViewById(R.id.siguiente);

        bundle = getArguments();

        Paciente paciente = null;

        if (bundle != null) {
//            paciente = (Paciente) bundle.getSerializable("paciente");
            paciente = (Paciente) bundle.getBundle("Paciente").getSerializable("paciente");
            EdadPaciente = bundle.getBundle("Edad").getString("edad");
            Titulo = "Nombre: " + paciente.getNombres().toString() + " " + paciente.getApellidos()+"\n"+EdadPaciente;
        }

        getActivity().setTitle(Titulo);

        return view;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter seccionesAdapter = new SeccionesAdapter(getFragmentManager());
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
        seccionesAdapter.addFragment(new CF(),"CF");
        seccionesAdapter.addFragment(new A(),"A");
        seccionesAdapter.addFragment(new I(),"I");
        seccionesAdapter.addFragment(new Ar(),"Ar");
        seccionesAdapter.addFragment(new Ad(),"Ad");

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
        if (Utilidades.rotacion == 0){
            appBarLayout.removeView(tabLayout);
        }
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
