package com.meal360.web.config;

import com.meal360.web.filter.JwtRequestFilter;
import com.meal360.web.userDetails.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService MyuserDetailsService;

    @Autowired
    private JwtRequestFilter jwtFilter;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(MyuserDetailsService);
       // super.configure(auth);
    }
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
        /*        .antMatchers("/restaurants").hasAuthority("ADMIN")
                .antMatchers("/promotions").hasAuthority("ADMIN")
                .antMatchers("/rider").hasAuthority("ADMIN")
                .antMatchers("/cousine").hasAuthority("ADMIN")
                .antMatchers("/coupons").hasAuthority("ADMIN")
                .antMatchers("/restaurantType").hasAuthority("ADMIN")*/
                /*.antMatchers("/v1/admin").hasAuthority("ADMIN")*/
                .antMatchers("/v1/admin").permitAll()
                .antMatchers("/restaurants").permitAll()

                .antMatchers("/restaurant").permitAll()
                .antMatchers("/image").permitAll()

                .antMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.cors();
/*        httpSecurity.requiresChannel()
                .antMatchers("/authenticate").requiresSecure();*/
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/v1/admin").hasRole("ADMIN")
//                .antMatchers("/rider").hasAnyRole("ADMIN", "RIDER")
//                //.antMatchers("/user").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/user").permitAll()
//                .and().formLogin();
//    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



}
