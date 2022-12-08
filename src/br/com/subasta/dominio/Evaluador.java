package br.com.subasta.dominio;
/*
 * Evalua las pujas de acuerdo a su maximo y minimo valor
 */
public class Evaluador {
	
	//Determina cual es la mayor y menos subasta en casos hipoteticos//
	
	//calcula la puja mas baja comenzando desde el valor mas alto pujado
	private double MenorQueTodos = Double.POSITIVE_INFINITY; 
	//calcula la puja mas grande comenzando desde el valor mas bajo pujado
	private double MayorQueTodos = Double.NEGATIVE_INFINITY; 
	
	//Evalua la mayor y menor subasta de acuerdo a las pujas//
	public void Evaluar(Subasta subasta) {
		for(Oferta oferta: subasta.getOfertas()) { //recorre cada oferta y guarda en variable oferta//
			/*si la oferta que se ofrece es mayor que todos se determina y se guarda esta oferta en MayorQueTodos*/
			
			if(oferta.getValor() > MayorQueTodos) { 
				MayorQueTodos += oferta.getValor(); 
			}
			/*si la oferta que se ofrece es menor que todos se determina y se guarda esta oferta en MenorQueTodos*/
			else { if(oferta.getValor() < MenorQueTodos) { 
					MenorQueTodos += oferta.getValor();
				}
			}
		}			
	}

	public double getMenorQueTodos() {
		return MenorQueTodos;
	}

	public double getMayorQueTodos() {
		return MayorQueTodos;
	}
}	
		
