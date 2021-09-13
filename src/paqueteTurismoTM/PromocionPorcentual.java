package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento; // decimal

	public PromocionPorcentual(String nombre, TipoAtraccion tipoAtraccion, double descuento,
			ArrayList<String> atracciones) {
		super(nombre, tipoAtraccion, atracciones);
		this.descuento = descuento;
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
		return (int) (costo * (1 - descuento));
	}

	@Override
	public String toString() {
		return "" + nombre + " contiene las siguientes atracciones de tipo " + "[" + tipoAtraccion + "]:" + "\n\t"
				+ atracciones + "\n\tSu costo total es de " + this.getCosto() + " monedas de oro"
				+ "\n\tEl tiempo total necesario es de " + this.getTiempo() + " Hs.";
	}
}