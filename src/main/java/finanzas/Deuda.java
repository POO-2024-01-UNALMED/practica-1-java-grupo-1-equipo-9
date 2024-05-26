package finanzas;

import java.util.ArrayList;

import gestorAplicacion.Empleado;
import gestorAplicacion.Producto;
import gestorAplicacion.Supermercado;

public class Deuda {
	
	private int id;
	private String fecha;
	private String hora;
	private float valor;
	private TipoDeuda concepto;
	private Supermercado supemercado;
	
	
	public Deuda( float valor, TipoDeuda concepto, Supermercado supemercado) {
		
		//Fecha actual
		String fecha = Supermercado.getFechaActual();
		
		//Hora actual
		String hora = Supermercado.getHoraActual();
		
		
		this.fecha = fecha;
		this.hora = hora;
		
		this.valor = valor;
		this.concepto = concepto;
		this.supemercado = supemercado;
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


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}


	public TipoDeuda getConcepto() {
		return concepto;
	}


	public void setConcepto(TipoDeuda concepto) {
		this.concepto = concepto;
	}


	public Supermercado getSupemercado() {
		return supemercado;
	}


	public void setSupemercado(Supermercado supemercado) {
		this.supemercado = supemercado;
	}
	
	
	
	
	

}
