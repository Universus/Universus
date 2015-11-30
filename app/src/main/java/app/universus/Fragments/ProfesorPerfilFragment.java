package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.universus.Models.Alumno;
import app.universus.Models.Profesor;
import app.universus.com.universus.R;

public class ProfesorPerfilFragment extends Fragment {
    public static final String ARG_NUMERO_ACTICULO = "numero_articulo";
    Profesor profesor;

    public ProfesorPerfilFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alumno, container, false);
        return rootView;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public static ProfesorPerfilFragment newInstance(Bundle args, Profesor profesor) {
        ProfesorPerfilFragment nuevo = new ProfesorPerfilFragment();
        nuevo.setArguments(args);
        nuevo.setProfesor(profesor);
        return nuevo;
    }
}