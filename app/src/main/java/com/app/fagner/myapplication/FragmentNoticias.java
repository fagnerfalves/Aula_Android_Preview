package com.app.fagner.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fagner on 11/10/14.
 */
public class FragmentNoticias extends Fragment {

    public FragmentNoticias() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentnoticias, container, false);
        return rootView;
    }
}

