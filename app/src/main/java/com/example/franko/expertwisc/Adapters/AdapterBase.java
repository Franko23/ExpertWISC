package com.example.franko.expertwisc.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.franko.expertwisc.Entidades.Test;

import java.util.ArrayList;

public class AdapterBase extends RecyclerView.Adapter<AdapterTest.ViewHolderTest> implements View.OnClickListener {

    Context context;
    View root;
    private View.OnClickListener listener;
    ArrayList<Test> listaTest;

    public  AdapterBase(ArrayList<Test> listatest) {
        this.listaTest = listatest;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public AdapterTest.ViewHolderTest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTest.ViewHolderTest holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
