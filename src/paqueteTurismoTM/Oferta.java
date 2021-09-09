package paqueteTurismoTM;

public abstract class Oferta implements Comparable {
	protected String nombre = "";
	protected double tiempo;
	protected TipoAtraccion tipoAtraccion;

	public Oferta(String nombre, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	protected abstract int getCuposDisponible();
	
	public abstract void venderCupo();

	protected abstract int getCosto();

	protected abstract double getTiempo();

	public int compareTo(Oferta otraOferta) {
		if (this.getCosto() > otraOferta.getCosto()) {
			return 1;
		} else if (this.getCosto() < otraOferta.getCosto()) {
			return -1;
		} else if (this.getTiempo() > otraOferta.getTiempo()) {
			return 1;
		} else if (this.getTiempo() < otraOferta.getCosto()) {
			return -1;
		} else {
			return 0;
		}
	}
}
