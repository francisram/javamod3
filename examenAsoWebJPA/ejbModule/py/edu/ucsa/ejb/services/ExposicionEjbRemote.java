package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.ExposicionDTO;
import py.edu.ucsa.ejb.entities.Exposicion;

@Remote
public interface ExposicionEjbRemote extends GenericEjbRemote<Long, ExposicionDTO> {
	Iterable<ExposicionDTO> listarPorFechas(String fechaInicial , String fechaFinal);
}
