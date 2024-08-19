package baseDatos;

import java.io.*;
import java.util.ArrayList;
import gestorAplicacion.*;

public class GestorDeArchivos {

    private static final String DIRECTORIO = "temp/";

    public static void guardarDatos() {
        guardarObjeto("supermercados.txt", Supermercado.getSupermercados());
        guardarObjeto("productos.txt", Producto.getLista_productos());
        guardarObjeto("descuentos.txt", Descuento.getDescuentos());
    }

    public static void cargarDatos() {
        Supermercado.setSupermercados(cargarObjeto("supermercados.txt"));
        Producto.setLista_productos(cargarObjeto("productos.txt"));
        Descuento.setDescuentos(cargarObjeto("descuentos.txt"));
    }

    private static <T> void guardarObjeto(String nombreArchivo, ArrayList<T> objetos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DIRECTORIO + nombreArchivo))) {
            oos.writeObject(objetos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> ArrayList<T> cargarObjeto(String nombreArchivo) {
        ArrayList<T> objetos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DIRECTORIO + nombreArchivo))) {
            objetos = (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objetos;
    }
    
    public static void crearCarpetaTemp() {
        File carpeta = new File(DIRECTORIO);
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta 'temp' creada.");
            } else {
                System.out.println("No se pudo crear la carpeta 'temp'.");
            }
        }
    }
}

