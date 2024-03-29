package gestorAplicacion;
import java.util.ArrayList;

public class Cliente extends Persona{
	private ArrayList<Orden> ordenes = new ArrayList<>();
	
	public Cliente(String nombre, long cedula) {
		super(nombre, cedula);
	}
	
	public void agregarOrden(Orden orden) {
		ordenes.add(orden);
	}
}
