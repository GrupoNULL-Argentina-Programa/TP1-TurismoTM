package paqueteTurismoTM;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
//		LectorDeFicheros lector = new LectorDeFicheros();
//		Archivo.clientes = lector.cargarClientes();
//		for (Cliente cliente : Archivo.clientes) {
//			System.out.println(cliente);
//		}
//
//		System.out.println();
//
//		LectorDeFicheros lector1 = new LectorDeFicheros();
//		Archivo.ofertas = lector1.cargarAtraccion();
//		for (Oferta atraccion : Archivo.ofertas) {
//			System.out.println(atraccion);
//		}
//		System.out.println();
//
//		LectorDeFicheros lector2 = new LectorDeFicheros();
//		Archivo.ofertas.addAll(lector2.cargarPromocionAbsoluta());
//		for (Oferta promocion : Archivo.ofertas) {
//			System.out.println(promocion);
//		}
		
		LectorDeFicheros lector3 = new LectorDeFicheros();
		Archivo.ofertas.addAll(lector3.cargarPromocionAxB());
		for (Oferta promocion : Archivo.ofertas) {
			System.out.println(promocion);
		}


		// Ordena el array ofertas de mayor a menor y luego lo muestra.
		//
//		Archivo.OrdenarOfertas();
//		System.out.println("\n\n");
//		for (Oferta a : Archivo.ofertas) {
//			System.out.println(a);
//		}
		//
	}
}
