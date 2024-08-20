package baseDatos;

import java.io.*;
import java.util.ArrayList;
import gestorAplicacion.*;

public class Deserializador {

	private static final String DIRECTORIO = "src/main/java/baseDatos/temp";
	
	public static void cargarDatos() {
        Supermercado.setSupermercados(cargarObjeto("supermercados.txt"));
        Producto.setLista_productos(cargarObjeto("productos.txt"));
        Descuento.setDescuentos(cargarObjeto("descuentos.txt"));
        Persona.setPersonas(cargarObjeto("personas.txt"));
        System.out.println("Datos deserializados");
//        for (Supermercado supermercado : Supermercado.getSupermercados()) {
 //       	for (Bodega bodega : supermercado.getBodegas()) {
  //      		for (Unidad unidad : bodega.getProductos()) {
   //     			unidad.getTipo().actualizarUnidad(unidad);
    //    		}
     //   	}
      //  }
    }
	
	private static <T> ArrayList<T> cargarObjeto(String nombreArchivo) {
        ArrayList<T> objetos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIRECTORIO + "/" + nombreArchivo))) {
            objetos = (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objetos;
    }
}
