package paqueteTurismoTM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente {
	protected String nombre;
	protected TipoAtraccion preferencia;
	protected int presupuesto;
	protected double tiempo;
	protected Itinerario itinerario;

	public Cliente(String nombre, TipoAtraccion preferencia, int presupuesto, double tiempo) {
		super();
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		itinerario = new Itinerario();
	}

	public void comprarOferta(Oferta unaOferta) {
		descontarOroYTiempo(unaOferta);
		agregarAItinerario(unaOferta);
	}

	private void agregarAItinerario(Oferta unaOferta) {
		this.itinerario.ofertasCompradas.add(unaOferta);

	}

	private void descontarOroYTiempo(Oferta unaOferta) {
		this.presupuesto -= unaOferta.getCosto();
		this.tiempo -= unaOferta.getTiempo();

	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempo=" + tiempo + "]";
	}

	public boolean responderPregunta() throws IOException {

		String laRespuesta = null;
		boolean r = false;

		// borrar el siguiente System.out cuando ya no se necesite
		System.out.println("\nProbando la respuesta por consola -> Quieres comprar un producto? (S/N)");

		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);

		laRespuesta = br.readLine();
		laRespuesta = laRespuesta.toLowerCase();

		for (int intentos = 3; intentos >= 1; intentos--) {
			if (laRespuesta.equals("si") || laRespuesta.equals("s")) {
				r = true;
			} else if (laRespuesta.equals("no") || laRespuesta.equals("n")) {
				r = false;
			} else if (intentos > 1) {
				System.out.println(
						".. la respuesta ingresada es incorrecta, debe contestar con 'Si' o 'No' (intentos restantes "
								+ (intentos - 1) + ")");
				laRespuesta = br.readLine();
				laRespuesta = laRespuesta.toLowerCase();
			} else {
				System.out.println(".. intentos agotados, la oferta se rechazara automaticamente .. ");
			}
		}
		return r;
	}

}
