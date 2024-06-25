package py.edu.ucsa.ejb.session.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.session.TorneoEjbRemote;

/**
 * Session Bean implementation class TorneoEjbImpl
 */
@Stateless
@LocalBean
public class TorneoEjbImpl implements TorneoEjbRemote {
	
	private List<Torneo> listaTorneos = new ArrayList<Torneo>();

    /**
     * Default constructor. 
     */
    public TorneoEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Torneo> listar() {
		// TODO Auto-generated method stub
		return listaTorneos;
	}

	@Override
	public Torneo getById(Integer id) {
		Torneo p = new Torneo();
		if (id != null) {
			for (Torneo t : listaTorneos) {
				if (id.equals(t.getId())) {
					p = t;
					break;
				}
			}
		}
		return p;
	}

	@Override
	public Torneo insertar(Torneo obj) {
		
		Torneo e = new Torneo();
		if (!Objects.isNull(obj)) {
			Torneo eq = getById(obj.getId());
			if (eq.getId() == 0) {
				listaTorneos.add(obj);
				e = obj;
			}
		}
		return e;
	}

	@Override
	public void actualizar(Torneo obj) {
		if (!Objects.isNull(obj)) {
			for (int i = 0 ; i <listaTorneos.size(); i++) {
				if(listaTorneos.get(i).getId() == obj.getId()) {
					listaTorneos.set(i, obj);
					break;
				}
			}
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		if (!Objects.isNull(id)) {
			for (int i = 0 ; i <listaTorneos.size(); i++) {
				if(listaTorneos.get(i).getId() == id) {
					listaTorneos.remove(i);
					break;
				}
			}
		}
		
	}

	@Override
	public Torneo getByNombre(String nombre) {
		Torneo j = new Torneo();
		if(!Objects.isNull(nombre)) {
			for (int i = 0; i < listaTorneos.size(); i++) {
				if(listaTorneos.get(i).getNombre() == nombre) {
					j = listaTorneos.get(i);					
				}
			}
		}
		return j;
	}

}
