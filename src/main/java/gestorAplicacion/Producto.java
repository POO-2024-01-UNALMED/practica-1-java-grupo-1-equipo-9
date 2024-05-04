package gestorAplicacion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Producto {
	private int id;
	private static int actual_id = 0;
	private String nombre;
	private TipoProducto tipo;
	private float precio;
	private float precio_compra;
	private float precio_base_compra;
	private float impuesto;
	private ArrayList<Unidad> unidades = new ArrayList<>(); //Lista de unidades del producto con codigo y fecha de vencimiento 

	public Producto(String nombre, TipoProducto tipo, float precio, float precio_compra, float precio_base_compra, float impuesto) {
		
		Producto.actual_id += 1; 
		this.id = Producto.actual_id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.precio_compra = precio_compra;
		this.precio_base_compra = precio_base_compra;
		this.impuesto = impuesto;
		
	}
	
	public static ArrayList<Unidad> listarProductosPorTipo(TipoProducto tipoProducto, Supermercado supermercado) {
		ArrayList<Unidad> resultado = new ArrayList<>();
		for (Bodega bodega: supermercado.getBodegas()) {
			for (Unidad producto : bodega.getProductos()) {
				//Obtener los productos del tipo solicitado
				if (producto.getTipo().tipo.equals(tipoProducto)) {
					resultado.add(producto);
				}
			}
		}
		return resultado;	
		
	}
	
	/*public static ArrayList<Producto> agregarProductoCarrito(ArrayList<Producto> productosTipo, ArrayList<Producto> productosSolicitados){
		
		for (Producto producto_solicitado : productosSolicitados) {
			
			for (Producto producto_tipo : productosTipo) {
				
				//Agregar al carrito de compras si hay suficientes productos en inventario
				boolean hay_suficientes_productos = (producto_solicitado.getNombre().equals(producto_tipo.getNombre())) && (producto_solicitado.cantidadUnidades() < producto_tipo.cantidadUnidades());
				
				//Falta colocar mensaje al usuario de que no hay más productos disponibles en bodega
				if (hay_suficientes_productos) {
					
					int cantidad_actual = producto_tipo.cantidadUnidades();
					int cantidad_solicitada = producto_solicitado.cantidadUnidades();
					
					int cantidad_actualizada = cantidad_actual - cantidad_solicitada;
					
					//producto_tipo.setCantidad(cantidad_actualizada); (Actualizar cantidades)
					
				}
				
			}
			
		}
		
		
		return productosSolicitados;
		
	}*/

	
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

	public int cantidadUnidades() {
		return unidades.size();
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

	public ArrayList<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(ArrayList<Unidad> unidades) {
		this.unidades = unidades;
	}
	
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}
}
