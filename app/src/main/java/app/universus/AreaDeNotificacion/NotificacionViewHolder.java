package app.universus.AreaDeNotificacion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.universus.RealmObjects.Notificacion;
import app.universus.com.universus.R;

public class NotificacionViewHolder extends RecyclerView.ViewHolder {

    public TextView descripcion;
    public ImageButton icono;
    public TextView lugar;
    public ImageView imagenView;
    public TextView autor;
    public View view;
    public Notificacion notificacion;

    public NotificacionViewHolder(View v) {
        super(v);
        view = v;
        imagenView =   (ImageView) v.findViewById(R.id.notificacion_item__imagen);
        descripcion = (TextView) v.findViewById(R.id.notificacion_item__descripcion);
        icono =  (ImageButton) v.findViewById(R.id.notificacion_item__icono);
        lugar = (TextView) v.findViewById(R.id.notificacion_item__lugar);
        autor  = (TextView) v.findViewById(R.id.notificacion_item__autor);
    }
}
