package com.app.fagner.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fagner.myapplication.modelo.Noticia;

//import recode.appro.model.Noticia;

/**
 * Created by eccard on 7/25/14.
 */
public class FragmentNoticia extends Fragment {
    Noticia noticia;

    public FragmentNoticia(){}

    public static FragmentNoticia newInstance(Noticia noticia){
        FragmentNoticia fragmentNoticia = new FragmentNoticia();
        fragmentNoticia.setNoticia(noticia);
        return fragmentNoticia;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        getActivity().getActionBar().setTitle("Noticia");
//        getActivity().getActionBar().setSubtitle(null);

        View view = inflater.inflate(R.layout.fragment_noticia,container,false);

        TextView assunto = (TextView) view.findViewById(R.id.textView_noticia_assunto);
        TextView descricao = (TextView) view.findViewById(R.id.textView_noticia_descricao);

        assunto.setText(noticia.getTitulo());
        descricao.setText(noticia.getConteudo());



        return view;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
}
