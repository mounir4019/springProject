package com.example.springProject.config; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Service;
 
import com.example.springProject.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Autowired
private CustomUserDetailsService customUserDetailsService;
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return   http //cors().and().csrf().disable()
		.cors(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
		/* cors(corsCustomizer -> {
			// Configuration spécifique CORS
			corsCustomizer
				.disable(); // Désactive la configuration CORS par défaut, à personnaliser selon vos besoins
		}). csrf(csrfCustomizer -> {
			// Configuration spécifique CSRF
			csrfCustomizer
				.disable(); // Désactive la protection CSRF par défaut, à personnaliser selon vos besoins
		})*/
		    /*authorizeHttpRequests(auth -> {
			auth.requestMatchers("/demo/admin").hasRole("ADMIN");
			auth.requestMatchers("/demo/user").hasAnyRole("ADMIN","USER"); 
			//auth.requestMatchers("/login").permitAll();
			auth.requestMatchers("/categories").hasRole("ADMIN") ;
			auth.requestMatchers("/api/login").permitAll() ;
			// auth.requestMatchers("/**");//.hasRole("ADMIN");
			auth.anyRequest().authenticated();
		})  */
		   //.formLogin(Customizer.withDefaults()) 
		   
		   .authorizeHttpRequests((authorize) -> authorize
		   //.requestMatchers("/login").permitAll()
		   .requestMatchers("/api/login").permitAll()
		   //.requestMatchers("/login").permitAll()
		   //.requestMatchers("/logout").permitAll()
		   .requestMatchers("/api/logout").permitAll()
		   .requestMatchers(HttpMethod.GET,"/produits/**").permitAll()
		   .requestMatchers(HttpMethod.GET,"/marques/**").permitAll()
		   .requestMatchers(HttpMethod.GET,"/categories/**").permitAll()
		   .requestMatchers(HttpMethod.POST,"/user").permitAll() 
		   .requestMatchers(HttpMethod.POST,"/paniers").permitAll()
		   .requestMatchers(HttpMethod.POST,"/paniers/**").permitAll()
		   .requestMatchers(HttpMethod.GET,"/paniers/userAnonyme/**").permitAll() 
		   .requestMatchers(HttpMethod.GET,"/paniersProduit/**").permitAll()
		   .requestMatchers(HttpMethod.POST,"/commandes/**").permitAll()
		   .requestMatchers(HttpMethod.POST,"/commandes").permitAll()
		   .requestMatchers(HttpMethod.DELETE,"/paniers/panierProduit/**").permitAll()
           .requestMatchers(HttpMethod.GET,"/espaceClient/mesCommandes/**").hasRole("USER")		   
		   .requestMatchers(HttpMethod.GET,"/espaceClient/maFacture/**").hasRole("USER")
		   .requestMatchers(HttpMethod.PUT,"/user").hasRole("USER")  
		   .requestMatchers(HttpMethod.GET,"/paniers/user/**").hasRole("USER")
		   .requestMatchers(HttpMethod.GET,"/administration/commandes/**").hasRole("ADMIN")
		   .requestMatchers(HttpMethod.GET,"/administration/commandes/validation/**").hasRole("ADMIN")
		   
		   .anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			//.formLogin(Customizer.withDefaults())
			.logout(logout -> logout
            .logoutUrl("/logout") // Spécifiez l'URL de déconnexion
            .logoutSuccessUrl("/") // Redirigez l'utilisateur après la déconnexion réussie
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID") 
        )
		  .build();  
	} 
	
	/* @Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("user"))
				.roles("USER" ).build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("USER").build();
		return new InMemoryUserDetailsManager(user, admin);
	} */
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
	System.out.println("bCryptPasswordEncoder");
	System.out.println(bCryptPasswordEncoder.toString());
	AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	return authenticationManagerBuilder.build();
}

}
