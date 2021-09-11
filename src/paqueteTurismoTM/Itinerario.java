package paqueteTurismoTM;

import java.util.ArrayList;

public class Itinerario {
	public ArrayList<Oferta> ofertasCompradas;
	public ArrayList<Oferta> ofertasRechazadas;
	protected int montoTotal;
	protected double horasTotales;
	
	public Itinerario() {
		ofertasCompradas = new ArrayList<Oferta>();
		ofertasRechazadas = new ArrayList<Oferta>();
	}
	
	public int getMontoTotal() {
		for(Oferta oferta : ofertasCompradas) {
			montoTotal += oferta.getCosto();
		}
		return montoTotal;
	}
	
	public double getHorasTotales() {
		for(Oferta oferta : ofertasCompradas) {
			horasTotales += oferta.getTiempo();
		}
		return horasTotales;
	}

	@Override
	public String toString() {
		return "Itinerario [ofertasCompradas=" + ofertasCompradas + ", ofertasRechazadas=" + ofertasRechazadas
				+ ", montoTotal=" + montoTotal + ", horasTotales=" + horasTotales + "]";
	}
	
}
