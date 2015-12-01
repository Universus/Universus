package app.universus.RealmObjects;

import io.realm.RealmObject;

public class GrupoModelo extends RealmObject{
    private int imagen;
    private String nombre;

    public GrupoModelo(){

    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
