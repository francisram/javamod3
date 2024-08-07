package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Dominio;
import py.edu.ucsa.ejb.entities.Opcion;



public interface IOpcionDao extends IGenericDao<Long, Opcion>{
	

	Opcion getOpcionByDominioCodOpcion(String dominio,String codOpcion);
	Iterable<Opcion> getOpcionesByIdDominio(Dominio dominio);


	
}
