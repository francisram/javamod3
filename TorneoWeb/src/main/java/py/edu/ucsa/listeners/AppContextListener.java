package py.edu.ucsa.listeners;

import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.services.impl.EquipoEjbImpl;
import py.edu.ucsa.ejb.services.impl.JugadorEjbImpl;
import py.edu.ucsa.ejb.services.impl.PartidoEjbImpl;
import py.edu.ucsa.ejb.services.impl.TorneoEjbImpl;


/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
public class AppContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppContextListener() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		/*
		//EquipoEjbImpl eImpl = new EquipoEjbImpl();
		JugadorEjbImpl jImpl = new JugadorEjbImpl();
		//PartidoEjbImpl pImpl = new PartidoEjbImpl();
		//TorneoEjbImpl tImpl = new TorneoEjbImpl();
        JugadorDTO j = new JugadorDTO();
        j.setId(1L);
        j.setNombres("francis");
        j.setApellidos("lopez");
        EquipoDTO e = new EquipoDTO();
        e.setId(1L);
        e.setNombre("rayadito");
        j.setEquipo(e);
        j.setNacionalidad("paraguayo");
        
        try {
			jImpl.insert(j);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			List<JugadorDTO> jugadores = jImpl.findAll();
			sce.getServletContext().setAttribute("jugadores", jugadores);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
        /*
        sce.getServletContext().setAttribute("equipos", eImpl.listar());
        sce.getServletContext().setAttribute("partidos", pImpl.listar());
        sce.getServletContext().setAttribute("torneos", tImpl.listar());
        */
		//ServletContextListener.super.contextInitialized(sce);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
