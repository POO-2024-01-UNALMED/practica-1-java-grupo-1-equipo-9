package gestorAplicacion;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.io.Serializable;

public class Unidad implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int actual_codigo = 0;
	private int codigo;
	private String vencimiento;
	private Producto tipo_producto;
	private Bodega bodega;
	private ArrayList<Descuento> descuentos = new ArrayList<>();
	private boolean enPaquete = false;
	
	public Unidad(String vencimiento, Producto tipo, Bodega ubicacion) {
		
		Unidad.actual_codigo += 1; 
		codigo = Unidad.actual_codigo;
		this.vencimiento = vencimiento;
		tipo_producto = tipo;
		bodega = ubicacion;
		tipo.agregarUnidad(this, ubicacion);
		ubicacion.agregarProducto(this);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Producto getTipo() {
		return tipo_producto;
	}

	public void setTipo(Producto tipo) {
		tipo_producto = tipo;
	}
	
	public Bodega getUbicacion() {
		return bodega;
	}

	public void setUbicacion(Bodega ubicacion) {
		bodega = ubicacion;
	}
	
	//Devuelve una fecha al azar, comprendida entre la fecha actual y dos meses en el futuro
	public static String generarFechaVencimiento() {
		
		LocalDate fechaActual = LocalDate.now();
        
        // Fecha máxima (dos meses en el futuro)
        LocalDate fechaMaxima = fechaActual.plus(2, ChronoUnit.MONTHS);
 
        
        //Número aleatorio de días entre 0 y el número de días entre la fecha actual y la fecha máxima
        long dias = ChronoUnit.DAYS.between(fechaActual, fechaMaxima);
        long diasAleatorios = ThreadLocalRandom.current().nextLong(0, dias + 1);
        
        // Generar la fecha aleatoria sumando los días aleatorios a la fecha actual
        LocalDate fechaAleatoria = fechaActual.plusDays(diasAleatorios);
        
        //Agregamos otros mes más
        fechaAleatoria.plusDays(30);
        
        //Formato fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = fechaAleatoria.format(formato);
        
        return fecha;
		
	}

	public int diasParaVencimiento() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter frm = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate venc = LocalDate.parse(vencimiento, frm);
		long dias = ChronoUnit.DAYS.between(hoy, venc);
		return (int)dias;
	}
	
	public Descuento calcularOferta() {
		Descuento descuento_final = null;
		int valor_descuento = 0;
		if (descuentos.size() != 0) {
			for (Descuento descuento : descuentos) {
				if (descuento.getPorcentaje_descuento() > valor_descuento) {
					valor_descuento = descuento.getPorcentaje_descuento();
					descuento_final = descuento;
				}
			}
		}
		return descuento_final;
	}
	
	public float calcularPrecio() {
		Descuento descuento = calcularOferta();
		if (descuento != null)
			return getTipo().getPrecio() * (100 - descuento.getPorcentaje_descuento()) / 100;
		else
			return getTipo().getPrecio();
	}
	
	public boolean isOferta() {
		boolean oferta = false;
		if (descuentos.size() != 0)
			oferta = true;
		return oferta;
	}

	public ArrayList<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(ArrayList<Descuento> descuentos) {
		this.descuentos = descuentos;
	}
	
	public void agregarDescuento(Descuento descuento) {
		this.descuentos.add(descuento);
	}
	
	public void eliminarDescuento(Descuento descuento) {
		this.descuentos.remove(descuento);
	}

	public boolean isEnPaquete() {
		return enPaquete;
	}

	public void setEnPaquete(boolean enPaquete) {
		this.enPaquete = enPaquete;
	}
	
	
}
