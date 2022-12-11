package col.com.subasta.dominio.TestJunit;

import org.junit.Before;
import org.junit.Test;

import Builder.ConstruirSubasta;
import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
import junit.framework.Assert;

public class TestJunitEvaluador {
	
	private Subasta subasta;
	
	@Before
	public void  prepararEscenario() {
		
		this.subasta = subasta = new ConstruirSubasta().para("Bicicleta").oferta(new Usuario("diego"), 250000).
				oferta(new Usuario("Alexis"), 300000).
				oferta(new Usuario("daniel"), 450000).
				Creador();
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
