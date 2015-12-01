package app.universus.Models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

import app.universus.RealmObjects.Notificacion;

public class Usuario{
    private String alias;
    private String contrasenya;
    private String matricula;
    private String email;

	private Bitmap imagen;

	List<Grupo> grupos;
	List<Notificacion> notificaciones;

    public Usuario(String alias, String contrasenya,
				   String matricula, String email){
        this.alias = alias;
        this.contrasenya = contrasenya;
        this.matricula = matricula;
        this.email = email;
		notificaciones = new ArrayList<>();
		grupos = new ArrayList<>();
    }

	public Bitmap getImagen(){
		return imagen;
	}

	public void setImagen(Bitmap imagen){
		this.imagen = imagen;
	}

    public boolean resgitrarse(){
		 return true;
    }
	
	public void setAlias(String alias){
		this.alias = alias;
	}
	
	public String getAlias(){
		return alias;
	}
	
	public void setContrasenya(String contrasenya){
		this.contrasenya = contrasenya;
	}
	
	public String getContrasenya(){
		return contrasenya;
	}
	
	public void setMatr(String matricula){
		this.matricula = matricula;
	}
	
	public String getMatr(){
		return matricula;
	}
	
	public void setCorreo(String email){
		this.email = email;
	}
	
	public String getCorreo(){
		return email;
	}

	public  void addNotificacion(Notificacion notificacion){
		notificaciones.add(notificacion);
	}

	public List<Notificacion> getNotificaciones(){
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> lista){
		this.notificaciones = lista;
	}
}
