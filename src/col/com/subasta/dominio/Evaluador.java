package col.com.subasta.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Evaluador {
	
	private double mayorQueTodos = Double.NEGATIVE_INFINITY;
	private double menorQueTodos = Double.POSITIVE_INFINITY;
	private List<Oferta> ofertasMayores = new ArrayList<Oferta>(); //Crea ArrayList de Ofertas//
	
	
	public void evalua(Subasta subasta) {
		for (Oferta oferta : subasta.getOfertas()) {
			if (oferta.getValor() > mayorQueTodos) {
				mayorQueTodos = oferta.getValor();
			} 
			if(oferta.getValor() < menorQueTodos) {
					menorQueTodos = oferta.getValor();
				}
			}
		// asigna todas las ofertas por un ArrayList a ofertasMayores
		ofertasMayores = new ArrayList<>(subasta.getOfertas());
		//sorteo de las ofertas y comparacion entre una oferta y otra//
		Collections.sort(ofertasMayores , new Comparator<Oferta>() {
			@Override
			public int compare(Oferta oferta1, Oferta oferta2) {
				if(oferta1.getValor() < oferta2.getValor()) {
					return -1; //si la primera oferta es mayor que la oferta 2 retorname -1//
				}else if(oferta1.getValor() > oferta2.getValor()) {
					return 1; //por el contrario retorname 1//
				}
				
				return 0; //si son iguales retorname 0//			
			}});
																							
		ofertasMayores = ofertasMayores.subList(0, 3); //toma el la primerOferta por indice//
		}
	
	
	public double getMayorQueTodos() {
		return mayorQueTodos;
	}

	public double getMenorQueTodos() {
		return menorQueTodos;
	}


	public List<Oferta> getOfertasMayores() {
		return ofertasMayores;
	}	
	
	
	
}
