package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	public ArrayList<String> atraccionesGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones,
			ArrayList<String> atraccionesGratis) {
		super(nombre, tipoAtraccion, atracciones);
		this.atraccionesGratis = atraccionesGratis;
	}

	@Override
	public int getCosto() {
		for (String a : atracciones) {
			for (Oferta b : TurismoTM.ofertas) {
				if (a.equals(b.nombre)) {
					costo += b.getCosto();
				}
			}
		}
		return (int) costo;
	}

	public double getTiempo() {
		double tiempoTotal = 0;
		for (String a : atracciones) {
			for (Oferta b : TurismoTM.ofertas) {
				if (a.equals(b.nombre)) {
					tiempoTotal += b.tiempo;
				}
			}
		}
		for (String a : atraccionesGratis) {
			for (Oferta b : TurismoTM.ofertas) {
				if (a.equals(b.nombre)) {
					tiempoTotal += b.tiempo;
				}
			}
		}
		return tiempoTotal;
	}

	@Override
	public String toString() {
		return "" + this.nombre + " contiene las siguientes atracciones de tipo" + "[" + tipoAtraccion + "]:" + "\n\t"
				+ this.atracciones + "\n\tSu precio total es de " + this.getCosto() + " monedas de oro."
				+ "\n\t Ademas son gratis las atracciones:\n\t" + this.atraccionesGratis + "\n\tTiempo Total es de "
				+ this.getTiempo() + "hs.";
	}
}