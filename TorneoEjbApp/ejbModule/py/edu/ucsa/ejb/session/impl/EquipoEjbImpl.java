package py.edu.ucsa.ejb.session.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.session.EquipoEjbRemote;

/**
 * Session Bean implementation class EquipoEjbImpl
 */
@Stateless
@LocalBean
public class EquipoEjbImpl implements EquipoEjbRemote {
	
	private List<Equipo> listaEquipos = new ArrayList<>();

	@Override
	public List<Equipo> listar() {
		return listaEquipos;
	}



	@Override
	public Equipo insertar(Equipo obj) {
		Equipo e = new Equipo();
		if (!Objects.isNull(obj)) {
			Equipo eq = getById(obj.getId());
			if (eq.getId() == 0) {
				listaEquipos.add(obj);
				e = obj;
			}
		}
		return e;
	}

	@Override
	public void actualizar(Equipo obj) {
		if (!Objects.isNull(obj)) {
			for (int i = 0 ; i <listaEquipos.size(); i++) {
				if(listaEquipos.get(i).getId() == obj.getId()) {
					listaEquipos.set(i, obj);
					break;
				}
			}
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		if (!Objects.isNull(id)) {
			for (int i = 0 ; i <listaEquipos.size(); i++) {
				if(listaEquipos.get(i).getId() == id) {
					listaEquipos.remove(i);
					break;
				}
			}
		}
		
	}

	@Override
	public Equipo getByNombre(String nombre) {
		Equipo e = new Equipo();
		if (nombre != null) {
			for (Equipo equipo : listaEquipos) {
				if (equipo.getNombre() == nombre) {
					e = equipo;
					break;
				}
			}
		}
		return e;
	}



	@Override
	public Equipo getById(Integer id) {
		Equipo e = new Equipo();
		if (id != null) {
			for (Equipo equipo : listaEquipos) {
				if (id.equals(equipo.getId())) {
					e = equipo;
					break;
				}
			}
		}
		return e;
	}



}
