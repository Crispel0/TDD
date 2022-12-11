package Builder;

import col.com.subasta.dominio.Oferta;
import col.com.subasta.dominio.Subasta;
import col.com.subasta.dominio.Usuario;

//BUILDER PATTERN
public class ConstruirSubasta {

	Subasta subasta;
	
	//Metodo constructor crea una subasta y asigna a atributo subasta
	public ConstruirSubasta para(String cosa) {
		this.subasta = new Subasta(cosa);
		return this;
	}
	
	//Metodo constructor crea una oferta y asigna a atributo subasta
	public ConstruirSubasta oferta (Usuario usuario, double valor) {
		this.subasta.propone(new Oferta(usuario, valor));
		return this;
	}
	 //retorna todo construido
	public Subasta Creador() {
		return this.subasta;
		
	}
}
