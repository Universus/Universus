package app.universus.AreaDeNotificacion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.universus.com.universus.R;

public class NotificacionViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagen;
    public TextView descripcion;
    public ImageView icono;
    public TextView lugar;

    public NotificacionViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.notificacion_item__imagen);
        descripcion = (TextView) v.findViewById(R.id.notificacion_item__descripcion);
        icono = (ImageView) v.findViewById(R.id.notificacion_item__icono);
        lugar = (TextView) v.findViewById(R.id.notificacion_item__lugar);
    }
}
