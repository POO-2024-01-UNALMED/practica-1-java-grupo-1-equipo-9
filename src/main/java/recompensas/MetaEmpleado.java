package recompensas;

import java.util.ArrayList;

import gestorAplicacion.Producto;
import gestorAplicacion.Empleado;

public class MetaEmpleado {
	
	int id;
	Producto producto_vendido;
	int cantidad_producto;
	int puntos_requeridos;
	boolean activo;
	
	public static ArrayList<MetaEmpleado> listarMetas(ArrayList<MetaEmpleado> metas){
		
		ArrayList<MetaEmpleado> resultado = new ArrayList<MetaEmpleado>();
		
		for (MetaEmpleado meta: metas) {
			
			if (meta.activo) resultado.add(meta);
		
		}
		
		return resultado;
		
	}
	
	public static boolean cumplioMetas(Empleado empleado, ArrayList<MetaEmpleado> metas) {
		
		ArrayList<MetaEmpleado> metas_empleado = empleado.getMetas();
		
		ArrayList<MetaEmpleado> metas_activas = MetaEmpleado.listarMetas(metas);
		
		boolean resultado = true;
		
		
		for (MetaEmpleado meta_actual : metas_activas) {
			
			boolean continuar = true;
			
			
			for (MetaEmpleado meta_empleado : metas_empleado) {
				
				if (meta_actual.getId() == meta_empleado.getId()) {
					
					//No Cumplió con la venta de N cantidad de cierto producto
					if (meta_actual.getCantidad_producto() > meta_empleado.getCantidad_producto()) {
						
						continuar = false;
						break;
						
					}
					
					//No Cumplió alcanzar la meta de N puntos solicitados al mes
					if ( meta_actual.getPuntos_requeridos() > meta_empleado.getPuntos_requeridos() ) {
						
						continuar = false;
						break;
						
					}
					
					//Cumplió con todos los requisitos de la meta actual
					break;
					
				}
				
			}
			
			
			//En caso de que el empleado no cumple ninguna de las metas solicitadas
			if (!continuar) {
				
				resultado = false;
				break;
				
			}
			
		}
		
		return resultado;
	
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto_vendido() {
		return producto_vendido;
	}

	public void setProducto_vendido(Producto producto_vendido) {
		this.producto_vendido = producto_vendido;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getPuntos_requeridos() {
		return puntos_requeridos;
	}

	public void setPuntos_requeridos(int puntos_requeridos) {
		this.puntos_requeridos = puntos_requeridos;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	

}
