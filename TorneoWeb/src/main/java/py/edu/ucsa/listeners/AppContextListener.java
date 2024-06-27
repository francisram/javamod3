package py.edu.ucsa.listeners;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.session.impl.EquipoEjbImpl;
import py.edu.ucsa.ejb.session.impl.JugadorEjbImpl;
import py.edu.ucsa.ejb.session.impl.PartidoEjbImpl;
import py.edu.ucsa.ejb.session.impl.TorneoEjbImpl;

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
		
		
		EquipoEjbImpl eImpl = new EquipoEjbImpl();
		JugadorEjbImpl jImpl = new JugadorEjbImpl();
		PartidoEjbImpl pImpl = new PartidoEjbImpl();
		TorneoEjbImpl tImpl = new TorneoEjbImpl();
        Jugador j = new Jugador();
        j.setId(1);
        j.setNombres("francis");
        j.setApellidos("lopez");
        Equipo e = new Equipo();
        e.setId(1);
        e.setNombre("rayadito");
        j.setEquipo(e);
        j.setNacionalidad("paraguayo");
        
        jImpl.insertar(j);
        
        sce.getServletContext().setAttribute("equipos", eImpl.listar());
        sce.getServletContext().setAttribute("jugadores", jImpl.listar());
        sce.getServletContext().setAttribute("partidos", pImpl.listar());
        sce.getServletContext().setAttribute("torneos", tImpl.listar());
        
		//ServletContextListener.super.contextInitialized(sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
