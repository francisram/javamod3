package py.edu.ucsa.ejb.dao;

import py.edu.ucsa.ejb.entities.MontoCuota;

public interface MontoCuotaDao extends IGenericDao<Long, MontoCuota> {
	MontoCuota getMontoCuotaByAnho(int mes,int anho);
}
