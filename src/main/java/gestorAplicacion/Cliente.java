package gestorAplicacion;
import java.util.ArrayList;
import java.io.Serializable;

public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Orden> ordenes = new ArrayList<>();
	private static ArrayList<Persona> clientes = new ArrayList<>();
	private int puntos = 0;

	public Cliente(String nombre, long cedula) {
		super(nombre, cedula);
	}
	
	public void agregarOrden(Orden orden) {
		ordenes.add(orden);
	}
	
	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}