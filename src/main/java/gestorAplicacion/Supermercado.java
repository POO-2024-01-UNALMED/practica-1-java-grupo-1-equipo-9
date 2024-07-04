package gestorAplicacion;
import java.security.PublicKey;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Random;

import finanzas.Deuda;
import finanzas.Gasto;
import finanzas.Impuesto;
import finanzas.Ingreso;
import finanzas.TipoGasto;
import recompensas.BonoCliente;
import recompensas.Descuento;
import recompensas.PagoBonoEmpleado;


public class Supermercado {
	
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private float salario_empleados;
	private ArrayList<Bodega> bodegas = new ArrayList<Bodega>();
	private ArrayList<Orden> ordenes = new ArrayList<Orden>();
	private ArrayList<BonoCliente> promociones = new ArrayList<BonoCliente>();
	private ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
	private ArrayList<Ingreso> ingresos;
	private float total_ingresos;
	private ArrayList<Gasto> gastos;
	private float total_gastos;
	private ArrayList<Deuda> deudas;
	private float total_deuda;
	private ArrayList<Producto> productos;
	
	public Supermercado(String nombre, ArrayList<Empleado> empleados, float salario_empleados,
			ArrayList<Bodega> bodegas, ArrayList<Orden> ordenes, ArrayList<BonoCliente> promociones,
			ArrayList<Descuento> descuentos, ArrayList<Ingreso> ingresos, float total_ingresos, ArrayList<Gasto> gastos,
			float total_gastos, ArrayList<Deuda> deudas, float total_deuda,
			ArrayList<Producto> productos) {
		
		this.nombre = nombre;
		this.empleados = empleados;
		this.salario_empleados = salario_empleados;
		this.bodegas = bodegas;
		this.ordenes = ordenes;
		this.promociones = promociones;
		this.descuentos = descuentos;
		this.ingresos = ingresos;
		this.total_ingresos = total_ingresos;
		this.gastos = gastos;
		this.total_gastos = total_gastos;
		this.deudas = deudas;
		this.total_deuda = total_deuda;
		this.productos = productos;
	}



	/*
	public void abastecer(Surtidor surtidor, ArrayList<Producto> productos) {
		
		
		for (Producto producto : productos) {
			
			
			for (Producto producto_surtidor : surtidor.getProductos()) {
				
				
				if (producto_surtidor.getId() == producto.getId()) {
					
					boolean comprar = Surtidor.puedePagarSurtidor(
							this, 
							producto_surtidor.getPrecio_compra(), 
							producto.getCantidad_comprar(),
							producto_surtidor.getImpuesto()
							);
					
					float costo_actual = Surtidor.calcularCostoActual(
							producto_surtidor.getPrecio_compra(), 
							producto.getCantidad_comprar());
					
					boolean tieneImpuesto = Impuesto.tieneImpuesto(producto);
					
					
					//En caso de tener que pagar impuestos
					if (tieneImpuesto) {
						
						boolean pago_impuesto = Surtidor.pagarImpuestoProducto(this, producto, producto.getCantidad_comprar());
						
						//En caso de no tener suficiente dinero para pagar el impuesto
						if (!pago_impuesto) {
							
							comprar = false;
						}
						
					}
					
					
					//El supermercado tiene dinero suficiente para comprar los productos
					if (comprar) {
						
						
						//Primero pagamos el total por los productos
						Gasto.registrarGasto(costo_actual, TipoGasto.IMPUESTO_PRODUCTO, this);
					
						
						//Generar N cantidad de unidades de acuerdo al producto elegido
						for (int i = 0; i < producto.getCantidad_comprar(); i++) {
							
							String vecimiento = Unidad.generarFechaVencimiento();
							
							ArrayList<Bodega> bodegas = this.getBodegas();
							
							Random n_random = new Random(); 
							
						    //Elegir cualquier bodega del supermercado 
						    Bodega bodega_obtenida = bodegas.get(n_random.nextInt(bodegas.size() + 1));
							
						    //Se crea la unidad para poder tener una fecha de vencimiento más actual
							Unidad nueva_unidad = new Unidad(vecimiento, producto, bodega_obtenida);
							
							producto.agregarUnidad(nueva_unidad);
							
						}
						
					}
					
					else {
						System.out.println("El supermercado no puede comprar: " + producto.getNombre());
					}
					
				}
				
			}
				
			
		}
		
		
	}
	*/
	
