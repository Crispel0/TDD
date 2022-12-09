package col.com.subasta.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subasta {

	private String descripcion;
	private List<Oferta> ofertas;
	
	public Subasta(String descripcion) {
		this.descripcion = descripcion;
		this.ofertas = new ArrayList<Oferta>();
	}
	
	public void propone(Oferta oferta) {
		int total = 0;
		for(Oferta listaOfertas: ofertas) { //si mi Ofertas es igual a oferta parametro entonces agrega suma al total;
			if(listaOfertas.getUsuario().equals(oferta.getUsuario())) {
				total ++;
			} 
			
		}
		
		//si la oferta esta vacia o el usuario actual es diferente del usuario anterior agregalo y es menos a 5 el total//
		if(ofertas.isEmpty() || ofertas.get(ofertas.size()-1).getUsuario().equals(oferta.getUsuario()) && total < 5){
		ofertas.add(oferta);}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Oferta> getOfertas() {
		return Collections.unmodifiableList(ofertas);
	}

}
