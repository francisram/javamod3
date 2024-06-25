package py.edu.ucsa.ejb.session.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.session.PartidoEjbRemote;

/**
 * Session Bean implementation class PartidoEjbImpl
 */
@Stateless
@LocalBean
public class PartidoEjbImpl implements PartidoEjbRemote {
	
	private List<Partido> listaPartidos = new ArrayList<Partido>();

	@Override
	public List<Partido> listar() {
		// TODO Auto-generated method stub
		return listaPartidos;
	}

	@Override
	public Partido getById(Integer id) {
		Partido p = new Partido();
		if (id != null) {
			for (Partido partido : listaPartidos) {
				if (id.equals(partido.getId())) {
					p = partido;
					break;
				}
			}
		}
		return p;
	}

	@Override
	public Partido insertar(Partido obj) {
		Partido e = new Partido();
		if (!Objects.isNull(obj)) {
			Partido eq = getById(obj.getId());
			if (eq.getId() == 0) {
				listaPartidos.add(obj);
				e = obj;
			}
		}
		return e;
	}

	@Override
	public void actualizar(Partido obj) {
		if (!Objects.isNull(obj)) {
			for (int i = 0 ; i <listaPartidos.size(); i++) {
				if(listaPartidos.get(i).getId() == obj.getId()) {
					listaPartidos.set(i, obj);
					break;
				}
			}
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		if (!Objects.isNull(id)) {
			for (int i = 0 ; i <listaPartidos.size(); i++) {
				if(listaPartidos.get(i).getId() == id) {
					listaPartidos.remove(i);
					break;
				}
			}
		}
		
	}

  

}
