package py.edu.ucsa.ejb.dao.impl;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IExposicionDao;
import py.edu.ucsa.ejb.entities.Exposicion;

@RequestScoped
@Named("exposicionDao")
public class ExposicionDaoImpl extends AbstractDao<Long, Exposicion> implements IExposicionDao {

	
	public ExposicionDaoImpl() {
		super(Exposicion.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Iterable<Exposicion> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Exposicion findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Exposicion insert(Exposicion entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Exposicion update(Exposicion entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Exposicion entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Exposicion> listarPorFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
				
		return this.entityManager.createNamedQuery("Exposicion.listarPorFechas")
				.setParameter("fechaInicio", fechaInicial)
				.setParameter("fechaFin", fechaFinal)
				.getResultList();
	}

}
