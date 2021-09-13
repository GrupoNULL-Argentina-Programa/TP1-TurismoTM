package paqueteTurismoTM;

import java.io.IOException;
import java.util.ArrayList;

public class TurismoTM {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public static void main(String[] args) throws IOException {

		LectorDeFicheros lector = new LectorDeFicheros();
		clientes = lector.cargarClientes();
		ofertas = lector.cargarAtraccion();

		ofertas.addAll(lector.cargarPromocionAbsoluta());
		ofertas.addAll(lector.cargarPromocionAxB());
		ofertas.addAll(lector.cargarPromocionPorcentual());

		sugerenciaCliente();
	}

	public static void sugerenciaCliente() throws IOException {

		for (Cliente unCliente : clientes) {
			boolean seguirOfreciendo = true;
			Oferta unaOferta;

			System.out.print("Hola " + unCliente.nombre);

			mensajeBienvenida();
			if (Ofertable.comprobarSiHayOferta()) {
				Ofertable.ordenarOfertas(unCliente.preferencia);
				while (seguirOfreciendo) {
					if (Ofertable.hayOfertaDisponible(unCliente)) {
						unaOferta = Ofertable.getOferta();
						mensajeQuieresComprarEsto(unaOferta);
						if (unCliente.responderPregunta()) {
							unCliente.comprarOferta(unaOferta);
							System.out.print("¡Compra exitosa!");
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
						seguirOfreciendo = false;
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
		System.out.println("¡Fin del programa!");
	}

	private static void mensajeNoPuedeComprarMas() {
		System.out.println("¡No puedes comprar más!");
	}

	private static void mensajeNoHayMasCupos() {
		System.out.println("Atracción sin cupo disponible, lo sentimos.");
	}

	private static void mensajeQuieresVerOtraOferta() {
		System.out.println("¿Quieres ver otra oferta? S/N");

	}

	private static void mensajeQuieresComprarEsto(Oferta unaOferta) {
		System.out.println("Te recomendamos esta oferta, ¿quieres comprarla? S/N");
		System.out.println(unaOferta);
	}

	private static void mensajeBienvenida() {
		System.out.println(", ¡te damos la bienvenida a Turismo en la Tierra Media!");
	}
}