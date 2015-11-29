package app.universus.Fragments;

import app.universus.AreaDeNotificacion.*;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

public class HomeFragment extends Fragment{
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public HomeFragment() {
    }

    Usuario usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String articulo = getArguments().getString(TITULO);

        List<Notificacion> items = usuario.getNotificaciones();
        if(items.isEmpty())
            items.add(new Notificacion(BitmapFactory.decodeResource(container.getResources(),
                    R.drawable.diana_1), "Sin notificaciones", -1, null));
        recycler = (RecyclerView) rootView.findViewById(R.id.area_de_notificacion);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(container.getContext());
        recycler.setLayoutManager(layoutManager);

        adapter = new NotificacionAdapter(items);
        recycler.setAdapter(adapter);

        return rootView;
    }

    public static HomeFragment newInstance(Bundle args, Usuario usuario) {
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        fragment.setUsuario(usuario);
        return fragment;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
