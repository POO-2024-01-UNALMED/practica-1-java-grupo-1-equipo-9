package finanzas;

import java.util.ArrayList;

import gestorAplicacion.Orden;
import gestorAplicacion.Producto;

//Fecha
import java.time.LocalDate;

//Hora
import java.time.LocalTime;

public class Ingreso {
	
	private int id;
	private static int actual_id;
	private String fecha;
	private String hora;
	private float ganancia_total;
	private Orden orden;
	private ArrayList<Producto> productos;
	
	
	
	
	public Ingreso(float ganancia_total, Orden orden, ArrayList<Producto> productos) {
		
		//El id se registra automaticamente
		Ingreso.actual_id += 1;
		this.id = Ingreso.getActual_id();
	
		
		this.fecha = fechaActual();
		this.hora = horaActual();
		
		this.ganancia_total = ganancia_total;
		this.orden = orden;
		this.productos = productos;
	}
	
	

	public static void registrarIngreso(float ganancia_total, Orden orden, ArrayList<Producto> productos) {
		
		new Ingreso(ganancia_total, orden, productos);
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	public static int getActual_id() {
		return Ingreso.actual_id;
	}


	public static void setActual_id(int actual_id) {
		Ingreso.actual_id = actual_id;
	}

	
	public String fechaActual() {
		
		String fecha = LocalDate.now().toString();
		
		return fecha;
		
	}
	
	public String horaActual() {
		
		String hora = LocalTime.now().toString();
		
		return hora;
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public float getGanancia_total() {
		return ganancia_total;
	}
	public void setGanancia_total(float ganancia_total) {
		this.ganancia_total = ganancia_total;
	}
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	

}
