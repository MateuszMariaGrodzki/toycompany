package com.toycompany.demo.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery("select email, password, active from client where email=?")
                .authoritiesByUsernameQuery("select email, 'ROLE_USER' from client where email=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/log").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/reservation/**").permitAll()
                .antMatchers("/toys/**").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/category/**").permitAll()
                .antMatchers("/login/**")
                .authenticated().and().csrf().disable().formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutSuccessUrl("/home");
    }

}
