package app.universus.AreaDeNotificacion;


import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.universus.Helpers.ImagenCircular;
import app.universus.RealmObjects.Notificacion;
import app.universus.com.universus.R;

public class NotificacionAdapter extends RecyclerView.Adapter<NotificacionViewHolder>
            implements View.OnClickListener{

    private View.OnClickListener listener;

    private List<Notificacion> items;

    public NotificacionAdapter(List<Notificacion> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public NotificacionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.notificacion_item, viewGroup, false);
        v.setOnClickListener(this);
        return new NotificacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NotificacionViewHolder viewHolder, int i) {
        viewHolder.imagenView.setImageDrawable(
                new ImagenCircular(
                        BitmapFactory.decodeResource(viewHolder.view.getResources(),
                                items.get(i).getImagen())
                )
        );
        viewHolder.descripcion.setText(items.get(i).getDescripcion());

        if(items.get(i).getIcono() != -1)
            viewHolder.icono.setImageResource(items.get(i).getIcono());

        if(items.get(i).getLugar() != null)
            viewHolder.lugar.setText("Lugar: " + items.get(i).getLugar());
        viewHolder.notificacion = items.get(i);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v){
        if(listener != null)
            listener.onClick(v);
    }

}
