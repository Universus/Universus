package app.universus.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.universus.RealmObjects.Notificacion;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class UniversusBDDAdministrador {

    Realm alumnosRealm;
    Realm profesoresRealm;
    Realm notificacionesRealm;

    public  UniversusBDDAdministrador(Context context){
        RealmConfiguration config_alumnos = new RealmConfiguration.Builder(context)
            .name("alumnos_2.realm")
            .schemaVersion(3)
            .build();
        alumnosRealm = Realm.getInstance(config_alumnos);

        RealmConfiguration config_profesores = new RealmConfiguration.Builder(context)
                .name("profesores_2.realm")
                .schemaVersion(3)
                .build();
        profesoresRealm = Realm.getInstance(config_profesores);

        RealmConfiguration config_notificaciones= new RealmConfiguration.Builder(context)
                .name("notificacion_2.realm")
                .schemaVersion(3)
                .build();
        notificacionesRealm = Realm.getInstance(config_notificaciones);
    }

    public static boolean guardar(Object objeto, Context context){
        if(objeto instanceof Notificacion)
            new UniversusBDDAdministrador(context).guardarNotificacion((Notificacion) objeto, context);
        if(objeto instanceof Usuario)
            new UniversusBDDAdministrador(context).guardarUsuario((Usuario) objeto, context);
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

    public List<Notificacion> getNotificaciones(){
        RealmResults<Notificacion> r = notificacionesRealm.where(Notificacion.class).findAll();
        List<Notificacion> resultado = new ArrayList<>();
        for(Notificacion nueva : r)
            resultado.add(nueva);
        return resultado;
    }

    public void guardarUsuario(Usuario usuario, Context context){

    }

}
