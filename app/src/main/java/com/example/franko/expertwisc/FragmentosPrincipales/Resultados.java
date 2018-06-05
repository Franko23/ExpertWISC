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

import com.example.franko.expertwisc.Adapters.SeccionesAdapter;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.DirectaEscalar;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.IndicesCI;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilCompuestas;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilEscalar;
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
 * {@link Resultados.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Resultados#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resultados extends Fragment {
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
    private OnFragmentInteractionListener mListener;

    public Resultados() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Resultados.
     */
    // TODO: Rename and change types and number of parameters
    public static Resultados newInstance(String param1, String param2) {
        Resultados fragment = new Resultados();
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
        view = inflater.inflate(R.layout.fragment_resultados, container, false);


        if (Utilidades.rotacion == 0){
            View parent = (View) container.getParent();
            if (appBarLayout == null){
                appBarLayout = parent.findViewById(R.id.appBar);
                tabLayout = new TabLayout(getActivity());
                appBarLayout.addView(tabLayout);

                viewPager = view.findViewById(R.id.res_content);

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
        return view;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesAdapter seccionesAdapter = new SeccionesAdapter(getFragmentManager());
        seccionesAdapter.addFragment(new DirectaEscalar(),"Conversión Directa Escalar");
        seccionesAdapter.addFragment(new IndicesCI(),"Índices y CI");
        seccionesAdapter.addFragment(new PerfilEscalar(),"Perfil Escalar");
        seccionesAdapter.addFragment(new PerfilCompuestas(),"Perfil Compuesta");

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
