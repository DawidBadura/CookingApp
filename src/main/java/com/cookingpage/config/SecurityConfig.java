package com.cookingpage.config;

import com.cookingpage.service.impl.UserSecurityService;
import com.cookingpage.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*	@Autowired
	private Environment env;

private BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.passwordEncoder();

 */
	@Autowired
	private UserSecurityService userSecurityService;



@Bean
public UserDetailsService userDetailsService() {
	return new UserSecurityService();
}

	public BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.passwordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/",
			"/newUser",
			"/newUserr",
			"/recipe/**",
			"/ingredient/**",

			"/forgetPassword",
			"/login",
			"/fonts/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().
				antMatchers(PUBLIC_MATCHERS).permitAll().
				antMatchers("/adminPortal").hasRole("ADMIN").
				antMatchers("/userPortal").hasRole("USER").
				anyRequest().authenticated().
				and().
				csrf().disable().//cors().disable().
				formLogin().failureUrl("/index").
				loginPage("/login").permitAll().
				and().
				logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
				logoutSuccessUrl("/").deleteCookies("remember-me").permitAll().
				and().
				rememberMe().
				and().headers().frameOptions().disable();


	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}

}
