package py.edu.ucsa.coop.dev.config;

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
		entityManagerFactoryRef = "coopDevEntityManagerFactory",
		transactionManagerRef = "coopDevTransactionManager",
		basePackages = {"py.edu.ucsa.coop.dev.dao"}
		)
public class CoopDevDataSourceConfiguration {
	
	@Bean(name = "coopDevProperties")
	@ConfigurationProperties("spring.dataspurce.coopdev")
	public DataSourceProperties coopDevProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "coopDevDataSource" )
	@ConfigurationProperties(prefix = "spring.dataspurce.coopedev")
	public DataSource coopDevDataSource(@Qualifier("coopDevProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}
	
	@Bean(name = "coopDevEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean coopDevEntityMangerFactory(
			EntityManagerFactoryBuilder builder ,@Qualifier("coopDevDataSource") DataSource dataSource
			) {
				return builder.dataSource(dataSource).packages("py.edu.ucsa.coop.dev.core.entities")
						.persistenceUnit("coopdev-pu")
						.build();
	}
	
	@Primary
	@Bean(name = "coopDevTransactionManager")
	@ConfigurationProperties("spring.jpa.coopDev")
	public PlatformTransactionManager coopDevTransactionManager(
			@Qualifier("coopDevEntityManagerFactory")
			EntityManagerFactory entityManagerFactory
			) {
		return new JpaTransactionManager(entityManagerFactory);
		
	}

}
