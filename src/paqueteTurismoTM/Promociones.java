package paqueteTurismoTM;
import java.util.ArrayList;

public class Promociones extends Oferta{
	private ArrayList<Atraccion> atracciones;
	private int costo; // puede heredarse
	private double tiempo; // puede heredarse
	private int cupoDisponible; // puede heredarse
	
	public Promociones(String nombre, TipoAtraccion tipoAtraccion, ArrayList<Atraccion> atracciones) {
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
	
	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion.name();
	}
	
	public int getCupoDisponible() {
		for (Atraccion a: atracciones) {
			
		}
	}
	
	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo="+ this.getCosto() + ", tiempo="+ this.getTiempo() + ", tipoDeAtraccipon=" this.getTipoAtraccion()+ ", cupoDisponible="+ this.getCupoDisponible() + "]";
	}
	
	public int compareTo(Oferta otraOferta) {
		
	}
	

}