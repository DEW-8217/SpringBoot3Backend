package me.shinsunyoung.springbootdeveloper.config;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers(new AntPathMatcher("/static/**"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecuriy http) throws Exception {
        return http
                .authorizeRequests(auth -> quth
                        .requestMatchers(
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMathcher("/signup"),
                                new AntPathRequestMathcer("/user")
                        )).permitAll()
                .anyRequest().authenticated())
        .formLogin(formLogin -> formLogin
                .loginPage("/login")
                        .defaultSuccessUrl("/articles")
        )
    }
}