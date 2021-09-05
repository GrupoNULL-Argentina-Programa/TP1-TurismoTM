package paqueteTurismoTM;

public class Atraccion extends Oferta {

	private int costo;
	private int cuposDisponible;

	public Atraccion(String nombre, int costo, double tiempo, int cuposDisponible, TipoAtraccion tipoAtraccion) {
		super(nombre, tipoAtraccion);
		this.costo = costo;
		this.tiempo = tiempo;
		this.cuposDisponible = cuposDisponible;
	}

	public int getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void venderCupo() {
		this.cuposDisponible--;
	}

	public int getCuposDisponible() {
		return cuposDisponible;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", tipoAtraccion="
				+ tipoAtraccion + ", cuposDisponible=" + cuposDisponible + "]";
	}

	@Override
	public int compareTo(Oferta otraOferta) {
		// TODO Auto-generated method stub
		return 0;
	}
}