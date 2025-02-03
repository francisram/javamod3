package py.edu.ucsa.coope.dev.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PaginationDto {

	
	private int length;
	private int size;
	private int page;
	private int lastPage;
	private int startIndex;
	private int endIndex;
	
}
