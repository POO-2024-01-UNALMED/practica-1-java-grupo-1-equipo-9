package gestorAplicacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Producto {
	private int id;
	private static int actual_id = 0;
	private String nombre;
	private TipoProducto tipo;
	private float precio_venta;
	private float precio_compra;
	private static ArrayList<Producto> lista_productos = new ArrayList<>();
	private ArrayList<Unidad> unidades = new ArrayList<>(); //Lista de unidades del producto con codigo y fecha de vencimiento 

	public Producto(String nombre, TipoProducto tipo, float precio, float precio_compra) {
		
		Producto.actual_id += 1; 
		id = Producto.actual_id;
		this.nombre = nombre;
		this.tipo = tipo;
		precio_venta = precio;
		this.precio_compra = precio_compra;
		Producto.lista_productos.add(this);		
	}
	
	public static ArrayList<Unidad> listarProductosPorTipo(TipoProducto tipoProducto, Supermercado supermercado, int cantidad) {
		ArrayList<Unidad> resultado = new ArrayList<>();
		for (Bodega bodega: supermercado.getBodegas()) {
			for (Unidad producto : bodega.getProductos()) {
				if (producto.getTipo().tipo.equals(tipoProducto)) {
					resultado.add(producto);
				}
			}
		}
		return resultado;	
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
		return precio_venta;
	}

	public void setPrecio(float precio) {
		this.precio_venta = precio;
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

	public ArrayList<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(ArrayList<Unidad> unidades) {
		this.unidades = unidades;
	}
	
	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	
	public static ArrayList<Producto> getLista_productos() {
		return lista_productos;
	}

	public static void setLista_productos(ArrayList<Producto> lista_productos) {
		Producto.lista_productos = lista_productos;
	}

}
