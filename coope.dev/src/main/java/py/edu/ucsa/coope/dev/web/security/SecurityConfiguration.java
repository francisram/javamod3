package py.edu.ucsa.coope.dev.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.security.Request;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


import static py.edu.ucsa.coope.dev.web.security.Rol.ADMIN;
import static py.edu.ucsa.coope.dev.web.security.Rol.MANAGER;
import static py.edu.ucsa.coope.dev.web.security.Permiso.ADMIN_CREATE;
import static py.edu.ucsa.coope.dev.web.security.Permiso.ADMIN_DELETE;
import static py.edu.ucsa.coope.dev.web.security.Permiso.ADMIN_READ;
import static py.edu.ucsa.coope.dev.web.security.Permiso.ADMIN_UPDATE;
import static py.edu.ucsa.coope.dev.web.security.Permiso.MANAGER_CREATE;
import static py.edu.ucsa.coope.dev.web.security.Permiso.MANAGER_DELETE;
import static py.edu.ucsa.coope.dev.web.security.Permiso.MANAGER_READ;
import static py.edu.ucsa.coope.dev.web.security.Permiso.MANAGER_UPDATE;




@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {

	private final static String[] WHITE_LIST_URL = {
		"/api/v1/auth/**",
		"/v2/api-docs",
		"/v3/api-docs",
		"/v3/api-docs/**",
		"/coopedev-auth-api-resources",
		"/c-resources/**",
		"/configuration/ui",
		"/configuration/security",
		"/auth-api-ui/**",
		"/webjars/**",
		"/auth-api-ui.html"
	};
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;
	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private LogoutHandler logoutHandler;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
					req -> req.requestMatchers(WHITE_LIST_URL)
					.permitAll()
					.requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
					.requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
					.requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
					.requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
					.requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
					.requestMatchers("/api/v1/barrios/**").hasAnyRole(ADMIN.name(), MANAGER.name())
					.requestMatchers(GET, "/api/v1/barrios/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
					.requestMatchers(POST, "/api/v1/barrios/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
					.requestMatchers(PUT, "/api/v1/barrios/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
					.requestMatchers(DELETE, "/api/v1/barrios/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
	 
					.requestMatchers("/api/v1/ciudades/**").hasAnyRole(ADMIN.name(), MANAGER.name())
					.requestMatchers(GET, "/api/v1/ciudades/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
					.requestMatchers(POST, "/api/v1/ciudades/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
					.requestMatchers(PUT, "/api/v1/ciudades/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
					.requestMatchers(DELETE, "/api/v1/ciudades/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
	 
					.requestMatchers("/api/v1/departamentos/**").hasAnyRole(ADMIN.name(), MANAGER.name())
					.requestMatchers(GET, "/api/v1/departamentos/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
					.requestMatchers(POST, "/api/v1/departamentos/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
					.requestMatchers(PUT, "/api/v1/departamentos/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
					.requestMatchers(DELETE, "/api/v1/departamentos/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
					.requestMatchers("/api/v1/usuarios/**").hasAnyRole(ADMIN.name(), MANAGER.name())
					.requestMatchers(GET, "/api/v1/usuarios/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
					.requestMatchers(POST, "/api/v1/usuarios/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
					.requestMatchers(PUT, "/api/v1/usuarios/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
					.requestMatchers(DELETE, "/api/v1/usuarios/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
					.anyRequest()
					.authenticated()
					)
			.sessionManagement(session-> session.sessionCreationPolicy(STATELESS))
			.authenticationProvider(authenticationProvider)
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
			.logout(logout -> 
					logout.logoutUrl("/api/v1/auth/logout") 
					.addLogoutHandler(logoutHandler)
					.logoutSuccessHandler((request , response ,authentication )-> 
																		SecurityContextHolder.clearContext())
					);
		
		return http.build();
	}
	
}
