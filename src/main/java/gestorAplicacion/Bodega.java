package gestorAplicacion;
import java.util.ArrayList;

public class Bodega {
	private String nombre;
	private String barrio;
	private Supermercado supermercado;
	private ArrayList<Unidad> productos = new ArrayList<>();
	private ArrayList<ArrayList<Unidad>> promos = new ArrayList<>();
	
	public Bodega(String nombre, String barrio, Supermercado supermercado) {
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

	public Supermercado getSupermercado() {
		return supermercado;
	}
	
	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
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
	
	public ArrayList<ArrayList<Unidad>> getPromos() {
		return promos;
	}
	
	public void setPromos(ArrayList<ArrayList<Unidad>> promos) {
		this.promos = promos;
	}
	
	public void agragarPromo(ArrayList<Unidad> promo) {
		promos.add(promo);
	}
	
	public void quitarProducto(Unidad unidad) {
		productos.remove(unidad);
	}
	
}
