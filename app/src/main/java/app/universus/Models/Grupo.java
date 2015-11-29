package app.universus.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Grupo {
    List<Usuario> alumnos;
    List<Usuario> profesores;
    int imagen;
    String nombre;

    public Grupo(String nombre, int imagen){
        this.nombre = nombre;
        this.imagen = imagen;
        alumnos = new ArrayList<>();
        profesores = new ArrayList<>();
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
