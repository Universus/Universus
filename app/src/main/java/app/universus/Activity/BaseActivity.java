package app.universus.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import app.universus.Helpers.*;

import java.util.ArrayList;
import java.util.List;

import app.universus.AreaDeNotificacion.AreaDeNotificacion;
import app.universus.Controllers.UsuarioController;
import app.universus.Drawer.Elemento;
import app.universus.Fragments.Articulo;
import app.universus.Drawer.DrawerItem;
import app.universus.Drawer.DrawerListAdapter;
import app.universus.Fragments.HomeFragment;
import app.universus.com.universus.R;


public class  BaseActivity  extends  ActionBarActivity {

    protected DrawerLayout drawerLayout;
    protected ListView drawerList;
    protected ActionBarDrawerToggle drawerToggle;

    protected CharSequence tituloActivity;
    protected CharSequence tituloElemento;
    protected List<Elemento> etiquetas;

    public UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected  void inicializaDrawer(){
        tituloElemento = tituloActivity = getTitle();
        etiquetas = usuarioController.getOpcionesMenu();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ArrayList<DrawerItem> elementos = new ArrayList<DrawerItem>();
        for(Elemento etiqueta : etiquetas){
            DrawerItem nuevo = new DrawerItem(etiqueta.getDescipcion(),
                    BitmapFactory.decodeResource(getResources(), etiqueta.getPath()));
            elementos.add(nuevo);
        }
        drawerList.setAdapter(new DrawerListAdapter(this, elementos));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.title_section1,
                R.string.title_section2
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(tituloElemento);

            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(tituloActivity);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    public void selectItem(int position) {
        if(position == 0) {
            Intent i = new Intent(this, SessionActivity.class);
            startActivity(i);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame,
                usuarioController.getSeleccion(position)
        ).commit();
        drawerList.setItemChecked(position, true);
        setTitle(etiquetas.get(position).getDescipcion());
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        tituloElemento = title;
        getSupportActionBar().setTitle(tituloElemento);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
