package gestorAplicacion;

import java.util.ArrayList;

import finanzas.Gasto;
import finanzas.TipoGasto;

public class Surtidor {
	
	String nombre;
	TipoProducto tipo_producto;
	ArrayList<Producto> productos;
	
	
	public static boolean puedePagarSurtidor(Supermercado supermercado, float precio_producto, int cantidad, float impuesto) {
		
		boolean resultado = true;
		
		float ingresos_actuales = supermercado.getTotal_ingresos();
		
		//El supermercado no puede pagar la compra del producto
		if (ingresos_actuales < (precio_producto * cantidad) + (impuesto * cantidad)) {
			
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public static float calcularCostoActual(float precio_producto, int cantidad) {
		
		return precio_producto * cantidad;
		
	}
	
	
	public static boolean pagarImpuestoProducto(Supermercado supermercado, Producto producto, int cantidad_producto) {
		
		
		float ingresos_supermercado = supermercado.getTotal_ingresos();
		float impuesto_total = producto.getImpuesto() * cantidad_producto;
		
		if (ingresos_supermercado > impuesto_total) {
			
			//Registrar gasto
			Gasto.registrarGasto(impuesto_total, TipoGasto.IMPUESTO_PRODUCTO, supermercado);
			
			return true;
			
		}
		
		else { 
			return false;
		}
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoProducto getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(TipoProducto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	

}
