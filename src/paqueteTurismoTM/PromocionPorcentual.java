package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento;// decimal

	public PromocionPorcentual(String nombre, TipoAtraccion tipoAtraccion, double descuento, double tiempo,
			ArrayList<String> atracciones) {
		super(nombre, tipoAtraccion, tiempo, atracciones);
		this.descuento = descuento;
	}


	public int getCosto(ArrayList<Atraccion> listaAtracciones) {
		for (String a : atracciones) {
			for (Atraccion b : listaAtracciones) {
				if (a == b.nombre) {
					costo += b.getCosto();
				}
			}

		}
		return (int) (costo * (1 - descuento));
	}
	
	public int getTiempo(ArrayList<Atraccion> listaAtracciones) {
		for (String a : atracciones) {
			for (Atraccion b : listaAtracciones) {
				if (a == b.nombre) {
					tiempo += b.getTiempo();
				}
			}

		}
		return (int) tiempo;
	}

}
