package app.universus.AreaDeNotificacion;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import app.universus.com.universus.R;

public class Notificacion {
    public static final int IMPORTANTE = R.drawable.estandar_icono;
    public static final int ESTANDAR = R.drawable.importante_icono;
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

    public static List<String> getImportanciaEtiquetas(){
        List<String> etiquetas = new ArrayList<>();
        etiquetas.add("Importante");
        etiquetas.add("Notificacion");
        etiquetas.add("Sin importancia");

        return etiquetas;
    }

    public static  int getImportanciaIcono(int posicion){
        switch (posicion){
            case 0:
                return IMPORTANTE;
            case 1:
                return ESTANDAR;
            case 2:
                return RECORDATORIO;
            default:
                return RECORDATORIO;
        }
    }
}
