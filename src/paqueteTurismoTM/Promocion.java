package paqueteTurismoTM;

import java.util.ArrayList;


public abstract class Promocion extends Oferta{
	protected ArrayList<String> atracciones;
	protected int costo; // puede heredarse
	protected double tiempoTotal; // puede heredarse
	protected int cupoDisponible; // puede heredarse
  
	public Promocion(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones) {
		super (nombre, tipoAtraccion);
		this.atracciones = atracciones;
	}

	public String getNombre() {
		return nombre;
	}
	
	protected abstract int getCosto(ArrayList<Atraccion> listaAtracciones);



		public int getTiempo(ArrayList<Atraccion> listaAtracciones) {
		for (String a : atracciones) {
			for (Atraccion b : listaAtracciones) {
				if (a.equals(b.nombre)) {
					tiempoTotal += b.getTiempo();
				}
			}
		}
		return (int) tiempoTotal;
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
