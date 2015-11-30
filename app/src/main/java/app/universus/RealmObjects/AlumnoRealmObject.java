package app.universus.RealmObjects;

import io.realm.RealmObject;

public class AlumnoRealmObject extends RealmObject{
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
