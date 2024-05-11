package finanzas;

import java.util.ArrayList;

import gestorAplicacion.Empleado;
import gestorAplicacion.Orden;
import gestorAplicacion.Producto;

public class Gasto {
	
	private int id;
	private String fecha;
	private String hora;
	private Empleado comprador;
	private float total_pagado;
	private TipoGasto concepto;
	private ArrayList<Producto> productos;
	
	//Registrar pago empleado, falta colocar la fecha y la hora
	public Gasto(float total_pagado, TipoGasto concepto) {
		
		this.total_pagado = total_pagado;
		this.concepto = concepto;
		
	}
	
	
	public Gasto(int id, String fecha, String hora, Empleado comprador, float total_pagado, TipoGasto concepto,
			ArrayList<Producto> productos) {
		
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.comprador = comprador;
		this.total_pagado = total_pagado;
		this.concepto = concepto;
		this.productos = productos;
	}
	
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Empleado getComprador() {
		return comprador;
	}
	public void setComprador(Empleado comprador) {
		this.comprador = comprador;
	}
	public float getTotal_pagado() {
		return total_pagado;
	}
	public void setTotal_pagado(float total_pagado) {
		this.total_pagado = total_pagado;
	}
	public TipoGasto getConcepto() {
		return concepto;
	}
	public void setConcepto(TipoGasto concepto) {
		this.concepto = concepto;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	

}
