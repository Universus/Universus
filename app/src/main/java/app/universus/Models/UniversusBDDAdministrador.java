package app.universus.Models;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import app.universus.Controllers.AlumnoController;
import app.universus.RealmObjects.AlumnoModelo;
import app.universus.RealmObjects.Notificacion;
import app.universus.RealmObjects.ProfesorModelo;
import app.universus.com.universus.R;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class UniversusBDDAdministrador {

    Realm alumnosRealm;
    Realm profesoresRealm;
    Realm notificacionesRealm;

    Context context;

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

        this.context = context;
    }

    public static boolean guardar(Object objeto, Context context){
        if(objeto instanceof Notificacion)
            new UniversusBDDAdministrador(context).guardarNotificacion((Notificacion) objeto, context);
        if(objeto instanceof Alumno){
            new UniversusBDDAdministrador(context).guardarAlumno((Alumno) objeto);
        }
        if(objeto instanceof Profesor){
            new UniversusBDDAdministrador(context).guardarProfesor((Profesor) objeto);
        }
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

    public  void guardarAlumno(Alumno alumno){
        alumnosRealm.beginTransaction();
        AlumnoModelo alumnoModelo = alumnosRealm.createObject(AlumnoModelo.class);
        alumnoModelo.setAlias(alumno.getAlias());
        alumnoModelo.setContrasenya(alumno.getContrasenya());
        alumnoModelo.setEmail(alumno.getCorreo());
        alumnoModelo.setMatricula(alumno.getMatr());
        alumnosRealm.commitTransaction();
    }

    public void guardarProfesor(Profesor alumno){
        profesoresRealm.beginTransaction();
        ProfesorModelo alumnoModelo = profesoresRealm.createObject(ProfesorModelo.class);
        alumnoModelo.setAlias(alumno.getAlias());
        alumnoModelo.setContrasenya(alumno.getContrasenya());
        alumnoModelo.setEmail(alumno.getCorreo());
        alumnoModelo.setMatricula(alumno.getMatr());
        profesoresRealm.commitTransaction();
    }

    public static Usuario getUsuario(Context context, String matricula, String contraseña){
        if(matricula.startsWith("1234")){
            return new UniversusBDDAdministrador(context).getAlumno(matricula, contraseña, context);
        }else{
            return new UniversusBDDAdministrador(context).getProfesor( matricula, contraseña, context);
        }
    }

    public Alumno getAlumno(String matricula, String contraseña, Context context){
         RealmResults<AlumnoModelo> r = alumnosRealm.where(AlumnoModelo.class)
                 .equalTo("contrasenya", contraseña)
                 .equalTo("matricula", contraseña).findAll();
            if(r.isEmpty()) return null;

        return convertirAlumno(r.first(), context);
    }

    public Profesor getProfesor(String matricula, String contraseña, Context context){
        RealmResults<ProfesorModelo> r = profesoresRealm.where(ProfesorModelo.class)
                .equalTo("contrasenya", contraseña)
                .equalTo("matricula", contraseña).findAll();
        if(r.isEmpty()) return null;

        return convertirProfesor(r.first(), context);
    }

    private Alumno convertirAlumno(AlumnoModelo objeto, Context context){
        Alumno nuevo = new Alumno(objeto.getAlias(),
                objeto.getContrasenya(),objeto.getMatricula(),
                objeto.getEmail());
        for(ProfesorModelo m : objeto.getProfesores()){
            nuevo.addProfesor(convertirProfesor(m, context));
        }
        nuevo.setImagen(BitmapFactory.decodeResource(context.getResources(), R.drawable.diana_1));
        return nuevo;
    }

    private Profesor convertirProfesor(ProfesorModelo objeto, Context context){
        Profesor nuevo = new Profesor(objeto.getAlias(),
                objeto.getContrasenya(),objeto.getMatricula(),
                objeto.getEmail());
        nuevo.setImagen(BitmapFactory.decodeResource(context.getResources(), R.drawable.diana_1));
        return nuevo;
    }

    public static List<Usuario> getProfesores(Context context){
        UniversusBDDAdministrador admin = new UniversusBDDAdministrador(context);
        RealmResults<ProfesorModelo> r = admin.profesoresRealm.where(ProfesorModelo.class).findAll();
        List<Usuario> usuarios = new ArrayList<>();
        for(ProfesorModelo object : r)
            usuarios.add(admin.convertirProfesor(object, context));
        return usuarios;
    }
}
