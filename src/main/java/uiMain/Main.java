package uiMain;

import gestorAplicacion.*;
import baseDatos.*;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final String CARPETA_TEMP = "src/baseDatos/temp/";

    public static void main(String[] args) {
    	//--------------------------------------------------------------------------
    	
    	Supermercado sup1 = new Supermercado("MercaChicles", 1000000);
    	Supermercado sup2 = new Supermercado("La Tapita", 1200000);
    	Empleado emp1 = new Empleado("Pepe Perez", 12345, sup1, "Empleado", 2000000);
    	Empleado emp2 = new Empleado("Pablo Tobon", 12345, sup1, "Gerente", 2000000);
    	Cliente cli1 = new Cliente("Jaimito Gutierrez", 23456);
    	Cliente cli2 = new Cliente("Armando Mendoza", 23456);
		Bodega bod1 = new Bodega("Bodega Principal", "Cordoba", sup1);
		Bodega bod2 = new Bodega("Bodega Secundaria", "La Piedra", sup1);
		sup1.agregarEmpleado(emp1);
		sup1.agregarBodega(bod1);
		sup1.agregarBodega(bod2);
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
    	
		//Descuento desc1 = new Descuento("Descuento Alimentos", TipoProducto.ALIMENTO, 25);
		//Descuento desc2 = new Descuento("Descuento Leche Coranta", prod1, 30);
		Descuento desc3 = new Descuento("Descuento cerca de vencer", uni2, 50);
		
    	//--------------------------------------------------------------------------
        // Deserializar los datos
        //deserializarDatos();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú Principal ===");
            System.out.println("");
            System.out.println("1. Nueva orden de compra");
            System.out.println("2. Manejo de Inventario");
            System.out.println("3. Salir");
            System.out.println("");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                	crearOrden();
                    break;
                case 2:
                    break;
                case 3:
                    exit = true;
                    System.out.print("¡Adiós!");
                    break;
                default:
                    System.out.println("- Opción inválida, por favor intente de nuevo.");
                    break;
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
        int i = 0;
        ArrayList<Supermercado> supermercados = Supermercado.getSupermercados();
    	ArrayList<Persona> personas = Persona.getPersonas();
    	ArrayList<Persona> empleados = new ArrayList<>();
    	ArrayList<Persona> clientes = new ArrayList<>();
    	Persona cliente;
    	for (Persona persona : personas) {
    		if (persona.getCargo() != "Cliente") empleados.add(persona);
    		else clientes.add(persona);
    	}
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("");
    	System.out.println("Lista de Supermercados:");
    	for (Supermercado supermercado : supermercados) {
    		i++;
    		System.out.println(i+". "+supermercado.getNombre());
    	}
    	System.out.println("");
    	System.out.print("Seleccione un supermercado: ");
    	int opcion = scanner.nextInt();
    	while (opcion < 1 || opcion > supermercados.size()) {
        	System.out.print("- Opción inválida, por favor intente de nuevo: ");
        	opcion = scanner.nextInt();
        	scanner.nextLine();
        }
        Supermercado supermercado = supermercados.get(opcion - 1);
        System.out.println("- Supermercado "+supermercado.getNombre()+" selecionado.");
        i = 0;
    	System.out.println("");
    	System.out.println("Lista de Empleados:");
        for (Persona persona : empleados) {
        	i++;
        	System.out.println(i + ". " + persona.getCargo()+ " " + persona.getNombre());
        }
        System.out.println("");
        System.out.print("Seleccione empleado encargado: ");
        opcion = scanner.nextInt();
        while (opcion < 1 || opcion > empleados.size()) {
        	System.out.print("- Opción inválida, por favor intente de nuevo: ");
        	opcion = scanner.nextInt();
        	scanner.nextLine();
        }
        Persona empleado = empleados.get(opcion - 1);
        System.out.println("- "+empleado.getCargo()+" "+empleado.getNombre()+" selecionado.");
        System.out.println("");
        i = 0;
        System.out.print("El cliente ya está registrado? (s/n): ");
        String opcionstr = scanner.next();
        scanner.nextLine();
    	while (!opcionstr.equalsIgnoreCase("s") && !opcionstr.equalsIgnoreCase("n")) {
    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
    			opcionstr = scanner.next();
    	    	scanner.nextLine();
    	}
    	if (opcionstr.equalsIgnoreCase("s")) {
    		System.out.println("");
    	    System.out.println("Lista de Clientes:");
    	    for (Persona persona : clientes) {
    	        i++;
    	        System.out.println(i + ". " + persona.getNombre()+" con cédula "+persona.getCedula());
    	    }
    	    System.out.println("");
    	    System.out.print("Seleccione el cliente: ");
    	    opcion = scanner.nextInt();
    	    while (opcion < 1 || opcion > clientes.size()) {
    	    	System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    	opcion = scanner.nextInt();
    	    	scanner.nextLine();
    	    }
    	    cliente = clientes.get(opcion - 1);
            System.out.println("- "+cliente.getCargo()+" "+ cliente.getNombre()+" con cédula "+cliente.getCedula()+" selecionado.");
            System.out.println("");
    	}
    	else {
    		System.out.println("");
    		System.out.println("- Iniciando registro de cliente...");
    		System.out.println("");
    		System.out.print("Ingrese el nombre del cliente: ");
    		String nombre = scanner.nextLine();
	    	System.out.print("Ingrese la cédula del cliente: ");
    		Long cedula = scanner.nextLong();
	    	scanner.nextLine();
	    	cliente = new Cliente(nombre, cedula);
	    	System.out.println("- Cliente "+nombre+" con cédula "+cedula+" creado con éxito.");
	    	System.out.println("");
    	}
    	Orden orden = new Orden(supermercado, (Empleado)empleado, (Cliente)cliente);
    	boolean exit = false;
    	while(!exit) {
    		System.out.println("Qué desea hacer?.");
    		System.out.println("1. Agregar producto a la orden");
    		System.out.println("2. Quitar producto de la orden");
    		System.out.println("3. Ver productos en la orden");
    		System.out.println("4. Finalizar orden");
    		System.out.println("5. Cancelar orden");
    		System.out.println("");
    		System.out.print("Seleccione una opción: ");
    		opcion = scanner.nextInt();
    		scanner.nextLine();
        
        	switch (opcion) {
        		case 1:
        			agregarProducto(orden);
        			break;
        		case 2:
        			//quitarProducto(orden);
        			break;
        		case 3:
        			//mostrarOrden(orden);
        			break;
        		case 4:
        			orden.completarOrden();
        			System.out.println("---Orden Completa---");
        			System.out.println("");
        			exit = true;
        			break;
        		case 5:
        			System.out.println("---Orden Cancelada---");
        			System.out.println("");
        			exit = true;
        			break;
        		default:
        			System.out.println("- Opción inválida, por favor intente de nuevo.");
        			break;
        	}
        }
    	
    	//Lista productos
    }
    public static void agregarProducto(Orden orden) {
    	Scanner scanner = new Scanner(System.in);
    	boolean exit = false;
    	TipoProducto tipo = null;;
    	while(!exit) {
    		System.out.println("");
    		System.out.println("Seleccione el tipo de producto a buscar:");
    		System.out.println("1. Aseo");
    		System.out.println("2. Alimento");
    		System.out.println("3. Bebida");
    		System.out.println("4. Cuidado personal");
    		System.out.println("5. Productos para mascotas");
    		System.out.println("6. Otro");
    		System.out.println("");
    		System.out.print("Seleccione una opción: ");
    		int opcion = scanner.nextInt();
    		scanner.nextLine();
        
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
        			System.out.println("- Opción inválida, por favor intente de nuevo.");
        			break;
        	}
        }
    	ArrayList<Producto> lista1 = orden.getSupermercado().productosPorTipo(tipo);
    	if (lista1.size() == 0) {
    		System.out.println("No hay productos disponibles del tipo seleccionado.");
    		System.out.println("");
    	}
    	else {
    		int i = 0;
    		System.out.println("");
    		System.out.println("Productos disponibles:");
    		for (Producto producto : lista1) {
    			i++;
    			System.out.println(i+". "+producto.getNombre());
    		}
    		System.out.println("");
    		System.out.print("Desea agregar algún producto al carrito? (s/n): ");
	        String opcionstr = scanner.next();
	        scanner.nextLine();
	    	while (!opcionstr.equalsIgnoreCase("s") && !opcionstr.equalsIgnoreCase("n")) {
	    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    			opcionstr = scanner.next();
	    	    	scanner.nextLine();
	    	}
	    	if (opcionstr.equalsIgnoreCase("s")) {
	    		System.out.print("Seleccione el producto a agregar: ");
	    		int opcionproducto = scanner.nextInt();
	    		scanner.nextLine();
	    		while (opcionproducto < 1 || opcionproducto > lista1.size()) {
	    	    	System.out.print("- Opción inválida, por favor intente de nuevo: ");
	    	    	opcionproducto = scanner.nextInt();
	    	    	scanner.nextLine();
	    	    }
	    		ArrayList<Unidad> unienof = new ArrayList<>();
    			ArrayList<Unidad> unisinof = new ArrayList<>();
    			for (Unidad unidad : lista1.get(opcionproducto-1).getUnidades()) {
    				if (unidad.isOferta())unienof.add(unidad);
    				else unisinof.add(unidad);
    			}
    			System.out.println("");
        		System.out.println("Unidades disponibles:");
        		i=0;
    			if (unisinof.size() != 0) {
    				i++;
    				System.out.println(i+". Sin oferta - $"+lista1.get(opcionproducto-1).getPrecio()+" cantidad disponible: "+unisinof.size());
    			}
    			if (unienof.size() != 0) {
    				for (Unidad unidad : unienof) {
    					System.out.println(i+". "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)"+" $"+unidad.calcularPrecio());
    					i++;
    				}
    			}
    			System.out.println("");
        		System.out.print("Desea agregar alguna unidad? (s/n): ");
    	        String opcionstr2 = scanner.next();
    	        scanner.nextLine();
    	    	while (!opcionstr2.equalsIgnoreCase("s") && !opcionstr2.equalsIgnoreCase("n")) {
    	    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    			opcionstr2 = scanner.next();
    	    	    	scanner.nextLine();
    	    	}
    	    	if (opcionstr2.equalsIgnoreCase("s")) {
    	    		System.out.println("");
            		System.out.print("Seleccione la unidad: ");
    	    		int opcion = scanner.nextInt();
    	    		scanner.nextLine();
    	    		while (opcion < 1 || opcion > i) {
    	            	System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	            	opcion = scanner.nextInt();
    	            	scanner.nextLine();
    	            }
    	    		if (opcion == 1) {
    	    			if(unisinof.size() != 0) {
    	    				System.out.print("Ingrese el número de unidades a agregar: ");
    	    				opcion = scanner.nextInt();
    	        	        scanner.nextLine();
    	        	        while (opcion < 0 || opcion > unisinof.size()) {
    	    	    	    	System.out.print("- Opción inválida, por favor intente de nuevo: ");
    	    	    	    	opcion = scanner.nextInt();
    	    	    	    	scanner.nextLine();
    	    	    	    }
    	        	        orden.agregarProducto(lista1.get(opcionproducto-1), opcion);
    	        	        System.out.println("");
    	            		System.out.println("Producto(s) agregado(s) a la orden.");
    	    			}
    	    			else {
    	    				orden.agregarUnidad(unienof.get(0));
    	    			}
    	    		}
    	    		else {
    	    			if(unisinof.size() != 0) {
    	    				orden.agregarUnidad(unienof.get(opcion-2));
    	    			}
    	    			else {
    	    				orden.agregarUnidad(unienof.get(opcion-1));
    	    			}
    	    		}
    	    	}
	    	}
    		System.out.println("");
    	}
    }
}
