package gestorAplicacion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class Producto{
	
	private int id;
	private static int actual_id;
	private String nombre;
	private TipoProducto tipo;
	private float precio_venta;
	private float precio_compra;
	private float precio_base_compra; //El precio precio_base_compra es el que normalmente debería encontrarse el producto cuando el supermercado le compra al surtidor.
									  //Por ejemplo un tomate puede que normalmente valga $2.000 pero otras veces su precio será superior al esperado.

	private int cantidad_comprar;
	private int cantidad_venta;
	
	private ArrayList<Unidad> unidades = new ArrayList<Unidad>(); //Lista de unidades del producto con codigo y fecha de vencimiento 
	
	public Producto(String nombre, TipoProducto tipo, float precio_venta, float precio_compra, float precio_base_compra) {
		
		Producto.actual_id += 1; 
		this.id = Producto.actual_id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio_venta = precio_venta;
		this.precio_compra = precio_compra;
		this.precio_base_compra = precio_base_compra;
		
		
	}
	
	//Información necesaria que se pasará desde el método agregarProductoCarrito() para después calcular el cobro total 
	public Producto(TipoProducto tipo, float precio_venta, int cantidad_venta) {
		this.tipo = tipo;
		this.precio_venta = precio_venta;
		this.cantidad_venta = cantidad_venta;
	}
	
	
	public static ArrayList<Producto> listarProductosPorTipo(TipoProducto tipoProducto, Supermercado supermercado) {
		
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		
		for (Bodega bodega: supermercado.getBodegas()) {
			for (Producto producto : bodega.getProductos()) {
				
				//Obtener los productos del tipo solicitado
				if (producto.getTipo().equals(tipoProducto)) {
					resultado.add(producto);
				}
				
			}
		}
		
		return resultado;	

	}
	
	
	
	public static Producto agregarProductoCarrito(Producto producto, int cantidadIngresada){
		
		boolean haySuficientesUnidades = producto.cantidadUnidades() >= cantidadIngresada;
		Producto resultado = new Producto(producto.getTipo(), 0,0);
	
		
		int unidadesdNoVencidas = 0;
		
		ArrayList<Unidad> unidadesParaEliminar = new ArrayList<Unidad>();
		
		//El supermercado tiene suficiente cantidad de unidades del producto solicitado
		//pero falta revisar si ninguna está vencida.
		if (haySuficientesUnidades) {
			
			for (Unidad unidad : producto.getUnidades()) {
				
				//Solo seleccionamos unidades que les falten 15 días para su vencimiento
				if ( unidad.diasParaVencimiento() >= 15 ) {
					
					unidadesdNoVencidas++;
				
			
			
					unidadesParaEliminar.add(unidad);
					
					//En caso de haber obtenido la cantidad de unidades esperadas para la venta
					if (unidadesdNoVencidas == cantidadIngresada) {
						break;
					}
					
				}
				
			}
			
			//Eliminamos de nuestro inventario las unidades seleccionadas para vender 
			if (unidadesParaEliminar.size() > 0) {
				producto.getUnidades().removeAll(unidadesParaEliminar);
			}
				
			 
		
			//Sobreescribimos el valor del objeto al que hace referencia el apuntador "resultado"
			//a los atributos cantidad_venta  y precio_venta
			//posteriormente usamos esos datos para calcular el total a cobrar
			resultado.setPrecio_Venta(producto.getPrecio_Venta());
			resultado.setCantidad_venta(unidadesdNoVencidas);
			
			//Nos aseguramos si hemos recolectado todas las unidades solicitadas inicialmente
			boolean todasElegidas = (unidadesdNoVencidas == cantidadIngresada);
			
			//En caso de no haber recolectado la cantidad de unidades solicitada inicialmente
			if (!todasElegidas) {
				
				int cantidadFaltante = cantidadIngresada - unidadesdNoVencidas;
				
				System.out.println("¡Vaya!... lo sentimos, pero hicieron falta: " + cantidadFaltante + " Unidades del producto: " + producto.getNombre().toUpperCase());
				System.out.println("Esto se debe a que las otras unidades faltantes estaban a punto de vencerse o ya se vencieron :,,(");
				
			}
	
		}
		
		//Cuando el supermercado no tiene la cantidad de unidades del producto que busca el cliente
		else {
			
			System.out.println("Lo sentimos pero no tenemos la cantidad de unidades que buscas del producto: || " + producto.getNombre() + " || " + 
					" :'(");
			
		}
		
		return resultado;
		
	}
	
	
	public static float calcularCobroTotal(ArrayList<Producto> productos_listados) {
		
		float cobro_total = 0f;
		
		for (Producto producto : productos_listados) {
			
			cobro_total += producto.getPrecio_Venta();
			
		}
		
		return cobro_total;
	
	}
	
	
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

	public float getPrecio_Venta() {
		return precio_venta;
	}

	public void setPrecio_Venta(float precio) {
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

	public int getCantidad_venta() {
		return cantidad_venta;
	}

	public void setCantidad_venta(int cantidad_venta) {
		this.cantidad_venta = cantidad_venta;
	}
	
	
	
	

	
	
	
}
