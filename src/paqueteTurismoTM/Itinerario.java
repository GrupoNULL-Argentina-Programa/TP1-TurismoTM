package paqueteTurismoTM;

import java.util.ArrayList;

public class Itinerario {
	public ArrayList<Oferta> ofertasCompradas;
	protected int montoTotal;
	protected double horasTotales;

	public Itinerario() {
		ofertasCompradas = new ArrayList<Oferta>();
	}

	public int getMontoTotal() {
		for (Oferta oferta : ofertasCompradas) {
			montoTotal += oferta.getCosto();
		}
		return montoTotal;
	}

	public double getHorasTotales() {
		for (Oferta oferta : ofertasCompradas) {
			horasTotales += oferta.getTiempo();
		}
		return horasTotales;
	}

	public void agregarAlItinerario(Oferta unaOferta) {
		this.ofertasCompradas.add(unaOferta);
	}

	@Override
	public String toString() {
		return "Ofertas Compradas: " + ofertasCompradas + ", Monto Total: " + getMontoTotal() + ", Horas Totales: "
				+ getHorasTotales();
	}
}