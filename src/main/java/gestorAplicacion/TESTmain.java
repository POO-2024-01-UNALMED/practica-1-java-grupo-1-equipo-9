package gestorAplicacion;

import gestorAplicacion.*;

import java.time.LocalDate;

import finanzas.*;
import recompensas.*;

public class TESTmain {

	public static void main(String[] args) {
		Empleado emp1 = new Empleado(1, "Pepe", 12345);
		Cliente cli1 = new Cliente("Jaimito", 23456);
		Bodega bod1 = new Bodega("Bodega Principal", "Barrio Tapitas");
		Bodega bod2 = new Bodega("Bodega Secundaria", "Barrio la Piedrita");
		Supermercado sup1 = new Supermercado("MercaChicles");
		sup1.agregarEmpleado(emp1);
		sup1.agregarBodega(bod1);
		sup1.agregarBodega(bod2);
		Producto prod1 = new Producto("Leche", TipoProducto.ALIMENTO, 3000, 2000, 2000, 400);
		Producto prod2 = new Producto("Vodka", TipoProducto.BEBIDA, 90000, 50000, 50000, 10000);
		Unidad uni1 = new Unidad(1, "2024-04-28", prod1);
		Unidad uni2 = new Unidad(2, "2024-06-10", prod1);
		Unidad uni3 = new Unidad(3, "2024-04-15", prod1);
		
		Unidad uni4 = new Unidad(4, "2024-04-29", prod2);
		Unidad uni5 = new Unidad(5, "2024-06-08", prod2);
		Unidad uni6 = new Unidad(6, "2024-04-27", prod2);
		
		System.out.println();

	}

}
