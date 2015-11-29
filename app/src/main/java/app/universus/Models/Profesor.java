package app.universus.Models;

public class Profesor extends Usuario{

    private  double calificacion;
    private String cubo;
	private int edad;
    
    public Profesor(String alias, String contrasenya,
					String matricula, String email){
		super(alias, contrasenya, matricula, email);
        calificacion = 10;
        cubo = "";
		edad = 0;
    }
	
	public void setCalificacion(double calificacion){
		this.calificacion = calificacion;
	}
	
	public double getCalificacion(){
		return calificacion;
	}
	
	public void setCubo(String cubo){
		this.cubo = cubo;
	}
	
	public String getCubo(){
		return cubo;
	}
	
	public void setEdad(int edad){
		this.edad = edad;
	}
	
	public int getEdad(){
		return edad;
	}
    
}