	public boolean supermercadoPuedeComprarProductos(float total_pagar) {
		
		boolean resultado = false;
		
		float supermercado_dinero = this.total_ingresos;
		
		if (supermercado_dinero >= total_pagar) {
			resultado = true;
			
			System.out.println("El supermercado: " + this.nombre + " ha pagado: $" + total_pagar + " en total");
			float ingresos_actuales = this.total_ingresos - total_pagar;
			this.setTotal_ingresos(ingresos_actuales);
			System.out.println("El saldo actual del supermercado es: " + this.getTotal_ingresos());
			System.out.println("");
			
		}
		
		else {
			System.out.println("El supermercado no tiene suficiente dinero para pagar los productos :,(");
		}
		
		return resultado;
		
	}

	
	public static void pagarImpuestos(ArrayList<Impuesto> impuestos, float ingresos, Supermercado supermercado) {
		  	
	  ArrayList<Impuesto> impuestos_actuales = Impuesto.listarImpuestos(impuestos);
	  
	  float total_pagado = Impuesto.tributar(impuestos_actuales, ingresos, supermercado);
	  
	  System.out.println("El pago de los impuestos se realizó con éxito, total: " + total_pagado);
	  
	}
	
	

	public void agregarIngreso(Ingreso ingreso) {
		
		this.ingresos.add(ingreso);
		
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void agregarOrden(Orden orden) {
		ordenes.add(orden);
	}
	
	public void quitarOrden(Orden orden) {
		for (int i = 0;i<ordenes.size();i++) {
			if (ordenes.get(i) == orden) {
				ordenes.remove(i);
				break;
			}
		}
	}
	
	public void agregarBodega(Bodega bodega) {
		bodegas.add(bodega);
	}
	
	public void quitarBodega(Bodega bodega) {
		for (int i = 0;i<bodegas.size();i++) {
			if (bodegas.get(i) == bodega) {
				bodegas.remove(i);
				break;
			}
		}
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	

	public float calcularTotalIngresos() {
		
		float resultado = 0f;
		
		for (Ingreso ingreso : this.ingresos) {
			
			resultado += ingreso.getGanancia_total();
			
		}
		
		return resultado;
		
	}
	
	public ArrayList<Ingreso> getArrayListIngresos(){
		return this.ingresos;
	}

	public void setIngresos(ArrayList<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
	
	public float getTotal_ingresos() {
		return this.total_ingresos;
	}

	public void setTotal_ingresos(float total_ingresos) {
		
		if (total_ingresos < 0 ) {
			this.total_ingresos = 0;
		}
		
		else {
			this.total_ingresos = total_ingresos;
		}
		
	}
	
	
	public float getTotal_deuda() {
		return total_deuda;
	}

	public void setTotal_deuda(float total_deuda) {
		this.total_deuda = total_deuda;
	}
	
	
	public float calcularTotalDeuda() {
		
		float resultado = 0f;
		
		for (Deuda deuda : this.deudas) {
			
			resultado += deuda.getValor();
			
		}
		
		return resultado;
		
	}
	
	

	public ArrayList<Deuda> getArrayListDeudas() {
		return deudas;
	}

	public void setArrayListDeudas(ArrayList<Deuda> deudas) {
		this.deudas = deudas;
	}
	
	
	
	public Producto buscarProductoPorId(int id) {
		
		Producto resultado = null;
		
		for (Producto producto : this.getProductos()) {
			
			if (producto.getId() == id) {
				
				resultado = producto;
				
				break;
				
			}
			
		}
		
		
		return resultado;
	
	}
	
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	public void quitarEmpleado(Empleado empleado) {
		for (int i = 0;i<empleados.size();i++) {
			if (empleados.get(i) == empleado) {
				empleados.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<BonoCliente> getPromociones() {
		return promociones;
	}
	
	/*
	public void verificarVencimiento() {
		for (Bodega bodega : this.getBodegas()) {
			for (Unidad unidad : bodega.getProductos()) {
				if (unidad.diasParaVencimiento() < 15) {
					if (unidad.diasParaVencimiento() >= 0) {
						System.out.println("Al producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " le quedan " + unidad.diasParaVencimiento() + " días para vencer.");
					}
					else {
						System.out.println("El producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " se venció hace " + (unidad.diasParaVencimiento() * -1) + 
								" días.");
					}
					//Verificar si el producto se encuentra en descuento, sino, agregarlo
				}	
			}
		}
	}
	*/
}
