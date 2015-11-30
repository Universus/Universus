package app.universus.Models;

import android.content.Context;
import android.util.Log;

import app.universus.AreaDeNotificacion.Notificacion;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

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

    public static boolean remover(RealmObject objecto, Context context) {
        if (objecto instanceof Notificacion) {
            new UniversusBDDAdministrador().removerNotificacion((Notificacion) objecto, context);
        }
        return true;
    }

    public boolean removerNotificacion(Notificacion objeto, Context context){
        Realm realm = Realm.getInstance(context);
        RealmResults<Notificacion> r = realm.where(Notificacion.class)
                .beginGroup()
                    .equalTo("descripcion", objeto.getDescripcion())
                    .equalTo("lugar", objeto.getLugar())
                .endGroup()
                .findAll();
        realm.beginTransaction();

        Notificacion encontrada = r.first();
        encontrada.removeFromRealm();

        realm.commitTransaction();
        return true;
    }
}
