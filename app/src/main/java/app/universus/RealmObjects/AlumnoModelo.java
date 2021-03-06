package app.universus.RealmObjects;

import app.universus.Models.Profesor;
import io.realm.RealmList;
import io.realm.RealmObject;

public class AlumnoModelo extends RealmObject{
    private String alias;
    private String  contrasenya;
    private String  matricula;
    private String email;

    private RealmList<ProfesorModelo> profesores;

    public AlumnoModelo(){

    }

    public RealmList<ProfesorModelo> getProfesores() {
        return profesores;
    }

    public void setProfesores(RealmList<ProfesorModelo> profesores) {
        this.profesores = profesores;
    }

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
}
