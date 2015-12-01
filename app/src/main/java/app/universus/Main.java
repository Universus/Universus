package app.universus;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.universus.Activity.BaseActivity;
import app.universus.Controllers.ProfesorController;
import app.universus.Models.Alumno;
import app.universus.Models.Profesor;
import app.universus.RealmObjects.Notificacion;
import app.universus.Controllers.AlumnoController;
import app.universus.Controllers.UsuarioController;
import app.universus.Models.UniversusBDDAdministrador;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;
import io.realm.RealmResults;


public class  Main  extends BaseActivity{

    protected DrawerLayout drawerLayout;
    protected ListView drawerList;
    protected ActionBarDrawerToggle drawerToggle;

    protected CharSequence tituloActivity;
    protected CharSequence tituloElemento;
    protected String[] descripcionEtiquetas;

    protected Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras().getBundle("usuario");
        boolean registrado = bundle.getBoolean("registrado");
        if(!registrado){
            String matricula = bundle.getString("matricula");
            if(matricula.startsWith("1234")){
                usuario = new Alumno(
                        bundle.getString("nombre"),
                        bundle.getString("contraseña"),
                        bundle.getString("matricula"),
                        bundle.getString("correo")
                );
            }else{
                usuario = new Profesor(
                        bundle.getString("nombre"),
                        bundle.getString("contraseña"),
                        bundle.getString("matricula"),
                        bundle.getString("correo")
                );
            }

            UniversusBDDAdministrador.guardar(usuario, getApplicationContext());
        }
        else{
            usuario = UniversusBDDAdministrador.getUsuario(
                    getApplicationContext(),
                    bundle.getString("contraseña"),
                    bundle.getString("matricula")
            );
        }


        List<Notificacion> r = new UniversusBDDAdministrador(getApplicationContext())
                .getNotificaciones();

        usuario.setNotificaciones(r);
        usuarioController = new UsuarioController();
        usuarioController.setUsuario(usuario);
        inicializaDrawer();
        selectItem(1);
    }

}
