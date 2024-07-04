package gestorAplicacion;

import java.util.ArrayList;

import finanzas.Deuda;
import finanzas.Gasto;
import finanzas.TipoDeuda;
import finanzas.TipoGasto;
import recompensas.MetaEmpleado;
import recompensas.PagoBonoEmpleado;

public class Empleado extends Persona{
	
	public static int actual_id;
	private int id;
	private boolean activo = true;
	private ArrayList<MetaEmpleado> metas;
	

	public Empleado(String nombre, long cedula) {
		super(nombre, cedula);
		Empleado.actual_id++;
		this.id = actual_id;
	}


	public static void despedirEmpleado(Empleado empleado, ArrayList<MetaEmpleado> metas) {
		
	   boolean despedir = MetaEmpleado.cumplioMetas(empleado, metas);
		
	   if (despedir) {
		   
		   empleado.setActivo(false); 
		   System.out.println("Se ha despedido a: " + empleado.getNombre());
		  
	   }
	   
	   
	}
	
	/*
	public static void pagarEmpleados(ArrayList<Empleado> empleados, ArrayList<BonoEmpleado> bonosEmpleados, ArrayList<PagoBonoEmpleado> pagosBonosEmpleados , Supermercado supermercado) {
		
		float dinero_disponible = supermercado.getTotal_ingresos();
		
	
		for (Empleado empleado : empleados) {
			
			//El empleado no ha sido despedido
			if (empleado.isActivo()) {
				
				
				float salario = Empleado.salario;
				int porcentaje_bono = PagoBonoEmpleado.obtenerPorcentajeBonoEmpleado(empleado, pagosBonosEmpleados);
				
				float total_pago = salario + (salario * porcentaje_bono) / 100;
				
				
				//En caso de tener suficientes ingresos para pagar al empleado
				if (dinero_disponible > total_pago) {
					
					
					//Registramos el gasto
					dinero_disponible = Gasto.registrarGasto(total_pago, TipoGasto.SALARIO, supermercado);
					
				}
				
				//El supermercado no tiene dinero para pagarle al empleado
				//Se endeuda el supermercado.
				else {
					
					float deuda_actual = supermercado.getTotal_deuda();
					supermercado.setTotal_deuda(total_pago + deuda_actual);
					
					Deuda nueva_deuda = new Deuda(total_pago, TipoDeuda.PAGO_EMPLEADO , supermercado);
					supermercado.getArrayListDeudas().add(nueva_deuda);
					
				}
				
				
				
			}
			
			
		}
		
		
	}
	*/
	
	public Empleado(int id, String nombre, long cedula) {
		super(nombre, cedula);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public ArrayList<MetaEmpleado> getMetas() {
		return metas;
	}



	public void setMetas(ArrayList<MetaEmpleado> metas) {
		this.metas = metas;
	}
	
	
	
	
	
}
