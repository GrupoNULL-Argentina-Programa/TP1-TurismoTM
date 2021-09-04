package paqueteTurismoTM;

import java.util.ArrayList;

public abstract class Promocion extends Oferta{
	public ArrayList<String> atracciones;
	protected int costo;
	protected double tiempoTotal;
	protected int cupoDisponible;
  
	public Promocion(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones) {
		super (nombre, tipoAtraccion);
		this.atracciones = new ArrayList<String>(atracciones);
	}

	public String getNombre() {
		return nombre;
	}
	
	protected abstract int getCosto(ArrayList<Atraccion> listaAtracciones);



		public double getTiempo() {
		for (String a : atracciones) {
			for (Oferta b : Archivo.ofertas) {
				if (a.equals(b.nombre)) {
					tiempoTotal += b.getTiempo();
				}
			}
		}
		return tiempoTotal;
	}
		
		

//	public ArrayList<Atraccion> getAtracciones() {
//		return atracciones;
//	}
//
//	public int getCupoDisponible() {
//		int cupoDisponible = 0;
//		for (Atraccion a : atracciones) {
//			cupoDisponible = a.getCuposDisponible();
//		}
//		return cupoDisponible;
//	}
//
//	public int compareTo(Oferta otraOferta) {
//		return 0;
//	}


}
