package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.IMenuDao;
import py.edu.ucsa.ejb.entities.Menu;

public class MenuDaoImpl extends AbstractDao<Long, Menu> implements IMenuDao {

	
	public MenuDaoImpl() {
		super(Menu.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Menu> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Menu findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Menu insert(Menu entity) {
		// TODO Auto-generated method stub
		return super.insert(entity);
	}

	@Override
	public Menu update(Menu entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(Menu entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
