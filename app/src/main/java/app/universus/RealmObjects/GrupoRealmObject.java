package app.universus.RealmObjects;

import java.util.List;

import app.universus.Models.Usuario;
import io.realm.RealmList;
import io.realm.RealmObject;


public class GrupoRealmObject extends RealmObject{
    private RealmList<UsuarioRealmObject> alumnos;
    private RealmList<UsuarioRealmObject> profesores;
    private int imagen;
    private String nombre;

    public RealmList<UsuarioRealmObject> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(RealmList<UsuarioRealmObject> alumnos) {
        this.alumnos = alumnos;
    }

    public RealmList<UsuarioRealmObject> getProfesores() {
        return profesores;
    }

    public void setProfesores(RealmList<UsuarioRealmObject> profesores) {
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
