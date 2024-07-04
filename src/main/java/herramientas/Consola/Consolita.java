package herramientas.Consola;

import java.io.IOException;
import java.util.ArrayList;

public class Consolita {
	
	public static void limpiarConsola() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}  
	
}
