package col.com.subasta.dominio.TestJunit;

import org.junit.Before;
import org.junit.Test;

import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
import junit.framework.Assert;

public class TestJunitEvaluador {
	
	private Subasta subasta;
	
	@Before
	public void  prepararEscenario() {
		
		Usuario diego = new Usuario(1, "Diego");
		Usuario alexiz = new Usuario(2, "Alexiz");
		Usuario daniel = new Usuario(3, "Daniel");
		
		Oferta oferta1 = new Oferta(diego, 2456841.00);
		Oferta oferta2 = new Oferta(alexiz, 2454531.00);
		Oferta oferta3 = new Oferta(daniel, 1457612.00);
		
		Subasta subasta = new Subasta("Auto");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		subasta.propone(oferta3);
		
		this.subasta = subasta;
		
	}
	
	@Test
	public void deberiaRetornarElMayorValor() {
		
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
		System.out.println(evaluador.getMayorQueTodos());
		System.out.println(evaluador.getMenorQueTodos());
		
		//El parametro delta es usado para redondear el valor double 0.00001
		Assert.assertEquals(2456841, evaluador.getMayorQueTodos(),0.00001);
		Assert.assertEquals(1457612, evaluador.getMenorQueTodos(),0.00001);
		
	}
	
		@Test
		public void deberiaRetornarElMayoresValores5Cifras() {
			
			Evaluador evaluador = new Evaluador();
			evaluador.evalua(subasta);
			System.out.println(evaluador.getMayorQueTodos());
			System.out.println(evaluador.getMenorQueTodos());
																//param. Operador Delta-Redondeo a entero un decimal//
			Assert.assertEquals(2456841, evaluador.getMayorQueTodos(), 0.00001);
			Assert.assertEquals(1457612, evaluador.getMenorQueTodos(), 0.00001);
			
	}

}
