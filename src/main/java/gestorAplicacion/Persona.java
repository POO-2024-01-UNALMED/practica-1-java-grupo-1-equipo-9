package gestorAplicacion;

public class Persona {
	
	private String nombre;
	private long cedula;
	private int puntos;
	
	public Persona(String nombre, long cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getCedula() {
		return cedula;
	}
	
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		
		if (puntos <= 0) {
			this.puntos = 0;
		}
		
		else {
			this.puntos = puntos;
		}
		
	}
}
