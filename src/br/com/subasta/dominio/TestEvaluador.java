package br.com.subasta.dominio;

public class TestEvaluador {
	public static void main(String[] args) {
	
		Usuario Crispelo = new Usuario("Crispelo");
		Usuario Crispelo2 = new Usuario("Crispelo2");
		
		Oferta offer = new Oferta(Crispelo, 300000);
		Oferta offer2 = new Oferta(Crispelo2, 40000);
		
		Subasta subas = new Subasta("Reloj Casio");
		subas.propone(offer);
		subas.propone(offer2);
		
		Evaluador evaluar = new Evaluador();
		evaluar.Evaluar(subas);
		
		System.out.println(evaluar.getMayorQueTodos());
		System.out.println(evaluar.getMayorQueTodos());
}
}
