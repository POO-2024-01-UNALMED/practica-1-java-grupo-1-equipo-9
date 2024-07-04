package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Cliente;
import gestorAplicacion.Producto;
import gestorAplicacion.Unidad;



public class BonoCliente {
	
	private int id;
	private static int actual_id;
	private boolean is_activo = true;
	private ArrayList<RequisitoPromocion> requisitos;
	private int puntos_obtenidos;
	
	
	public BonoCliente() {
		
		this.is_activo = false;
		this.requisitos = null;
		this.puntos_obtenidos = 0;
		
	}
	
	public BonoCliente(ArrayList<RequisitoPromocion> requisitos, int puntos_obtenidos) {
		
		BonoCliente.actual_id++;
		this.id = BonoCliente.actual_id;
		this.requisitos = requisitos;
		this.puntos_obtenidos = puntos_obtenidos;
		
	}


	public static ArrayList<BonoCliente> promocionesActivas(ArrayList<BonoCliente> promociones) {
		
		ArrayList<BonoCliente> resultado = new ArrayList<BonoCliente>();
		
		for (BonoCliente promocion : promociones) {
			
			if (promocion.is_activo) {
				
				resultado.add(promocion);
				
			}
			
		}
		
		return resultado;
		
	}
	
	
	public static boolean cumpleRequisitos(ArrayList<Producto> productos, float cobro_total, ArrayList<RequisitoPromocion> requisitos) {
		
		boolean resultado = true;
		
		for (RequisitoPromocion requisito : requisitos) {
			
			boolean continuar = false;
			
			for (Producto producto : productos) {
				
				boolean cumple_tipo = (requisito.getTipoProducto().equals(producto.getTipo()));
				boolean cumple_total_cobro = (cobro_total >= requisito.getTotalCobro());
				boolean requisitos_cumplidos = (cumple_tipo && cumple_total_cobro);
				
				//Algún producto cumple con algún requisito
				//Tipo de producto y precio cobrado.
				if (requisitos_cumplidos) {
					
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
	
	
	public static BonoCliente seleccionPromoCliente(ArrayList<Producto> productos, float cobro_compra , ArrayList<BonoCliente> promociones) {
		
		BonoCliente promocion_elegida = new BonoCliente();
		
		for (BonoCliente promocion_iteracion : promociones) {
			
			boolean cumple_requisitos = BonoCliente.cumpleRequisitos(productos, cobro_compra , promocion_iteracion.getRequisitos());
			
			boolean es_mejor_promocion = (cumple_requisitos) && (promocion_elegida.getPuntos_obtenidos() < promocion_iteracion.getPuntos_obtenidos());
			
			//Solo se elige la única promoción que le dé más puntos al cliente.
			if (es_mejor_promocion) {
				
				promocion_elegida = promocion_iteracion;
				
			}
	
			
		}
		
		return promocion_elegida;
		
	}
	
	public static void bonificarCliente(Cliente cliente, ArrayList<Producto> productos, float cobro_compra , ArrayList<BonoCliente> promociones) {
		
		ArrayList<BonoCliente> promociones_activas = BonoCliente.promocionesActivas(promociones);
		
		BonoCliente promocion_ganadora = BonoCliente.seleccionPromoCliente(productos, cobro_compra ,promociones_activas);
		
		//Aumentar acumulado puntos cliente
		if (promocion_ganadora.getPuntos_obtenidos() > 0) {
			
			int puntos_cliente = cliente.getPuntos();
			int puntos_promocion = promocion_ganadora.getPuntos_obtenidos();
			int total_puntos = puntos_cliente + puntos_promocion;
			
			cliente.setPuntos(total_puntos);
			
			System.out.println("El cliente : " + cliente.getNombre() + ", ha ganado: " + puntos_promocion + " puntos!!!");
			System.out.println("al seguir comprando más productos, participa y gana buenísimos premios");
			System.out.println("cada punto acumulado te sirve para aumentar tus probabilidades de ganar!");
			System.out.println();
			
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
