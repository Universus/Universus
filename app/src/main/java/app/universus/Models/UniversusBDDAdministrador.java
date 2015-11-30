package app.universus.Models;

import android.content.Context;
import android.util.Log;

import app.universus.AreaDeNotificacion.Notificacion;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class UniversusBDDAdministrador {

    Realm alumnosRealm;
    Realm profesoresRealm;
    Realm notificacionesRealm;

    public  UniversusBDDAdministrador(Context context){
        alumnosRealm = Realm.getInstance(context, "alumnos.realm");
        profesoresRealm = Realm.getInstance(context, "profesores.realm");
        notificacionesRealm = Realm.getInstance(context, "notificaciones.realm");
    }

    public static boolean guardar(RealmObject objeto, Context context){
        if(objeto instanceof Notificacion)
            new UniversusBDDAdministrador(context).guardarNotificacion((Notificacion) objeto, context);
        return true;
    }

    public boolean guardarNotificacion(Notificacion objeto, Context context){
        notificacionesRealm.beginTransaction();
        Notificacion nuevo = notificacionesRealm.createObject(Notificacion.class);
        nuevo.setDescripcion(objeto.getDescripcion());
        nuevo.setLugar(objeto.getLugar());
        nuevo.setIcono(objeto.getIcono());
        nuevo.setImagen(objeto.getImagen());
        notificacionesRealm.commitTransaction();
        return true;
    }

    public static boolean remover(RealmObject objecto, Context context) {
        if (objecto instanceof Notificacion) {
            new UniversusBDDAdministrador(context).removerNotificacion((Notificacion) objecto, context);
        }
        return true;
    }

    public boolean removerNotificacion(Notificacion objeto, Context context){

        RealmResults<Notificacion> r = notificacionesRealm.where(Notificacion.class)
                .beginGroup()
                    .equalTo("descripcion", objeto.getDescripcion())
                    .equalTo("lugar", objeto.getLugar())
                .endGroup()
                .findAll();
        notificacionesRealm.beginTransaction();

        Notificacion encontrada = r.first();
        encontrada.removeFromRealm();

        notificacionesRealm.commitTransaction();
        return true;
    }

    public RealmResults<Notificacion> getNotificaciones(){
        return notificacionesRealm.where(Notificacion.class).findAll();
    }
}
