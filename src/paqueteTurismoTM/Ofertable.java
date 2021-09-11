package paqueteTurismoTM;

import java.util.ArrayList;
import java.util.Collections;

public class Ofertable {

	static ArrayList<Oferta> ofertasCopia = TurismoTM.ofertas;

	public static void ordenarOfertas(TipoAtraccion preferencia) {
		Collections.sort(ofertasCopia, new ComparadorDeOfertas(preferencia));
	}

	// Y ademas todo lo que haga falta voy a estar rellenando con booleans
	public static boolean comprobarSiHayOferta() {
		return (TurismoTM.ofertas != null);
	}

	public static boolean hayOfertaDisponible(Cliente unCliente) {
		return (ofertasCopia != null);
	}

	public static Oferta getOferta(Cliente unCliente) {
		return ofertasCopia.get(0);
	}

	public static void resetearArrayCopia() {
		ofertasCopia = TurismoTM.ofertas;
	}

	public static void quitarOfertasSinCupo() {
		if (ofertasCopia.get(0) instanceof Promocion) {
			Promocion unaPromo = (Promocion) ofertasCopia.get(0);
			ArrayList<String> atraccionesCompradas = unaPromo.getAtracciones();
			for (String a : atraccionesCompradas) {
				for (Oferta b : ofertasCopia) {
					if (a.equals(b.nombre)) {
						b.getCuposDisponibles();
						if (b.getCuposDisponibles() == 0) {
							ofertasCopia.remove(b);
						}
					}
				}
			}

		}
		if (ofertasCopia.get(0).getCuposDisponibles() == 0) {
			ofertasCopia.remove(0);
		}

	}

	public static void quitarOfertasCompradas() {
		if (ofertasCopia.get(0) instanceof Promocion) {
			Promocion unaPromo = (Promocion) ofertasCopia.get(0);
			ArrayList<String> atraccionesCompradas = unaPromo.getAtracciones();
			for (String a : atraccionesCompradas) {
				for (Oferta b : ofertasCopia) {
					if (a.equals(b.nombre)) {
						ofertasCopia.remove(b);
					}
				}
			}

		} else
			ofertasCopia.remove(0);

	}

	public static void quitarOfertasRechazadas() {
		ofertasCopia.remove(0);
	}

	// Falta esto
	public static void quitarOfertasQueNoPuedeComprar(boolean unCliente) {

	}

	// Falta esto
	public static void quitarOfertasQueNoTieneTiempo(boolean unCliente) {

	}
}
