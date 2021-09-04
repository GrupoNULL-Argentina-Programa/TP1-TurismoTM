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
		return "" + nombre + " contiene las siguientes atracciones " + "[" + tipoAtraccion + "]:" + "\n\t" + atracciones + "\n\tSu costo total es de " + costo + " monedas de oro" + 
				"\n\tEl tiempo total necesario es de " + this.getTiempo() + " Hs.";
	}


	public int getCosto() {
		return 0;
	}

}
