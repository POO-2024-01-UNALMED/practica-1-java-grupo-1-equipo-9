package finanzas;

import java.util.ArrayList;

public class Impuesto {
	
	int id;
	String motivo;
	float pago;
	String fecha_limite;
	boolean is_pagado;
	float multa;
	
	

	
	public static ArrayList<Impuesto>  listarImpuestos(ArrayList<Impuesto> impuestos) {
		
		ArrayList<Impuesto> resultado = new ArrayList<Impuesto>();
		
		for (Impuesto impuesto: impuestos) {
			
			boolean no_pagado = !impuesto.getIs_pagado();
			
			if (no_pagado) {
				
				resultado.add(impuesto);
				
			}
		}
		
		return resultado;
	
		
	}
	
	public static void algunaMulta(ArrayList<Impuesto> impuestos) {
		
		String mensaje = "Tiene algunas Multas: \n";

		
		for (Impuesto impuesto : impuestos) {
			
			if (impuesto.multa > 0) {
				
				
				float total_pago = impuesto.getPago() + impuesto.getMulta();
				
				mensaje += "Motivo: " + impuesto.getMotivo() + "\n";
				mensaje += "Pago original: " + impuesto.getPago() + "\n";
				mensaje += "Pago Multa: " + impuesto.getMulta() + "\n";
				mensaje += "Total a Pagar: " + total_pago + "\n";
				
				mensaje += "--------------------------------------------------------------------------- \n \n";
				
			}
			
		}
		
		System.out.println(mensaje);
 		
	}
	
	
	public static float tributar(ArrayList<Impuesto> impuestos_activos, float ingresos) {
		
		//Avisar que tiene alguna multa
		Impuesto.algunaMulta(impuestos_activos);
		
		float ingresos_actuales = ingresos;
		float total_impuesto = 0f;
				
		for (Impuesto impuesto : impuestos_activos) {
			
			float total_cobro = impuesto.getPago() + impuesto.getMulta();
			
			//En caso de que el supermercado tenga plata suficiente para pagar el impuesto
			if (ingresos_actuales > total_cobro) {
				
				impuesto.setIs_pagado(true);
				impuesto.setMulta(0);
				
				ingresos_actuales -= total_cobro;
				total_impuesto += total_cobro;
				
			} 
			
			//El supermercado no dinero dinero suficiente para pagar
			else {
				
				System.out.print("El supermercado no tiene dinero suficiente para pagar los otros impuestos!!");
				break;
				
			}
			
		}
		
		//Falta colocar la parte de actualizar el valor total de los ingresos de la clase Ingreso
		
		
		return total_impuesto;
	
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getMotivo() {
		return motivo;
	}




	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}




	public float getPago() {
		return pago;
	}




	public void setPago(float pago) {
		this.pago = pago;
	}




	public String getFecha_limite() {
		return fecha_limite;
	}




	public void setFecha_limite(String fecha_limite) {
		this.fecha_limite = fecha_limite;
	}




	public boolean getIs_pagado() {
		return is_pagado;
	}




	public void setIs_pagado(boolean is_pagado) {
		this.is_pagado = is_pagado;
	}




	public float getMulta() {
		return multa;
	}




	public void setMulta(float multa) {
		this.multa = multa;
	}
	
	
	
	
	
}
