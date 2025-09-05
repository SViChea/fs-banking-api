package kh.edu.icstad.fsbankingapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //Disable Login Form
        httpSecurity.formLogin(login -> login.disable());

        // Disable CSRF Token (Due to no form Login)
        httpSecurity.csrf(token -> token.disable());

        // Temporary for Form Login Http Basic
//         httpSecurity.httpBasic(Customizer.withDefaults());

        // Set Security Meganism to OAuth2 with JWT
        httpSecurity.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        // Set Security for all requests
        httpSecurity.authorizeHttpRequests(requests ->
                requests
                        .requestMatchers(HttpMethod.POST, "api/v1/customers").authenticated()
                        .requestMatchers(HttpMethod.GET, "api/v1/customers").hasRole("ADMIN")
                        .anyRequest().authenticated());

        return httpSecurity.build();
    }

    /**
     * Define user = admin, password = 123, role = USER
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        inMemoryUserDetailsManager.createUser(admin);

        UserDetails staff = User.builder()
                .username("staff")
                .password(passwordEncoder().encode("123"))
                .roles("STAFF")
                .build();

        inMemoryUserDetailsManager.createUser(staff);
        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
            Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");

            Collection<String> roles = realmAccess.get("roles");

            return roles.stream().map(
                            role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        };

        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;

    }
}
