package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Empleado;

public class PagoBonoEmpleado {
	
	private int id;
	private boolean is_activo;
	private float puntos_necesarios;
	private int porcentaje_ganancia;
	
	

	public static ArrayList<PagoBonoEmpleado> pagosBonosActivos(ArrayList<PagoBonoEmpleado> pagosBonosEmpleados) {
		
		ArrayList<PagoBonoEmpleado> resultado = new ArrayList<>();
				
		for (PagoBonoEmpleado pagoBonoEmpleado : pagosBonosEmpleados) {
			
			if (pagoBonoEmpleado.getIs_activo()) {
				
				resultado.add(pagoBonoEmpleado);
				
			}
			
		}
				
		return resultado;
		
	}
	
	public static int obtenerPorcentajeBonoEmpleado(Empleado empleado, ArrayList<PagoBonoEmpleado> pagosBonosEmpleados) {
		
	  ArrayList<PagoBonoEmpleado> pagosBonosActivos = PagoBonoEmpleado.pagosBonosActivos(pagosBonosEmpleados);
	  PagoBonoEmpleado mejor_pago = null;
	  
	  for (PagoBonoEmpleado pagosBonosActivo: pagosBonosActivos) {
		  
		  boolean es_mejor_pago = (empleado.getPuntos() > pagosBonosActivo.getPuntos_necesarios()) && (pagosBonosActivo.getPorcentaje_ganancia() > mejor_pago.getPorcentaje_ganancia());
		  
		  if (es_mejor_pago) {
			  
			  mejor_pago = pagosBonosActivo;
			  
		  }
		  
	  }
	  
	  
	  int resultado = mejor_pago.getPorcentaje_ganancia();
	  
	  return resultado;
	  
		
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
	public float getPuntos_necesarios() {
		return puntos_necesarios;
	}
	public void setPuntos_necesarios(float puntos_necesarios) {
		this.puntos_necesarios = puntos_necesarios;
	}
	public int getPorcentaje_ganancia() {
		return porcentaje_ganancia;
	}
	public void setPorcentaje_ganancia(int porcentaje_ganancia) {
		this.porcentaje_ganancia = porcentaje_ganancia;
	}
	
	

}
