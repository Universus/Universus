package app.universus.Models;

import java.util.List;

import app.universus.AreaDeNotificacion.Notificacion;

public class Alumno extends Usuario{

    private int edad;
    
    public Alumno(String al, String cont, String mat, String ema){
        super(al, cont, mat, ema);
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
}

