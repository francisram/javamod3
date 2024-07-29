package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Exposicion;



public interface IExposicionDao extends IGenericDao<Long, Exposicion> {
	
	Iterable<Exposicion> listarPorFechas(String fechaInicial , String fechaFinal);

}
