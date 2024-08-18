package gestorAplicacion;

import java.util.ArrayList;
import java.io.Serializable;

public class Descuento implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private TipoProducto tipo_en_promocion;
	private Producto producto_en_promocion;
	private Unidad unidad_en_promocion;
	private boolean is_activo = true;
	private int porcentaje_descuento;
	private static ArrayList<Descuento> descuentos = new ArrayList<>();
	
	
	public Descuento(String nombre, TipoProducto tipo, int porcentaje) {
		this.nombre = nombre;
		tipo_en_promocion = tipo;
		porcentaje_descuento = porcentaje;
		Descuento.descuentos.add(this);
		calcularDescuento(1);
	}

	public Descuento(String nombre, Producto producto, int porcentaje) {
		this.nombre = nombre;
		producto_en_promocion = producto;
		porcentaje_descuento = porcentaje;
		Descuento.descuentos.add(this);
		calcularDescuento(2);
	}
	
	public Descuento(String nombre, Unidad unidad, int porcentaje) {
		this.nombre = nombre;
		unidad_en_promocion = unidad;
		porcentaje_descuento = porcentaje;
		Descuento.descuentos.add(this);
		calcularDescuento(3);
	}


	public void calcularDescuento(int i) {
		if (i==1) {
			for (Producto producto : Producto.getLista_productos()) {
				if (producto.getTipo() == this.tipo_en_promocion) {
					for (Unidad unidad : producto.getUnidades())
						unidad.agregarDescuento(this);
				}
			}
		}
		else if (i==2) {
			for (Unidad unidad : producto_en_promocion.getUnidades())
				unidad.agregarDescuento(this);
		}
		else if (i==3) {
			unidad_en_promocion.agregarDescuento(this);
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProducto getTipo_en_promocion() {
		return tipo_en_promocion;
	}

	public void setTipo_en_promocion(TipoProducto tipo_en_promocion) {
		this.tipo_en_promocion = tipo_en_promocion;
	}

	public Producto getProducto_en_promocion() {
		return producto_en_promocion;
	}

	public void setProducto_en_promocion(Producto producto_en_promocion) {
		this.producto_en_promocion = producto_en_promocion;
	}

	public Unidad getUnidad_en_promocion() {
		return unidad_en_promocion;
	}

	public void setUnidad_en_promocion(Unidad unidad_en_promocion) {
		this.unidad_en_promocion = unidad_en_promocion;
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

	public static ArrayList<Descuento> getDescuentos() {
		return descuentos;
	}

	public static void setDescuentos(ArrayList<Descuento> descuentos) {
		Descuento.descuentos = descuentos;
	}
	

}
