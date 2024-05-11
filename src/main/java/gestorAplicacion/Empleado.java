package gestorAplicacion;

import java.util.ArrayList;

import recompensas.MetaEmpleado;

public class Empleado extends Persona{
	private int id;
	private boolean activo = true;
	private ArrayList<MetaEmpleado> metas;
	private int puntos;
	public static float salario;
	
	
	public static void despedirEmpleado(Empleado empleado, ArrayList<MetaEmpleado> metas) {
		
	   boolean despedir = MetaEmpleado.cumplioMetas(empleado, metas);
		
	   if (despedir) {
		   
		   empleado.setActivo(false); 
		   System.out.println("Se ha despedido a: " + empleado.getNombre());
		  
	   }
	   
	   
	   
	   
	}
	
	
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
	
	public ArrayList<MetaEmpleado> getMetas() {
		return metas;
	}



	public void setMetas(ArrayList<MetaEmpleado> metas) {
		this.metas = metas;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	
	
}
