package gestorAplicacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.util.Locale;

public class Unidad {
	private int codigo;
	private String vencimiento;
	private Producto tipo;
	private Bodega ubicacion;
	
	public Unidad(int codigo, String vencimiento, Producto tipo, Bodega ubicacion) {
		this.codigo = codigo;
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

	public long diasParaVencimiento() {
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter frm = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate venc = LocalDate.parse(vencimiento, frm);
		long dias = ChronoUnit.DAYS.between(hoy, venc);
		return dias;
	}
}
