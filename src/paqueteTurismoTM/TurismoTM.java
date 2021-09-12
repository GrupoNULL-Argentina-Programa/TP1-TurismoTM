package paqueteTurismoTM;

import java.io.IOException;
import java.util.ArrayList;

public class TurismoTM {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public static void main(String[] args) throws IOException {

		LectorDeFicheros lector = new LectorDeFicheros();
		clientes = lector.cargarClientes();
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//		}

		// System.out.println();

		// LectorDeFicheros lector1 = new LectorDeFicheros();
		ofertas = lector.cargarAtraccion();
//		for (Oferta atraccion : ofertas) {
//			System.out.println(atraccion);
//		}
		// System.out.println();

		// LectorDeFicheros lector2 = new LectorDeFicheros();
		ofertas.addAll(lector.cargarPromocionAbsoluta());
//		for (Oferta promocion : ofertas) {
//			System.out.println(promocion);
//		}

		// LectorDeFicheros lector3 = new LectorDeFicheros();
		ofertas.addAll(lector.cargarPromocionAxB());
//		for (Oferta promocion : ofertas) {
//			System.out.println(promocion);
//		}

		// LectorDeFicheros lector4 = new LectorDeFicheros();
		ofertas.addAll(lector.cargarPromocionPorcentual());
//		for (Oferta promocion : ofertas) {
//			System.out.println(promocion);
//		}

		sugerenciaCliente();
	}

	public static void sugerenciaCliente() throws IOException {

		for (Cliente unCliente : clientes) {
			boolean seguirOfreciendo = true;
			Oferta unaOferta;

			System.out.print(unCliente.nombre);

			mensajeBienvenida();
			if (Ofertable.comprobarSiHayOferta()) {
				Ofertable.ordenarOfertas(unCliente.preferencia);
				while (seguirOfreciendo) {
					if (Ofertable.hayOfertaDisponible(unCliente)) {
						unaOferta = Ofertable.getOferta();
						mensajeQuieresComprarEsto(unaOferta);
						if (unCliente.responderPregunta()) {
							unCliente.comprarOferta(unaOferta);
							Ofertable.quitarOfertasCompradasDos();
							unaOferta.venderCupo();
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();
						} else {
							Ofertable.quitarOfertasRechazadas();
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();
						}
					} else {
						mensajeNoPuedeComprarMas();
						seguirOfreciendo=false;
					}
				}
			} else {
				mensajeNoHayMasCupos();
			}
			System.out.println("Este será su itinerario: ");
			System.out.println(unCliente.itinerario);
			System.out.println();
			LectorDeFicheros lector = new LectorDeFicheros();
			lector.generarTicket(unCliente);
		}
		System.out.println("Fin del programa!");
	}

	private static void mensajeNoPuedeComprarMas() {
		System.out.println("¡No puede comprar mas!");
	}

	private static void mensajeNoHayMasCupos() {
		System.out.println("Atracción sin cupo disponible, lo sentimos.");
	}

	private static void mensajeQuieresVerOtraOferta() {
		System.out.println("¿Quieres ver otra oferta? S/N");

	}

	private static void mensajeQuieresComprarEsto(Oferta unaOferta) {
		System.out.println("Te recomendamos esta oferta, quieres comprarla? S/N");
		System.out.println(unaOferta);
	}

	private static void mensajeBienvenida() {
		System.out.println(", te damos la bienvenida a Turismo en la Tierra Media!");

	}

}
