package py.edu.ucsa.coope.dev.web.dto.usuarios;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.BaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemNavegacionDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = -7250840206491910002L;

	private String id;
	private String title;
	private String subtitle;
	private String type;
	private Boolean hidden;
	private Boolean active;
	private Boolean disabled;
	private String tooltip;
	private String link;
	private String target;
	private String badgeTitle;
	private String badgeClasses;
	private String icon;
	private String idPadre;
	private List<ItemNavegacionDto> children;
	
	
}