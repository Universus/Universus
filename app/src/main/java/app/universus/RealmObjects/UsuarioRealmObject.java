package app.universus.RealmObjects;

import android.graphics.Bitmap;

import java.util.List;

import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Models.Grupo;
import io.realm.RealmList;
import io.realm.RealmObject;

public class UsuarioRealmObject extends RealmObject{
    private String alias;
    private String contrasenya;
    private String matricula;
    private String email;

    private Bitmap imagen;

    private RealmList<GrupoRealmObject> grupos;
    private RealmList<Notificacion> notificaciones;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public RealmList<GrupoRealmObject> getGrupos() {
        return grupos;
    }

    public void setGrupos(RealmList<GrupoRealmObject> grupos) {
        this.grupos = grupos;
    }

    public RealmList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(RealmList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}
