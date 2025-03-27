package py.edu.ucsa.coope.dev.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDtoWithId extends BaseDto {
	
	private static final long serialVersionUID = 6180751715331916942L;

	private Long id;
}
