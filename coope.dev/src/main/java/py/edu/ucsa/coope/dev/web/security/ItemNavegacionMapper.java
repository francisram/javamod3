package py.edu.ucsa.coope.dev.web.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;
import py.edu.ucsa.coope.dev.web.security.entities.ItemNavegacion;

public class ItemNavegacionMapper {

	public static List<ItemNavegacionDto> mapToDtoList(List<ItemNavegacion> items) {
		List<ItemNavegacionDto> groups = items.stream()
								.filter(item -> "group".equals(item.getType()))
								.map(ItemNavegacion::toDto)
								.collect(Collectors.toList());
		
		Map<String, List<ItemNavegacionDto>> childrenByParentID = items.stream()
				.filter(item -> "basic".equals(item.getType()))
				.map(ItemNavegacion::toDto)
				.collect(Collectors.groupingBy(ItemNavegacionDto::getIdPadre));
		
		groups.forEach(group -> {
			List<ItemNavegacionDto> children = childrenByParentID.get(group.getId());
			group.setChildren(children != null ? children : new ArrayList<>() );
		}); 
		
		
		return groups;
	}

}
