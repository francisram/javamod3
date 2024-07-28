package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.MenuDTO;
import py.edu.ucsa.ejb.services.MenuEjbRemote;

/**
 * Session Bean implementation class MenuEjbImpl
 */
@Stateless(mappedName = "MenuEjb")
@LocalBean
public class MenuEjbImpl implements MenuEjbRemote {

    @Override
	public List<MenuDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MenuDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MenuDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(MenuDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Default constructor. 
     */
    public MenuEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
