package app.universus.Controllers;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import java.util.List;

import app.universus.Drawer.Elemento;
import app.universus.Fragments.Articulo;
import app.universus.Models.Alumno;
import app.universus.Models.Profesor;
import app.universus.Models.Usuario;

public class UsuarioController {
    protected Usuario usuario;

    public UsuarioController() {

    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public List<Elemento> getOpcionesMenu(){
        if(usuario != null){
            if(usuario instanceof Alumno)
                return AlumnoController.getOpcionesMenu();
            if(usuario instanceof Profesor)
                return ProfesorController.getOpcionesMenu();
        }
        return AlumnoController.getOpcionesMenu();
    }

    public Fragment getSeleccion(int posicion){
        if(usuario != null){
            if(usuario instanceof Alumno)
                return AlumnoController.getSeleccion(posicion, usuario);
            if(usuario instanceof Profesor);
                return ProfesorController.getSeleccion(posicion);
        }
        Bundle args = new Bundle();
        args.putInt(Articulo.ARG_ARTICLES_NUMBER, posicion);
        Articulo nuevo = Articulo.newInstance(args);
        return nuevo;
    }

    public static Usuario getUsuarioDefult(){
        return AlumnoController.getDefault();
    }
}
