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
        // Deserializar los datos
		deserializarDatos();
	
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
        serializarDatos();
        scanner.close();
    }

    private static void deserializarDatos() {
        Deserializador.cargarDatos();
    }

    private static void serializarDatos() {
    	Serializador.guardarDatos();
    }

    private static void crearOrden() {
        ArrayList<Supermercado> supermercados = Supermercado.getSupermercados();
    	ArrayList<Persona> personas = Persona.getPersonas();
    	ArrayList<Empleado> empleados;
    	ArrayList<Cliente> clientes = new ArrayList<>();
    	Supermercado supermercado;
    	Persona empleado;
    	Persona cliente;
    	for (Persona persona : personas) {
    		if (persona.getCargo().equals("Cliente")) {clientes.add((Cliente)persona);}
    	}
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
    			System.out.println(i + ". " + persona.informacion());
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
    				System.out.println(i + ". " + persona.informacion());
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
    
  //=============METODO PARA LA PRIMERA FUNCION====================
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
    			for (Unidad unidad : lista1.get(opcionproducto-1).getUnidades(orden.getSupermercado())) {
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
    	        	        orden.agregarProducto(orden.getSupermercado() , lista1.get(opcionproducto-1), opcion);
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
    
    //=============METODO PARA LA PRIMERA FUNCION====================
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

    //=============METODO PARA LA PRIMERA FUNCION====================
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
    	System.out.println("______________________________________________________________________________________________________");
    	System.out.println("Lista de Supermercados:\n");
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
								 unidad.getUbicacion().getProductos().remove(unidad);
								 tiposdisp.remove(unidad.getTipo().getTipo());
								
							 }
						 }
						 if (paquete.size() > 1) {
							 supermercado.agregarPaquetePromocion(paquete);
						 }
						 else {
							 for (Unidad uni : paquete) {
								 uni.setEnPaquete(false);
								 uni.getUbicacion().getProductos().add(uni);
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
					 
					System.out.print("\n¿Desea hacer descuento al precio? (s/n): ");
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
    
//=============METODO PARA LA TERCERA FUNCION====================
    private static void intercambioProductos() {
    	ArrayList<Supermercado> supermercados = new ArrayList<>();
    	Scanner sci = new Scanner(System.in);
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
    	for (Producto prod : Producto.getLista_productos()) {
    		int i = 0;
    		for (Bodega bodega : supermercado1.getBodegas()) {
    			for (Unidad unidad : bodega.getProductos()) {
    				if (unidad.getTipo().getNombre().equals(prod.getNombre())) {
    					i++;
    				}
    			}
    		}
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("En "+supermercado1.getNombre()+" habían inicialmente "+supermercado1.numeroUnidades(prod)+" unidades de "+prod.getNombre());
    		System.out.println("Actualmente hay "+i+" unidades");
    	}
    	System.out.println("______________________________________________________________________________________________________");
    	System.out.println("______________________________________________________________________________________________________");
    	for (Producto producto : Producto.getLista_productos()) {
    		int i = 0;
    		for (Bodega bodega : supermercado2.getBodegas()) {
    			for (Unidad unidad : bodega.getProductos()) {
    				if (unidad.getTipo().getNombre().equals(producto.getNombre())) {
    					i++;
    				}
    			}
    		}
    		System.out.println("______________________________________________________________________________________________________");
    		System.out.println("En "+supermercado2.getNombre()+" habían inicialmente "+supermercado2.numeroUnidades(producto)+" unidades de "+producto.getNombre());
    		System.out.println("Actualmente hay "+i+" unidades");
    	}
    	System.out.print("\n¿Desea intercambiar productos entre los supermercados? (s/n): ");
		String select = sci.next();
		 while (!select.equalsIgnoreCase("s") && !select.equalsIgnoreCase("n")) {
    			System.out.print("- Opción inválida, por favor intente de nuevo: ");
    			select = sci.next();
    	    	sci.nextLine();}
		 if(select.equalsIgnoreCase("s")) {
			 Supermercado envia = null;
			 Supermercado recibe = null;
			 boolean exiti = false;

			 while (!exiti) {
				System.out.println("______________________________________________________________________________________________________");
				   System.out.println("=== Supermercado que enviará los productos ===\n");
				   System.out.println("1. "+supermercado1.getNombre());
				   System.out.println("2. "+supermercado2.getNombre());
				   System.out.println("");
				   System.out.print("Seleccione una opción: ");


				   try {
				       int opcion = sci.nextInt();
				       sci.nextLine();

				       switch (opcion) {
				       		case 1:
				       			envia = supermercado1;
				       			recibe = supermercado2;
				       			exiti = true;
				            	break;
				            case 2:
				            	envia = supermercado2;
				            	recibe = supermercado1;
				            	exiti = true;
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
				       sci.nextLine();
				   }
			 }
			 
			 ArrayList<Producto> productosenv = new ArrayList<>();
			 for (Producto producto : Producto.getLista_productos()) {
				 for (Bodega bodega : envia.getBodegas()) {
					 for (Unidad unidad : bodega.getProductos()) {
						 if (unidad.getTipo() == producto && !productosenv.contains(unidad.getTipo())) {
							 productosenv.add(producto);
						 }
					 }
				 }
			 }
			 Producto seleccionado = null;
			 boolean exitj = false;

			 while (!exitj) {
				 System.out.println("______________________________________________________________________________________________________");
				 System.out.println("=== Productos disponibles para enviar ===\n");
				 int i = 0;
				 for (Producto p : productosenv) {
					 i++;
					 System.out.println(i+". "+p.getNombre());
				 }
				 System.out.println("");
				 System.out.print("Seleccione una opción: ");
				 
				 try {
					 int opcion = sci.nextInt();
					 sci.nextLine();
					 while (opcion < 1 || opcion > productosenv.size()) {
						 System.out.println("______________________________________________________________________________________________________");
						 System.out.println("- Opción inválida, por favor intente de nuevo.");
						 System.out.println("______________________________________________________________________________________________________");
		   				 System.out.println("=== Productos disponibles para enviar ===\n");
		   				 i = 0;
		   				 for (Producto p : productosenv) {
		   					 i++;
		   					 System.out.println(i+". "+p.getNombre());
		   				 }
		   				 System.out.println("");
		   				 System.out.print("Seleccione una opción: ");
		    	    		opcion = scni.nextInt();
		    	    		scni.nextLine();
					 }
					 seleccionado = productosenv.get(opcion-1);
					 break;
				 } 
				 catch (InputMismatchException e) {
					 System.out.println("______________________________________________________________________________________________________");
					 System.out.println("- Opción inválida, por favor intente de nuevo.");
					 sci.nextLine();
				 }
			 }
			 
			 ArrayList<Unidad> unidades = new ArrayList<>();
			 for (Bodega bodega : envia.getBodegas()) {
				 for(Unidad unidad : bodega.getProductos()) {
					 if (unidad.getTipo() == seleccionado) {
						 unidades.add(unidad);
					 }
				 }
			 }
			 Unidad unienv = null;
			 while (true) {
	    			System.out.println("______________________________________________________________________________________________________");
	        		System.out.println("=== Unidades disponibles para enviar ===\n");
	        		int i=0;
	        		for (Unidad unidad : unidades) {
	        			i++;
	        			if (!unidad.isOferta()) {
	        				System.out.println(i+". "+unidad.getTipo().getNombre()+" Sin oferta");
	        			}
	        			else {
	        				System.out.println(i+". "+unidad.getTipo().getNombre()+" "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)");
	        			}
	        		}
	        		System.out.println("");
        			System.out.print("Seleccione una opción: ");
	        		try {
	        			int opcion = sci.nextInt();
	        			sci.nextLine();
						 while (opcion < 1 || opcion > unidades.size()) {
							 System.out.println("______________________________________________________________________________________________________");
							 System.out.println("- Opción inválida, por favor intente de nuevo.");
							 System.out.println("______________________________________________________________________________________________________");
							 System.out.println("=== Unidades disponibles para enviar ===\n");
							 i=0;
							 for (Unidad unidad : unidades) {
								 i++;
								 if (!unidad.isOferta()) {
									 System.out.println(i+". "+unidad.getTipo().getNombre()+" Sin oferta");
								 }
								 else {
									 System.out.println(i+". "+unidad.getTipo().getNombre()+" "+unidad.calcularOferta().getNombre()+"("+unidad.calcularOferta().getPorcentaje_descuento()+"%)");
								 }
							 }
							 System.out.println("");
							 System.out.print("Seleccione una opción: ");
							 opcion = scni.nextInt();
							 scni.nextLine();
						 }
						 unienv = unidades.get(opcion-1);
						 break;
	        		}
	        		catch (InputMismatchException e) {
	        			System.out.println("______________________________________________________________________________________________________");
	        			System.out.println("- Opción inválida, por favor intente de nuevo.");
	        			sci.nextLine();
	        		}
			 }
			 Bodega bodrecibe = null;
			 while (true) {
				 System.out.println("______________________________________________________________________________________________________");
				 System.out.println("=== Bodega que recibirá los productos ===\n");
				 int i=0;
				 for (Bodega bodega : recibe.getBodegas()) {
					 i++;
					 System.out.println(i+". "+bodega.getNombre());
				 }
				 System.out.println("");
				 System.out.print("Seleccione una opción: ");
				 try {
					 int opcion = sci.nextInt();
		    			sci.nextLine();
		    			while (opcion < 0 || opcion > recibe.getBodegas().size()) {
		    				System.out.println("______________________________________________________________________________________________________");
		    				System.out.print("- Opción inválida, por favor intente de nuevo: ");
		    				opcion = sci.nextInt();
		    				sci.nextLine();
		    			}
		    			bodrecibe = recibe.getBodegas().get(opcion-1);
		    			break;
				 }
				 catch (InputMismatchException e) {
		    			System.out.println("______________________________________________________________________________________________________");
				        System.out.println("- Opción inválida, por favor intente de nuevo.");
				        sci.nextLine();
				 }
			 }
			 System.out.println("______________________________________________________________________________________________________");
			 System.out.println(unienv.getTipo().getNombre()+" con código "+unienv.getCodigo()+" enviado de "+unienv.getUbicacion().getNombre()+" a "+bodrecibe.getNombre());
			 bodrecibe.agregarProducto(unienv);
			 unienv.getUbicacion().quitarProducto(unienv);
			 unienv.setUbicacion(bodrecibe);
		 }
    }
    
    private static void verificarVencimiento(Supermercado supermercado) {
    	verificarVencimiento(supermercado, 0);
    }
    
	private static void verificarVencimiento(Supermercado supermercado, int dias) {
		for (Bodega bodega : supermercado.getBodegas()) {
			for (Unidad unidad : bodega.getProductos()) {
				if (unidad.diasParaVencimiento() <= dias) {
					if (unidad.diasParaVencimiento() > 0) {
						System.out.println("Al producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " le quedan " + unidad.diasParaVencimiento() + " días para vencer.");
					}
					else if (unidad.diasParaVencimiento() == 0) {
						System.out.println("El producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " se vence hoy.");
					}
					else {
						System.out.println("El producto " + unidad.getTipo().getNombre() + " con código: " + unidad.getCodigo() + 
								", ubicado en " + bodega.getNombre() + " se venció hace " + (unidad.diasParaVencimiento() * -1) + 
								" días.");
					}
				}	
			}
		}
	}
}
