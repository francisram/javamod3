package py.edu.ucsa.coope.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import py.edu.ucsa.coope.dev.config.CoopeDevDataSourceConfiguration;

@SpringBootApplication(scanBasePackages = { "py.edu.ucsa.coope.dev.core.dao", "py.edu.ucsa.coope.dev.core.services",
		 "py.edu.ucsa.coope.dev.web", "py.edu.ucsa.coope.dev.web.security", })
@Import(CoopeDevDataSourceConfiguration.class)
public class CoopeDevApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CoopeDevApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CoopeDevApplication.class);
	}

}