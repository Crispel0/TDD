package col.com.subasta.dominio.TestJunit;


import org.junit.Before;

import org.junit.Test;

import Builder.ConstruirSubasta;
import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


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
		assertThat(evaluador.getMayorQueTodos(), equalTo(450000.0));
		assertThat(evaluador.getMenorQueTodos(), equalTo(250000.0));
	}
	
		@Test
		public void deberiaRetornarElMayoresValores5Cifras() {
			
			Evaluador evaluador = new Evaluador();
			evaluador.evalua(subasta);
			System.out.println(evaluador.getMayorQueTodos());
			System.out.println(evaluador.getMenorQueTodos());
																//param. Operador Delta-Redondeo a entero un decimal//
			assertThat(evaluador.getMayorQueTodos(), equalTo(450000.0));
			assertThat(evaluador.getMenorQueTodos(), equalTo(250000.0));
			
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
			
			
			assertThat(evaluador.getOfertasMayores().size(), equalTo(3));
			assertThat(evaluador.getOfertasMayores().get(0).getValor(), equalTo(250000.0));
			assertThat(evaluador.getOfertasMayores().get(1).getValor(), equalTo(300000.0));
			assertThat(evaluador.getOfertasMayores().get(2).getValor(), equalTo(450000.0));
		}
		
		
		
	}
