package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.universus.AreaDeNotificacion.IconosImportanciaAdapter;
import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Drawer.Elemento;
import app.universus.com.universus.R;

public class NotificacionCrearFragment extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    private ExpandableListView expandableListViews;
    private IconosImportanciaAdapter listAdapter;

    private List<Elemento> padres;
    private HashMap<String, List<Elemento>> opciones;

    public NotificacionCrearFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notificacion_create_fragment, container, false);

        expandableListViews = (ExpandableListView) rootView.findViewById(R.id.lista_importancia);
        if (expandableListViews != null) {
            agregaOpciones();
            listAdapter = new IconosImportanciaAdapter(container.getContext(), padres, opciones);
            expandableListViews.setAdapter(listAdapter);
        }
        return rootView;
    }

    private void agregaOpciones(){
        padres = new ArrayList<>();
        opciones = new HashMap<>();

        padres.add(new Elemento("Importancia", R.drawable.diana_1));

        List<Elemento> lista = new ArrayList<Elemento>();
        lista.add(new Elemento("Importante", Notificacion.IMPORTANTE));
        lista.add(new Elemento("Recordatorio", Notificacion.RECORDATORIO));
        lista.add(new Elemento("Estandar", Notificacion.ESTANDAR));

        opciones.put(padres.get(0).getDescipcion(), lista);
    }

    public static NotificacionCrearFragment newInstance(Bundle args){
        NotificacionCrearFragment nuevo = new NotificacionCrearFragment();
        nuevo.setArguments(args);
        return nuevo;
    }
}
