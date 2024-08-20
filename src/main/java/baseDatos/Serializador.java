package baseDatos;

import java.io.*;
import java.util.ArrayList;
import gestorAplicacion.*;

public class Serializador {

	private static final String DIRECTORIO = "baseDatos/temp";
	
	public static void guardarDatos() {
		crearCarpetaTemp();
		guardarObjeto("supermercados.txt", Supermercado.getSupermercados());
        guardarObjeto("productos.txt", Producto.getLista_productos());
        guardarObjeto("descuentos.txt", Descuento.getDescuentos());
        guardarObjeto("personas.txt", Persona.getPersonas());
    }
	
	private static <T> void guardarObjeto(String nombreArchivo, Object objeto) {
		try (FileOutputStream fileOut = new FileOutputStream(DIRECTORIO + "/" + nombreArchivo);
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

	            out.writeObject(objeto);
	            System.out.println("Objeto serializado en: " + DIRECTORIO + "/" + nombreArchivo);
	            
		} catch (IOException e) {
            System.out.println("Error al serializar el objeto: " + e.getMessage());
        }
    }
	
	public static void crearCarpetaTemp() {
            // Crear el directorio "temp" si no existe
            File directorio = new File(DIRECTORIO);
            if (!directorio.exists()) {
                directorio.mkdir();
            }
	}
}
