package Tests;

import java.util.ArrayList;
import java.util.Scanner;

import finanzas.Deuda;
import finanzas.Gasto;
import finanzas.Ingreso;
import gestorAplicacion.Bodega;
import gestorAplicacion.Empleado;
import gestorAplicacion.Orden;
import gestorAplicacion.Producto;
import gestorAplicacion.Supermercado;
import gestorAplicacion.TipoProducto;
import gestorAplicacion.Unidad;
import herramientas.Consola.Consolita;

public class testAbastecer {
	
	public static void main(String[] args) {
		
		//Productos
		Producto tomate = new Producto("Tomate", TipoProducto.ALIMENTO, 2500, 1800, 2300);
		Producto cebolla = new Producto("Cebolla", TipoProducto.ALIMENTO, 2300, 1700, 2800);
		Producto papa = new Producto("Papa", TipoProducto.ALIMENTO, 1500, 1000, 2000);
		Producto zanahoria = new Producto("Zanahoria", TipoProducto.ALIMENTO, 1200, 900, 1500);
		Producto lechuga = new Producto("Lechuga", TipoProducto.ALIMENTO, 1300, 1000, 1600);
		
		//Unidades Tomate
		for (int x = 0; x < 10; x++) {
			
			new Unidad(tomate);
			
		}
		//Fin Unidades Tomate
		

		//Bodegas
		ArrayList<Producto> productosA = new ArrayList<Producto>();
		productosA.add(tomate);
		productosA.add(cebolla);
		productosA.add(lechuga);
		
		
		Bodega bodega_A = new Bodega("Bodega A", "Barrio santigo", productosA);
		
		ArrayList<Bodega> bodegasA = new ArrayList<Bodega>();
		bodegasA.add(bodega_A);
		//Fin Bodegas
		
		
		//Supermercado
		Supermercado elPaisa = new Supermercado("El paisa", null, 1200, bodegasA, null, 
		null, null, new ArrayList<Ingreso>(), 10000000004445545.554f, new ArrayList<Gasto>(), 0, 
		new ArrayList<Deuda>(), 0, productosA);
		//Fin Supermercado
		
		
		System.out.print("¿Desea buscar los productos de forma manual?: S/N ");
		
		Scanner scn = new Scanner(System.in);
		
		String valor = scn.next();
		System.out.println("");
		
		boolean terminar = (valor.toUpperCase().equals("S")) || (valor.toUpperCase().equals("N"));
		
		while(!terminar){
			
			Consolita.limpiarConsola();
			System.out.println("Por favor ingrese un valor válido, S ó N");
			System.out.print("¿Desea buscar los productos de forma manual?: S/N ");
			
			scn = new Scanner(System.in);
			
			valor = scn.next();
		
			
		}
		
		boolean busqueda_auto = valor.equals("N");
		
		ArrayList<Producto> productos_hayados = new ArrayList<Producto>();
		
		//Buscar productos automaticamente
		if (busqueda_auto) {
			
			productos_hayados = Producto.sugerirProductosEscasos(elPaisa);
			
			while(true) {
				
				
				for (int i = 0; i < productos_hayados.size(); i++) {
					System.out.println(i + ". " + productos_hayados.get(i).getNombre());
				}
				
				System.out.print("Escriba el número del producto para que le asigne la cantidad que desea: ");
				scn = new Scanner(System.in);
				int eleccion = scn.nextInt();
				
				boolean eleccion_incorrecta = ( (eleccion < 0) || (eleccion > productos_hayados.size()) );
				
				while (eleccion_incorrecta) {
					
					Consolita.limpiarConsola();
					
					for (int i = 0; i < productos_hayados.size(); i++) {
						System.out.println(i + ". " + productos_hayados.get(i).getNombre());
					}
					
					System.out.println("Ingresa un número válido, >:( ");
					System.out.print("Escriba el número del producto para que le asigne la cantidad que desea: ");
					scn = new Scanner(System.in);
					eleccion = scn.nextInt();
					
					
				}
				
				//Eligiendo producto
				Consolita.limpiarConsola();
				Producto producto_elegido = productos_hayados.get(eleccion);
				
				System.out.print("Ingrese la cantidad de unidades del producto: " + producto_elegido.getNombre() + ": ");
				Scanner scn_unidades = new Scanner(System.in);
				int unidades = scn_unidades.nextInt();
				
				producto_elegido.asignarUnidadesCompra(unidades);
				//Fin Eligiendo producto
				
				Consolita.limpiarConsola();
				System.out.print("¿Quiere seguir asignando más unidades a los productos, escriba S?: ");
				
				Scanner new_scn = new Scanner(System.in);
				String decision = new_scn.next();
				
				boolean terminar_eleccion = !decision.toUpperCase().equals("S");
				
				if (terminar_eleccion) {
					break;
				}
			
			}
			

		}
		//Fin Buscar productos automaticamente
		
		else {
			
			productos_hayados = Producto.getTodosProductos(elPaisa);
			
			while(true) {
				
				
				for (int i = 0; i < productos_hayados.size(); i++) {
					System.out.println(i + ". " + productos_hayados.get(i).getNombre());
				}
				
				System.out.print("Escriba el número del producto para que le asigne la cantidad que desea: ");
				scn = new Scanner(System.in);
				int eleccion = scn.nextInt();
				
				boolean eleccion_incorrecta = ( (eleccion < 0) || (eleccion > productos_hayados.size()) );
				
				while (eleccion_incorrecta) {
					
					Consolita.limpiarConsola();
					
					for (int i = 0; i < productos_hayados.size(); i++) {
						System.out.println(i + ". " + productos_hayados.get(i).getNombre());
					}
					
					System.out.println("Ingresa un número válido, >:( ");
					System.out.print("Escriba el número del producto para que le asigne la cantidad que desea: ");
					scn = new Scanner(System.in);
					eleccion = scn.nextInt();
					
					
				}
				
				//Eligiendo producto
				Consolita.limpiarConsola();
				Producto producto_elegido = productos_hayados.get(eleccion);
				
				System.out.print("Ingrese la cantidad de unidades del producto: " + producto_elegido.getNombre() + ": ");
				Scanner scn_unidades = new Scanner(System.in);
				int unidades = scn_unidades.nextInt();
				
				producto_elegido.asignarUnidadesCompra(unidades);
				//Fin Eligiendo producto
				
				Consolita.limpiarConsola();
				System.out.print("¿Quiere seguir asignando más unidades a los productos, escriba S?: ");
				
				Scanner new_scn = new Scanner(System.in);
				String decision = new_scn.next();
				
				boolean terminar_eleccion = !decision.toUpperCase().equals("S");
				
				if (terminar_eleccion) {
					break;
				}
			
			}
			
		}
		
				
		//Calcular total cobrar Supermercado
		float total_cobro = Producto.calcularAbastecimiento(productosA);
		//Fin Calcular total cobrar Supermercado
		
		
		//¿El supermercado puede pagar?
		boolean puede_pagar = elPaisa.supermercadoPuedeComprarProductos(total_cobro);
		//Fin ¿El supermercado puede pagar?
		
		
		//En caso de que el supermercado pueda comprar los productos
		if (puede_pagar) {
			
			Unidad.abastecerUnidadesProducto(productos_hayados);
			
		}
		//Fin En caso de que el supermercado pueda comprar los productos
		
		
		//Mostrar los productos obtenidos
		for (Producto producto : productos_hayados) {
			
			System.out.println("Producto: " + producto.getNombre());
			System.out.println("Cantidad venta: " + producto.getCantidad_venta());
			System.out.println("Cantidad compra: " + producto.getCantidad_compra());
			System.out.println("Cantidad Unidades: " + producto.getUnidades().size());
			
			System.out.println();
		}
		
		//Mostrar los productos obtenidos
	
	}
	
	
}
