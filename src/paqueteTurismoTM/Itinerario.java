package paqueteTurismoTM;

import java.util.ArrayList;

public class Itinerario {

	public ArrayList<Oferta> ofertasCompradas;
	public ArrayList<Oferta> ofertasRechazadas;
	
	public Itinerario() {
		ofertasCompradas = new ArrayList<Oferta>();
		ofertasRechazadas = new ArrayList<Oferta>();
	}
	
	public String toString(){
		return "";
	}
}
