package py.edu.ucsa.ejb.dao.impl;

import java.util.Objects;

import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;

@RequestScoped
@Named("jugadorDAO")
public class JugadorDaoImpl extends AbstractDao<Long, Jugador>  implements IJugadorDao{

	public JugadorDaoImpl() {
		super(Jugador.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Jugador> findByNombre(String nombre, boolean isNull) {
		boolean isBlank = Objects.isNull(nombre) || nombre.isBlank();
		String hql = "SELECT NEW Jugador(j.id,j.nroFicha , j.nombre , j.apellido ,j.nacionalidad)" 
				+ ((isBlank && !isNull) ? "" : "where"
				+ (!isBlank ? "e.nombre LIKE : nombre" : "")
				+ (!isBlank && isNull ? "AND" : "")
				+(isNull? "e.equipo IS NULL" : "" ));
		Query query = this.entityManager.createQuery(hql, Jugador.class);
		if(!isBlank) {
			query.setParameter("nombre","%"+ nombre +"%" );
		}
		return query.getResultList();
	}

}
