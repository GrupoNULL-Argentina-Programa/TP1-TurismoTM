package paqueteTurismoTM;

public abstract class Oferta {
	protected String nombre = "";
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

	public void venderUnCupo() {
		// TODO Auto-generated method stub

	}
}
