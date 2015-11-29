package app.universus.Models;

import java.util.List;

public class Grupo {
    List<Usuario> alumnos;
    List<Usuario> profesores;
    int imagen;
    String nombre;

    public Grupo(String nombre, int imagen){
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public void addAlumno(Alumno alumno){
        alumnos.add(alumno);
    }

    public void addProfesor(Profesor profesor){
        profesores.add(profesor);
    }

    public List<Usuario> getAlumnos(){
        return alumnos;
    }

    public List<Usuario> getProfesores(){
        return profesores;
    }

    public int getImagen(){
        return imagen;
    }

    public String getNombre(){
        return nombre;
    }
}
