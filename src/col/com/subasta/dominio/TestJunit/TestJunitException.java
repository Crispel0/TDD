package col.com.subasta.dominio.TestJunit;

import org.junit.Test;

import Builder.ConstruirSubasta;
import col.com.subasta.dominio.Evaluador;
import col.com.subasta.dominio.Subasta;

public class TestJunitException {

	@Test(expected = RuntimeException.class) //Propiedad para capturar una exception de la annotation @Test
	public void debeRetornarExceptionSubastaVacia() {
		
		Subasta subasta = new ConstruirSubasta().para("Computador Hp").Creador();
		
		Evaluador evaluar = new Evaluador();
		evaluar.evalua(subasta);
	}
}
