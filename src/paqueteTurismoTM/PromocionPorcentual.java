package paqueteTurismoTM;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento;// decimal


	public PromocionPorcentual(String nombre, TipoAtraccion tipoAtraccion, 
			ArrayList<String> atracciones,double descuento) {
		super(nombre, tipoAtraccion, atracciones);
		this.descuento = descuento;
	}


	public int getCosto() {
		for (String a : atracciones) {
			for (Oferta b : Archivo.ofertas) {
				if (a == b.getNombre()) {
					costo += b.getCosto();
				}
			}
		}
		return (int) (costo * (1 - descuento));
	}
	
//	public int getTiempo(ArrayList<Atraccion> listaAtracciones) {
//		for (String a : atracciones) {
//			for (Atraccion b : listaAtracciones) {
//				if (a == b.nombre) {
//					tiempo += b.getTiempo();
//				}
//			}
//
//		}
//		return (int) tiempo;
//	}

	@Override
	public String toString() {
		return "Promocion [nombre=" + this.nombre + ", costo=" + this.getCosto() + ", tiempo=" + this.getTiempo()
				+ ", tipoDeAtraccipon=" + tipoAtraccion + ", cupoDisponible=" + "]";
	}


	@Override
	protected int getCosto(ArrayList<Atraccion> listaAtracciones) {
		// TODO Auto-generated method stub
		return 0;
	}
}
