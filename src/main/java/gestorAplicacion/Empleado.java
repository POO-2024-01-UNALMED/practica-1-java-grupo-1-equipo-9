package gestorAplicacion;

import java.util.ArrayList;
import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean activo = true;
	private float salario;
	private Supermercado supermercado;
	private static int actual_id = 0;
	private static ArrayList<Persona> empleados = new ArrayList<>();
	
	
	public Empleado(String nombre, long cedula,Supermercado supermercado, String cargo, float salario) {
		super(nombre, cedula, cargo);
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

	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}
	
}
