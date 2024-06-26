package DataTiempo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Tiempo {
	
	
	public static String generarFechaActual() {
		
		
		LocalDate fechaAhora = LocalDate.now();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = fechaAhora.format(formato);
		
		return fecha;
		
	}
	
	
	public static String generarHoraActual() {
		
		LocalTime horaObtenida = LocalTime.now();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        String hora = horaObtenida.format(formato);
		
		return hora;
		
	}
	
	
	public static String formatoFecha(String fechaStr) {
		
		DateTimeFormatter entradaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaData = LocalDate.parse(fechaStr, entradaFormato);

        DateTimeFormatter salidaFormato = DateTimeFormatter.ofPattern("EEEE d MMMM 'de' yyyy");
        String fechaObtenida = fechaData.format(salidaFormato);
        String resultado = Character.toUpperCase(fechaObtenida.charAt(0)) + fechaObtenida.substring(1);

        return resultado;
	}
	
	
	public static String formatoHora(String horaStr) {
		
		DateTimeFormatter entradaFormato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaData = LocalTime.parse(horaStr, entradaFormato);

        DateTimeFormatter salidaFormato = DateTimeFormatter.ofPattern("hh:mm a");
        String resultado = horaData.format(salidaFormato);

        return resultado;
		
		
	}

}
