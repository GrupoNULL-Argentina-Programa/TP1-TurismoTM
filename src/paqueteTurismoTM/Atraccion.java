package paqueteTurismoTM;

public class Atraccion {

	private String nombre;
	private int costo;
	private double tiempo;
	private static final int CUPO_TOTAL = 50;
	private TipoAtraccion tipoAtraccion;
	private int cuposDisponible;

	public Atraccion(String nombre, int costo, double tiempo, int cuposDisponible, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cuposDisponible = CUPO_TOTAL;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
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