package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.universus.com.universus.R;

public class BaseFragment extends Fragment {
    public static final String ARG_NUMERO_ACTICULO = "numero_articulo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.articulo_fragment, container, false);
        int i = getArguments().getInt(ARG_NUMERO_ACTICULO);
        String articulo= getResources().getStringArray(R.array.items_menu_izquierdo)[i];

        getActivity().setTitle(articulo);
        TextView cabecera = (TextView) rootView.findViewById(R.id.cabecera);
        cabecera.append(" " + articulo);
        return rootView;
    }
    public static  BaseFragment newInstace(Bundle args){
        BaseFragment nuevo = new BaseFragment();
        if(args != null){
            nuevo.setArguments(args);
        }
        return  nuevo;
    }
}
