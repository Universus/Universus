package app.universus.RealmObjects;

import io.realm.RealmObject;

/**
 * Created by win7 on 30/11/2015.
 */
public class ProfesorRealmObject extends UsuarioRealmObject{
    private  double calificacion;
    private String cubo;
    private int edad;

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
