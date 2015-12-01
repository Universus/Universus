package app.universus.Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import app.universus.Drawer.Elemento;
import app.universus.Fragments.Articulo;
import app.universus.Models.Profesor;
import app.universus.com.universus.R;

public class ProfesorController {

    public static List<Elemento> getOpcionesMenu(){
        List<Elemento> menu = new ArrayList<Elemento>();
        menu.add(new Elemento("Home", R.drawable.ic_1448961499_home));
        menu.add(new Elemento("Perfil", R.drawable.ic_1448961152_gear_user));
        menu.add(new Elemento("Cursos", R.drawable.cursos));
        menu.add(new Elemento("Actividades", R.drawable.ic_1448841788_books));
        return menu;
    }

    public static Fragment getSeleccion(int posicion){
        Bundle args = new Bundle();
        args.putInt(Articulo.ARG_ARTICLES_NUMBER, posicion);
        args.putString(Articulo.TITULO, getOpcionesMenu().get(posicion).getDescipcion());
        Articulo nuevo = Articulo.newInstance(args);
        return nuevo;
    }

    public static Profesor getDefault(){
        Profesor defecto= new Profesor("Default", "1234",
                "20141234","default@user.com" );
        return defecto;
    }
}
