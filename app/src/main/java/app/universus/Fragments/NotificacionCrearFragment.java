package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import app.universus.RealmObjects.Notificacion;
import app.universus.Controllers.AlumnoController;
import app.universus.Controllers.ProfesorController;
import app.universus.Helpers.NotificacionFactory;
import app.universus.Models.*;
import app.universus.com.universus.R;

public class NotificacionCrearFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";
    public static final String TITULO = "titulo";

    View rootView;
    Usuario usuario;
    ViewGroup container;
    int posicionSeleccion;

    public NotificacionCrearFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.notificacion_create_fragment, container, false);
        this.container = container;

        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        List<String> categories = NotificacionFactory.getImportanciaEtiquetas();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(container.getContext(),
                android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        Button enviar = (Button) rootView.findViewById(R.id.notificacion_crear__enviar);
        enviar.setOnClickListener(this);
        return rootView;
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
        Fragment fragment = usuario instanceof Alumno? AlumnoController.getSeleccion(posicion, usuario) : ProfesorController.getSeleccion(posicion, usuario);
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
                if (descripcion.matches("") || descripcion.length() < 10) {
                    Toast.makeText(v.getContext(), "Debes ingresar una descripcion",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    EditText lugarEntrada = (EditText) rootView.findViewById(R.id.notificacion_crear__lugar);
                    String lugar;
                    if(lugarEntrada.getText() == null){
                        lugar = null;
                    }
                    else{
                        lugar = lugarEntrada.getText().toString();
                    }

                    Notificacion nueva = NotificacionFactory.newInstance(
                            NotificacionFactory.getImportanciaIcono(posicionSeleccion), descripcion,
                            R.drawable.diana_1 ,lugar, usuario.getAlias());

                    usuario.addNotificacion(nueva);
                    Toast.makeText(v.getContext(), "Notificacion enviada",
                            Toast.LENGTH_SHORT).show();

                    UniversusBDDAdministrador.guardar(nueva, v.getContext());
                    cambiarFragment(0);
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        posicionSeleccion = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        posicionSeleccion = 0;
    }
}
