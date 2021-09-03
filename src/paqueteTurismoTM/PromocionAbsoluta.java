package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {
	private int costo = 0;

	public PromocionAbsoluta(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones, int costo) {
		super(nombre, tipoAtraccion, atracciones);
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo=" + this.getCosto() + ", tiempo=" + this.getTiempo()
				+ ", tipoDeAtraccipon=" + tipoAtraccion + ", cupoDisponible=" + "]";
	}
}
