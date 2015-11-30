package app.universus.AreaDeNotificacion;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.universus.Helpers.NotificacionFactory;
import app.universus.RealmObjects.Notificacion;
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
        items.add(NotificacionFactory.newInstance(R.drawable.diana_1,
                "Entregar libro", NotificacionFactory.IMPORTANTE, "Biblioteca"));
        items.add(NotificacionFactory.newInstance(R.drawable.riven_1,
                "Ver Porno", NotificacionFactory.IMPORTANTE, "Interner"));
        items.add(NotificacionFactory.newInstance(R.drawable.leona_1,
                "Faltar a progra", NotificacionFactory.ESTANDAR, "CU"));
        items.add(NotificacionFactory.newInstance(R.drawable.leona_2,
                "Vender tacos", NotificacionFactory.RECORDATORIO, "CU"));
        items.add(NotificacionFactory.newInstance( R.drawable.diana_1,
                "Comprar coca a Victor", NotificacionFactory.IMPORTANTE, "Tienda o OXXO"));
        items.add(NotificacionFactory.newInstance(R.drawable.diana_1,
                "Comprar manga", NotificacionFactory.IMPORTANTE, "No se U.U"));


        recycler = (RecyclerView) findViewById(R.id.area_de_notificacion);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        adapter = new NotificacionAdapter(items);
        recycler.setAdapter(adapter);
    }

}
