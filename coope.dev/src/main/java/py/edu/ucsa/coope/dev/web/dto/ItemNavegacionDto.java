package py.edu.ucsa.coope.dev.web.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemNavegacionDto extends BaseDto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;
	private String title;
	private String subTitle;
	private String type;
	private boolean active;
	private boolean hidden;
	private boolean disabled;
	private String toolTip;
	private String link;
	private String target;
	private String badgeTitle;
	private String badgeClasses;
	private String icon;
	private String idPadre;
	private List<ItemNavegacionDto> children;
	
	
	
	
}
