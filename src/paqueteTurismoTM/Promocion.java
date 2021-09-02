package paqueteTurismoTM;
import java.util.ArrayList;

public class Promocion extends Oferta{
	public ArrayList<Atraccion> atracciones;
	public int costo; // puede heredarse
	private double tiempo; // puede heredarse
	private int cupoDisponible; // puede heredarse
	
	public Promocion(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones) {
		super (nombre, tipoAtraccion);
		this.atracciones = new ArrayList<Atraccion>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	protected int getCosto() {
		for (Atraccion a: atracciones) {
			costo += a.getCosto(); 
		}
		return costo;
	}
	
	public double getTiempo() {
		for (Atraccion a: atracciones) {
			tiempo += a.getTiempo(); 
		}
		return tiempo;
	}
	
	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	/*
	 * public int getCupoDisponible() { for (Atraccion a: atracciones) {
	 * 
	 * }
	 */
	
	
	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo="+ this.getCosto() + ", tiempo="+ this.getTiempo() + ", tipoDeAtraccipon="+  tipoAtraccion+ ", cupoDisponible=" + "]";
	}
	
	/*
	 * public int compareTo(Oferta otraOferta) {
	 * 
	 * }
	 */
	

}
