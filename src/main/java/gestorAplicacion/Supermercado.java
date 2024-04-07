package gestorAplicacion;
import java.util.ArrayList;

import recompensas.Descuento;
import recompensas.Promocion;

public class Supermercado {
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private ArrayList<Bodega> bodegas = new ArrayList<>();
	private ArrayList<Orden> ordenes = new ArrayList<>();
	private ArrayList<Promocion> promociones = new ArrayList<>();
	private ArrayList<Descuento> descuentos = new ArrayList<>();
	
	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}


	public Supermercado(String nombre, ArrayList<Empleado> empleados, ArrayList<Bodega> bodegas) {
		this.nombre = nombre;
		this.empleados = empleados;
		this.bodegas = bodegas;
	}
	
	
	public void vender() {
		
		
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void agregarOrden(Orden orden) {
		ordenes.add(orden);
	}
	
	public void quitarOrden(Orden orden) {
		for (int i = 0;i<ordenes.size();i++) {
			if (ordenes.get(i) == orden) {
				ordenes.remove(i);
				break;
			}
		}
	}
	
	public void agregarBodega(Bodega bodega) {
		bodegas.add(bodega);
	}
	
	public void quitarBodega(Bodega bodega) {
		for (int i = 0;i<bodegas.size();i++) {
			if (bodegas.get(i) == bodega) {
				bodegas.remove(i);
				break;
			}
		}
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void quitarEmpleado(Empleado empleado) {
		for (int i = 0;i<empleados.size();i++) {
			if (empleados.get(i) == empleado) {
				empleados.remove(i);
				break;
			}
		}
	}
}
