package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento;// decimal

	public PromocionPorcentual(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones,
			double descuento) {
		super(nombre, tipoAtraccion, atracciones);
		this.descuento = descuento;
	}

	public int getCosto() {
		int costo = 0;
		for (Atraccion a : atracciones) {
			costo += a.getCosto();
		}
		return (int) (costo * (1 - descuento));
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo=" + this.getCosto() + ", tiempo=" + this.getTiempo()
				+ ", tipoDeAtraccipon=" + tipoAtraccion + ", cupoDisponible=" + "]";
	}
}
