package com.example.transportapp.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.transportapp.ui.main.Clientes;
import com.example.transportapp.ui.main.Transportista;

public class PagerController extends FragmentPagerAdapter {
    int numofTabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
        this.numofTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Clientes();
            case 1:
                return new Transportista();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return numofTabs;
    }



}
