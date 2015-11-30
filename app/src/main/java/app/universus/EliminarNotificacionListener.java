package app.universus;

import android.view.View;
import android.widget.Toast;

import app.universus.Models.Usuario;


public class EliminarNotificacionListener implements View.OnClickListener{

    Usuario usuario;

    public EliminarNotificacionListener(Usuario usuario){
        this.usuario = usuario;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(), "Eliminado", Toast.LENGTH_SHORT).show();
    }
}
