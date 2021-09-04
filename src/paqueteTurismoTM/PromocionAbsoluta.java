package paqueteTurismoTM;

import java.util.ArrayList;


public class PromocionAbsoluta extends Promocion{
	
	public PromocionAbsoluta(String nombre, TipoAtraccion tipoAtraccion, int costo, ArrayList<String> atracciones) {
		super(nombre, tipoAtraccion, atracciones);
		this.costo = costo;
	}
	
	public int getCosto(ArrayList<Atraccion> listaAtracciones) {
		return costo;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [atracciones=" + atracciones + ", costo=" + costo + 
				", tiempo total=" + tiempoTotal + " ,nombre=" + nombre
				+ ", tipoAtraccion=" + tipoAtraccion + "]";
	}

}
