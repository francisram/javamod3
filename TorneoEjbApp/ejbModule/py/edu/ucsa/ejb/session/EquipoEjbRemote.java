package py.edu.ucsa.ejb.session;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.entities.Equipo;

@Remote
public interface EquipoEjbRemote extends GenericEjbRemote<Equipo> {

	public Equipo getByNombre(String nombre);

}
