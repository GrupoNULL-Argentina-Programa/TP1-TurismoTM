package paqueteTurismoTM;

import java.io.IOException;

public class TurismoTM {

	public static void sugerenciaCliente() throws IOException {

		for (Cliente unCliente : App.clientes) {
			boolean nuevoCliente = true;
			boolean seguirOfreciendo = true;
			Oferta unaOferta;
			mensajeBienvenida();
			// Ordena el array ofertas disponibles, según preferencias, costo y tiempo.
			Ofertable.ordenarOfertas(unCliente.preferencia);
			if (Ofertable.comprobarCuposTotales()) {
				while (seguirOfreciendo) {
					if (Ofertable.hayOfertaDisponible(unCliente, nuevoCliente)) {
						unaOferta = Ofertable.getOferta(unCliente, nuevoCliente);
						mensajeQuieresComprarEsto(unaOferta);
						if (unCliente.responderPregunta()) {
							unCliente.comprarOferta(unaOferta);
							unaOferta.venderCupo();
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();
							nuevoCliente = false;
						} else {
							unCliente.agregarAItinerarioOR(unaOferta);
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();
						}
					} else {
						mensajeNoPuedeComprarMas();
					}
				}
			} else {
				mensajeNoHayMasCupos();
			}
		}

	}

	private static void mensajeNoPuedeComprarMas() {

	}

	private static void mensajeNoHayMasCupos() {

	}

	private static void mensajeQuieresVerOtraOferta() {

	}

	private static void mensajeQuieresComprarEsto(Oferta unaOferta) {

	}

	private static void mensajeBienvenida() {

	}

}
