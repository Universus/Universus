package app.universus.AreaDeNotificacion;

import android.graphics.Bitmap;
import app.universus.com.universus.R;

public class Notificacion {
    public static final int IMPORTANTE = R.drawable.importante_icono;
    public static final int ESTANDAR = R.drawable.estandar_icono;
    public static final int RECORDATORIO = R.drawable.recordatorio_icono;


    private Bitmap imagen;
    private String descripcion;
    private int icono;
    private String lugar;

    public Notificacion(Bitmap imagen, String descripcion, int icono, String lugar){
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.icono = icono;
        this.lugar = lugar;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public int getIcono() {
        return icono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public  String getLugar(){
        return lugar;
    }
}
