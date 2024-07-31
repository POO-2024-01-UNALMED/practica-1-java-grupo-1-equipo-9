package gestorAplicacion;

import gestorAplicacion.*;

import java.util.ArrayList;
import java.time.LocalDate;

public class TESTmain {

	public static void main(String[] args) {
		
		Supermercado sup1 = new Supermercado("MercaChicles");
		Empleado emp1 = new Empleado("Pepe", 12345, sup1, 2000000);
		Cliente cli1 = new Cliente("Jaimito", 23456);
		Bodega bod1 = new Bodega("Bodega Principal", "Barrio Tapitas");
		Bodega bod2 = new Bodega("Bodega Secundaria", "Barrio la Piedrita");
		sup1.agregarEmpleado(emp1);
		sup1.agregarBodega(bod1);
		sup1.agregarBodega(bod2);
		Producto prod1 = new Producto("Leche Coranta", TipoProducto.ALIMENTO, 3000, 2000);
		Producto prod2 = new Producto("Vodka Absoluti", TipoProducto.BEBIDA, 90000, 50000);
		Producto prod3 = new Producto("Leche Arqueria", TipoProducto.ALIMENTO, 3100, 2100);
		Unidad uni1 = new Unidad("2024-04-28", prod1, bod1);
		Unidad uni2 = new Unidad("2024-08-10", prod1, bod1);
		Unidad uni3 = new Unidad("2024-06-05", prod1, bod2);
		
		Unidad uni4 = new Unidad("2024-05-30", prod2, bod2);
		Unidad uni5 = new Unidad("2024-07-08", prod2, bod1);
		Unidad uni6 = new Unidad("2024-05-27", prod2, bod1);
		
		Unidad uni7 = new Unidad("2024-06-08", prod3, bod1);

		
/*	//Prueba Verificar dias
		System.out.println("-- Iniciando Prueba de dias para vencer... --");
		for (Bodega bodega : sup1.getBodegas()) {
			for (Unidad unidad : bodega.getProductos()) {
				if (unidad.diasParaVencimiento() < 0)
					System.out.println("El producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
						", ubicado en " + bodega.getNombre() + " se venció hace " + (unidad.diasParaVencimiento() * -1) + 
						" días.");
				else
					System.out.println("Al producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
							", ubicado en " + bodega.getNombre() + " le quedan " + unidad.diasParaVencimiento() + " días para vencer.");
			}
		}
		
	//Prueba Verificar vencimiento de menos de 15 y 0 dias
		System.out.println("");
		System.out.println("-- Iniciando Prueba de menos de 15 dias para vencer... --");
		sup1.verificarVencimiento(15);
		
		System.out.println("");
		System.out.println("-- Iniciando Prueba de vencidos... --");
		sup1.verificarVencimiento();
*/
/*	//Prueba Descuentos
	//	Descuento desc1 = new Descuento("Descuento Alimentos", TipoProducto.ALIMENTO, 25);
		Descuento desc2 = new Descuento("Descuento Leche Coranta", prod1, 30);
*/		Descuento desc3 = new Descuento("Descuento cerca de vencer", uni2, 50);
//Prueba Orden (FUNCIONALIDAD 1)---------------------------------------------------------------------------------------
		Orden orden1 = new Orden(sup1, emp1, cli1);
		ArrayList<Producto> lista1 = sup1.productosPorTipo(TipoProducto.ALIMENTO);
		for (Producto producto : lista1) {
			ArrayList<Unidad> unienof = new ArrayList<>();
			ArrayList<Unidad> unisinof = new ArrayList<>();
			for (Unidad unidad : producto.getUnidades()) {
				if (unidad.isOferta())unienof.add(unidad);
				else unisinof.add(unidad);
			}
			if (unisinof.size() != 0)
				System.out.println(producto.getNombre()+" - sin oferta - $"+producto.getPrecio()+" cant: "+unisinof.size());
			if (unienof.size() != 0) {
				for (Unidad unidad : unienof) {
					System.out.println(producto.getNombre()+" - "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
				}
			}
		}
		ArrayList<Producto> lista2 = sup1.productosPorTipo(TipoProducto.BEBIDA);
		for (Producto producto : lista2) {
			ArrayList<Unidad> unienof = new ArrayList<>();
			ArrayList<Unidad> unisinof = new ArrayList<>();
			for (Unidad unidad : producto.getUnidades()) {
				if (unidad.isOferta())unienof.add(unidad);
				else unisinof.add(unidad);
			}
			if (unisinof.size() != 0)
				System.out.println(producto.getNombre()+" - sin oferta - $"+producto.getPrecio()+" cant: "+unisinof.size());
			if (unienof.size() != 0) {
				for (Unidad unidad : unienof) {
					System.out.println(producto.getNombre()+" - "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
				}
			}
		}
		
		orden1.agregarUnidad(uni5);
		orden1.agregarProducto(prod3);
		orden1.agregarProducto(prod1);
		orden1.agregarProducto(prod2, 2);
		orden1.agregarUnidad(uni3);
		System.out.println("---Productos Actualmente en la Orden---");
		for (Unidad unidad : orden1.getProductos()) {
			if (unidad.isOferta())
				System.out.println(unidad.getTipo().getNombre() + " en oferta: $"+unidad.calcularPrecio());
			else
				System.out.println(unidad.getTipo().getNombre()+": $"+unidad.calcularPrecio());
		}

		System.out.println("---Total Precio Orden: $"+orden1.calcularPrecioTotal()+"---");
		orden1.completarOrden();
		System.out.println("---Orden Completa---");
		System.out.println("");
		
		for (Producto producto : lista1) {
			ArrayList<Unidad> unienof = new ArrayList<>();
			ArrayList<Unidad> unisinof = new ArrayList<>();
			for (Unidad unidad : producto.getUnidades()) {
				if (unidad.isOferta())unienof.add(unidad);
				else unisinof.add(unidad);
			}
			if (unisinof.size() != 0)
				System.out.println(producto.getNombre()+" - sin oferta - $"+producto.getPrecio()+" cant: "+unisinof.size());
			if (unienof.size() != 0) {
				for (Unidad unidad : unienof) {
					System.out.println(producto.getNombre()+" - "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
				}
			}
		}
		
		for (Producto producto : lista2) {
			ArrayList<Unidad> unienof = new ArrayList<>();
			ArrayList<Unidad> unisinof = new ArrayList<>();
			for (Unidad unidad : producto.getUnidades()) {
				if (unidad.isOferta())unienof.add(unidad);
				else unisinof.add(unidad);
			}
			if (unisinof.size() != 0)
				System.out.println(producto.getNombre()+" - sin oferta - $"+producto.getPrecio()+" cant: "+unisinof.size());
			if (unienof.size() != 0) {
				for (Unidad unidad : unienof) {
					System.out.println(producto.getNombre()+" - "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
				}
			}
		}
		
//Prueba Manejo de Inventario (FUNCIONALIDAD 2)-----------------------------------------------------------------------------
		sup1.verificarVencimiento(15);
	}
}
