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
	private float precio_base_compra;
	private float impuesto;
	private int cantidad_comprar;
	

	private ArrayList<Unidad> unidades = new ArrayList<>(); //Lista de unidades del producto con codigo y fecha de vencimiento 

	public Producto(String nombre, TipoProducto tipo, float precio, float precio_compra, float precio_base_compra, float impuesto) {
		
		Producto.actual_id += 1; 
		this.id = Producto.actual_id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio_venta = precio;
		this.precio_compra = precio_compra;
		this.precio_base_compra = precio_base_compra;
		this.impuesto = impuesto;
		
	}
	
	public static ArrayList<Unidad> listarProductosPorTipo(TipoProducto tipoProducto, Supermercado supermercado, int cantidad) {
		ArrayList<Unidad> resultado = new ArrayList<>();
		for (Bodega bodega: supermercado.getBodegas()) {
			for (Unidad producto : bodega.getProductos()) {
				//Obtener los productos del tipo solicitado
				//Falta colocar que disminuya la cantidad de unidades
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
	
	
	public static void ordenarProductoPrecioCompra(ArrayList<Producto> productos) {
		
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Float.compare(p1.getPrecio_base_compra(), p2.getPrecio_base_compra());
            }
        });
        
    }
	
	
	//Compara el precio base o normal que debería tener el producto, con el precio actual debido a la inflación
	//Trata de ver si un producto actualmente está barato
	public static boolean productoBarato(Producto producto) {
		
		return producto.getPrecio_compra() < producto.getPrecio_base_compra();
		
	}
	
	
	public static ArrayList<Producto> sugerenciaEficiente(Supermercado supermercado){
		
		ArrayList<Producto> posibles_productos = new ArrayList<Producto>();
		
		ArrayList<Surtidor> surtidores  = supermercado.getSurtidores();
		
		for (Surtidor surtidor : surtidores) {
			
			
			for (Producto producto : surtidor.getProductos() ) {
				
				//El producto actualmente está barato
				boolean barato = Producto.productoBarato(producto);
				
				if (barato) {
					
					posibles_productos.add(producto);
					
				}
				

			}
			
			
		}
		
		
		//Ordenar los productos por precio de compra, de menor a mayor
		Producto.ordenarProductoPrecioCompra(posibles_productos);
	
		
		//En caso de que hayan más de 5 productos obtenidos, solo elegimos los 5 primeros más baratos
		if (posibles_productos.size() > 5) {
		
			return (ArrayList<Producto>) posibles_productos.subList(0, 5);
			
		}
		
		else {
			return posibles_productos;
		}
		
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

	public int getCantidad_comprar() {
		return cantidad_comprar;
	}

	public void setCantidad_comprar(int cantidad_comprar) {
		this.cantidad_comprar = cantidad_comprar;
	}
	
	

	
	
	
}
