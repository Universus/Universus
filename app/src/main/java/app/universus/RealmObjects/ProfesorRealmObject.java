package app.universus.RealmObjects;

import io.realm.RealmObject;

/**
 * Created by win7 on 30/11/2015.
 */
public class ProfesorRealmObject extends RealmObject{
    private  double calificacion;
    private String cubo;
    private int edad;

    public String getCubo() {
        return cubo;
    }

    public void setCubo(String cubo) {
        this.cubo = cubo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
