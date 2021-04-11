package com.cmc.gestion.talento.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class GestionSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/loginPage", "/logoutPage","/public/**","/resources/**").permitAll()
		    .anyRequest().authenticated()
		.and()
			.formLogin()
				.loginPage("/loginPage")
				.loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/home", true)
				.failureUrl("/loginPage?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
		.and()
			.logout() 
			 .logoutRequestMatcher(new AntPathRequestMatcher("/logoutPage"))
			 .logoutSuccessUrl("/loginPage")
             .deleteCookies("JSESSIONID")
             .invalidateHttpSession(true)
             .logoutSuccessHandler(logoutSuccessHandler())
        .and()
 			.sessionManagement()
 				.maximumSessions(1)
 				.expiredUrl("/loginPage?expired=true");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("mario")
		.password("{noop}mario")
		.authorities("ROLE_USER");
		
	}
	
    @Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
	     return new CustomLogoutSuccessHandler();
	 }

}
