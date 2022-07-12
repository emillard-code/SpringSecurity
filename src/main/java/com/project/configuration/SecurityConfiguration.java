package com.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // This object loads the username and password from the database.
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider() {

        // These methods allow you to set up the credentials of the Spring Security login page.
        // This is all that's needed to implement BCrypt Encryption into the application.
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder()); // BCrypt Encryption.

        return provider;

    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//
//        // This method allows you to set up the credentials of the Spring Security login page.
//        List<UserDetails> users = new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder()
//                .username("Emillard")
//                .password("Password123")
//                .roles("USER")
//                .build());
//
//        return new InMemoryUserDetailsManager(users);
//
//    }

}