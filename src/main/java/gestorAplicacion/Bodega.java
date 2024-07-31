package gestorAplicacion;
import java.util.ArrayList;

public class Bodega {
	private String nombre;
	private String barrio;
	private ArrayList<Unidad> productos = new ArrayList<>();
	
	public Bodega(String nombre, String barrio) {
		this.nombre = nombre;
		this.barrio = barrio;
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

	public ArrayList<Unidad> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Unidad> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Unidad unidad) {
		productos.add(unidad);
	}
	
	public void quitarProducto(Unidad unidad) {
		productos.remove(unidad);
	}
	
}
