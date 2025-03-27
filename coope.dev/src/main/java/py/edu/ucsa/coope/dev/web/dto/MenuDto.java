package py.edu.ucsa.coope.dev.web.dto;

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
public class MenuDto extends BaseDtoWithId {

	private static final long serialVersionUID = -6949187509263764703L;

	private String codigoMenu;
	private String icon;
	private String nombreMenu;
	private String subtitle;
	private String title;
	private String type;
	private String url;
	private MenuDto menuPadre;	
}