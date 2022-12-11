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
		//obtiene cada oferta segun la List<Oferta>;
		int total = getTotalOfertas(oferta.getUsuario(), ofertas);
		if (ofertas.isEmpty() || 
		ElMismoUsuarioAnterior(oferta.getUsuario()) && total < 5) {
		ofertas.add(oferta);}
			
	}
	//Encontrar la ultima oferta hecha por el usuario y crear una nueva oferta al doble de la anterior.
	public void DuplicarOferta(Usuario usuario) {
		Oferta ultimaOferta = getUltimaOferta(usuario);
		if((ultimaOferta != null)) { //si no es null entonces crea una instancia de Oferta y multiplica su valor//
		propone(new Oferta(usuario, ultimaOferta.getValor() * 2)); //agrega la oferta anterior y la actual duplicando su valor
	}
	}
	
	private Oferta getUltimaOferta(Usuario usuario) {
		Oferta ultimaOferta = null;
		for(Oferta oferta : ofertas) { //itera por cada oferta de List y compara la oferta con la que se pasa por parametros
			if(oferta.getUsuario().equals(usuario)); 
			ultimaOferta = oferta; //si es igual se guarda en ultimaOferta
		}
		return ultimaOferta;
	}
	
	private int getTotalOfertas(Usuario usuario, List<Oferta> ofertas) {
		int total = 0;
		for(Oferta listaOfertas: ofertas) { 
			if(listaOfertas.getUsuario().equals(usuario)) {
				total ++;
			} 
	}
		return total;
		
	}
	
	private boolean ElMismoUsuarioAnterior(Usuario usuario) {
		return !ofertas.get(ofertas.size()-1).getUsuario().equals(usuario);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Oferta> getOfertas() {
		return Collections.unmodifiableList(ofertas);
	}

}
