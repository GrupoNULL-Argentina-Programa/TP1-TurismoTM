package paqueteTurismoTM;

import java.io.IOException;
import java.util.*;

public class App {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public static void main(String[] args) throws IOException {
		LectorDeFicheros lector = new LectorDeFicheros();
		clientes = lector.cargarClientes();
		for (Cliente cliente : clientes) {
		//	System.out.println(cliente);
		}

		//System.out.println();

		//LectorDeFicheros lector1 = new LectorDeFicheros();
		Archivo.ofertas = lector.cargarAtraccion();
		for (Oferta atraccion : Archivo.ofertas) {
		//	System.out.println(atraccion);
		}
		//System.out.println();

		//LectorDeFicheros lector2 = new LectorDeFicheros();
		Archivo.ofertas.addAll(lector.cargarPromocionAbsoluta());
		for (Oferta promocion : Archivo.ofertas) {
		//	System.out.println(promocion);
		}

		// Ordena el array ofertas de mayor a menor y luego lo muestra.
		//
		Archivo.OrdenarOfertas();
		//System.out.println("\n\n");
		for (Oferta a : Archivo.ofertas) {
			System.out.println(a);
		}
		
		lector.generarTicket(Archivo.ofertas);

	}
}
