package br.com.subasta.dominio;

public class Evaluador {
	
	private double mayorQueTodos = Double.NEGATIVE_INFINITY;
	private double menorQueTodos = Double.POSITIVE_INFINITY;
	
	public void evalua(Subasta subasta) {
		for (Oferta oferta : subasta.getOfertas()) {
			if (oferta.getValor() > mayorQueTodos) {
				mayorQueTodos = oferta.getValor();
			} 
				if(oferta.getValor() < menorQueTodos) {
					menorQueTodos = oferta.getValor();
				}
			}
		}
	

	public double getMayorQueTodos() {
		return mayorQueTodos;
	}

	public double getMenorQueTodos() {
		return menorQueTodos;
	}
	
	

}
