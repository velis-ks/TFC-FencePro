package com.fencepro.backend.security;

import com.fencepro.backend.security.jwt.JwtAuthenticationFilter;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
    @EnableMethodSecurity

    public class SecurityConfig {
        @PostConstruct
        public void loaded() {
            System.out.println("Security config loaded");
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .formLogin(AbstractHttpConfigurer::disable)
                    .httpBasic(AbstractHttpConfigurer::disable)
                    .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(
                                    "/ping",
                                    "/auth/logout",
                                    "/auth/login",
                                    "/swagger-ui/**",
                                    "/swagger-ui.html",
                                    "/v3/api-docs/**"
                            ).permitAll()
                            .anyRequest().authenticated()
                    )
                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailsService(PasswordEncoder encoder) {
            UserDetails admin = User.withUsername("admin")
                    .password(encoder.encode("admin1234"))
                    .roles("ADMIN")
                    .build();

            UserDetails entrenador = User.withUsername("entrenador")
                    .password(encoder.encode("entrenador1234"))
                    .roles("ENTRENADOR")
                    .build();

            UserDetails deportista = User.withUsername("deportista")
                    .password(encoder.encode("deportista1234"))
                    .roles("DEPORTISTA")
                    .build();

            UserDetails federativo = User.withUsername("federativo")
                    .password(encoder.encode("federativo1234"))
                    .roles("FEDERATIVO")
                    .build();

            UserDetails club = User.withUsername("club")
                    .password(encoder.encode("club1234"))
                    .roles("CLUB")
                    .build();

            UserDetails arbitro = User.withUsername("arbitro")
                    .password(encoder.encode("arbitro1234"))
                    .roles("ÁRBITRO")
                    .build();

            return new InMemoryUserDetailsManager(admin, entrenador, deportista, federativo, club, arbitro);
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
            return config.getAuthenticationManager();
        }
    }