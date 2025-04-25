package py.edu.ucsa.coope.dev;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import py.edu.ucsa.coope.dev.config.CoopeDevDataSourceConfiguration;

@SpringBootApplication(scanBasePackages = { 
		"py.edu.ucsa.coope.dev.core.dao",
		"py.edu.ucsa.coope.dev.core.services",
		"py.edu.ucsa.coope.dev.web",
		"py.edu.ucsa.coope.dev.core.entities",
		"py.edu.ucsa.coope.dev.web.security.entities"
		,"py.edu.ucsa.coope.dev.web.security.repo"
		
		})
@EnableJpaRepositories(basePackages = {
	    "py.edu.ucsa.coope.dev.core.repositories",
	    "py.edu.ucsa.coope.dev.web.security.repo"
	})
@EntityScan(basePackages = "py.edu.ucsa.coope.dev.core.entities")
@Import(CoopeDevDataSourceConfiguration.class)
public class CoopeDevApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CoopeDevApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder.sources(CoopeDevApplication.class);
	}


}