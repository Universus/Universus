package app.universus.RealmObjects;

import io.realm.RealmObject;

public class ProfesorModelo extends RealmObject{
    private String alias;
    private String  contrasenya;
    private String  matricula;
    private String email;

    public ProfesorModelo(){

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
