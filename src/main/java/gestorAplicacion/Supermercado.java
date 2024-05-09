package gestorAplicacion;
import java.security.PublicKey;
import java.util.ArrayList;

import finanzas.Impuesto;
import recompensas.BonoCliente;
import recompensas.Descuento;


public class Supermercado {
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private ArrayList<Bodega> bodegas = new ArrayList<>();
	private ArrayList<Orden> ordenes = new ArrayList<>();
	private ArrayList<BonoCliente> promociones = new ArrayList<>();
	private ArrayList<Descuento> descuentos = new ArrayList<>();
	
	//Asignar pago de impuesto, sea automático o manual los pagos al fin de mes
	private boolean pago_impuesto_auto;

	public Supermercado(String nombre) {
		this.nombre = nombre;
	}
	
	
	public static void pagarImpuestos(ArrayList<Impuesto> impuestos, float ingresos) {
		
	  	
	  ArrayList<Impuesto> impuestos_actuales = Impuesto.listarImpuestos(impuestos);
	  
	  float total_pagado = Impuesto.tributar(impuestos_actuales, ingresos);
	  
	  System.out.println("El pago de los impuestos se realizó con éxito, total: " + total_pagado);
	  
	  
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
	
	public boolean getPagoImpuestoAuto() {
		return this.pago_impuesto_auto;
	}
	
	public void setPagoImpuestoAuto(boolean value) {
		this.pago_impuesto_auto = value;
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
	
	public ArrayList<BonoCliente> getPromociones() {
		return promociones;
	}
	
	public void verificarVencimiento() {
		for (Bodega bodega : this.getBodegas()) {
			for (Unidad unidad : bodega.getProductos()) {
				if (unidad.diasParaVencimiento() < 15) {
					if (unidad.diasParaVencimiento() >= 0) {
						System.out.println("Al producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " le quedan " + unidad.diasParaVencimiento() + " días para vencer.");
					}
					else {
						System.out.println("El producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " se venció hace " + (unidad.diasParaVencimiento() * -1) + 
								" días.");
					}
					//Verificar si el producto se encuentra en descuento, sino, agregarlo
				}	
			}
		}
	}
}
