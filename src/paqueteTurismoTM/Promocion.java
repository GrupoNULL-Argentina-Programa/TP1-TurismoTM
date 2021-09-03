package paqueteTurismoTM;

import java.util.ArrayList;

public class Promocion extends Oferta {
	public ArrayList<Atraccion> atracciones;

	public Promocion(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones) {
		super(nombre, tipoAtraccion);
		this.atracciones = new ArrayList<Atraccion>();
	}

	public double getTiempo() {
		int tiempo = 0;
		for (Atraccion a : atracciones) {
			tiempo += a.getTiempo();
		}
		return tiempo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public int getCupoDisponible() {
		int cupoDisponible = 0;
		for (Atraccion a : atracciones) {
			cupoDisponible = a.getCuposDisponible();
		}
		return cupoDisponible;
	}

	public int compareTo(Oferta otraOferta) {
		return 0;
	}

}
