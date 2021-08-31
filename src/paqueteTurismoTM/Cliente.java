package paqueteTurismoTM;

public class Cliente {
	protected String nombre;
	protected TipoAtraccion preferencia;
	protected int presupuesto;
	protected double tiempo;	
	private Itinerario itinerario;
	
	public Cliente(String nombre, TipoAtraccion preferencia, int presupuesto, double tiempo) {
		super();
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempo=" + tiempo + "]";
	}	
}
