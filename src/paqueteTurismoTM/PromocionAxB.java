package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	private ArrayList<Atraccion> atraccionesGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones,
			ArrayList<Atraccion> atraccionesGratis) {
		super(nombre, tipoAtraccion, atracciones);
		this.atraccionesGratis = new ArrayList<Atraccion>();
	}

	public int getCosto() {
		int costo = 0;
		for (Atraccion a : atracciones) {
			costo += a.getCosto();
		}
		int descuento = 0;
		for (Atraccion a : atraccionesGratis) {
			descuento += a.getCosto();
		}
		return (costo - descuento);
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo=" + this.getCosto() + ", tiempo=" + this.getTiempo()
				+ ", tipoDeAtraccipon=" + tipoAtraccion + ", cupoDisponible=" + "]";
	}
}
