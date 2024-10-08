package gestorAplicacion;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;


public class Supermercado implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private double saldo;
	private static ArrayList<Supermercado> supermercados = new ArrayList<>();
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private ArrayList<Bodega> bodegas = new ArrayList<>();
	private ArrayList<Orden> ordenes = new ArrayList<>();
	private ArrayList<Unidad> productosPromocion = new ArrayList<>();
	private ArrayList<ArrayList<Unidad>> paquetesPromocion = new ArrayList<>();
	
	public Supermercado(String nombre) {
		this(nombre, 0);
	}
	
	public Supermercado(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
		Supermercado.supermercados.add(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
        return saldo;
    }

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    public void actualizarSaldo(double monto) {
        saldo += monto;
    }
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void quitarEmpleado(Empleado empleado) {
		for (int i = 0;i<empleados.size();i++) {
			if (empleados.get(i) == empleado) {
				empleados.remove(i);
				break;
			}
		}
	}

	public ArrayList<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(ArrayList<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public void agregarBodega(Bodega bodega) {
		bodegas.add(bodega);
	}

	public void quitarBodega(Bodega bodega) {
		for (int i = 0;i<bodegas.size();i++) {
			if (bodegas.get(i) == bodega) {
				bodegas.remove(i);
				break;
			}
		}
	}

	public ArrayList<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void agregarOrden(Orden orden) {
		ordenes.add(orden);
	}
	
	public void quitarOrden(Orden orden) {
		for (int i = 0;i<ordenes.size();i++) {
			if (ordenes.get(i) == orden) {
				ordenes.remove(i);
				break;
			}
		}
	}
	
	public static ArrayList<Supermercado> getSupermercados() {
		return supermercados;
	}

	public static void setSupermercados(ArrayList<Supermercado> supermercados) {
		Supermercado.supermercados = supermercados;
	}

	public ArrayList<Unidad> getProductosPromocion() {
		return productosPromocion;
	}

	public void setProductosPromocion(ArrayList<Unidad> productosPromocion) {
		this.productosPromocion = productosPromocion;
	}

	public ArrayList<ArrayList<Unidad>> getPaquetesPromocion() {
		return paquetesPromocion;
	}

	public void setPaquetesPromocion(ArrayList<ArrayList<Unidad>> paquetesPromocion) {
		this.paquetesPromocion = paquetesPromocion;
	}
	
	public void agregarPaquetePromocion(ArrayList<Unidad> paquetePromocion) {
		this.paquetesPromocion.add(paquetePromocion);
	}
	
	public void quitarPaquetePromocion(ArrayList<Object> paquetePromocion) {
		this.paquetesPromocion.remove(paquetePromocion);
	}

	public ArrayList<Producto> productosPorTipo(TipoProducto tipo){
		ArrayList<Producto> resultado = new ArrayList<>();
		for (Bodega bodega : bodegas) {
			ArrayList<Unidad> productos = bodega.getProductos();
			for (Unidad unidad : productos) {
				if (unidad.getTipo().getTipo() == tipo) {
					if (!resultado.contains(unidad.getTipo()))
						resultado.add(unidad.getTipo());
				}
			}
		}
		return resultado;
	}
	
	public int numeroUnidades(Producto producto) {
		int numero;
		int indice = producto.getSupermercados().indexOf(this);
		if (indice != -1) {
			numero = producto.getUnidadesSupermercado().get(indice);
		}
		else {
			numero = 0;
		}
		return numero;
	}
	
}