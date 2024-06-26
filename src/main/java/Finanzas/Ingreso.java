package finanzas;

import java.util.ArrayList;

import DataTiempo.Tiempo;
import gestorAplicacion.Orden;
import gestorAplicacion.Producto;
import gestorAplicacion.Supermercado;

//Fecha
import java.time.LocalDate;

//Hora
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ingreso {
	
	private int id;
	private static int actual_id;
	private String fecha;
	private String hora;
	private float ganancia_total;
	private Orden orden;
	private ArrayList<Producto> productos;	
	private Supermercado supermercado;
	
	
	
	public Ingreso(float ganancia_total, Orden orden, ArrayList<Producto> productos, Supermercado supermercado) {
		
		//El id se registra automaticamente
		Ingreso.actual_id += 1;
		this.id = Ingreso.getActual_id();
	
		
		this.fecha = Tiempo.generarFechaActual();
		this.hora = Tiempo.generarHoraActual();
		
		this.ganancia_total = ganancia_total;
		this.orden = orden;
		this.productos = productos;
		
		this.supermercado = supermercado;
		
		
		//Registrar el ingreso en el supermercado
		supermercado.agregarIngreso(this);
		
		//Actualizar el valor total de ingresos
		ArrayList<Ingreso> ingresos_actuales = supermercado.getArrayListIngresos();
		
		float total_ingresos = 0f;
		
		for (Ingreso ingreso : ingresos_actuales) {
			
			total_ingresos += ingreso.getGanancia_total();
			
		}
		
		//Guardar el total de las ganancias de los ingresos
		supermercado.setTotal_ingresos(total_ingresos);
		
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
		return this.ganancia_total;
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
