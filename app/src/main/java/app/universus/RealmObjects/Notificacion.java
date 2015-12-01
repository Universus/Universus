package app.universus.RealmObjects;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import app.universus.com.universus.R;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public  class Notificacion extends RealmObject {


    private int imagen;
    private String descripcion;
    private int icono;
    private String lugar;
    private String autor;

    public Notificacion(){

    }

    public int getImagen() {
        return imagen;
    }

    public int getIcono() {
        return icono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public  String getLugar(){
        return lugar;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
