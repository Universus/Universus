package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.universus.Helpers.UsuarioAdapter;
import app.universus.Models.Grupo;
import app.universus.Models.Profesor;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

public class ProfesoresListaFragment extends Fragment{
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    private RecyclerView alumnosView;
    private RecyclerView profesoresView;

    private RecyclerView.Adapter adapterAlumnos;
    private RecyclerView.Adapter adapterProfesores;

    private RecyclerView.LayoutManager layoutManager;
    private List<Usuario> grupo;

    public ProfesoresListaFragment(){

    }

    public static ProfesoresListaFragment newInstance(Bundle args, List<Usuario> grupo){
        ProfesoresListaFragment nuevo = new ProfesoresListaFragment();
        nuevo.setGrupo(grupo);
        nuevo.setArguments(args);
        return nuevo;
    }

    public void setGrupo(List<Usuario>  grupo){
        this.grupo = grupo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.grupo_lista_layout, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);

        ImageView imagenGrupo = (ImageView) rootView.findViewById(R.id.grupo__imagen);

        List<Usuario> alumnos = grupo;

        imagenGrupo.setImageResource(R.drawable.diana_1);
        TextView tituloGrupo = (TextView) rootView.findViewById(R.id.grupo__titulo);
        tituloGrupo.setText("Profesores");

        alumnosView = (RecyclerView) rootView.findViewById(R.id.grupo__alumnos);
        layoutManager = new LinearLayoutManager(container.getContext());
        alumnosView.setLayoutManager(layoutManager);
        adapterAlumnos = new UsuarioAdapter(alumnos);
        alumnosView.setAdapter(adapterAlumnos);

        return rootView;
    }
}
