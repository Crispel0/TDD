package col.com.subasta.dominio.TestJunit;

import org.junit.Test;

import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
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

}
