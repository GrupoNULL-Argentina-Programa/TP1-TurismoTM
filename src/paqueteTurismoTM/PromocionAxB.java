package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	public ArrayList<String> atraccionesGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones,
			ArrayList<Atraccion> atraccionesGratis) {
		super(nombre, tipoAtraccion, atracciones);
		this.atraccionesGratis = new ArrayList<String>();
	}

	private ArrayList<String> mostrarAtraccionesPagas() {
		ArrayList<String> atraccionesPagas = new ArrayList<String>();
		for (String a : atracciones) {
			atraccionesPagas.add(a);
		}
		for (int b = 0; b < atraccionesPagas.size(); b++) {
			for (String c : atraccionesGratis) {
				if (atraccionesPagas.get(b).equals(c)) {
					atraccionesPagas.remove(b);
				}
			}
		}
		return atraccionesPagas;
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		ArrayList<String> atraccionesPagas = new ArrayList<String>();
		for (String a : atracciones) {
			atraccionesPagas.add(a);
		}
		for (int b = 0; b < atraccionesPagas.size(); b++) {
			for (String c : atraccionesGratis) {
				if (atraccionesPagas.get(b).equals(c)) {
					atraccionesPagas.remove(b);
				}
			}
		}
		for (String a : atraccionesPagas) {
			for (Oferta b : Archivo.ofertas)
				if (a.equals(b.nombre))
					costoTotal = b.getCosto();
		}
		return costoTotal;
	}

	@Override
	public String toString() {
		return "" + this.nombre + " contiene las siguientese atracciones " + "[" + tipoAtraccion + "]:" + "\n\t"
				+ this.mostrarAtraccionesPagas() + "\n\tSu precio total es de " + this.getCosto() + " monedas de oro."
				+ "\n\t Ademas son gratis las atracciones:\n\t" + this.atraccionesGratis + "\n\tTiempo Total es de "
				+ this.getTiempo() + "hs.";
	}
}
