package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Cliente;
import gestorAplicacion.Producto;



public class Promocion {
	
	private int id;
	private boolean is_activo;
	private ArrayList<RequisitoPromocion> requisitos;
	private int puntos_obtenidos;
	
	
	public Promocion() {
		this.id = 0;
		this.is_activo = false;
		this.requisitos = null;
		this.puntos_obtenidos = 0;
	}
	
	public Promocion(int id, boolean is_activo, ArrayList<RequisitoPromocion> requisitos, int puntos_obtenidos) {

		this.id = id;
		this.is_activo = is_activo;
		this.requisitos = requisitos;
		this.puntos_obtenidos = puntos_obtenidos;
	}


	public static ArrayList<Promocion> promocionesActivas(ArrayList<Promocion> promociones) {
		
		ArrayList<Promocion> resultado = new ArrayList<>();
		
		for (Promocion promocion : promociones) {
			
			if (promocion.is_activo) {
				
				resultado.add(promocion);
				
			}
			
		}
		
		return resultado;
		
	}
	
	
	public static boolean cumpleRequisitos(ArrayList<Producto> productos, ArrayList<RequisitoPromocion> requisitos) {
		
		boolean resultado = true;
		
		for (RequisitoPromocion requisito : requisitos) {
			
			
			boolean continuar = false;
			
			for (Producto producto : productos) {
				
				boolean requisito_cumplido = requisito.getProducto().getCantidad() == producto.getCantidad();
				
				//Algún producto cumple con algún requisito
				if (requisito_cumplido) {
					
					continuar = true;
					break;

				}
				
			}
			
			//No cumple con algún requisito, se descarta la promoción
			if (!continuar) {
				
				resultado = false;
				break;
				
			}
			

		}
		
		return resultado;
		
	}
	
	
	public static Promocion seleccionPromoCliente(ArrayList<Producto> productos, ArrayList<Promocion> promociones) {
		
		
		Promocion promocion_elegida = new Promocion();
		
		
		for (Promocion promocion_iteracion : promociones) {
			
			boolean cumple_requisitos = Promocion.cumpleRequisitos(productos, promocion_iteracion.getRequisitos());
			
			boolean es_mejor_promocion = (cumple_requisitos) && (promocion_elegida.getPuntos_obtenidos() < promocion_iteracion.getPuntos_obtenidos());
			
			//Solo se elige la única promoción que le dé más puntos al cliente.
			if (es_mejor_promocion) {
				
				promocion_elegida = promocion_iteracion;
				
			}
	
			
		}
		
		
		return promocion_elegida;
		
		
		
	}
	
	public static void bonificarCliente(Cliente cliente, ArrayList<Producto> productos , ArrayList<Promocion> promociones) {
		
		ArrayList<Promocion> promociones_activas = Promocion.promocionesActivas(promociones);
		
		Promocion promocion_ganadora = Promocion.seleccionPromoCliente(productos, promociones_activas);
		
		//Aumentar acumulado puntos cliente
		
		if (promocion_ganadora.getPuntos_obtenidos() > 0) {
			
			int puntos_cliente = cliente.getPuntos();
			int puntos_promocion = promocion_ganadora.getPuntos_obtenidos();
			int total_puntos = puntos_cliente + puntos_promocion;
			
			cliente.setPuntos(total_puntos);
			
		}
		

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


	public ArrayList<RequisitoPromocion> getRequisitos() {
		return requisitos;
	}


	public void setRequisitos(ArrayList<RequisitoPromocion> requisitos) {
		this.requisitos = requisitos;
	}


	public int getPuntos_obtenidos() {
		return puntos_obtenidos;
	}


	public void setPuntos_obtenidos(int puntos_obtenidos) {
		this.puntos_obtenidos = puntos_obtenidos;
	}
	
	
	

}
