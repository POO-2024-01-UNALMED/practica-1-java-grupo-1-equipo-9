package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Empleado;

public class BonoEmpleado {
	
	private int id;
	private boolean is_activo;
	private float dinero_requerido;
	private int puntos_ganados;
	
	

	public static ArrayList<BonoEmpleado> bonosActivos(ArrayList<BonoEmpleado> bonosEmpleados) {
		
		ArrayList<BonoEmpleado> resultado = new ArrayList<>();
				
		for (BonoEmpleado bonoEmpleado : bonosEmpleados) {
			
			if (bonoEmpleado.getIs_activo()) {
				
				resultado.add(bonoEmpleado);
				
			}
			
		}
				
		return resultado;
		
	}
	
	
	public static void bonificarEmpleado(Empleado empleado , float total_vendido , ArrayList<BonoEmpleado> bonosEmpleados) {
		
		ArrayList<BonoEmpleado> bonos_activos = BonoEmpleado.bonosActivos(bonosEmpleados);
		
		BonoEmpleado bono_elegido = new BonoEmpleado();
		
		//Elegir el bono que más puntos le dé al empleado
		for (BonoEmpleado bono: bonos_activos) {
			
			boolean es_mejor_bono = (total_vendido > bono.getDinero_requerido()) && (bono_elegido.getPuntos_ganados() < bono.getPuntos_ganados());
			
			if (es_mejor_bono) {
				
				bono_elegido = bono;
				
			}
			
		}
		
	   
		//En caso de que el empleado pueda recibir el bono
		if (bono_elegido.getPuntos_ganados() > 0) {
			
			int puntos_empleado = empleado.getPuntos();
			int puntos_bono = bono_elegido.getPuntos_ganados();
			int total_puntos = puntos_empleado + puntos_bono;
			
			empleado.setPuntos(total_puntos);
			
		}
		
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getIs_activo() {
		return is_activo;
	}
	public void setIs_activo(boolean is_activo) {
		this.is_activo = is_activo;
	}
	public float getDinero_requerido() {
		return dinero_requerido;
	}
	public void setDinero_requerido(float dinero_requerido) {
		this.dinero_requerido = dinero_requerido;
	}
	public int getPuntos_ganados() {
		return puntos_ganados;
	}
	public void setPuntos_ganados(int puntos_ganados) {
		this.puntos_ganados = puntos_ganados;
	}
	
	
	

}
