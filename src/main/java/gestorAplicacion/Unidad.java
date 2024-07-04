package gestorAplicacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Unidad {
	
	public static int actual_codigo;
	private int codigo;
	private String vencimiento;
	private Producto tipo;


	public Unidad(Producto tipo) {
		
		Unidad.actual_codigo += 1; 
		
		//El código se genera automaticamente
		this.codigo = Unidad.actual_codigo;
		
		this.vencimiento = generarFechaVencimiento();
		
		this.tipo = tipo;
		tipo.agregarUnidad(this);
		
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
	
	public static void abastecerUnidadesProducto(ArrayList<Producto> productos) {
		
		for(Producto producto: productos) {
		
			//Creamos las nuevas unidades con su fecha de vencimiento de forma automática.
			for (int i = 0 ; i < producto.getCantidad_compra(); i++) {
				
				Unidad nueva_unidad = new Unidad(producto);
				
			}
			
			//Quitamos la cantidad de unidades que se deben comprar (ya se compraron).
			producto.setCantidad_compra(0);
			
		}
		
		System.out.println("¡Todo bien, todo bonito!");
		System.out.println("Unidades de los productos solicitados abastecidos!!!");
		System.out.println();
		
	}

	//Devuelve una fecha al azar, comprendida entre la fecha actual y dos meses en el futuro
	public static String generarFechaVencimiento() {
		
		LocalDate fechaActual = LocalDate.now();
        
        // Fecha máxima (3 meses en el futuro)
        LocalDate fechaMaxima = fechaActual.plus(3, ChronoUnit.MONTHS);
 

        long dias = ChronoUnit.DAYS.between(fechaActual, fechaMaxima);
        long diasAleatorios = ThreadLocalRandom.current().nextLong(0, dias + 1);
        
        // Generar la fecha aleatoria sumando los días aleatorios a la fecha actual
        LocalDate fechaAleatoria = fechaActual.plusDays(diasAleatorios);
       
        //Formato fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = fechaAleatoria.format(formato);
        
        return fecha;
		
	}

	public long diasParaVencimiento() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter frm = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
		LocalDate venc = LocalDate.parse(vencimiento, frm);
		long dias = ChronoUnit.DAYS.between(hoy, venc);
		return dias;
	}

}
