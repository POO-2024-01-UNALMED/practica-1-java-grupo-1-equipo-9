package finanzas;

import java.util.ArrayList;

import gestorAplicacion.Empleado;
import gestorAplicacion.Orden;
import gestorAplicacion.Producto;
import gestorAplicacion.Supermercado;

public class Gasto {
	
	private int id;
	private String fecha;
	private String hora;
	private Empleado comprador;
	private float total_pagado;
	private TipoGasto concepto;
	private ArrayList<Producto> productos;
	private ArrayList<Gasto> deudas;
	private float total_deuda;
	private Supermercado supemercado;
	

	public Gasto(float total_pagado, TipoGasto concepto, Supermercado supermercado) {
		
	
		//Fecha actual
		String fecha = Supermercado.getFechaActual();
		
		//Hora actual
		String hora = Supermercado.getHoraActual();
		
		
		this.fecha = fecha;
		this.hora = hora;		
		this.total_pagado = total_pagado;
		this.concepto = concepto;
		this.supemercado = supermercado;
	
	}
	
	
	public Gasto(Empleado comprador, float total_pagado, TipoGasto concepto,
			ArrayList<Producto> productos) {
		
	
		//Fecha actual
		String fecha = Supermercado.getFechaActual();
		
		//Hora actual
		String hora = Supermercado.getHoraActual();
		
		
		this.fecha = fecha;
		this.hora = hora;
		
		this.comprador = comprador;
		this.total_pagado = total_pagado;
		this.concepto = concepto;
		this.productos = productos;
	}
	
	
	public static float registrarGasto(float total_pago, TipoGasto tipo_gasto, Supermercado supermercado) {
		
		//Registrar el gasto del pago del salario empleado
		Gasto nuevo_gasto = new Gasto(total_pago, tipo_gasto, supermercado );
		
		//Descontar la cantidad total de ingresos
		float total_ingresos = supermercado.getTotal_ingresos() - total_pago;
		
		//Evitar valores negativos
		if (total_ingresos > 0) {
			
			supermercado.setTotal_ingresos(total_ingresos);
			return total_ingresos;
			
		}
		
		else {
			
			supermercado.setTotal_ingresos(0f);
			return 0f;
		}
		
		
		
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
