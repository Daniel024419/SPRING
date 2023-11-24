package com.template.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    // user services from the core security
    private UserDetailsService userDetailsService;

    // inject the bean
    @Bean
    AuthenticationProvider authenticationProvider() {

        // dao data access object
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // set provider details
        provider.setUserDetailsService(userDetailsService);
        // password encoder
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
      //public
      .antMatchers("/")
      .permitAll()


      //dashboard
      .antMatchers("/api/users/**")
      .hasAnyAuthority("ADMIN")
      .anyRequest()
      .authenticated()
      .and()
      .httpBasic();

      
    }

}
