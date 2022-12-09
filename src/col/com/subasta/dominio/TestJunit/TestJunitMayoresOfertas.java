package col.com.subasta.dominio.TestJunit;

import org.junit.Test;

import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
import junit.framework.Assert;

public class TestJunitMayoresOfertas {
	
	@Test
	public void MayoresTresOfertas() {
		Usuario Alejandria = new Usuario(1,"Alejandria");
		Usuario Alejandro = new Usuario(2,"Alejandro");
		Usuario Alejo = new Usuario(3,"Alejo");
		Usuario Martes = new Usuario(4,"Martes");
		Usuario carla = new Usuario(5,"Carla");
		
		Oferta ofertaMartes = new Oferta(Martes, 200000.00);
		Oferta ofertaAlejandro = new Oferta(Alejandro, 300000.00);
		Oferta ofertaAlejo = new Oferta(Alejo, 400000.00);
		Oferta ofertaAlejandria = new Oferta(Alejandria, 500000.00);
		Oferta ofertaCarla = new Oferta(carla, 600000.00);
		
		Subasta audifonos = new Subasta("Audifonos inalambricos");
		audifonos.propone(ofertaAlejandria);
		audifonos.propone(ofertaAlejo);
		audifonos.propone(ofertaMartes);
		audifonos.propone(ofertaAlejandro);
		audifonos.propone(ofertaCarla);
		
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(audifonos);
		
		Assert.assertEquals(evaluador.getOfertasMayores().size(), 3);
		Assert.assertEquals(evaluador.getOfertasMayores().get(1).getValor(), 300000.00);
		Assert.assertEquals(evaluador.getOfertasMayores().get(2).getValor(), 400000.00);
		Assert.assertEquals(evaluador.getOfertasMayores().get(3).getValor(), 500000.00);
	}
	
}
