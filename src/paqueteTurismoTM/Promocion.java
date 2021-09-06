package paqueteTurismoTM;

import java.util.ArrayList;

public abstract class Promocion extends Oferta {
	public ArrayList<String> atracciones;
	protected int costo;
	protected double tiempoTotal;
	protected int cupoDisponible;

	public Promocion(String nombre, TipoAtraccion tipoAtraccion, ArrayList<String> atracciones) {
		super(nombre, tipoAtraccion);
		this.atracciones = new ArrayList<String>(atracciones);
	}

	public String getNombre() {
		return nombre;
	}

	public double getTiempo() {
		double tiempoTotal = 0;
		for (String a : atracciones) {
			for (Oferta b : Archivo.ofertas) {
				if (a.equals(b.nombre)) {
					tiempoTotal += b.tiempo;
				}
			}
		}
		return tiempoTotal;
	}

	public void venderCupo() {
		for (String a : atracciones) {
			for (Oferta b : Archivo.ofertas)
				if (a.equals(b.nombre))
					b.venderCupo();
		}
	}

	public int getCupoDisponible() {
		int cupoDisponible = 0;
		for (String a : atracciones) {
			for (Oferta b : Archivo.ofertas)
				if (a.equals(b.nombre))
					cupoDisponible = b.getCosto();
		}
		return cupoDisponible;
	}

	public abstract int getCosto();

}
