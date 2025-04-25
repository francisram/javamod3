package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import py.edu.ucsa.coope.dev.web.security.entities.Usuario;



public interface BaseEntity extends Serializable {

	public Timestamp getFechaAlta();
	public void setFechaAlta(Timestamp fechaAlta);
	
	public Timestamp getFechaModificacion();
	public void setFechaModificacion(Timestamp fechaModificacion);
	
	public Usuario getUsuarioAlta(); 
	public void setUsuarioAlta(Usuario usuarioAlta);
	
	public Usuario getUsuarioModificacion(); 
	public void setUsuarioModificacion(Usuario usuarioModificacion);
	
	
	
}
