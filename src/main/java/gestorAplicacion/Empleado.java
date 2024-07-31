package gestorAplicacion;

import java.util.ArrayList;

public class Empleado extends Persona{
	private int id;
	private boolean activo = true;
	private float salario;
	private Supermercado supermercado;
	private static int actual_id = 0;
	
	
	public Empleado(String nombre, long cedula,Supermercado supermercado, float salario) {
		super(nombre, cedula);
		this.salario = salario;
		this.supermercado = supermercado;
		supermercado.agregarEmpleado(this);
		Empleado.actual_id += 1;
		id = Empleado.actual_id;
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
