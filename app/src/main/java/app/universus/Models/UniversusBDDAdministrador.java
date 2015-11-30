package app.universus.Models;

import android.content.Context;

import app.universus.AreaDeNotificacion.Notificacion;
import io.realm.Realm;
import io.realm.RealmObject;

public class UniversusBDDAdministrador {
    UniversusBDDAdministrador(){

    }

    public static boolean guardar(RealmObject objeto, Context context){
        if(objeto instanceof Notificacion)
            new UniversusBDDAdministrador().guardarNotificacion((Notificacion) objeto, context);
        return true;
    }

    public boolean guardarNotificacion(Notificacion objeto, Context context){
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Notificacion nuevo = realm.createObject(Notificacion.class);
        nuevo.setDescripcion(objeto.getDescripcion());
        nuevo.setLugar(objeto.getLugar());
        nuevo.setIcono(objeto.getIcono());
        nuevo.setImagen(objeto.getImagen());
        realm.commitTransaction();
        return true;
    }
}
