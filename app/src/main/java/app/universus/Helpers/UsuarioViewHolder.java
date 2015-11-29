package app.universus.Helpers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.universus.Models.Usuario;
import app.universus.com.universus.R;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {
    public ImageView imagen;
    public TextView nombre;

    public UsuarioViewHolder(View v) {
        super(v);
        imagen = (ImageView) v.findViewById(R.id.usuario_item__imagen);
        nombre = (TextView) v.findViewById(R.id.usuario_item__nombre);
    }
}
