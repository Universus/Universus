package app.universus.AreaDeNotificacion;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.universus.Helpers.ImagenCircular;
import app.universus.com.universus.R;

public class NotificacionViewHolder extends RecyclerView.ViewHolder {

    public TextView descripcion;
    public ImageView icono;
    public TextView lugar;
    public ImageView imagenView;
    public View view;

    public NotificacionViewHolder(View v) {
        super(v);
        view = v;
        imagenView = (ImageView) v.findViewById(R.id.notificacion_item__imagen);
        descripcion = (TextView) v.findViewById(R.id.notificacion_item__descripcion);
        icono = (ImageView) v.findViewById(R.id.notificacion_item__icono);
        lugar = (TextView) v.findViewById(R.id.notificacion_item__lugar);
    }
}
