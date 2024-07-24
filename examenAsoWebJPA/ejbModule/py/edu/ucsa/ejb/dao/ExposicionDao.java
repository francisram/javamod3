package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Exposicion;



public interface ExposicionDao extends IGenericDao<Long, Exposicion> {
	
	List<Exposicion> listarPorFechas(String fechaInicial , String fechaFinal);

}
