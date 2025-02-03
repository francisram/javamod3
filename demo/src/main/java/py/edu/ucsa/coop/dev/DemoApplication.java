package py.edu.ucsa.coop.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import py.edu.ucsa.coop.dev.config.CoopDevDataSourceConfiguration;

@SpringBootApplication(scanBasePackages = {
		"py.edu.ucsa.coope.dev.core.dao",
		"py.edu.ucsa.coope.dev.core.services",
		"py.edu.ucsa.coope.dev.web.controllers",
		"py.edu.ucsa.coope.dev.web.security"})
@Import(CoopDevDataSourceConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
