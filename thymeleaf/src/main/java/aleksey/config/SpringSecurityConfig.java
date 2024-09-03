package aleksey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public SpringSecurityConfig() {
        super();
    }


    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .formLogin(formLogin -> formLogin
                        .loginPage("/hello"))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                new AntPathRequestMatcher("/test/**"),
                                new AntPathRequestMatcher("/hello"),
                                new AntPathRequestMatcher("/css/**"),
                                new AntPathRequestMatcher("/images/**"),
                                new AntPathRequestMatcher("/js/**"))
                        .permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/index.jsp")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/new")).hasRole("USER")
                        .anyRequest().authenticated());
        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("asdemo@yandex.ru").password("{noop}demo").roles("ADMIN").build(),
                User.withUsername("bob").password("{noop}demo").roles("USER").build(),
                User.withUsername("ted").password("{noop}demo").roles("USER", "ADMIN").build());
    }


}