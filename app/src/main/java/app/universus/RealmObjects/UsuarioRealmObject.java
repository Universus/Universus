package app.universus.RealmObjects;

import io.realm.RealmList;
import io.realm.RealmObject;

public class UsuarioRealmObject extends RealmObject{
    private String alias;
    private String contrasenya;
    private String matricula;
    private String email;

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
