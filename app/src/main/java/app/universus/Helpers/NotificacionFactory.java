package app.universus.Helpers;

import java.util.ArrayList;
import java.util.List;

import app.universus.RealmObjects.Notificacion;
import app.universus.com.universus.R;

public class NotificacionFactory {

    public static final int IMPORTANTE = R.drawable.estandar_icono;
    public static final int ESTANDAR = R.drawable.importante_icono;
    public static final int RECORDATORIO = R.drawable.recordatorio_icono;


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

    public static Notificacion newInstance(int imagen, String descripcion, int icono, String lugar, String autor){
        Notificacion nueva = new Notificacion();

        nueva.setImagen(imagen);
        nueva.setDescripcion(descripcion);
        nueva.setIcono(icono);
        nueva.setLugar(lugar);
        nueva.setAutor(autor);
        return nueva;
    }
}
