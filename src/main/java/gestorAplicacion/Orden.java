package gestorAplicacion;
import java.util.ArrayList;

import DataTiempo.Tiempo;
import finanzas.Ingreso;
import java.time.*;
import recompensas.*;

public class Orden {
	
	private int id;
	private static int actual_id;
	private TipoOrden tipo;
	private Empleado empleado;
	private Cliente cliente;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private float precio_total;
	private String fecha;
	private String hora;
	private float descuentos;
	private Supermercado supermercado;
	
	
	public Orden(TipoOrden tipo, Supermercado supermercado, Empleado vendedor, Cliente comprador) {
		
		Orden.actual_id += 1;
		this.id = Orden.actual_id;
		
		this.tipo = tipo;
		this.supermercado = supermercado;
		this.empleado = vendedor;
		this.cliente = comprador;
		this.fecha = Tiempo.generarFechaActual();
		this.hora = Tiempo.generarHoraActual();
		
	}
	
	
	public static void generarOrden(TipoOrden tipoOrden, Supermercado supermercado, Empleado vendedor , Cliente cliente, ArrayList<Producto> productos_listados, ArrayList<BonoCliente> promociones, ArrayList<Descuento> descuentos) {
		
		
		float cobro_total = Producto.calcularCobroTotal(productos_listados);
		
		//Bonificar cliente
		BonoCliente.bonificarCliente(cliente, productos_listados, cobro_total , promociones);
		
		//Calcular el porcentaje de descuento del cliente
		int porcentaje_descuento = Descuento.calcularDescuento(cliente, descuentos);
		
		if (porcentaje_descuento > 0) {
			
			cobro_total -= (cobro_total * porcentaje_descuento) / 100;
			
		}
		
		//Registrar nueva orden
		Orden nueva_orden = new Orden(tipoOrden, supermercado, vendedor, cliente);
		ArrayList<Orden> ordenes = supermercado.getOrdenes();
		ordenes.add(nueva_orden);
		supermercado.setOrdenes(ordenes);
		
		
		//Registrar ingreso
		Ingreso nuevo_ingreso = new Ingreso(cobro_total, nueva_orden, productos_listados, supermercado); 
		ArrayList<Ingreso> ingresos = supermercado.getArrayListIngresos();
		ingresos.add(nuevo_ingreso);
		supermercado.setIngresos(ingresos);
		
		
		System.out.println("Hemos registrado con éxito la Orden para el supermercado: " + supermercado.getNombre());
		System.out.println("Fecha: " + Tiempo.formatoFecha(nueva_orden.getFecha()));
		System.out.println("Hora: " + Tiempo.formatoHora(nueva_orden.getHora()));
	
		
	}
	
	
	
	
	public TipoOrden getTipo() {
		return tipo;
	}

	public void setTipo(TipoOrden tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	public void quitarProducto(Producto producto) {
		for (int i = 0;i<productos.size();i++) {
			if (productos.get(i) == producto) {
				productos.remove(i);
				break;
			}
		}
	}
	public float getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}
	public float getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(float descuentos) {
		this.descuentos = descuentos;
	}
	public Supermercado getSupermercado() {
		return supermercado;
	}
	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
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
	
	
	
}
