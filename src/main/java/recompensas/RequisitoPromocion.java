package recompensas;

import gestorAplicacion.TipoProducto;

public class RequisitoPromocion {
	
	private TipoProducto tipo;
	private float total_compra;
	

	public RequisitoPromocion(TipoProducto tipo, float total_compra) {

		this.tipo = tipo;
		this.total_compra = total_compra;
	}
	

	public TipoProducto getTipoProducto() {
		return this.tipo;
	}
	
	public void setTipoProducto(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public float getTotalCobro() {
		return this.total_compra;
	}

	public void setTotalCobro(float cantidad) {
		this.total_compra = cantidad;
	}
	
	
}
