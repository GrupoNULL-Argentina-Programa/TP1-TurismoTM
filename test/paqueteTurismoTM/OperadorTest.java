package paqueteTurismoTM;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

//Debe verificar que ordena bien, que filtra tiempo, dinero y cupo

public class OperadorTest {
//
//	public ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
//	public ArrayList<Oferta> ofertasCopia = new ArrayList<Oferta>();
//	public ArrayList<Oferta> ofertasEsperadas = new ArrayList<Oferta>();
//
//	public ArrayList<Oferta> cargarAtraccion() {
//		ArrayList<String> arrayDeAtracciones = LectorDeFicheros.leerFichero("res/test/entrada/atraccionesTest.txt");
//		ArrayList<Oferta> atracciones = new ArrayList<Oferta>();
//		for (int i = 0; i < arrayDeAtracciones.size(); i++) {
//			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDeAtracciones.get(i).split(";")));
//			atracciones.add(
//					new Atraccion(campos.get(0), Integer.parseInt(campos.get(1)), Double.parseDouble(campos.get(2)),
//							Integer.parseInt(campos.get(3)), TipoAtraccion.valueOf(campos.get(4))));
//		}
//		return atracciones;
//	}
//
//	public ArrayList<Oferta> cargarPromocionAbsoluta() {
//		ArrayList<String> arrayDePromAbs = LectorDeFicheros.leerFichero("res/test/entrada/promocionesTest.txt");
//		ArrayList<Oferta> promociones = new ArrayList<Oferta>();
//		for (int i = 0; i < arrayDePromAbs.size(); i++) {
//			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDePromAbs.get(i).split(";")));
//			@SuppressWarnings("unused")
//			ArrayList<String> arrayDeAtracciones;
//			promociones.add(new PromocionAbsoluta(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
//					Integer.parseInt(campos.get(2)),
//					arrayDeAtracciones = new ArrayList<>(Arrays.asList(campos.get(3).split(",")))));
//		}
//		return promociones;
//	}
//
//	@SuppressWarnings("static-access")
//	@Test
////	public void ordenarOfertasTest() {
//////		LectorDeFicheros lector = new LectorDeFicheros();
//////		TurismoTM turismo = new TurismoTM();
//////		turismo.ofertas=lector.cargarAtraccion();
//////		Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 80, 12);
//////		ofertas = this.cargarPromocionAbsoluta();
//////		cliente.comprarOferta(ofertas.get(1));
////	
////		LectorDeFicheros lector = new LectorDeFicheros();
////		TurismoTM turismo = new TurismoTM();
////		turismo.ofertas=lector.cargarAtraccion();
////		Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 80, 12);
////		ofertas = this.cargarPromocionAbsoluta();
////		ofertas.addAll(this.cargarAtraccion());
////		Ofertable.ofertasCopia = ofertas;
////		if (Ofertable.comprobarSiHayOferta()) {
////			Ofertable.ordenarOfertas(cliente.preferencia);
////		}
////		
////		System.out.println(ofertas);
//////		ArrayList<String> atracciones1 = new 
//////		
//////		Promocion promocion1 = new PromocionAbsoluta("PromocionAbsoluta 1", TipoAtraccion.DEGUSTACION,36,atracciones)
//////		ofertasEsperadas.add();
////
////	}


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

		@Test
		public void salidaTest() throws IOException {
			LectorDeFicheros lector = new LectorDeFicheros();
			TurismoTM turismo = new TurismoTM();
			turismo.ofertas = lector.cargarAtraccion();
			Cliente cliente = new Cliente("Pippin", TipoAtraccion.AVENTURA, 80, 12);
			ofertas = this.cargarPromocionAbsoluta();
			Ofertable.ofertasCopia = ofertas;
			if (Ofertable.comprobarSiHayOferta()) {
				Ofertable.ordenarOfertas(cliente.preferencia);
			}

			System.out.println(ofertas);

		}

}
