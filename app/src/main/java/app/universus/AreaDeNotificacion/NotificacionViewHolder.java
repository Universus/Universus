package app.universus.AreaDeNotificacion;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.universus.EliminarNotificacionListener;
import app.universus.Helpers.ImagenCircular;
import app.universus.com.universus.R;

public class NotificacionViewHolder extends RecyclerView.ViewHolder {

    public TextView descripcion;
    public ImageButton icono;
    public TextView lugar;
    public ImageView imagenView;
    public View view;
    public Notificacion notificacion;

    public NotificacionViewHolder(View v) {
        super(v);
        view = v;
        imagenView =   (ImageView) v.findViewById(R.id.notificacion_item__imagen);
        descripcion = (TextView) v.findViewById(R.id.notificacion_item__descripcion);
        icono =  (ImageButton) v.findViewById(R.id.notificacion_item__icono);
        lugar = (TextView) v.findViewById(R.id.notificacion_item__lugar);
    }
}
