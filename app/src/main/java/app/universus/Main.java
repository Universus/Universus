package app.universus;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

import app.universus.Activity.BaseActivity;
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
        usuario = AlumnoController.getDefault();

        RealmResults<Notificacion> r = new UniversusBDDAdministrador(getApplicationContext())
                .getNotificaciones();

        for(Notificacion nueva : r){
            usuario.addNotificacion(nueva);
        }

        usuarioController = new UsuarioController();
        usuarioController.setUsuario(usuario);
        inicializaDrawer();
        selectItem(0);
    }

}
