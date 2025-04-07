package py.edu.ucsa.coope.dev.web.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.OperacionesXItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.security.entities.ItemNavegacion;
import py.edu.ucsa.coope.dev.web.security.entities.OperacionesXItemNavegacion;

public class OperacionesXItemNavegacionMapper {

	public static List<OperacionesXItemNavegacionDto> mapToDtoList(List<OperacionesXItemNavegacion> items){
		List<OperacionesXItemNavegacionDto> groups = items.stream().filter(item -> "group".equals(item.getItemNavegacion() ))
				.map(OperacionesXItemNavegacion::toDto)
				.collect(Collectors.toList());
		/*
		Map<String, List<OperacionesXItemNavegacionDto>> childrenByParentId = items.stream()
				.filter( item -> "basic".equals(item.getItemNavegacion()))
				.map(OperacionesXItemNavegacion::toDto)
				.collect(Collectors.groupingBy(OperacionesXItemNavegacionDto::getIdPadre));
		
		groups.forEach(group -> {List<OperacionesXItemNavegacionDto> children = childrenByParentId.get(group.getId());
		group.setChildren(children != null ? children : new ArrayList<>());
		});
		*/
		
		return groups;
	}

}
