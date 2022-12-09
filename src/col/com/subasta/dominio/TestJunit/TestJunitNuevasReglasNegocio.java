package col.com.subasta.dominio.TestJunit;
import org.junit.Test;

import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
import junit.framework.Assert;

public class TestJunitNuevasReglasNegocio {
 /*
  * 1.No acepte dos ofertas consecutivas por el mismo Usuario
  * 2. No acepte mas de 5 ofertas por el mismo Usuario
  */
	
	@Test
	public void Aceptar1OfertaPorUsuarioConsecutiva() {
		Usuario Alejandria = new Usuario(1 , "Alejandria");
		Oferta ofertaAlejandria = new Oferta(Alejandria, 200000.00);
		Oferta ofertaAlejandria2 = new Oferta(Alejandria, 500000.00);
		Oferta ofertaAlejandria3 = new Oferta(Alejandria, 600000.00);
		
		Subasta subasta = new Subasta("Equipo MP3");
		subasta.propone(ofertaAlejandria);
		subasta.propone(ofertaAlejandria2);
		subasta.propone(ofertaAlejandria3);
	
		Assert.assertEquals(subasta.getOfertas().size(), 1);; //Evalua que el tamaño de las ofertas no sea mayor que 1
	}
	@Test
	public void AceptarMaximo5Ofertas() {
		
		Usuario Alejandria = new Usuario(1, "Alejandria");
		Usuario Alejandro = new Usuario(2, "Alejandro");
		
		Oferta oferta1 = new Oferta(Alejandria, 100000.00);
		Oferta oferta2 = new Oferta(Alejandro, 200000.00);
		Oferta oferta3 = new Oferta(Alejandria, 300000.00);
		Oferta oferta4 = new Oferta(Alejandro, 400000.00);
		Oferta oferta5 = new Oferta(Alejandria, 500000.00);
		Oferta oferta6 = new Oferta(Alejandro, 600000.00);
		Oferta oferta7 = new Oferta(Alejandria, 700000.00);
		Oferta oferta8 = new Oferta(Alejandro, 800000.00);
		Oferta oferta9 = new Oferta(Alejandria, 900000.00);
		Oferta oferta10 = new Oferta(Alejandro, 1000000.00);
		Oferta oferta11 = new Oferta(Alejandria, 1100000.00);

		Subasta subasta = new Subasta("Equipo MP3");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		subasta.propone(oferta3);
		subasta.propone(oferta4);
		subasta.propone(oferta5);
		subasta.propone(oferta6);
		subasta.propone(oferta7);
		subasta.propone(oferta8);
		subasta.propone(oferta9);
		subasta.propone(oferta10);
		subasta.propone(oferta11);
		
		Assert.assertEquals(subasta.getOfertas().size(),10);
		
		
		
	}
}
