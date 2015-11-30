package app.universus.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Controllers.AlumnoController;
import app.universus.Models.Alumno;
import app.universus.com.universus.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class AlumnoPerfilFragment extends Fragment{
    public static final String ARG_NUMERO_ACTICULO = "numero_articulo";
    Alumno alumno;

    public AlumnoPerfilFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.alumno, container, false);
        TextView nombre = (TextView) rootView.findViewById(R.id.profe);

        nombre.setText(alumno.getAlias());
        return rootView;
    }

    public void setAlumno(Alumno alumno){
        this.alumno = alumno;
    }

    public static AlumnoPerfilFragment newInstance(Bundle args, Alumno alumno){
        AlumnoPerfilFragment nuevo = new AlumnoPerfilFragment();
        nuevo.setArguments(args);
        nuevo.setAlumno(alumno);
        return nuevo;
    }
}
