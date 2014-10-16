package com.app.fagner.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.fagner.myapplication.modelo.FragmentListener;
import com.app.fagner.myapplication.modelo.Noticia;

//import recode.appro.model.Noticia;

/**
 * Created by eccard on 7/25/14.
 */
public class FragmentNoticia extends Fragment {
    private FragmentListener fragmentListener;
    Noticia noticia;

    public FragmentNoticia(){}

    public static FragmentNoticia newInstance(Noticia noticia){
        Log.i("esta entranaoo","esta entrando aki");
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
        descricao.setMovementMethod(new ScrollingMovementMethod());
        descricao.setText(noticia.getConteudo());

        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            fragmentListener = (FragmentListener) activity;

        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " deve implementar FragmentListener");

        }
    }




    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
}
