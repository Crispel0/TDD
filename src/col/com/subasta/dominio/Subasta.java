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
