package py.edu.ucsa.ejb.session;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Torneo;

@Remote
public interface TorneoEjbRemote extends GenericEjbRemote<Torneo>{
	public Torneo getByNombre (String nombre);
}
