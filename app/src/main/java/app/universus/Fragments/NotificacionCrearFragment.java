package app.universus.Fragments;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.universus.AreaDeNotificacion.IconosImportanciaAdapter;
import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Controllers.AlumnoController;
import app.universus.Controllers.ProfesorController;
import app.universus.Drawer.Elemento;
import app.universus.Models.*;
import app.universus.com.universus.R;

public class NotificacionCrearFragment extends Fragment implements View.OnClickListener{
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    private ExpandableListView expandableListViews;
    private IconosImportanciaAdapter listAdapter;

    private List<Elemento> padres;
    private HashMap<String, List<Elemento>> opciones;
    View rootView;
    Usuario usuario;
    ViewGroup container;

    public NotificacionCrearFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.notificacion_create_fragment, container, false);
        this.container = container;

        expandableListViews = (ExpandableListView) rootView.findViewById(R.id.notificacion_crear__importancia);
        if (expandableListViews != null) {
            agregaOpciones();
            listAdapter = new IconosImportanciaAdapter(container.getContext(), padres, opciones);
            expandableListViews.setAdapter(listAdapter);
        }

        Button enviar = (Button) rootView.findViewById(R.id.notificacion_crear__enviar);
        enviar.setOnClickListener(this);
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

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public static NotificacionCrearFragment newInstance(Bundle args, Usuario usuario){
        NotificacionCrearFragment nuevo = new NotificacionCrearFragment();
        nuevo.setArguments(args);
        nuevo.setUsuario(usuario);
        return nuevo;
    }

    private void cambiarFragment(int posicion){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = usuario instanceof Alumno? AlumnoController.getSeleccion(posicion, usuario) : ProfesorController.getSeleccion(posicion);
        fragmentManager.beginTransaction().replace(R.id.content_frame,
                fragment

        ).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notificacion_crear__enviar:
                EditText descripcionEntrada = (EditText) rootView.findViewById(
                        R.id.notificacion_crear__descripcion);

                String descripcion  = descripcionEntrada.getText().toString();
                if (descripcion.matches("") || descripcion.length() < 20) {
                    Toast.makeText(v.getContext(), "Debes ingresar una descripcion",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    ExpandableListView lista = (ExpandableListView) rootView.findViewById(
                            R.id.notificacion_crear__importancia);
                    Elemento elemento = (Elemento) lista.getSelectedItem();
                    EditText lugarEntrada = (EditText) rootView.findViewById(R.id.notificacion_crear__lugar);
                    String lugar;
                    if(lugarEntrada.getText() == null){
                        lugar = null;
                    }
                    else{
                        lugar = lugarEntrada.getText().toString();
                    }
                    if(elemento == null)
                        elemento = new Elemento("Pene", Notificacion.ESTANDAR);
                    usuario.addNotificacion(new Notificacion(
                            BitmapFactory.decodeResource(v.getResources(), R.drawable.diana_1),
                            descripcion, elemento.getPath(), lugar
                            ));
                    Toast.makeText(v.getContext(), "Notificacion enviada",
                            Toast.LENGTH_SHORT).show();
                    cambiarFragment(0);
                }
                break;
        }
    }
}
