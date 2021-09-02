package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAxB extends Promocion{

	private ArrayList<Atraccion> atraccionesGratis;

	public PromocionAxB(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones , ArrayList<Atraccion> atraccionesGratis) {
		super(nombre, tipoAtraccion, atracciones);
		this.atraccionesGratis = new ArrayList<Atraccion>();
	}
	
	@Override
	public int getCosto() {
		int descuento = 0;
		for (Atraccion a: atracciones) {
			costo += a.getCosto(); 
		}
		for (Atraccion a: atraccionesGratis) {
			descuento += a.getCosto(); 
		}
		return (costo-descuento);
	}

}
