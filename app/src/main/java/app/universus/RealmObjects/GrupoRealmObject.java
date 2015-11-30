package app.universus.RealmObjects;

import java.util.List;

import app.universus.Models.Usuario;
import io.realm.RealmObject;

/**
 * Created by win7 on 30/11/2015.
 */
public class GrupoRealmObject extends RealmObject{
    List<Usuario> alumnos;
    List<Usuario> profesores;
    int imagen;
    String nombre;

    public List<Usuario> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Usuario> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Usuario> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Usuario> profesores) {
        this.profesores = profesores;
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
