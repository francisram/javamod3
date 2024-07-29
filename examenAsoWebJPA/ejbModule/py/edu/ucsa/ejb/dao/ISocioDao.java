package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Socio;



public interface ISocioDao extends IGenericDao<Long, Socio>{
	Socio getSocioByNroCedula(String nroCedula);


	
}
