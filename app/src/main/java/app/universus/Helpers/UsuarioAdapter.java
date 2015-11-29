package app.universus.Helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.AreaDeNotificacion.NotificacionViewHolder;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder>{
    private List<Usuario> items;

    public UsuarioAdapter(List<Usuario> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.usuario_item, viewGroup, false);
        return new UsuarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder viewHolder, int i) {
        ImagenCircular imagen = new ImagenCircular(items.get(i).getImagen());
        viewHolder.imagen.setImageDrawable(imagen);
        viewHolder.nombre.setText(items.get(i).getAlias());
    }

}