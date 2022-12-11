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
		Assert.assertEquals(450000, evaluador.getMayorQueTodos(),0.00001);
		Assert.assertEquals(250000, evaluador.getMenorQueTodos(),0.00001);
		
	}
	
		@Test
		public void deberiaRetornarElMayoresValores5Cifras() {
			
			Evaluador evaluador = new Evaluador();
			evaluador.evalua(subasta);
			System.out.println(evaluador.getMayorQueTodos());
			System.out.println(evaluador.getMenorQueTodos());
																//param. Operador Delta-Redondeo a entero un decimal//
			Assert.assertEquals(450000, evaluador.getMayorQueTodos(), 0.00001);
			Assert.assertEquals(250000, evaluador.getMenorQueTodos(), 0.00001);
			
	}
		
		
		@Test
		public void MayoresTresOfertas() {
			
			this.subasta = subasta = new ConstruirSubasta().para("Bicicleta").oferta(new Usuario("diego"), 250000).
					oferta(new Usuario("Alexis"), 300000).
					oferta(new Usuario("daniel"), 450000).
					oferta(new Usuario("Martes"), 500000).
					oferta(new Usuario("Carla"), 600000).
					Creador();
			
			Evaluador evaluador = new Evaluador();
			evaluador.evalua(subasta);
			
			Assert.assertEquals(evaluador.getOfertasMayores().size(), 3);
			Assert.assertEquals(evaluador.getOfertasMayores().get(1).getValor(), 300000.00);
			Assert.assertEquals(evaluador.getOfertasMayores().get(2).getValor(), 450000.00);
			Assert.assertEquals(evaluador.getOfertasMayores().get(3).getValor(), 500000.00);
		}
		
	}
