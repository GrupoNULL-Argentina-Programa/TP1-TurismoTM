package paqueteTurismoTM;

import java.util.ArrayList;


public abstract class Promocion extends Oferta{
		protected ArrayList<String> atracciones;
	protected int costo; // puede heredarse
	protected double tiempo; // puede heredarse
	protected int cupoDisponible; // puede heredarse
  
	public Promocion(String nombre, TipoAtraccion tipoAtraccion, double tiempo, ArrayList<String> atracciones) {
		super (nombre, tipoAtraccion);
		this.tiempo=tiempo;
		this.atracciones = atracciones;
	}

	public String getNombre() {
		return nombre;
	}
	
	protected abstract int getCosto(ArrayList<Atraccion> listaAtracciones);



		public int getTiempo(ArrayList<Atraccion> listaAtracciones) {
		for (String a : atracciones) {
			for (Atraccion b : listaAtracciones) {
				if (a == b.nombre) {
					tiempo += b.getTiempo();
				}
			}

		}
		return (int) tiempo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public int getCupoDisponible() {
		int cupoDisponible = 0;
		for (Atraccion a : atracciones) {
			cupoDisponible = a.getCuposDisponible();
		}
		return cupoDisponible;
	}

	public int compareTo(Oferta otraOferta) {
		return 0;
	}


}
