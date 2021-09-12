package paqueteTurismoTM;

import java.util.ArrayList;
import java.util.Collections;

public class Ofertable {

	static ArrayList<Oferta> ofertasCopia = new ArrayList<Oferta>();

	public static void ordenarOfertas(TipoAtraccion preferencia) {
		Collections.sort(ofertasCopia, new ComparadorDeOfertas(preferencia));
	}

	public static boolean comprobarSiHayOferta() {
		// Reiniciar la copia por cada nuevo cliente
		ofertasCopia.removeAll(ofertasCopia);
		// Hacer la copia como corresponde
		for(Oferta unaOferta : TurismoTM.ofertas) {
			ofertasCopia.add(unaOferta);
		}
		// quitar todas las ofertas sin cupo de la copia
		quitarOfertasSinCupo();
		return (TurismoTM.ofertas != null);
	}

	public static boolean hayOfertaDisponible(Cliente unCliente) {
		
		// ciclo que se repite cada vez que el cliente quiera seguir comprando
		
		quitarOfertasQueNoPuedeComprar(unCliente);
		quitarOfertasCompradas(unCliente);
		
		// devuelve un booleano para saber si existe oferta para el mismo cliente
		return (ofertasCopia != null);
	}

	public static Oferta getOferta(Cliente unCliente) {
		return ofertasCopia.get(0);
	}

	public static void quitarOfertasSinCupo() {
		for(Oferta unaOferta : ofertasCopia) {
			if(unaOferta.getCuposDisponibles() <= 0) {
				ofertasCopia.remove(unaOferta);
			}
		}
	}

	public static void quitarOfertasCompradas(Cliente unCliente) {
		for(Oferta ofertaComprada : unCliente.itinerario.ofertasCompradas) {
			ofertasCopia.remove(ofertaComprada);
		}
	}

	public static void quitarOfertasRechazadas() {
		ofertasCopia.remove(0);
	}

	public static void quitarOfertasQueNoPuedeComprar(Cliente unCliente) {
		for(Oferta ofertaImposible : ofertasCopia) {
			if(unCliente.presupuesto < ofertaImposible.getCosto() && unCliente.tiempo < ofertaImposible.getCosto()) {
				ofertasCopia.remove(ofertaImposible);
			}
		}
	}
}
