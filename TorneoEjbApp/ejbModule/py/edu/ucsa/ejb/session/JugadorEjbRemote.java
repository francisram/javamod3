package py.edu.ucsa.ejb.session;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Jugador;

@Remote
public interface JugadorEjbRemote extends GenericEjbRemote<Jugador>{
	
	public Jugador getByNombre(String nombre);

}
