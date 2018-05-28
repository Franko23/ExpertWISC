package com.example.franko.expertwisc.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeccionesAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> listaFragment = new ArrayList<>();

    private final List<String> listaTitulos = new ArrayList<>();

    public SeccionesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {

        return listaFragment.get(position);
    }

    public void addFragment(Fragment fragment, String titulos){
        listaFragment.add(fragment);
        listaTitulos.add(titulos);
    }

    @Override
    public int getCount() {
        return listaFragment.size();
    }
}
