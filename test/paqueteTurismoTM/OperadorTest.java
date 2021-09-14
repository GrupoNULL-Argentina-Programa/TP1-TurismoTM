package paqueteTurismoTM;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

//Debe verificar que ordena bien, que filtra tiempo, dinero y cupo

public class OperadorTest {

	public ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	public ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	public ArrayList<Oferta> ofertasCompradas = new ArrayList<Oferta>();

	public ArrayList<Oferta> cargarAtraccion() {
		ArrayList<String> arrayDeAtracciones = LectorDeFicheros.leerFichero("res/test/entrada/atraccionesTest.txt");
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

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void ordenarOfertasTest() throws IOException {
		LectorDeFicheros lector = new LectorDeFicheros();
		TurismoTM turismo = new TurismoTM();
		turismo.ofertas = this.cargarAtraccion();
		Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 20, 12);
		ofertas = this.cargarPromocionAbsoluta();
		ofertas.addAll(this.cargarAtraccion());
		Ofertable.ofertasCopia = (ArrayList<Oferta>) ofertas.clone();

		Ofertable.ordenarOfertas(cliente.preferencia);

		PrintWriter salida = new PrintWriter(new FileWriter("res/test/salida/ofertasOrdenadas.txt"));
		salida.print(Ofertable.ofertasCopia);
		salida.close();

		byte[] ofertas1Bytes = Files.readAllBytes(Paths.get("res/test/entrada/ofertasEsperadas.txt"));
		byte[] ofertas2Bytes = Files.readAllBytes(Paths.get("res/test/salida/ofertasOrdenadas.txt"));

		String ofertas1 = new String(ofertas1Bytes, StandardCharsets.UTF_8);
		String ofertas2 = new String(ofertas2Bytes, StandardCharsets.UTF_8);

		assertEquals(ofertas1, ofertas2);

	}

	@Test
	public void filtrosTest() throws IOException {
		LectorDeFicheros lector = new LectorDeFicheros();
		TurismoTM turismo = new TurismoTM();
		turismo.ofertas = this.cargarAtraccion();
		Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 20, 10);
		ofertas = this.cargarPromocionAbsoluta();
		ofertas.addAll(this.cargarAtraccion());
		Ofertable.ofertasCopia = (ArrayList<Oferta>) ofertas.clone();
		System.out.println(Ofertable.ofertasCopia);
	
		
		PrintWriter salida = new PrintWriter(new FileWriter("res/test/salida/ofertasFiltradas.txt"));
		salida.println(Ofertable.ofertasCopia);
		
		Ofertable.ordenarOfertas(cliente.preferencia);
		salida.println(Ofertable.ofertasCopia);
		System.out.println(Ofertable.ofertasCopia);
	
		if (Ofertable.hayOfertaDisponible(cliente)) {
			System.out.println("1" + Ofertable.ofertasCopia);
			salida.println(Ofertable.ofertasCopia);
			
			Ofertable.quitarOfertasSinCupo();
			salida.println(Ofertable.ofertasCopia);
			System.out.println("2" + Ofertable.ofertasCopia);

			cliente.comprarOferta(Ofertable.ofertasCopia.get(0));

			Ofertable.ofertasCopia.get(0).venderCupo();

			Ofertable.quitarOfertasCompradas();
			salida.println(Ofertable.ofertasCopia);
			System.out.print("5" + Ofertable.ofertasCopia);

			Ofertable.quitarOfertasQueNoPuedeComprar(cliente);
			salida.print(Ofertable.ofertasCopia);
		}
		
		salida.close();

		byte[] ofertas1Bytes = Files.readAllBytes(Paths.get("res/test/entrada/ofertasFiltradasEsperadas.txt"));
		byte[] ofertas2Bytes = Files.readAllBytes(Paths.get("res/test/salida/ofertasFiltradas.txt"));

		String ofertas1 = new String(ofertas1Bytes, StandardCharsets.UTF_8);
		String ofertas2 = new String(ofertas2Bytes, StandardCharsets.UTF_8);

		assertEquals(ofertas1, ofertas2);

		
		
	}
}
