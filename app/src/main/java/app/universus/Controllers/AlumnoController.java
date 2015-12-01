package app.universus.Controllers;

import app.universus.Drawer.Elemento;
import app.universus.Fragments.AlumnoPerfilFragment;
import app.universus.Fragments.Articulo;
import app.universus.Fragments.GrupoFragment;
import app.universus.Fragments.HomeFragment;
import app.universus.Fragments.NotificacionCrearFragment;
import app.universus.Models.Alumno;
import app.universus.Models.Grupo;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AlumnoController {
    Alumno alumno;

    AlumnoController(Alumno alumno){

    }

    public static Alumno getDefault(){
        Alumno defecto= new Alumno("Default", "1234",
                "20141234","default@user.com" );
        return defecto;
    }

    public static List<Elemento> getOpcionesMenu(){
        List<Elemento> menu = new ArrayList<Elemento>();
        menu.add(new Elemento("Login", R.drawable.importante_icono));
        menu.add(new Elemento("Home", R.drawable.ic_1448961499_home));
        menu.add(new Elemento("Perfil", R.drawable.ic_1448961152_gear_user));
        menu.add(new Elemento("Cursos", R.drawable.cursos));
        menu.add(new Elemento("Mandar notificacion", R.drawable.ic_1448841788_books));
        menu.add(new Elemento("Profesores", R.drawable.ic_1448843475_preferences_contact_list));

        return menu;
    }

    public static Fragment getSeleccion(int posicion, Usuario usuario){
        Bundle args = new Bundle();
        args.putInt(Articulo.ARG_ARTICLES_NUMBER, posicion);
        args.putString(Articulo.TITULO, getOpcionesMenu().get(posicion).getDescipcion());

        switch(posicion){
            case 0:
                HomeFragment home = HomeFragment.newInstance(args, usuario);
                return home;
            case 1:
                AlumnoPerfilFragment alumnoPerfilFragment =
                        AlumnoPerfilFragment.newInstance(args, (Alumno) usuario);
                return alumnoPerfilFragment;
            case 2:
                Grupo grupo = new Grupo("Prueba", R.drawable.diana_1);

                Alumno alumno1 = new Alumno("Pepe", "1234", "1234", "12341");
                Alumno alumno2 = new Alumno("Pepe", "1234", "1234", "12341");
                Alumno alumno3 = new Alumno("Pepe", "1234", "1234", "12341");
                Alumno alumno4 = new Alumno("Pepe", "1234", "1234", "12341");

                grupo.addAlumno(alumno1);
                grupo.addAlumno(alumno2);
                grupo.addAlumno(alumno3);
                grupo.addAlumno(alumno4);

                GrupoFragment grupoFragment =
                        GrupoFragment.newInstance(args, grupo);
                return grupoFragment;

            case 3:
                NotificacionCrearFragment fragment = NotificacionCrearFragment.newInstance(args, usuario);
                return fragment;

            default:
                Articulo nuevo = Articulo.newInstance(args);
                return nuevo;
        }


    }
}
