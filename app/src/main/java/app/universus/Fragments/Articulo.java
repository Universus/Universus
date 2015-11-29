package app.universus.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.universus.com.universus.R;


public class Articulo extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    public Articulo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.articulo_fragment, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String articulo = getArguments().getString(TITULO);

        getActivity().setTitle(articulo);
        TextView cabecera = (TextView) rootView.findViewById(R.id.cabecera);
        cabecera.append(" " + articulo);

        return rootView;
    }

    public static Articulo newInstance(Bundle args){
        Articulo nuevo = new Articulo();
        nuevo.setArguments(args);
        return nuevo;
    }
}
