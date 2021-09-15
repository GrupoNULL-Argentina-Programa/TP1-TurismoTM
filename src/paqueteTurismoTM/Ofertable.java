package paqueteTurismoTM;

import java.util.ArrayList;
import java.util.Collections;

public class Ofertable {

	static ArrayList<Oferta> ofertasCopia = new ArrayList<Oferta>();

	public static void ordenarOfertas(TipoAtraccion preferencia) {
		Collections.sort(ofertasCopia, new ComparadorDeOfertas(preferencia));
	}

	public static boolean comprobarSiHayOferta() {
		resetearArrayCopia();
		quitarOfertasSinCupo();
		return (TurismoTM.ofertas != null);
	}

	public static void resetearArrayCopia() {
		// Reiniciar la copia por cada nuevo cliente
		ofertasCopia.removeAll(ofertasCopia);
		for (Oferta unaOferta : TurismoTM.ofertas) {
			ofertasCopia.add(unaOferta);
		}
	}

	public static boolean hayOfertaDisponible(Cliente unCliente) {
		// ciclo que se repite cada vez que el cliente quiera seguir comprando
		quitarOfertasQueNoPuedeComprar(unCliente);
//		quitarOfertasCompradas(unCliente);
		// devuelve un booleano para saber si existe oferta para el mismo cliente
		return (ofertasCopia.size() > 0);
	}

	public static Oferta getOferta() {
		return ofertasCopia.get(0);
	}

	public static void quitarOfertasSinCupo() {
		@SuppressWarnings("unchecked")
		ArrayList<Oferta> copia = (ArrayList<Oferta>) ofertasCopia.clone();
		for (Oferta unaOferta : copia) {
			if (unaOferta.getCuposDisponibles() <= 0) {
				ofertasCopia.remove(unaOferta);
			}
		}
	}

//	public static void quitarOfertasCompradas(Cliente unCliente) {
//		for (Oferta ofertaComprada : unCliente.itinerario.ofertasCompradas) {
//			ofertasCopia.remove(ofertaComprada);
//		}
//	}

	public static void quitarOfertasRechazadas() {
		ofertasCopia.remove(0);
	}

	public static void quitarOfertasCompradas() {
		@SuppressWarnings("unchecked")
		ArrayList<Oferta> copia = (ArrayList<Oferta>) ofertasCopia.clone();
		if (copia.get(0) instanceof Promocion) {
			Promocion unaPromo = (Promocion) copia.get(0);
			ArrayList<String> atraccionesCompradas = unaPromo.getAtracciones();
			for (String a : atraccionesCompradas) {
				for (Oferta b : copia) {
					if (b instanceof Promocion) {
						Promocion otraPromo = (Promocion) b;
						ArrayList<String> atraccionesIncluidas = otraPromo.getAtracciones();
						for (String c : atraccionesIncluidas) {
							if (a.equals(c)) {
								ofertasCopia.remove(b);
							}
						}
					} else if (a.equals(b.nombre)) {
						ofertasCopia.remove(b);
					}
				}
			}
		} else
			ofertasCopia.remove(0);
	}

	public static void quitarOfertasQueNoPuedeComprar(Cliente unCliente) {
		@SuppressWarnings("unchecked")
		ArrayList<Oferta> copia = (ArrayList<Oferta>) ofertasCopia.clone();
		for (Oferta ofertaImposible : copia) {
			if (unCliente.presupuesto < ofertaImposible.getCosto() || unCliente.tiempo < ofertaImposible.getTiempo()) {
				ofertasCopia.remove(ofertaImposible);
			}
		}
	}
}