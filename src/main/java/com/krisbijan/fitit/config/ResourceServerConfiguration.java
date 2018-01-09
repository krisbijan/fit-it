package com.krisbijan.fitit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

 @Configuration
 @EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	 
		static final String RESOURCE_ID = "fit_it_rest_service";


		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.resourceId(RESOURCE_ID);
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().
			antMatchers("/test/admin").hasRole("ADMIN").
			antMatchers("/test/user").hasAnyRole("ADMIN","USER").
			antMatchers("/test/guest","/", "/login**", "/webjars/**").permitAll();
		}
		
	    @Primary
	    @Bean
	    public RemoteTokenServices tokenServices() {
	        final RemoteTokenServices tokenService = new RemoteTokenServices();
	        tokenService.setCheckTokenEndpointUrl("http://localhost:8090/oauth/check_token");
	        tokenService.setClientId("myclientapp");
	        tokenService.setClientSecret("9999");
	        return tokenService;
	    }
	    

}
