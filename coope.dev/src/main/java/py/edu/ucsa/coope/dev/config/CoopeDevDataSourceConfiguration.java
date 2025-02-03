package py.edu.ucsa.coope.dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "coopeDevEntityManagerFactory",
		transactionManagerRef = "coopeDevTransactionManager",
		basePackages = {"py.edu.ucsa.coope.dev.core.dao"}
		)
public class CoopeDevDataSourceConfiguration {
	
	@Bean(name = "coopeDevProperties")
	@ConfigurationProperties("spring.datasource.coopedev")
	public DataSourceProperties coopDevProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "coopeDevDatasource" )
	@ConfigurationProperties(prefix = "spring.datasource.coopedev")
	public DataSource coopDevDataSource(@Qualifier("coopeDevProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}
	
	@Bean(name = "coopeDevEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean coopDevEntityMangerFactory(
			EntityManagerFactoryBuilder builder ,@Qualifier("coopeDevDatasource") DataSource dataSource
			) {
				return builder.dataSource(dataSource).packages("py.edu.ucsa.coope.dev.core.entities")
						.persistenceUnit("coopedev-pu")
						.build();
	}
	
	@Primary
	@Bean(name = "coopeDevTransactionManager")
	@ConfigurationProperties("spring.jpa.coopedev")
	public PlatformTransactionManager coopDevTransactionManager(
			@Qualifier("coopeDevEntityManagerFactory")
			EntityManagerFactory entityManagerFactory
			) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}

}
