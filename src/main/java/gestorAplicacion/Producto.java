package gestorAplicacion;

public class Producto {
	private int id;
	private String nombre;
	private TipoProducto tipo;
	private float precio;
	private int cantidad;
	private float precio_compra;
	private float precio_base_compra;
	private float impuesto;
	private static int generar_id = 0;

	public Producto(String nombre, TipoProducto tipo, float precio, int cantidad, float precio_compra, float precio_base_compra, float impuesto) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precio_compra = precio_compra;
		this.precio_base_compra = precio_base_compra;
		this.impuesto = impuesto;
		this.id = Producto.generar_id;
		Producto.generar_id++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}

	public float getPrecio_base_compra() {
		return precio_base_compra;
	}

	public void setPrecio_base_compra(float precio_base_compra) {
		this.precio_base_compra = precio_base_compra;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public static int getGenerar_id() {
		return generar_id;
	}

	public static void setGenerar_id(int generar_id) {
		Producto.generar_id = generar_id;
	}
	
	
}
