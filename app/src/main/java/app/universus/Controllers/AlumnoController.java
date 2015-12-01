package app.universus.Controllers;

import app.universus.Drawer.Elemento;
import app.universus.Fragments.AlumnoPerfilFragment;
import app.universus.Fragments.Articulo;
import app.universus.Fragments.GrupoFragment;
import app.universus.Fragments.HomeFragment;
import app.universus.Fragments.NotificacionCrearFragment;
import app.universus.Fragments.ProfesoresListaFragment;
import app.universus.Models.Alumno;
import app.universus.Models.Grupo;
import app.universus.Models.UniversusBDDAdministrador;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

import android.content.Context;
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
        menu.add(new Elemento("Mis profesores", R.drawable.cursos));
        menu.add(new Elemento("Mandar notificacion", R.drawable.ic_1448841788_books));
        menu.add(new Elemento("Profesores", R.drawable.ic_1448843475_preferences_contact_list));

        return menu;
    }

    public static Fragment getSeleccion(int posicion, Usuario usuario, Context context){
        Bundle args = new Bundle();
        args.putInt(Articulo.ARG_ARTICLES_NUMBER, posicion);
        args.putString(Articulo.TITULO, getOpcionesMenu().get(posicion).getDescipcion());

        switch(posicion){
            case 1:
                HomeFragment home = HomeFragment.newInstance(args, usuario);
                return home;
            case 2:
                AlumnoPerfilFragment alumnoPerfilFragment =
                        AlumnoPerfilFragment.newInstance(args, (Alumno) usuario);
                return alumnoPerfilFragment;
            case 3:
                Alumno nuevoAlumno = (Alumno) usuario;
                ProfesoresListaFragment profesores = ProfesoresListaFragment.newInstance(
                        args, nuevoAlumno.getProfesores()
                );
                return profesores;

            case 4:
                NotificacionCrearFragment fragment = NotificacionCrearFragment.newInstance(args, usuario);
                return fragment;

            case 5:
                List<Usuario> lista = UniversusBDDAdministrador.getProfesores(context);
                ProfesoresListaFragment listaProfesores = ProfesoresListaFragment.newInstance(args, lista);
                return listaProfesores;
            default:
                Articulo nuevo = Articulo.newInstance(args);
                return nuevo;
        }


    }
}
