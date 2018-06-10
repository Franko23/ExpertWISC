package com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.franko.expertwisc.R;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilEscalar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerfilEscalar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilEscalar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LineChart lineChart;
    View view;

    private OnFragmentInteractionListener mListener;

    public PerfilEscalar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilEscalar.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilEscalar newInstance(String param1, String param2) {
        PerfilEscalar fragment = new PerfilEscalar();
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
        view = inflater.inflate(R.layout.fragment_perfil_escalar, container, false);

        lineChart = view.findViewById(R.id.lineChartEscalar);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);

        ArrayList<Entry> entries =  new ArrayList<>();

        int[] value = {1,5,8,12,14,0,3,7,10,2,6,13,4,9,11};

        for (int i = 0; i < Utilidades.listResultEscalar.size(); i++){
            if (!Utilidades.listResultEscalar.get(value[i]).equals("0")){
                if (Utilidades.listResultEscalar.get(value[i]).contains("r")){
                    String[]  datos = Utilidades.listResultEscalar.get(value[i]).split("r");
                    entries.add(new Entry(i,Integer.parseInt(datos[0])));
                }
                entries.add(new Entry(i,Integer.parseInt(Utilidades.listResultEscalar.get(value[i]))));
            }

        }
        int promedio = 0;
        for (int i = 0; i < entries.size(); i++){
            promedio +=  entries.get(i).getY();
        }

        promedio = promedio/entries.size();

        LineDataSet lineDataSet = new LineDataSet(entries, "Perfil de Puntuaciones Escalares");
        lineDataSet.setFillAlpha(110);
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setValueTextColor(Color.DKGRAY);

        lineDataSet.setCircleColor(Color.BLUE);


        LimitLine max = new LimitLine(promedio,"Promedio");
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.addLimitLine(max);

        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);

        LineData lineData = new LineData(iLineDataSets);

        lineChart.setData(lineData);
        lineChart.setContentDescription("");


        return view;
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
