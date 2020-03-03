package com.bonguyen.todospringapp.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin").password("admin")
                .roles("USER", "ADMIN")
                .and().withUser("bo").password("123").roles("ADMIN")

        ;
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER")
//                .and().withUser("admin").password("admin").roles("USER", "ADMIN")
//                .and().withUser("bo").password("123").roles("USER")
//                .and().withUser("bo1").password("admin1").roles("USER", "ADMIN")
//        ;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/register","/all").permitAll()
//                .antMatchers("/order","/cart","/cart/**").hasRole("MEMBER")
//                .antMatchers("/profile","/profile/**","/tour/checkout").hasAnyRole("MEMBER","ADMIN")
//                .antMatchers("/admin","/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/index")
//                .failureUrl("/login?error")
//                .and()
//
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/index")
//                .permitAll()
//
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");
//        http.headers().frameOptions().sameOrigin();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}