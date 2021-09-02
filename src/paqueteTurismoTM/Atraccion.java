package paqueteTurismoTM;

public class Atraccion extends Oferta {

	private int costo;
	private double tiempo;
	private final int CUPO_TOTAL = 0;
	private int cuposDisponible;

	public Atraccion(String nombre, int costo, double tiempo, int cuposDisponible, TipoAtraccion tipoAtraccion) {	
		super(nombre, tipoAtraccion);
		this.costo = costo;
		this.tiempo = tiempo;
		this.cuposDisponible = CUPO_TOTAL;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getCuposDisponible() {
		return cuposDisponible;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", tipoAtraccion="
				+ tipoAtraccion + ", cuposDisponible=" + cuposDisponible + "]";
	}
}