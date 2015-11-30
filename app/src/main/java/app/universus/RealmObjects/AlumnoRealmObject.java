package app.universus.RealmObjects;

import io.realm.RealmObject;

/**
 * Created by win7 on 30/11/2015.
 */
public class AlumnoRealmObject extends UsuarioRealmObject{
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
