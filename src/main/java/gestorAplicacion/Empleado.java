package gestorAplicacion;

public class Empleado extends Persona{
	private int id;
	private boolean activo = true;
	
	public Empleado(int id, String nombre, long cedula) {
		super(nombre, cedula);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
