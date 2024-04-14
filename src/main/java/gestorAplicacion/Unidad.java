package gestorAplicacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Locale;

public class Unidad {
	private int codigo;
	private String vencimiento;
	private Producto tipo;
	
	public Unidad(int codigo, String vencimiento, Producto tipo) {
		this.codigo = codigo;
		this.vencimiento = vencimiento;
		this.tipo = tipo;
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
	
	public int diasParaVencimiento() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter frm = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate venc = LocalDate.parse(vencimiento, frm);
		int dias = Period.between(hoy, venc).getDays();
		return dias;
	}
}
