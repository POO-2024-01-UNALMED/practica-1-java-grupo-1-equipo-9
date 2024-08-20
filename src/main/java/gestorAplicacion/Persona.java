package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public  abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private long cedula;
	private String cargo;
	private static ArrayList<Persona> personas = new ArrayList<>();
	
	public Persona(String nombre, long cedula) {
		this(nombre, cedula, "Cliente");
	}
	
	public Persona(String nombre, long cedula, String cargo) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.cargo = cargo;
		personas.add(this);
	}
	
	public abstract String informacion();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getCedula() {
		return cedula;
	}
	
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public static ArrayList<Persona> getPersonas() {
		return personas;
	}

	public static void setPersonas(ArrayList<Persona> personas) {
		Persona.personas = personas;
	}
	
	public static void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	
	@Override
    public String toString() {
        return "Persona con nombre "+this.getNombre()+" y cédula "+this.getCedula();
	}
}
