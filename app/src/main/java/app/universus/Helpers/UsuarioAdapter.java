package app.universus.Helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import app.universus.Models.Usuario;
import app.universus.com.universus.R;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder>{
    private List<Usuario> items;
    ViewGroup viewGroup;

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
        this.viewGroup = viewGroup;
        return new UsuarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder viewHolder, int i) {
        Bitmap imagen = items.get(i).getImagen();
        if(imagen == null){
            imagen = BitmapFactory.decodeResource(viewGroup.getResources(),
                    R.drawable.diana_1);
        }
        ImagenCircular imagenCircular = new ImagenCircular(imagen);
        viewHolder.imagen.setImageDrawable(imagenCircular);
        viewHolder.nombre.setText(items.get(i).getAlias());
    }

}