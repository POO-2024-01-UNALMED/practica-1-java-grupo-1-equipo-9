package gestorAplicacion;
import java.util.ArrayList;

public class Bodega {
	
	private String nombre;
	private String barrio;
	private ArrayList<Producto> productos;
	
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
