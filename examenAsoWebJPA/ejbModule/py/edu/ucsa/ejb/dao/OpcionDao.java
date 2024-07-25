package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Opcion;



public interface OpcionDao extends IGenericDao<Long, Opcion>{
	

	Opcion getOpcionByDominioCodOpcion(String dominio,String codOpcion);
	Iterable<Opcion> getOpcionesByCodDominio(String dominio);
	Iterable<Opcion> getOpcionesByIdDominio(Integer idDominio);


	
}
