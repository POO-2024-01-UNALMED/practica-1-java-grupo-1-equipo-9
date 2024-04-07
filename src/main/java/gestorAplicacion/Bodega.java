package gestorAplicacion;
import java.util.ArrayList;

public class Bodega {
	private String nombre;
	private String barrio;
	
	//Se recomienda que al agregar algún producto a la lista se haga clonación profunda
	//del objeto del producto, para el manejo del atributo cantidad del producto
	//como vamos a trabajar con un solo atributo de cantidad, necesitamos saber la cantidad
	//de productos que están disponibles y la cantidad de productos que compra el cliente
	//en una orden
	private ArrayList<Producto> productos = new ArrayList<>();
	
	public Bodega(String nombre, String barrio, ArrayList<Producto> productos) {
		this.nombre = nombre;
		this.barrio = barrio;
		this.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
}
