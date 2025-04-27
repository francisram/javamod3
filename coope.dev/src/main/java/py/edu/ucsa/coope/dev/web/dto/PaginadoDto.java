package py.edu.ucsa.coope.dev.web.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaginadoDto<T> {

	private PaginationDto pagination;
	private List<T> data;
}
