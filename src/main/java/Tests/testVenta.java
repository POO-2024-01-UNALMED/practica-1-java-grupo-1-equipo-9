package Tests;

import java.util.ArrayList;
import java.util.Scanner;

import finanzas.Deuda;
import finanzas.Gasto;
import finanzas.Ingreso;
import gestorAplicacion.Bodega;
import gestorAplicacion.Cliente;
import gestorAplicacion.Empleado;
import gestorAplicacion.Orden;
import gestorAplicacion.Producto;
import gestorAplicacion.Supermercado;
import gestorAplicacion.TipoOrden;
import gestorAplicacion.TipoProducto;
import gestorAplicacion.Unidad;
import recompensas.BonoCliente;
import recompensas.Descuento;
import recompensas.RequisitoPromocion;

public class testVenta {
	

	public static void main(String[] args) {
		
		//Productos
		Producto tomate = new Producto("Tomate", TipoProducto.ALIMENTO, 2500, 1800, 2300);
		Producto cebolla = new Producto("Cebolla", TipoProducto.ALIMENTO, 2300, 1700, 2800);
		Producto papa = new Producto("Papa", TipoProducto.ALIMENTO, 1500, 1000, 2000);
		Producto zanahoria = new Producto("Zanahoria", TipoProducto.ALIMENTO, 1200, 900, 1500);
		Producto lechuga = new Producto("Lechuga", TipoProducto.ALIMENTO, 1300, 1000, 1600);
		Producto manzana = new Producto("Manzana", TipoProducto.ALIMENTO, 3000, 2500, 3500);
		Producto banana = new Producto("Banana", TipoProducto.ALIMENTO, 2800, 2300, 3300);
		Producto naranja = new Producto("Naranja", TipoProducto.ALIMENTO, 2600, 2200, 3100);
		Producto pollo = new Producto("Pollo", TipoProducto.ALIMENTO, 6000, 5000, 7000);
		Producto pescado = new Producto("Pescado", TipoProducto.ALIMENTO, 5500, 4500, 6500);
		Producto carne = new Producto("Carne", TipoProducto.ALIMENTO, 7000, 6000, 8000);
		Producto arroz = new Producto("Arroz", TipoProducto.ALIMENTO, 2000, 1700, 2300);
		Producto shampoo = new Producto("Shampoo", TipoProducto.CUIDADOPERSONAL, 4500, 3500, 5500);
		Producto detergente = new Producto("Detergente", TipoProducto.ASEO, 3000, 2500, 3500);
		Producto jugoNaranja = new Producto("Jugo de Naranja", TipoProducto.BEBIDA, 2500, 2000, 3000);
		Producto croquetasPerro = new Producto("Croquetas para Perro", TipoProducto.MASCOTA, 8000, 7000, 9000);
		Producto cerveza = new Producto("Cerveza", TipoProducto.BEBIDA, 3500, 3000, 4000);
		Producto pastaDental = new Producto("Pasta Dental", TipoProducto.CUIDADOPERSONAL, 2000, 1500, 2500);
		Producto suavizante = new Producto("Suavizante", TipoProducto.ASEO, 3200, 2700, 3700);
		Producto vitaminas = new Producto("Vitaminas", TipoProducto.OTRO, 5000, 4000, 6000);
		//Fin Productos
		
	
		//Unidades Tomate
		for (int x = 0; x < 10; x++) {
			
			new Unidad(tomate);
			
		}
		//Fin Unidades Tomate
		
		//Unidades Cerveza
		for (int x = 0; x < 10; x++) {
			
			new Unidad(cerveza);
			
		}
		//Fin Unidades Cerveza
		
		
		//Unidades shampoo
		for (int x = 0; x < 10; x++) {
			
			new Unidad(shampoo);
			
		}
		//Fin Unidades shampoo
		
		
		//Unidades croquetasPerro
		for (int x = 0; x < 10; x++) {
			
			new Unidad(croquetasPerro);
			
		}
		//Fin Unidades croquetasPerro
		
		
		//Unidades carne
		for (int x = 0; x < 10; x++) {
			
			new Unidad(carne);
			
		}
		//Fin Unidades carne
				
		//Unidades pescado
		for (int x = 0; x < 10; x++) {
			
			new Unidad(pescado);
			
		}
		//Fin Unidades pescado		
		
		
		//Bodegas
		
		ArrayList<Producto> productosA = new ArrayList<Producto>();
		productosA.add(tomate);
		productosA.add(pescado);
		productosA.add(carne);
		productosA.add(cerveza);
		productosA.add(shampoo);
		productosA.add(croquetasPerro);
		
		Bodega bodega_A = new Bodega("Bodega A", "Barrio santigo", productosA);
		
		ArrayList<Bodega> bodegasA = new ArrayList<Bodega>();
		bodegasA.add(bodega_A);
		
		//Fin Bodegas
		
		
		//Empleados
		Empleado empleado1 = new Empleado("Mark", 1234545);
		Empleado empleado2 = new Empleado("Mario Bros", 45787878);
		Empleado empleado3 = new Empleado("Luigi", 23456789);
		Empleado empleado4 = new Empleado("Peach", 34567890);
		Empleado empleado5 = new Empleado("Toad", 45678901);
		Empleado empleado6 = new Empleado("Yoshi", 56789012);
		Empleado empleado7 = new Empleado("Bowser", 67890123);
		
		ArrayList<Empleado> empleadosA = new ArrayList<Empleado>();
		
		empleadosA.add(empleado1);
		empleadosA.add(empleado2);
		empleadosA.add(empleado3);
		empleadosA.add(empleado4);
		empleadosA.add(empleado5);
		empleadosA.add(empleado6);
		empleadosA.add(empleado7);
		
	
		//Fin Empleados
		
		//Clientes
		Cliente cliente1 = new Cliente("Jimmy Micker", 112000);
		Cliente cliente2 = new Cliente("Sasfasd", 7567878);
		Cliente cliente3 = new Cliente("Marcelo agáchate y conócelo", 78787878);
		cliente3.setPuntos(20000);
		//Fin Clientes
		
		//Ordenes
		Orden orden1 = new Orden(TipoOrden.VENTA, null, empleado1, cliente1);
		Orden orden2 = new Orden(TipoOrden.VENTA, null, empleado2, cliente2);
		
		ArrayList<Orden> ordenes = new ArrayList<Orden>();
		
		ordenes.add(orden1);
		ordenes.add(orden2);
		
		//Fin Ordenes
		
		//Requisitos promocion
		RequisitoPromocion requisito1 = new RequisitoPromocion(TipoProducto.ALIMENTO, 500);
		RequisitoPromocion requisito2 = new RequisitoPromocion(TipoProducto.BEBIDA, 200);
		RequisitoPromocion requisito3 = new RequisitoPromocion(TipoProducto.ALIMENTO, 200);
		
		ArrayList<RequisitoPromocion> requisitos1 = new ArrayList<RequisitoPromocion>();
		
		requisitos1.add(requisito1);
		
		
		ArrayList<RequisitoPromocion> requisitos2 = new ArrayList<RequisitoPromocion>();
		requisitos2.add(requisito2);
		
		ArrayList<RequisitoPromocion> requisitos3 = new ArrayList<RequisitoPromocion>();
		requisitos3.add(requisito3);
		requisitos3.add(requisito1);
		//Fin Requisitos promocion
		
	
		//Bonos cliente
		BonoCliente promocion1 = new BonoCliente(requisitos1, 1300);
		BonoCliente promocion2 = new BonoCliente(requisitos2, 1700);
		BonoCliente promocion3 = new BonoCliente(requisitos3, 2500);
		
		ArrayList<BonoCliente> promociones1 = new ArrayList<BonoCliente>();
		promociones1.add(promocion1);
		promociones1.add(promocion2);
		promociones1.add(promocion3);
		//Fin Bonos cliente
		
		
		//Descuentos
		Descuento descuento1 = new Descuento(26, 500);
		Descuento descuento2 = new Descuento(50, 10);
		Descuento descuento3 = new Descuento(35, 254);
		
		ArrayList<Descuento> descuentos1 = new ArrayList<Descuento>();
		descuentos1.add(descuento3);
		descuentos1.add(descuento1);
		descuentos1.add(descuento2);
		
		ArrayList<Descuento> descuentos2 = new ArrayList<Descuento>();
		descuentos2.add(descuento1);
		descuentos2.add(descuento3);
		
		//Fin Descuentos
		
		//Supermercado
		Supermercado elPaisa = new Supermercado("El paisa", empleadosA, 1200, bodegasA, ordenes , 
				promociones1, descuentos1, new ArrayList<Ingreso>(), 0, new ArrayList<Gasto>(), 0, 
				new ArrayList<Deuda>(), 0, productosA);
		
		//Fin Supermercado
		
		
		
		//Listar productos
		ArrayList<Producto> productosObtenidos = Producto.listarProductosPorTipo(TipoProducto.ALIMENTO, elPaisa);
		//Fin Listar productos
	
		
		//Productos requeridos
		Producto producto_pedido1 = Producto.agregarProductoCarrito(productosObtenidos.get(0), 3);
		Producto producto_pedido2 = Producto.agregarProductoCarrito(productosObtenidos.get(1), 3);
		
		ArrayList<Producto> productos_requeridos = new ArrayList<Producto>();
		productos_requeridos.add(producto_pedido1);
		productos_requeridos.add(producto_pedido2);
		//Productos requeridos
		
		
		//Generar orden
		Orden.generarOrden(TipoOrden.VENTA, elPaisa, empleado7, cliente3, productos_requeridos, promociones1, descuentos1);
		//Fin Generar orden
		
		
		
	}

}
