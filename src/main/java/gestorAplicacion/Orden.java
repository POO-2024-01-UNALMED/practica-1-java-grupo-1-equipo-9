package gestorAplicacion;
import java.util.ArrayList;
import java.time.*;

public class Orden {
	private int id;
	private static int actual_id = 0;
	private Empleado empleado;
	private Cliente cliente;
	private Supermercado supermercado;
	private ArrayList<Unidad> productos = new ArrayList<>();
	private float precio_total = 0;
	private String fecha;
	private String hora;
	
	
	public Orden(Supermercado supermercado, Empleado vendedor, Cliente comprador) {
		
		Orden.actual_id += 1;
		this.id = Orden.actual_id;
		this.supermercado = supermercado;
		supermercado.agregarOrden(this);
		this.empleado = vendedor;
		this.cliente = comprador;
		this.fecha = LocalDate.now().toString();
		this.hora = LocalTime.now().toString();
		
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
	public ArrayList<Unidad> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Unidad> productos) {
		this.productos = productos;
	}
	public void agregarProducto(Producto producto, int cantidad) {
		for (int i=0;i<cantidad;i++) {
			Unidad unidad = producto.getUnidades().get(0);
			productos.add(unidad);
			unidad.getUbicacion().quitarProducto(unidad);
			producto.getUnidades().remove(unidad);
			
		}
	}
	public void agregarProducto(Producto producto) {
		agregarProducto(producto, 1);
	}
	public void agregarUnidad(Unidad unidad) {
		productos.add(unidad);
	}
	public void quitarUnidad(Unidad unidad) {
		for (int i = 0;i<productos.size();i++) {
			if (productos.get(i) == unidad) {
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
	
	public float calcularPrecioTotal() {
		float total = 0;
		for (Unidad unidad : productos) {
			total += unidad.calcularPrecio();
		}
		return total;
	}
	
	public void completarOrden() {
		precio_total = calcularPrecioTotal();
		for (Unidad unidad : productos) {
			unidad.getTipo().getUnidades().remove(unidad);
			unidad.getUbicacion().quitarProducto(unidad);
		}
		cliente.agregarOrden(this);
	}
}