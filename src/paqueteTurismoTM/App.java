package paqueteTurismoTM;

import java.io.IOException;
import java.util.*;

public class App {

	
		public static void main(String[] args) throws IOException {
			LectorDeFicheros lector = new LectorDeFicheros();
			ArrayList<Cliente> clientes = lector.cargarClientes();
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			
			System.out.println();
			
			LectorDeFicheros lector1 = new LectorDeFicheros();
			ArrayList<Atraccion> atracciones = lector1.cargarAtraccion();
			for (Atraccion atraccion : atracciones) {
				System.out.println(atraccion);
			}
			
			System.out.println();

			LectorDeFicheros lector2 = new LectorDeFicheros();
			ArrayList<PromocionAbsoluta> promAbsoluta = lector2.cargarPromocionAbsoluta();
			for (PromocionAbsoluta promocion : promAbsoluta) {
				promocion.getTiempo(atracciones);
				System.out.println(promocion);
			}

			
			
			System.out.println("\n El booleando retornado es: " + clientes.get(0).responderPregunta());
		}
	}


