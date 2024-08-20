package uiMain;

import gestorAplicacion.*;
import baseDatos.*;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static final String CARPETA_TEMP = "src/baseDatos/temp/";

    public static void main(String[] args) {
    	//--------------------------------------------------------------------------
    	
    	Supermercado sup1 = new Supermercado("MercaChicles", 1000000);
    	Supermercado sup2 = new Supermercado("La Tapita", 1200000);
    	Empleado emp1 = new Empleado("Pepe Perez", 12345, sup1, "Empleado", 2000000);
    	Empleado emp2 = new Empleado("Pablo Tobon", 12345, sup1, "Gerente", 2000000);
    	Empleado emp3 = new Empleado("Pepito Alea", 12345, sup2, "Empleado", 2000000);
    	Empleado emp4 = new Empleado("Pedro Picapiedra", 12345, sup2, "Gerente", 2000000);
    	Cliente cli1 = new Cliente("Jaimito Gutierrez", 23456);
    	Cliente cli2 = new Cliente("Armando Mendoza", 23456);
		Bodega bod1 = new Bodega("Bodega Principal", "Cordoba", sup1);
		Bodega bod2 = new Bodega("Bodega Secundaria", "La Piedra", sup1);
		Bodega bod3 = new Bodega("Bodega Principal 2", "Cordoba", sup2);
		Bodega bod4 = new Bodega("Bodega Secundaria 2", "La Piedra", sup2);
		sup1.agregarBodega(bod1);
		sup1.agregarBodega(bod2);
		sup2.agregarBodega(bod3);
		sup2.agregarBodega(bod4);
		Producto prod1 = new Producto("leche Colanta", TipoProducto.ALIMENTO, 3000, 2000);
		Producto prod2 = new Producto("vodka Absoluti", TipoProducto.BEBIDA, 90000, 50000);
		Producto prod3 = new Producto("leche Alqueria", TipoProducto.ALIMENTO, 3100, 2100);
		Producto prod4 = new Producto("detergente Fav", TipoProducto.ASEO, 6500, 5000);
		Producto prod5 = new Producto("jabón Dove", TipoProducto.CUIDADOPERSONAL, 18900, 13450);
		Producto prod6 = new Producto("cuido Dog Chow", TipoProducto.MASCOTA, 125000, 98000);
		Producto prod7 = new Producto("spray Raid", TipoProducto.OTRO, 17000, 15100);
		Producto prod8 = new Producto("cepillo Pro 425", TipoProducto.CUIDADOPERSONAL, 4700, 3000);
		
		Unidad uni1 = new Unidad("2024-09-20", prod1, bod1);
		Unidad uni2 = new Unidad("2024-08-25", prod1, bod1);
		Unidad uni3 = new Unidad("2024-10-05", prod1, bod2);
		
		Unidad uni4 = new Unidad("2024-09-30", prod2, bod2);
		Unidad uni5 = new Unidad("2024-07-08", prod2, bod1);
		Unidad uni6 = new Unidad("2024-11-27", prod2, bod1);
		
		Unidad uni7 = new Unidad("2024-12-08", prod3, bod2);
		Unidad uni8 = new Unidad("2024-10-20", prod3, bod1);
		Unidad uni9 = new Unidad("2024-09-27", prod3, bod2);
		Unidad uni10 = new Unidad("2025-01-30", prod3, bod1);
		
		Unidad uni11 = new Unidad("2026-02-25", prod4, bod1);
		Unidad uni12 = new Unidad("2026-02-25", prod4, bod1);
		Unidad uni13 = new Unidad("2026-02-25", prod4, bod2);
		Unidad uni14 = new Unidad("2026-02-25", prod4, bod2);
		
		Unidad uni15 = new Unidad("2025-08-06", prod5, bod1);
		Unidad uni16 = new Unidad("2025-08-06", prod5, bod1);
		Unidad uni17 = new Unidad("2025-04-30", prod5, bod2);
		
		Unidad uni18 = new Unidad("2024-12-31", prod6, bod1);
		Unidad uni19 = new Unidad("2024-12-31", prod6, bod2);
		Unidad uni20 = new Unidad("2025-01-30", prod6, bod2);
		Unidad uni21 = new Unidad("2025-01-30", prod6, bod1);
		Unidad uni22 = new Unidad("2025-06-10", prod6, bod2);
		
		Unidad uni23 = new Unidad("2030-01-01", prod7, bod1);
		Unidad uni24 = new Unidad("2030-01-01", prod7, bod1);
		Unidad uni25 = new Unidad("2030-01-01", prod7, bod2);
		Unidad uni26 = new Unidad("2030-01-01", prod7, bod2);
		
		Unidad uni27 = new Unidad("2025-03-25", prod8, bod1);
		Unidad uni28 = new Unidad("2025-03-25", prod8, bod1);
		Unidad uni29 = new Unidad("2025-05-01", prod8, bod2);
		Unidad uni30 = new Unidad("2025-05-01", prod8, bod2);
		Unidad uni31 = new Unidad("2025-07-10", prod8, bod1);
		
		Unidad uni41 = new Unidad("2024-09-20", prod1, bod3);
		Unidad uni42 = new Unidad("2024-08-25", prod1, bod3);
		Unidad uni43 = new Unidad("2024-10-05", prod1, bod4);
		
		Unidad uni44 = new Unidad("2024-09-30", prod2, bod4);
		Unidad uni45 = new Unidad("2024-07-08", prod2, bod3);
		Unidad uni46 = new Unidad("2024-11-27", prod2, bod3);
		
		Unidad uni47 = new Unidad("2024-12-08", prod3, bod4);
		Unidad uni48 = new Unidad("2024-10-20", prod3, bod3);
		Unidad uni49 = new Unidad("2024-09-27", prod3, bod4);
		Unidad uni50 = new Unidad("2025-01-30", prod3, bod3);
		
		Unidad uni51 = new Unidad("2026-02-25", prod4, bod3);
		Unidad uni52 = new Unidad("2026-02-25", prod4, bod3);
		Unidad uni53 = new Unidad("2026-02-25", prod4, bod4);
		Unidad uni54 = new Unidad("2026-02-25", prod4, bod4);
		
		Unidad uni55 = new Unidad("2025-08-06", prod5, bod3);
		Unidad uni56 = new Unidad("2025-08-06", prod5, bod3);
		Unidad uni57 = new Unidad("2025-04-30", prod5, bod4);
		
		Unidad uni58 = new Unidad("2024-12-31", prod6, bod3);
		Unidad uni59 = new Unidad("2024-12-31", prod6, bod4);
		Unidad uni60 = new Unidad("2025-01-30", prod6, bod4);
		Unidad uni61 = new Unidad("2025-01-30", prod6, bod3);
		Unidad uni62 = new Unidad("2025-06-10", prod6, bod4);
		
		Unidad uni63 = new Unidad("2030-01-01", prod7, bod3);
		Unidad uni64 = new Unidad("2030-01-01", prod7, bod3);
		Unidad uni65 = new Unidad("2030-01-01", prod7, bod4);
		Unidad uni66 = new Unidad("2030-01-01", prod7, bod4);
		
		Unidad uni67 = new Unidad("2025-03-25", prod8, bod3);
		Unidad uni68 = new Unidad("2025-03-25", prod8, bod3);
		Unidad uni69 = new Unidad("2025-05-01", prod8, bod4);
		Unidad uni70 = new Unidad("2025-05-01", prod8, bod4);
		Unidad uni71 = new Unidad("2025-07-10", prod8, bod3);
    	
		//Descuento desc1 = new Descuento("Descuento Alimentos", TipoProducto.ALIMENTO, 25);
		//Descuento desc2 = new Descuento("Descuento Leche Coranta", prod1, 30);
		Descuento desc3 = new Descuento("Descuento cerca de vencer", uni2, 50);
		
    	//--------------------------------------------------------------------------
        // Deserializar los datos
        //deserializarDatos();

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("______________________________________________________________________________________________________");
		    System.out.println("=== Menú Principal ===\n");
		    System.out.println("1. Nueva orden de compra");
		    System.out.println("2. Manejo de Inventario");
		    System.out.println("3. Salir");
		    System.out.println("");
		    System.out.print("Seleccione una opción: ");


		    try {
		        int opcion = scanner.nextInt();
		        scanner.nextLine();

		        switch (opcion) {
		            case 1:
		                crearOrden();
		                break;
		            case 2:
		            	boolean et = false;
		            	while(!et) {
		            		System.out.println("______________________________________________________________________________________________________");
		            		System.out.println("=== Que desea hacer ===\n");
		            		System.out.println("1. Descuentos por vencimiento");
		            		System.out.println("2. Intercambio de productos entre supermercados");
		            		System.out.println("3. Surtir");
		            		System.out.println("");
		            		System.out.print("Seleccione una opción: ");
		    		    
		            		try {
		            			opcion = scanner.nextInt();
		            			scanner.nextLine();

		            			switch (opcion) {
		    		            	case 1:
		    		            		administrarInventario();
		    		            		et = true;
		    		            		break;
		    		            	case 2:
		    		            		intercambioProductos();
		    		            		et = true;
		    		            		break;
		    		            	case 3:
		    		            		//surtir();
		    		            		et = true;
		    		            		break;
		    		            	default:
		    		            		System.out.println("______________________________________________________________________________________________________");
		    		            		System.out.println("- Opción inválida, por favor intente de nuevo.");
		    		            		break;
		            			}
		            		}
		            		catch (InputMismatchException e) {
		            			System.out.println("______________________________________________________________________________________________________");
		            			System.out.println("- Opción inválida, por favor intente de nuevo.");
		            			scanner.nextLine();
		            		}	
		            	}
		            	break;
		            case 3:
		                exit = true;
		                System.out.println("______________________________________________________________________________________________________");
		                System.out.println("¡Adiós!");
		                System.out.println("______________________________________________________________________________________________________");
		                break;
		            default:
		            	System.out.println("______________________________________________________________________________________________________");
		                System.out.println("- Opción inválida, por favor intente de nuevo.");
		                break;
		        }
		    } 
		    catch (InputMismatchException e) {
		    	System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scanner.nextLine();
		    }
		}
        // Serializar los datos antes de salir
        //serializarDatos();
        scanner.close();
    }

    private static void deserializarDatos() {
    	GestorDeArchivos.crearCarpetaTemp();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA_TEMP + "datos.dat"))) {
            Supermercado.setSupermercados((ArrayList<Supermercado>) ois.readObject());
            Producto.setLista_productos((ArrayList<Producto>) ois.readObject());
            Descuento.setDescuentos((ArrayList<Descuento>) ois.readObject());
            // Añadir la deserialización de otras clases si es necesario
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar los datos: " + e.getMessage());
        }
    }

    private static void serializarDatos() {
    	GestorDeArchivos.crearCarpetaTemp();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA_TEMP + "datos.dat"))) {
            oos.writeObject(Supermercado.getSupermercados());
            oos.writeObject(Producto.getLista_productos());
            oos.writeObject(Descuento.getDescuentos());
            // Añadir la serialización de otras clases si es necesario
        } catch (IOException e) {
            System.out.println("Error al serializar los datos: " + e.getMessage());
        }
    }

    private static void crearOrden() {
        ArrayList<Supermercado> supermercados = Supermercado.getSupermercados();
    	ArrayList<Persona> personas = Persona.getPersonas();
    	ArrayList<Empleado> empleados;
    	ArrayList<Persona> clientes = new ArrayList<>();
    	Supermercado supermercado;
    	Persona empleado;
    	Persona cliente;
//    	for (Persona persona : personas) {
//    		if (persona.getCargo() != "Cliente") empleados.add(persona);
//    		else clientes.add(persona);
//    	}
    	Scanner scn = new Scanner(System.in);
    	while (true) {
    		int i = 0;
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Lista de Supermercados ===\n");
    		for (Supermercado sup : supermercados) {
    			i++;
    			System.out.println(i+". "+sup.getNombre());
    		}
    		System.out.println("");
    		System.out.print("Seleccione un supermercado: ");
    		try {
    			int opcion = scn.nextInt();
    			while (opcion < 1 || opcion > supermercados.size()) {
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- Opción inválida, por favor intente de nuevo.");
    				i = 0;
    	    		System.out.println("______________________________________________________________________________________________________");
    	    		System.out.println("=== Lista de Supermercados ===\n");
    	    		for (Supermercado sup : supermercados) {
    	    			i++;
    	    			System.out.println(i+". "+sup.getNombre());
    	    		}
    	    		System.out.println("");
    	    		System.out.print("Seleccione un supermercado: ");
    	    		opcion = scn.nextInt();
    	    		scn.nextLine();
    			}
    			supermercado = supermercados.get(opcion - 1);
    			System.out.println("______________________________________________________________________________________________________");
    			System.out.println("- Supermercado "+supermercado.getNombre()+" selecionado.");
    			break;
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scn.nextLine();
		    }
    	}
    	empleados = supermercado.getEmpleados();
    	while (true) {
    		int i = 0;
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Lista de Empleados ===\n");
    		for (Persona persona : empleados) {
    			i++;
    			System.out.println(i + ". " + persona.getCargo()+ " " + persona.getNombre());
    		}
    		System.out.println("");
    		System.out.print("Seleccione empleado encargado: ");
    		try {
    			int opcion = scn.nextInt();
    			while (opcion < 1 || opcion > empleados.size()) {
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- Opción inválida, por favor intente de nuevo.");
    				i = 0;
    	    		System.out.println("______________________________________________________________________________________________________");
    	    		System.out.println("=== Lista de Empleados ===\n");
    	    		for (Persona persona : empleados) {
    	    			i++;
    	    			System.out.println(i + ". " + persona.getCargo()+ " " + persona.getNombre());
    	    		}
    	    		System.out.println("");
    	    		System.out.print("Seleccione empleado encargado: ");
    				opcion = scn.nextInt();
    				scn.nextLine();
    			}
    			empleado = (Empleado)empleados.get(opcion - 1);
    			System.out.println("______________________________________________________________________________________________________");
    			System.out.println("- "+empleado.getCargo()+" "+empleado.getNombre()+" selecionado.");
    			break;
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scn.nextLine();
		    }
    	}
    	System.out.println("______________________________________________________________________________________________________");
    	System.out.print("El cliente ya está registrado? (s/n): ");
    	String opcionstr = scn.next();
    	scn.nextLine();
    	while (!opcionstr.equalsIgnoreCase("s") && !opcionstr.equalsIgnoreCase("n")) {
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("- Opción inválida, por favor intente de nuevo.");
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.print("El cliente ya está registrado? (s/n): ");
    		opcionstr = scn.next();
    	    scn.nextLine();
    	}
    	if (opcionstr.equalsIgnoreCase("s")) {
    		while (true) {
    			int i = 0;
    			System.out.println("______________________________________________________________________________________________________");
    			System.out.println("=== Lista de Clientes ===\n");
    			for (Persona persona : clientes) {
    				i++;
    				System.out.println(i + ". " + persona.getNombre()+" con cédula "+persona.getCedula());
    			}
    			System.out.println("");
    			System.out.print("Seleccione el cliente: ");
    			try {
    				int opcion = scn.nextInt();
    				while (opcion < 1 || opcion > clientes.size()) {
    					System.out.println("______________________________________________________________________________________________________");
    					System.out.println("- Opción inválida, por favor intente de nuevo.");
    					i = 0;
    	    			System.out.println("______________________________________________________________________________________________________");
    	    			System.out.println("=== Lista de Clientes ===\n");
    	    			for (Persona persona : clientes) {
    	    				i++;
    	    				System.out.println(i + ". " + persona.getNombre()+" con cédula "+persona.getCedula());
    	    			}
    	    			System.out.println("");
    	    			System.out.print("Seleccione el cliente: ");
    					opcion = scn.nextInt();
    					scn.nextLine();
    				}
    				cliente = clientes.get(opcion - 1);
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- "+cliente.getCargo()+" "+ cliente.getNombre()+" con cédula "+cliente.getCedula()+" selecionado.");
    				break;
    			}
    			catch (InputMismatchException e) {
    				System.out.println("______________________________________________________________________________________________________");
    		        System.out.println("- Opción inválida, por favor intente de nuevo.");
    		        scn.nextLine();
    		    }
    		}
    	}
    	else {
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("- Iniciando registro de cliente...");
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.print("Ingrese el nombre del cliente: ");
    		String nombre = scn.nextLine();
	    	System.out.print("Ingrese la cédula del cliente: ");
    		Long cedula = scn.nextLong();
	    	scn.nextLine();
	    	cliente = new Cliente(nombre, cedula);
	    	System.out.println("______________________________________________________________________________________________________");
	    	System.out.println("Cliente "+nombre+" con cédula "+cedula+" creado con éxito.");
    	}
    	Orden orden = new Orden(supermercado, (Empleado)empleado, (Cliente)cliente);
    	boolean exit = false;
    	while(!exit) {
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Qué desea hacer? ===\n");
    		System.out.println("1. Agregar producto a la orden");
    		System.out.println("2. Remover producto de la orden");
    		System.out.println("3. Ver productos en la orden");
    		System.out.println("4. Finalizar orden");
    		System.out.println("5. Cancelar orden");
    		System.out.println("");
    		System.out.print("Seleccione una opción: ");
    		
    		try {
    			int opcion = scn.nextInt();
    			scn.nextLine();
        
    			switch (opcion) {
        			case 1:
        				agregarProducto(orden);
        				break;
        			case 2:
        				quitarProducto(orden);
        				break;
        			case 3:
        				mostrarOrden(orden);
        				break;
        			case 4:
        				if (orden.getProductos().size()!=0) {
        					orden.completarOrden();
        					System.out.println("______________________________________________________________________________________________________");
        					System.out.println("---Orden Completa---");
        				}
        				else {
        					System.out.println("______________________________________________________________________________________________________");
        					System.out.println("---La Orden no contiene productos---");
        					System.out.println("---Orden Cancelada---");
        				}
        				exit = true;
        				break;
        			case 5:
        				orden.cancelarOrden();
        				System.out.println("______________________________________________________________________________________________________");
        				System.out.println("---Orden Cancelada---");
        				exit = true;
        				break;
        			default:
        				System.out.println("______________________________________________________________________________________________________");
        				System.out.println("- Opción inválida, por favor intente de nuevo.");
        				break;
    			}
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scn.nextLine();
		    }
    		
        }
    }
    private static void agregarProducto(Orden orden) {
    	Scanner scann = new Scanner(System.in);
    	boolean exit = false;
    	TipoProducto tipo = null;;
    	while(!exit) {
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Seleccione el tipo de producto a buscar ===\n");
    		System.out.println("1. Aseo");
    		System.out.println("2. Alimento");
    		System.out.println("3. Bebida");
    		System.out.println("4. Cuidado personal");
    		System.out.println("5. Productos para mascotas");
    		System.out.println("6. Otro");
    		System.out.println("");
    		System.out.print("Seleccione una opción: ");
    		
    		try {
    			int opcion = scann.nextInt();
    			scann.nextLine();
        
    			switch (opcion) {
        			case 1:
        				tipo = TipoProducto.ASEO;
        				exit = true;
        				break;
        			case 2:
        				tipo = TipoProducto.ALIMENTO;
        				exit = true;
        				break;
        			case 3:
        				tipo = TipoProducto.BEBIDA;
        				exit = true;
        				break;
        			case 4:
        				tipo = TipoProducto.CUIDADOPERSONAL;
        				exit = true;
        				break;
        			case 5:
        				tipo = TipoProducto.MASCOTA;
        				exit = true;
        				break;
        			case 6:
        				tipo = TipoProducto.OTRO;
        				exit = true;
        				break;
        			default:
        				System.out.println("______________________________________________________________________________________________________");
        				System.out.println("- Opción inválida, por favor intente de nuevo.");
        				break;
    			}
    		}
    		catch (InputMismatchException e) {
		    	System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scann.nextLine();
		    }
    		
        }
    	ArrayList<Producto> lista1 = orden.getSupermercado().productosPorTipo(tipo);
    	if (lista1.size() == 0) {
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("No hay productos disponibles del tipo seleccionado.");
    	}
    	else {
    		int i = 0;
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Productos disponibles ===\n");
    		for (Producto producto : lista1) {
    			i++;
    			System.out.println(i+". "+producto.getNombre());
    		}
    		System.out.print("\nDesea agregar algún producto al carrito? (s/n): ");
	        String opcionstr = scann.next();
	        scann.nextLine();
	    	while (!opcionstr.equalsIgnoreCase("s") && !opcionstr.equalsIgnoreCase("n")) {
	    		System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    		opcionstr = scann.next();
	    	    scann.nextLine();
	    	}
	    	if (opcionstr.equalsIgnoreCase("s")) {
	    		int opcionproducto;
	    		System.out.print("Seleccione el producto a agregar: ");
	    		while (true) {
	    			try {
	    				opcionproducto = scann.nextInt();
	    				scann.nextLine();
	    				while (opcionproducto < 1 || opcionproducto > lista1.size()) {
	    					System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    					opcionproducto = scann.nextInt();
	    					scann.nextLine();
	    				}
	    				break;
	    			}
	    			catch (InputMismatchException e) {
	    				System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    				scann.nextLine();
	    			}
	    		}
	    		ArrayList<Unidad> unienof = new ArrayList<>();
    			ArrayList<Unidad> unisinof = new ArrayList<>();
    			for (Unidad unidad : lista1.get(opcionproducto-1).getUnidades()) {
    				if (unidad.isOferta())unienof.add(unidad);
    				else unisinof.add(unidad);
    			}
    			System.out.println("______________________________________________________________________________________________________");
        		System.out.println("=== Unidades disponibles=== \n");
        		i=0;
    			if (unisinof.size() != 0) {
    				i++;
    				System.out.println(i+". Sin oferta - $"+lista1.get(opcionproducto-1).getPrecio()+" cantidad disponible: "+unisinof.size());
    			}
    			if (unienof.size() != 0) {
    				for (Unidad unidad : unienof) {
    					i++;
    					System.out.println(i+". "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
    				}
    			}
    			System.out.println("");
        		System.out.print("Desea agregar alguna unidad? (s/n): ");
    	        String opcionstr2 = scann.next();
    	        scann.nextLine();
    	    	while (!opcionstr2.equalsIgnoreCase("s") && !opcionstr2.equalsIgnoreCase("n")) {
    	    		System.out.println("______________________________________________________________________________________________________");
    	    		System.out.println("- Opción inválida, por favor intente de nuevo.");
    	    		System.out.println("______________________________________________________________________________________________________");
            		System.out.println("=== Unidades disponibles=== \n");
            		i=0;
        			if (unisinof.size() != 0) {
        				i++;
        				System.out.println(i+". Sin oferta - $"+lista1.get(opcionproducto-1).getPrecio()+" cantidad disponible: "+unisinof.size());
        			}
        			if (unienof.size() != 0) {
        				for (Unidad unidad : unienof) {
        					i++;
        					System.out.println(i+". "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
        				}
        			}
        			System.out.println("");
            		System.out.print("Desea agregar alguna unidad? (s/n): ");
        	        opcionstr2 = scann.next();
        	        scann.nextLine();
    	    	}
    	    	if (opcionstr2.equalsIgnoreCase("s")) {
    	    		int opcion;
    	    		System.out.print("Seleccione la unidad a agregar: ");
    	    		while (true) {
    	    			try {
    	    				opcion = scann.nextInt();
    	    				scann.nextLine();
    	    				while (opcion < 1 || opcion > i) {
    	    					System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    					opcion = scann.nextInt();
    	    					scann.nextLine();
    	    				}
    	    				break;
    	    			}
    	    			catch (InputMismatchException e) {
    	    				System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    				scann.nextLine();
    	    			}
    	    		}
    	    		if (opcion == 1) {
    	    			if(unisinof.size() != 0) {
    	    				System.out.print("Ingrese el número de unidades a agregar: ");
    	    				while(true) {
    	    					try {
    	    						opcion = scann.nextInt();
    	    						scann.nextLine();
    	    						while (opcion < 0 || opcion > unisinof.size()) {
    	    							System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    							opcion = scann.nextInt();
    	    							scann.nextLine();
    	    						}
    	    						break;
    	    					}
    	    					catch (InputMismatchException e) {
    	    	    				System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    	    				scann.nextLine();
    	    	    			}
    	    				}
    	        	        orden.agregarProducto(lista1.get(opcionproducto-1), opcion);
    	        	        System.out.println("______________________________________________________________________________________________________");
    	            		System.out.println("Producto(s) agregado(s) a la orden: ");
    	    			}
    	    			else {
    	    				orden.agregarUnidad(unienof.get(0));
    	    				System.out.println("______________________________________________________________________________________________________");
    	            		System.out.println("Producto agregado a la orden: ");
    	    			}
    	    		}
    	    		else {
    	    			if(unisinof.size() != 0) {
    	    				orden.agregarUnidad(unienof.get(opcion-2));
    	    				System.out.println("______________________________________________________________________________________________________");
    	            		System.out.println("Producto agregado a la orden: ");
    	    			}
    	    			else {
    	    				orden.agregarUnidad(unienof.get(opcion-1));
    	    				System.out.println("______________________________________________________________________________________________________");
    	            		System.out.println("Producto agregado a la orden: ");
    	    			}
    	    		}
    	    	}
	    	}
    	}
    }
    
    private static void quitarProducto(Orden orden) {
    	Scanner scnn = new Scanner(System.in);
    	boolean exit = false;
    	while (!exit) {
    		int i = 0;
    		ArrayList<Unidad> unidades = orden.getProductos();
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Producto(s) actualmente en la orden ===\n");
    		for (Unidad unidad : unidades) {
    			i++;
    			if (unidad.isOferta()) {
    			System.out.println(i+". "+unidad.getTipo().getNombre()+" "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
    			}
    			else {
    				System.out.println(i+". "+unidad.getTipo().getNombre()+" $"+unidad.calcularPrecio());
    			}
    		}
    		i++;
    		System.out.println(i+". Cancelar");
    		System.out.println("");
    		System.out.print("Seleccione un producto para remover: ");
    		try {
    			int opcion = scnn.nextInt();
    			scnn.nextLine();
    			while (opcion < 0 || opcion > unidades.size()+1) {
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- Opción inválida, por favor intente de nuevo.");
    				opcion = scnn.nextInt();
    				scnn.nextLine();
    			}
    			if (opcion != i) {
    				orden.quitarUnidad(unidades.get(opcion-1));
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("El producto se removió con éxito.");
    			}
    			else exit = true;
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scnn.nextLine();
		    }
    		
    	}
    }
    
    private static void mostrarOrden(Orden orden) {
    	int i = 0;
    	ArrayList<Unidad> unidades = orden.getProductos();
    	System.out.println("______________________________________________________________________________________________________");
    	System.out.println("Orden id: "+orden.getId());
		System.out.println("Supermercado: "+orden.getSupermercado().getNombre());
		System.out.println("Empleado: "+orden.getEmpleado().getNombre());
		System.out.println("Cliente: "+orden.getCliente().getNombre());
		System.out.println("");
    	System.out.println("Productos en la orden:");
    	for (Unidad unidad : unidades) {
			i++;
			if (unidad.isOferta()) {
			System.out.println(i+". "+unidad.getTipo().getNombre()+" "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
			}
			else {
				System.out.println(i+". "+unidad.getTipo().getNombre()+" $"+unidad.calcularPrecio());
			}
		}
    	System.out.println("");
    	System.out.println("Precio total: $"+orden.calcularPrecioTotal());
    	System.out.println("______________________________________________________________________________________________________");
    	
    }


//=============METODO PARA LA SEGUNDA FUNCION (ADMINISTRAR INVENTARIO)====================
	
    private static int contarTiposDiferentes(ArrayList<Unidad> unidades) {
        ArrayList<TipoProducto> tiposUnicos = new ArrayList<>();
        for (Unidad unidad : unidades) {
            if (!tiposUnicos.contains(unidad.getTipo().getTipo())) {
                tiposUnicos.add(unidad.getTipo().getTipo());
            }
        }
        System.out.println("Retornando: " + tiposUnicos.size());
        return tiposUnicos.size();
    }
    
    private static void administrarInventario() {
		
		Scanner scanner2 = new Scanner(System.in);
		
		ArrayList<Supermercado> supermercados = Supermercado.getSupermercados();
		ArrayList<Persona> personas = Persona.getPersonas();
    	ArrayList<Empleado> empleados;
    	
    	int j = 0;
    	System.out.println("Lista de Supermercados:");
    	for (Supermercado supermercado : supermercados) {
    		j++;
    		System.out.println(j+". "+supermercado.getNombre());
    	}
    	System.out.println("");
    	System.out.print("Seleccione un supermercado: ");
    	int opcion = scanner2.nextInt();
    	while (opcion < 1 || opcion > supermercados.size()) {
        	System.out.print("- Opción inválida, por favor intente de nuevo: ");
        	opcion = scanner2.nextInt();
        	scanner2.nextLine();
        }
        Supermercado supermercado = supermercados.get(opcion - 1);
        empleados = supermercado.getEmpleados();
        System.out.println("- Supermercado "+supermercado.getNombre()+" selecionado.");
        j = 0;
    	System.out.println("");
    	System.out.println("Lista de Empleados:");
        for (Persona persona : empleados) {
        	j++;
        	System.out.println(j + ". " + persona.getCargo()+ " " + persona.getNombre());
        }
        System.out.println("");
        System.out.print("\nSeleccione empleado encargado: ");
        opcion = scanner2.nextInt();
        while (opcion < 1 || opcion > empleados.size()) {
        	System.out.print("- Opción inválida, por favor intente de nuevo: ");
        	opcion = scanner2.nextInt();
        	scanner2.nextLine();
        }
        Persona empleado = empleados.get(opcion - 1);
        System.out.println("- "+empleado.getCargo()+" "+empleado.getNombre()+" selecionado.");
        System.out.println("");
    	
		System.out.print("Ingrese los días para la busqueda: ");
		int eleccion1 = scanner2.nextInt();

		while (eleccion1 < 0 ) {
        	System.out.print("- Opción inválida, por favor intente de nuevo: ");
        	eleccion1 = scanner2.nextInt();
        	scanner2.nextLine();
        }
		
		ArrayList<Bodega> bodegas = supermercado.getBodegas();
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
		if(avencer.size() == 0) {
			System.out.println("No hay productos proximos a vencer en ese plazo");
		}
		else {
			System.out.println("______________________________________________________________________________________________________"
					+ "\nEstos son los productos vencidos o proximos a vencer:\n");
		
			for (int i=0; i<avencer.size(); i++) {
				
				if( avencer.get(i).diasParaVencimiento() <= 0 ) {
					
					System.out.println("Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + 
					avencer.get(i).getCodigo() + ", Ubicación: " + avencer.get(i).getUbicacion().getNombre() + ", VENCIDO");
					
					avencer.get(i).getUbicacion().quitarProducto(avencer.get(i));
					
				}
				
				else { 
					System.out.println("Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + avencer.get(i).getCodigo() 
					+ ", Ubicacion: "+ avencer.get(i).getUbicacion().getNombre() +", Dias para vencer: " + avencer.get(i).diasParaVencimiento());
				}
			}
			
			scanner2.nextLine();
			scanner2.nextLine();
			
			int disponibles = 0;
			for(int d=0; d<avencer.size(); d++) {
				if( avencer.get(d).diasParaVencimiento() > 0 ) {
					disponibles++;
				}
			}
			if (disponibles > 0) {
				System.out.println("______________________________________________________________________________________________________\nProductos disponibles para hacerle descuentos:");
			}
			else {
				System.out.print("No hay productos disponibles para hacer descuentos.");
			}
			
			for (int i=0; i<avencer.size(); i++) {
				
				if( avencer.get(i).diasParaVencimiento() > 0 ) {
					
				System.out.println("\n->Nombre: " + avencer.get(i).getTipo().getNombre() + ", Codigo: " + avencer.get(i).getCodigo() + ", Dias para vencer: " + avencer.get(i).diasParaVencimiento());
					
					if (avencer.get(i).getDescuentos().size() == 0) {
						System.out.print("  No tiene descuentos disponibles ¿desea crear uno? (s/n): ");
						String eleccion2 = scanner2.next();
						
						while (!eleccion2.equalsIgnoreCase("s") && !eleccion2.equalsIgnoreCase("n")) {
	    	    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    	    			eleccion2 = scanner2.next();}
						
						if(eleccion2.equalsIgnoreCase("s")) {
							System.out.print("  Ingrese el nombre del descuento: ");
							String nombreDescuento = scanner2.next();
							System.out.print("  Ingrese el porcentaje de descuento: ");
							int porcentajeDescuento = scanner2.nextInt();
							Descuento descuentoPorVencimiento = new Descuento(nombreDescuento, avencer.get(i), porcentajeDescuento);
						}
					}
					
					else{
						System.out.println("  Mejor descuento:");
						System.out.println("  Nombre del descuento: '" + avencer.get(i).calcularOferta().getNombre() + "' Descuento: " + avencer.get(i).calcularOferta().getPorcentaje_descuento() 
								+ "% (Antes: " + avencer.get(i).getTipo().getPrecio() + " Ahora: " + avencer.get(i).calcularPrecio() + ")");
						
						
						System.out.print("  ¿Desea agregar un mejor descuento? (s/n): ");
						String eleccion3 = scanner2.next();
		    	    	
		    	        while (!eleccion3.equalsIgnoreCase("s") && !eleccion3.equalsIgnoreCase("n")) {
		    	    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
		    	    			eleccion3 = scanner2.next();
		    	    	    	scanner2.nextLine();}
						
						if (eleccion3.equalsIgnoreCase("s")) {
							System.out.print("  Ingrese el nombre del descuento: ");
							String nombreDescuento = scanner2.next();
							System.out.print("  Ingrese el porcentaje de descuento: ");
							int porcentajeDescuento = scanner2.nextInt();
							Descuento descuentoPorVencimiento = new Descuento(nombreDescuento, avencer.get(i), porcentajeDescuento);
						}
					}	
				
				}
			}
			scanner2.nextLine();
			
			ArrayList<Unidad> disponiblesParaPaquetes = new ArrayList<Unidad> ();
			for(Unidad unidad : avencer) {
				if(unidad.diasParaVencimiento()>0) {
					disponiblesParaPaquetes.add(unidad);
				}
			}
			
			ArrayList<TipoProducto> tipos = new ArrayList<TipoProducto> ();
			
			for(Unidad unidad : disponiblesParaPaquetes) {
				TipoProducto tipo = unidad.getTipo().getTipo();
				if(!tipos.contains(tipo)) {
					tipos.add(tipo);
				}
			}
			
			if(tipos.size()>1) {
				System.out.print("\n¿Desea crear paquetes de promociones? (s/n): ");
				String eleccion4 = scanner2.next();
				 while (!eleccion4.equalsIgnoreCase("s") && !eleccion4.equalsIgnoreCase("n")) {
		    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
		    			eleccion4 = scanner2.next();
		    	    	scanner2.nextLine();}
				 if(eleccion4.equalsIgnoreCase("s")) {
					 ArrayList<TipoProducto> tiposdisp;
					 ArrayList<Unidad> paquete;
					 //
					 boolean ex = false;
					 while (!ex) {
						 paquete = new ArrayList<>();
						 tiposdisp = new ArrayList<>();
						 for (TipoProducto t : tipos) {
							 tiposdisp.add(t);
						
						 }
						 for(Unidad unidad : disponiblesParaPaquetes) {
							
							 if (tiposdisp.contains(unidad.getTipo().getTipo()) && !unidad.isEnPaquete()) {
								 paquete.add(unidad);
								 unidad.setEnPaquete(true);
								 tiposdisp.remove(unidad.getTipo().getTipo());
								
							 }
						 }
						 if (paquete.size() > 1) {
							 supermercado.agregarPaquetePromocion(paquete);
						 }
						 else {
							 for (Unidad uni : paquete) {
								 uni.setEnPaquete(false);
								 ex = true;
							 }
						 }
					 }
				 }	
				 System.out.println("______________________________________________________________________________________________________");
				 System.out.println("Paquetes creados.");
				 int i = 1;
				 for (ArrayList<Unidad> uni : supermercado.getPaquetesPromocion()) {
					 float valorPromo = 0;
					for(Unidad u : uni) {
						valorPromo += u.calcularPrecio();
					}
					 System.out.println("______________________________________________________________________________________________________\nPaquete #" + i + " Precio: " + valorPromo);
					 
					 for(Unidad u : uni) {
						 System.out.println("Producto: " + u.getTipo().getNombre() + " Codigo: " + u.getCodigo());
					 }
					 
					System.out.print("\n¿Desea hacer decuento al precio? (s/n): ");
					String eleccion5 = scanner2.next();
					 while (!eleccion5.equalsIgnoreCase("s") && !eleccion5.equalsIgnoreCase("n")) {
			    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
			    			eleccion5 = scanner2.next();
			    	    	scanner2.nextLine();}
					 if(eleccion5.equalsIgnoreCase("s")) {
						 System.out.print("Ingrese el descuento que desea: ");
						 int descuentoPaquete = scanner2.nextInt();
						 for(Unidad u : uni) {
							 if(u.calcularPrecio() == u.getTipo().getPrecio()) {
								 Descuento descuento = new Descuento(null,u,descuentoPaquete);
							 }
							 else {
								 u.calcularOferta().setPorcentaje_descuento(((u.calcularOferta().getPorcentaje_descuento()*descuentoPaquete)/100)+u.calcularOferta().getPorcentaje_descuento());
							 }
						 }
						 valorPromo = 0;
							for(Unidad u : uni) {
								valorPromo += u.calcularPrecio();
							}
						 System.out.println("______________________________________________________________________________________________________\nPaquete #" + i + " Precio con descuento: " + valorPromo);
					 }
					 i++;
				 }
			}
			else{
				System.out.println("No hay suficientes productos para crear paquetes promocionados.");
			}
		}
	}
    private static void intercambioProductos() {
    	ArrayList<Supermercado> supermercados = new ArrayList<>();
    	for(Supermercado supermercado: Supermercado.getSupermercados()) {
    		supermercados.add(supermercado);
    	}
    	Supermercado supermercado1;
    	Supermercado supermercado2;
    	Scanner scni = new Scanner(System.in);
    	while (true) {
    		int i = 0;
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Lista de Supermercados ===\n");
    		for (Supermercado sup : supermercados) {
    			i++;
    			System.out.println(i+". "+sup.getNombre());
    		}
    		System.out.println("");
    		System.out.print("Seleccione el primer supermercado: ");
    		try {
    			int opcion = scni.nextInt();
    			while (opcion < 1 || opcion > supermercados.size()) {
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- Opción inválida, por favor intente de nuevo.");
    				i = 0;
    	    		System.out.println("______________________________________________________________________________________________________");
    	    		System.out.println("=== Lista de Supermercados ===\n");
    	    		for (Supermercado sup : supermercados) {
    	    			i++;
    	    			System.out.println(i+". "+sup.getNombre());
    	    		}
    	    		System.out.println("");
    	    		System.out.print("Seleccione el primer supermercado: ");
    	    		opcion = scni.nextInt();
    	    		scni.nextLine();
    			}
    			supermercado1 = supermercados.get(opcion - 1);
    			supermercados.remove(supermercado1);
    			System.out.println("______________________________________________________________________________________________________");
    			System.out.println("- Supermercado "+supermercado1.getNombre()+" selecionado.");
    			break;
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scni.nextLine();
		    }
    	}
    	while (true) {
    		int i = 0;
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("=== Lista de Supermercados ===\n");
    		for (Supermercado sup : supermercados) {
    			i++;
    			System.out.println(i+". "+sup.getNombre());
    		}
    		System.out.println("");
    		System.out.print("Seleccione el segundo supermercado: ");
    		try {
    			int opcion = scni.nextInt();
    			while (opcion < 1 || opcion > supermercados.size()) {
    				System.out.println("______________________________________________________________________________________________________");
    				System.out.println("- Opción inválida, por favor intente de nuevo.");
    				i = 0;
    	    		System.out.println("______________________________________________________________________________________________________");
    	    		System.out.println("=== Lista de Supermercados ===\n");
    	    		for (Supermercado sup : supermercados) {
    	    			i++;
    	    			System.out.println(i+". "+sup.getNombre());
    	    		}
    	    		System.out.println("");
    	    		System.out.print("Seleccione el segundo supermercado: ");
    	    		opcion = scni.nextInt();
    	    		scni.nextLine();
    			}
    			supermercado2 = supermercados.get(opcion - 1);
    			supermercados.remove(supermercado2);
    			System.out.println("______________________________________________________________________________________________________");
    			System.out.println("- Supermercado "+supermercado2.getNombre()+" selecionado.");
    			break;
    		}
    		catch (InputMismatchException e) {
    			System.out.println("______________________________________________________________________________________________________");
		        System.out.println("- Opción inválida, por favor intente de nuevo.");
		        scni.nextLine();
		    }
    	}
    	//System.out.print("Leche colanta en supermercado "+Supermercado.getSupermercados().get(0).getNombre()+" "+Producto.getLista_productos().get(0).getUnidadesSupermercado().get(0));
    	for (Producto producto : Producto.getLista_productos()) {
    		int i = 0;
    		for (Bodega bodega : supermercado1.getBodegas()) {
    			for (Unidad unidad : bodega.getProductos()) {
    				if (unidad.getTipo() == producto) {
    					i++;
    				}
    			}
    		}
    		System.out.println("En "+supermercado1.getNombre()+" habían inicialmente "+supermercado1.numeroUnidades(producto)+" unidades de "+producto.getNombre());
    		System.out.println("Actualmente hay "+i+" unidades");
    	}
    	for (Producto producto : Producto.getLista_productos()) {
    		System.out.println("En "+supermercado2.getNombre()+" habían inicialmente "+supermercado2.numeroUnidades(producto)+" unidades de "+producto.getNombre());
    	}
    }
}
