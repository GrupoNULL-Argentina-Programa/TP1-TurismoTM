package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion{
	
	public PromocionAbsoluta(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones, int costo) {
		super(nombre, tipoAtraccion, atracciones);
		this.costo = costo;
	}
	
	public int getCosto() {
		return costo;
	}	

}
