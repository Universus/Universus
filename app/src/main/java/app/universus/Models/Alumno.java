package app.universus.Models;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario{

    private int edad;
    private List<Usuario> profesores;
    
    public Alumno(String al, String cont, String mat, String ema){
        super(al, cont, mat, ema);
        profesores = new ArrayList<>();
    }

    public boolean consultaCurso(){
		System.out.println("Ingresa el curso que desees consultar");
        return true;
    }


	public void setEdad(int edad){
		this.edad = edad;
	}
	
	public int getEdad(){
		return edad;
	}

    public void addCurso(){

    }

    public void addProfesor(Profesor p){
        profesores.add(p);
    }

    public List<Usuario> getProfesores(){
        return profesores;
    }

}

