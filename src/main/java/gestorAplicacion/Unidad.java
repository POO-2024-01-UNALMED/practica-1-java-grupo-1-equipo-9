package gestorAplicacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Unidad {
	
	public static int actual_codigo;
	private int codigo;
	private String vencimiento;
	private Producto tipo;
	private Bodega ubicacion;
	
	public Unidad(String vencimiento, Producto tipo, Bodega ubicacion) {
		
		Unidad.actual_codigo += 1; 
		
		//El código se genera automaticamente
		this.codigo = Unidad.actual_codigo;
		
		this.vencimiento = vencimiento;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		tipo.agregarUnidad(this);
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
		return tipo;
	}

	public void setTipo(Producto tipo) {
		this.tipo = tipo;
	}
	
	public Bodega getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Bodega ubicacion) {
		this.ubicacion = ubicacion;
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

	public long diasParaVencimiento() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter frm = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate venc = LocalDate.parse(vencimiento, frm);
		long dias = ChronoUnit.DAYS.between(hoy, venc);
		return dias;
	}
}
