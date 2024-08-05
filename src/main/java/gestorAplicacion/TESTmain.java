package gestorAplicacion;

import gestorAplicacion.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class TESTmain {

	public static void main(String[] args) {
		
		Supermercado sup1 = new Supermercado("MercaChicles");
		Empleado emp1 = new Empleado("Pepe", 12345, sup1, 2000000);
		Cliente cli1 = new Cliente("Jaimito", 23456);
		Bodega bod1 = new Bodega("Bodega Principal", "Cordoba", sup1);
		Bodega bod2 = new Bodega("Bodega Secundaria", "La Piedra", sup1);
		sup1.agregarEmpleado(emp1);
		sup1.agregarBodega(bod1);
		sup1.agregarBodega(bod2);
		Producto prod1 = new Producto("Leche Colanta", TipoProducto.ALIMENTO, 3000, 2000);
		Producto prod2 = new Producto("Vodka Absoluti", TipoProducto.BEBIDA, 90000, 50000);
		Producto prod3 = new Producto("Leche Alqueria", TipoProducto.ALIMENTO, 3100, 2100);
		Unidad uni1 = new Unidad("2024-09-20", prod1, bod1);
		Unidad uni2 = new Unidad("2024-08-01", prod1, bod1);
		Unidad uni3 = new Unidad("2024-10-05", prod1, bod2);
		
		Unidad uni4 = new Unidad("2024-09-30", prod2, bod2);
		Unidad uni5 = new Unidad("2024-07-08", prod2, bod1);
		Unidad uni6 = new Unidad("2024-11-27", prod2, bod1);
		
		Unidad uni7 = new Unidad("2024-12-08", prod3, bod2);
		Unidad uni8 = new Unidad("2024-10-20", prod3, bod1);
		Unidad uni9 = new Unidad("2024-09-27", prod3, bod2);
		Unidad uni10 = new Unidad("2025-01-30", prod3, bod1);
		
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
*/		//Descuento desc3 = new Descuento("Descuento cerca de vencer", uni2, 50);
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
	


//__________________________________________________________________________________________________________________________________________________________________________________________________________

	Scanner scanner = new Scanner(System.in);
	
	System.out.println("BIENVENIDO\n¿Qué desa hacer?");
	System.out.println("1. Generar orden.\n2. Administrar productos proximos a vencer.");
	System.out.print("Ingrese el numero de la opción que desea: ");
	int eleccion = scanner.nextInt();
	//if (eleccion == 1) {
		
	//} 
	
	if (eleccion == 2) {
		
		//System.out.print("Nota: ingrese 000 para ir al menú anterior.");
		System.out.print("Ingrese los días para la busqueda: ");
		int eleccion1 = scanner.nextInt();
		
		ArrayList<Bodega> bodegas = sup1.getBodegas();
		ArrayList<Unidad> unidades = new ArrayList<Unidad>();
		ArrayList<Unidad> avencer = new ArrayList<Unidad>();
		for (int i=0 ; i < bodegas.size(); i++) {
			
			unidades.addAll(bodegas.get(i).getProductos());
			
		}
		
		for (int i=0; i < unidades.size(); i++) {
			long dias = unidades.get(i).diasParaVencimiento();
			if (dias <= eleccion1) {
				avencer.add(unidades.get(i));
			}
		}
		
		Collections.sort(avencer, new Comparator<Unidad>() {
			@Override
			public int compare(Unidad u1, Unidad u2) {
                return Long.compare(u1.diasParaVencimiento(), u2.diasParaVencimiento());
            }
		});
		
		System.out.println("Estos son los productos vencidos o proximos a vencer:");
		
		for (int i=0; i<avencer.size(); i++) {
			
			if( avencer.get(i).diasParaVencimiento() <= 0 ) {
				
				System.out.println("Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + avencer.get(i).getCodigo() + ", Ubicación: " + avencer.get(i).getUbicacion().getNombre() + ", VENCIDO");
				avencer.get(i).getUbicacion().quitarProducto(avencer.get(i));
				
			}
			
			else { 
				System.out.println("Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + avencer.get(i).getCodigo() + ", Ubicacion: "+ avencer.get(i).getUbicacion().getNombre() +", Dias para vencer: " + avencer.get(i).diasParaVencimiento());
			}
		}
		
		System.out.println("\nProductos disponibles para hacerle descuentos:");
		
		for (int i=0; i<avencer.size(); i++) {
			
			if( avencer.get(i).diasParaVencimiento() > 0 ) {
				
				System.out.println(" Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + avencer.get(i).getCodigo() + ", Dias para vencer: " + avencer.get(i).diasParaVencimiento());
				if (avencer.get(i).getDescuentos().size() == 0) {
					System.out.print("   No tiene descuentos disponibles ¿desea crear uno?\n   1.SI\n   2.NO\n   Ingrese el numero de la opción que desea: ");
					int eleccion2 = scanner.nextInt();
					if(eleccion2 == 1) {
						System.out.println("(Se crea el descuento)");
					}
				}
				
				else{
					System.out.println("Descuentos disponibles: " + avencer.get(i).getDescuentos());
				}
				
				
			}
			
		}
		
		
		
		
	}
	
}}


