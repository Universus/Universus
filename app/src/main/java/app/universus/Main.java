package app.universus;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

import app.universus.Activity.BaseActivity;
import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Controllers.AlumnoController;
import app.universus.Controllers.ProfesorController;
import app.universus.Controllers.UsuarioController;
import app.universus.Models.Profesor;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;


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
        usuario.addNotificacion(
                new Notificacion(
                    BitmapFactory.decodeResource(getResources(),
                            R.drawable.leona_1), "Hacer tarea de progra",
                    Notificacion.IMPORTANTE, "mi casa"
                )
        );

        usuario.addNotificacion(
                new Notificacion(
                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.diana_1), "Ver Scorpion",
                        Notificacion.IMPORTANTE, "mi casa otra vez XD"
                )
        );
        usuarioController = new UsuarioController();
        usuarioController.setUsuario(usuario);
        inicializaDrawer();
        selectItem(0);
    }

}
