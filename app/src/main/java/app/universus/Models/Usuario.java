package app.universus.Models;

import java.util.ArrayList;
import java.util.List;

import app.universus.AreaDeNotificacion.Notificacion;
import app.universus.Helpers.Foto;
import io.realm.RealmObject;

public class Usuario{
    private String alias;
    private String contrasenya;
    private String matricula;
    private String email;
    
    private Foto fotoDePerfil;
	List<Notificacion> notificaciones;

    public Usuario(String alias, String contrasenya,
				   String matricula, String email){
        this.alias = alias;
        this.contrasenya = contrasenya;
        this.matricula = matricula;
        this.email = email;
		notificaciones = new ArrayList<Notificacion>();
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
}
