package paqueteTurismoTM;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ItinerarioTests {

	public ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	public ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	public ArrayList<Oferta> ofertasCompradas = new ArrayList<Oferta>();
	
	public ArrayList<Oferta> cargarAtraccion() {
		ArrayList<String> arrayDeAtracciones = LectorDeFicheros.leerFichero("res/entrada/atracciones.txt");
		ArrayList<Oferta> atracciones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDeAtracciones.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDeAtracciones.get(i).split(";")));
			atracciones.add(
					new Atraccion(campos.get(0), Integer.parseInt(campos.get(1)), Double.parseDouble(campos.get(2)),
							Integer.parseInt(campos.get(3)), TipoAtraccion.valueOf(campos.get(4))));
		}
		return atracciones;
		}

	public ArrayList<Oferta> cargarPromocionAbsoluta() {
		ArrayList<String> arrayDePromAbs = LectorDeFicheros.leerFichero("res/test/entrada/promocionesTest.txt");
		ArrayList<Oferta> promociones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDePromAbs.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDePromAbs.get(i).split(";")));
			@SuppressWarnings("unused")
			ArrayList<String> arrayDeAtracciones;
			promociones.add(new PromocionAbsoluta(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
					Integer.parseInt(campos.get(2)),
					arrayDeAtracciones = new ArrayList<>(Arrays.asList(campos.get(3).split(",")))));
		}
		return promociones;
	}

	@Test
	public void salidaTest() throws IOException {
		LectorDeFicheros lector = new LectorDeFicheros();
		TurismoTM turismo = new TurismoTM();
		turismo.ofertas=lector.cargarAtraccion();
		Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 80, 12);
		ofertas = this.cargarPromocionAbsoluta();
		cliente.comprarOferta(ofertas.get(2));
		
		lector.generarTicket(cliente);

		byte[] itinerario1Bytes = Files.readAllBytes(Paths.get("res/test/salida/promocionesSalidaTest.txt"));
		byte[] itinerario2Bytes = Files.readAllBytes(Paths.get("res/salida/Pippin_itinerario.txt"));

		String itinerario1 = new String(itinerario1Bytes, StandardCharsets.UTF_8);
		String itinerario2 = new String(itinerario2Bytes, StandardCharsets.UTF_8);

		assertEquals(itinerario1, itinerario2);

	}

}