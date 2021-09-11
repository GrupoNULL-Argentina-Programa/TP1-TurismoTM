package paqueteTurismoTM;

import java.io.IOException;
import java.util.ArrayList;

public class TurismoTM {
	
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	public static void main(String[] args) throws IOException {

		LectorDeFicheros lector = new LectorDeFicheros();
		clientes = lector.cargarClientes();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}

		System.out.println();

		LectorDeFicheros lector1 = new LectorDeFicheros();
		ofertas = lector1.cargarAtraccion();
		for (Oferta atraccion : ofertas) {
			System.out.println(atraccion);
		}
		System.out.println();

		LectorDeFicheros lector2 = new LectorDeFicheros();
		ofertas.addAll(lector2.cargarPromocionAbsoluta());
		for (Oferta promocion : ofertas) {
			System.out.println(promocion);
		}

		LectorDeFicheros lector3 = new LectorDeFicheros();
		ofertas.addAll(lector3.cargarPromocionAxB());
		for (Oferta promocion : ofertas) {
			System.out.println(promocion);
		}

		LectorDeFicheros lector4 = new LectorDeFicheros();
		ofertas.addAll(lector4.cargarPromocionPorcentual());
		for (Oferta promocion : ofertas) {
			System.out.println(promocion);
		}
		
		
		

	}

	public static void sugerenciaCliente() throws IOException {

		for (Cliente unCliente : clientes) {			
			boolean seguirOfreciendo = true;
			Oferta unaOferta;

			mensajeBienvenida();
			if (Ofertable.comprobarSiHayOferta()) {				
			Ofertable.ordenarOfertas(unCliente.preferencia);			
				while (seguirOfreciendo) {
					if (Ofertable.hayOfertaDisponible(unCliente)) {
						unaOferta = Ofertable.getOferta(unCliente);
						mensajeQuieresComprarEsto(unaOferta);
						if (unCliente.responderPregunta()) {
							unCliente.comprarOferta(unaOferta);
							unaOferta.venderCupo();
							Itinerario.agregarAlItinerario(unaOferta);
							Ofertable.quitarOfertasCompradas();
							Ofertable.quitarOfertasSinCupo();
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();							
						} else {
							Ofertable.quitarOfertasRechazadas();
							mensajeQuieresVerOtraOferta();
							seguirOfreciendo = unCliente.responderPregunta();
						}
					} else {
						mensajeNoPuedeComprarMas();
					}
				}
				Ofertable.resetearArrayCopia();
			} else {
				mensajeNoHayMasCupos();
			}
		}

	}

	//Faltan todos los mensajes
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
