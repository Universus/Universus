package app.universus.AreaDeNotificacion;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.universus.Activity.BaseActivity;
import app.universus.Drawer.DrawerItem;
import app.universus.Drawer.DrawerListAdapter;
import app.universus.Fragments.Articulo;
import app.universus.com.universus.R;

public class AreaDeNotificacion extends ActionBarActivity{

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_de_notificacion);


        List<Notificacion> items = new ArrayList<Notificacion>();
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.diana_1),
                "Entregar libro", Notificacion.IMPORTANTE, "Biblioteca"));
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.riven_1),
                "Ver Porno", Notificacion.IMPORTANTE, "Interner"));
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.leona_1),
                "Faltar a progra", Notificacion.ESTANDAR, "CU"));
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.leona_2),
                "Vender tacos", Notificacion.RECORDATORIO, "CU"));
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.diana_1),
                "Comprar coca a Victor", Notificacion.IMPORTANTE, "Tienda o OXXO"));
        items.add(new Notificacion(BitmapFactory.decodeResource(getResources(), R.drawable.diana_1),
                "Comprar manga", Notificacion.IMPORTANTE, "No se U.U"));


        recycler = (RecyclerView) findViewById(R.id.area_de_notificacion);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        adapter = new NotificacionAdapter(items);
        recycler.setAdapter(adapter);
    }

}
