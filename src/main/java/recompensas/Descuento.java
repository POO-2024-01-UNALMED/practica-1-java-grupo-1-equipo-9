package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Cliente;

public class Descuento {
	
	private int id;
	private static int actual_id;
	private boolean is_activo = true;
	private int porcentaje_descuento;
	private int puntos_necesarios;
	
	
	public Descuento() {
		
	}
	
	public Descuento(int porcentaje_descuento, int puntos_necesarios) {
		
		Descuento.actual_id++;
		this.id = Descuento.actual_id;
		this.porcentaje_descuento = porcentaje_descuento;
		this.puntos_necesarios = puntos_necesarios;
		
	}

	public static ArrayList<Descuento> descuentosActivos(ArrayList<Descuento> descuentos) {
		
		ArrayList<Descuento> resultado = new ArrayList<>();
		
		for (Descuento descuento : descuentos) {
			
			if (descuento.is_activo) {
				
				resultado.add(descuento);
				
			}
			
		}
		
		return resultado;
		
	}
	
	public static int calcularDescuento(Cliente cliente, ArrayList<Descuento> descuentos) {
		
		ArrayList<Descuento> descuentos_actuales = Descuento.descuentosActivos(descuentos);
		
		Descuento descuento_elegido  = new Descuento();
		
		int porcentaje_descuento = 0;
		
		for (Descuento descuento : descuentos_actuales) {
			
			//Porcentaje descuento elegido como posible candidato
			int porc_desc_elegido = descuento_elegido.getPorcentaje_descuento();
			
			//Descuento porcentaje actual, pues está en la iteración del for
			int porc_desc_actual = descuento.getPorcentaje_descuento();
			
			//Puntos del cliente
			int pts_cliente = cliente.getPuntos();
			
			//Puntos requeridos para acceder al descuento de la actual iteración
			int pts_desc_actual = descuento.getPuntos_necesarios();
			
			//El único descuento que más beneficie al cliente
			if ( (porc_desc_elegido < porc_desc_actual) && (pts_cliente > pts_desc_actual) ) {
				
				descuento_elegido = descuento;
	
			}
			
		}
		
		if (descuento_elegido.getPorcentaje_descuento() > 0) {
			
			porcentaje_descuento = descuento_elegido.getPorcentaje_descuento();
			
			//Le quitamos puntos al cliente, pues usó el descuento
			int cliente_pts = cliente.getPuntos() - descuento_elegido.getPuntos_necesarios();
			cliente.setPuntos(cliente_pts);
			
			System.out.println("El cliente : " + cliente.getNombre() + ", ha conseguido un jugoso descuento: " + porcentaje_descuento + " %");
			System.out.println("Los puntos necesarios para acceder al descuento fueron: " + descuento_elegido.getPuntos_necesarios() + " puntos.");
			System.out.println("Los puntos actuales del cliente son: " + cliente.getPuntos() + " puntos.");
			System.out.println();
		}
		
		return porcentaje_descuento;
				
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIs_activo() {
		return is_activo;
	}
	public void setIs_activo(boolean is_activo) {
		this.is_activo = is_activo;
	}
	public int getPorcentaje_descuento() {
		return porcentaje_descuento;
	}
	public void setPorcentaje_descuento(int porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	public int getPuntos_necesarios() {
		return puntos_necesarios;
	}
	public void setPuntos_necesarios(int puntos_necesarios) {
		this.puntos_necesarios = puntos_necesarios;
	}
	
	
	
	

}
