package br.com.subasta.dominio;

import org.junit.Test;

import junit.framework.Assert;

public class TestJunitEvaluador {
	
	@Test
	public void deberiaRetornarElMayorValor() {
		Usuario diego = new Usuario(1, "Diego");
		Usuario alexiz = new Usuario(2, "Alexiz");
		Usuario daniel = new Usuario(3, "Daniel");
		
		Oferta oferta1 = new Oferta(diego, 300.00);
		Oferta oferta2 = new Oferta(alexiz, 500.00);
		Oferta oferta3 = new Oferta(daniel, 700.00);
		
		Subasta subasta = new Subasta("Auto");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		subasta.propone(oferta3);
		
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
		System.out.println(evaluador.getMayorQueTodos());
		System.out.println(evaluador.getMenorQueTodos());
		
		Assert.assertEquals(700, evaluador.getMayorQueTodos(), 0.00001);
		Assert.assertEquals(300, evaluador.getMenorQueTodos(), 0.00001);
		
	}
	
		@Test
		public void deberiaRetornarElMayoresValores5Cifras() {
			
			Usuario diego = new Usuario(1, "Diego");
			Usuario alexiz = new Usuario(2, "Alexiz");
			Usuario daniel = new Usuario(3, "Daniel");
			
			Oferta oferta1 = new Oferta(diego, 34021.00);
			Oferta oferta2 = new Oferta(alexiz, 56024.00);
			Oferta oferta3 = new Oferta(daniel, 77041.00);
			
			Subasta subasta = new Subasta("Auto");
			subasta.propone(oferta1);
			subasta.propone(oferta2);
			subasta.propone(oferta3);
			
			Evaluador evaluador = new Evaluador();
			evaluador.evalua(subasta);
			System.out.println(evaluador.getMayorQueTodos());
			System.out.println(evaluador.getMenorQueTodos());
																//param. Operador Delta-Redondeo a entero un decimal//
			Assert.assertEquals(77041, evaluador.getMayorQueTodos(), 0.00001);
			Assert.assertEquals(34021, evaluador.getMenorQueTodos(), 0.00001);
			
	}
		
		@Test
		public void MayoresTresOfertas() {
			Usuario Alejandria = new Usuario("Alejandria");
			Usuario Alejandro = new Usuario("Alejandro");
			Usuario Alejo = new Usuario("Alejo");
			Usuario Martes = new Usuario("Martes");
			Usuario carla = new Usuario("Carla");
			
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
		@Test
		public void ComprenderValoresOfertaAleatoriamente() {
			
			Usuario Alejandria = new Usuario("Alejandria");
			Usuario Alejandro = new Usuario("Alejandro");
			Usuario Alejo = new Usuario("Alejo");
			Usuario Martes = new Usuario("Martes");
			Usuario carla = new Usuario("Carla");
			
			Oferta ofertaMartes = new Oferta(Martes, 32457.00);
			Oferta ofertaAlejandro = new Oferta(Alejandro, 15478.00);
			Oferta ofertaAlejo = new Oferta(Alejo, 45478.00);
			Oferta ofertaAlejandria = new Oferta(Alejandria, 54712.00);
			Oferta ofertaCarla = new Oferta(carla, 32564.00);
			
			Subasta audifonos = new Subasta("Audifonos inalambricos");
			audifonos.propone(ofertaAlejandria);
			audifonos.propone(ofertaAlejo);
			audifonos.propone(ofertaMartes);
			audifonos.propone(ofertaAlejandro);
			audifonos.propone(ofertaCarla);
			
			Evaluador evaluador = new Evaluador();
					evaluador.evalua(audifonos);
			
			Assert.assertEquals(evaluador.getOfertasMayores() < , false);
		}
}
