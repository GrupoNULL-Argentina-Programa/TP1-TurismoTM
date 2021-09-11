package paqueteTurismoTM;

import java.util.ArrayList;
import java.util.Collections;

public class Ofertable {

	static ArrayList<Oferta> ofertasCopia = new ArrayList<Oferta>();
	

	public static void ordenarOfertas(TipoAtraccion preferencia) {
		Collections.sort(ofertasCopia, new ComparadorDeOfertas(preferencia));
	}
		
	// Y ademas todo lo que haga falta voy a estar rellenando con booleans
	public static boolean comprobarCuposTotales() {
		return false;
	}

	public static boolean hayOfertaDisponible(Cliente unCliente, boolean esNuevoCliente) {
		return false;
	}

	public static Oferta getOferta(Cliente unCliente, boolean nuevoCliente) {
		Oferta unaOferta = new Atraccion("unNombre", 0, 0.0, 0, TipoAtraccion.valueOf("AVENTURA"));

		return unaOferta;
	}

	public static void resetearArrayCopia() {

	}

	public static void quitarOfertasSinCupo(boolean unCliente) {

	}

	public static void quitarOfertasQueNoPuedeComprar(boolean unCliente) {

	}

	public static void quitarOfertasYaCompradas(boolean unCliente) {

	}

	public static void quitarOfertasRechazadas(boolean unCliente) {

	}
}
