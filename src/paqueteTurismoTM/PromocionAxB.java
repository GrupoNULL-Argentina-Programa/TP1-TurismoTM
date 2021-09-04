package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	private ArrayList<Atraccion> atraccionesGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones,
			ArrayList<Atraccion> atraccionesGratis) {
		super(nombre, tipoAtraccion, atracciones);
		this.atraccionesGratis = new ArrayList<Atraccion>();
	}

	public int getCosto() {
		int costo = 0;
		return costo;
	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo=" + this.getCosto() + ", tiempo=" + this.getTiempo()
				+ ", tipoDeAtraccipon=" + tipoAtraccion + ", cupoDisponible=" + "]";
	}

	@Override
	protected int getCosto(ArrayList<Atraccion> listaAtracciones) {
		// TODO Auto-generated method stub
		return 0;
	}
}
