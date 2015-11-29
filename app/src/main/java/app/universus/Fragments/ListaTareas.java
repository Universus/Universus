package app.universus.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import app.universus.com.universus.R;

public class ListaTareas extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";

    public ListaTareas() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listatareas_layout, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String articulo= getResources().getStringArray(R.array.items_menu_izquierdo)[i];

        getActivity().setTitle(articulo);
        TextView cabecera = (TextView) rootView.findViewById(R.id.cabecera);
        cabecera.append(" " + articulo);
        return rootView;
    }
}