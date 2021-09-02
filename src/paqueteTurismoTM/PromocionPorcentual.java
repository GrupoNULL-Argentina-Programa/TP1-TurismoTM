package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion{

	private double descuento;//decimal

	public PromocionPorcentual(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones, double descuento) {
		super(nombre, tipoAtraccion, atracciones);
		this.descuento = descuento;
	}
	@Override
	public int getCosto() {
		for (Atraccion a: atracciones) {
			costo += a.getCosto(); 
		}
		return (int) (costo*(1-descuento));
	}

}
