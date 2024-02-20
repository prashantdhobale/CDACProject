package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.project.filters.JWTRequestFilter;

//Entry point of spring sec configuration
@EnableWebSecurity //to enable web security frmwork
@Configuration //to tell SC following is java configuration class : to declare spring beans
//Equivalent to bean config xml file, This class can contain bean declaration : @Bean
//annotated methods(equivalent to <bean id , class....../>
@EnableGlobalMethodSecurity(prePostEnabled = true) //to enable method level security , with pre auth n post auth
public class SecurityConfig {
	//dep : JWT filter
	@Autowired
	private JWTRequestFilter jwtFilter;
	
	//configures spring security for authorization (role based)
	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception
	{
		http.csrf().disable(). //disable CSRF  to continue with REST APIs
		authorizeRequests() //specify all authorization rules (i.e authorize all requests)
		.antMatchers("/users/signin","/users/signup").permitAll() // for incoming req ending with /products/view : no authentication n authorization needed
		.antMatchers("webjars/**","/v3/api-docs/**","/v2/api-docs/**","/swagger.json","/swagger-ui/**","swagger-ui.html","swagger-resources/**").permitAll()
		.antMatchers("/vehicle/addvehicle","/shop/{city}","/getallmake","/getmodel/{make_name}","/findmodel/{id}","/jobcard/{id}","/addjobcard","/shop/findshop/{id}","/allvehicles").permitAll()//only customer can purchase the products
		.antMatchers("/shop/*","/shop/editshop","/getallusers","/getallshops","/service/addservice","/model/addModel","/allservices","/getallshops","/getallmake/*","/getmodel/*").permitAll()
		.antMatchers("/user/delete/{id}","/finduser/{id}","/shop/delete/{id}","/service/delete/{id}","/makeModel/delete/{id}","/service/addservice","/service/editservice/{id}","/shop/addshop","/model/addModel","/shop/editshop/{id}","/shop/findshop/{id}","/getallusers","/findservice/{id}","/findvehicle/{id}").permitAll()
		//.hasRole("admin") //only admin can add the products
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated() //all remaining end points accessible only to authenticated users
		.and()
		.sessionManagement() //configure HttpSession management
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //DO NOT use HttpSession for storing any sec info
		.and()
		.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	//expose spring supplied auth mgr as a spring bean , so that auth controller can use it for authentication .
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
