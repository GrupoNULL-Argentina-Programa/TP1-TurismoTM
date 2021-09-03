package paqueteTurismoTM;

import java.util.ArrayList;


public class PromocionAbsoluta extends Promocion{
	
	public PromocionAbsoluta(String nombre, TipoAtraccion tipoAtraccion, int costo,double tiempo, ArrayList<String> atracciones) {
		super(nombre, tipoAtraccion, tiempo, atracciones);
		this.costo = costo;
	}
	
	public int getCosto(ArrayList<Atraccion> listaAtracciones) {
		return costo;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [atracciones=" + atracciones + ", costo=" + costo + 
				", tiempo total=" + tiempo + " ,nombre=" + nombre
				+ ", tipoAtraccion=" + tipoAtraccion + "]";
	}

}
