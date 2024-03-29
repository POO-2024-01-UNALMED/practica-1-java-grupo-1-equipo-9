package gestorAplicacion;
import java.util.ArrayList;
import java.time.*;

public class Orden {
	private int id;
	private TipoOrden tipo;
	private Empleado empleado;
	private Cliente cliente;
	private ArrayList<Producto> productos = new ArrayList<>();
	private float precio_total = 0;
	private String fecha;
	private String hora;
	private float descuentos = 0;
	private Supermercado supermercado;
	private static int generar_id = 0;
	
	public Orden(TipoOrden tipo, Supermercado supermercado, Empleado vendedor, Cliente comprador) {
		this.tipo = tipo;
		this.supermercado = supermercado;
		this.empleado = vendedor;
		this.cliente = comprador;
		this.fecha = LocalDate.now().toString();
		this.hora = LocalTime.now().toString();
		this.id = Orden.generar_id;
		Orden.generar_id++;
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
	public static int getGenerar_id() {
		return Orden.generar_id;
	}
	public static void setGenerar_id(int id) {
		Orden.generar_id = id;
	}
}
