package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tacos.data.UserRepository;
import tacos.model.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.POST, "/api/ingredients")
                  .hasAuthority("SCOPE_writeIngredients")
                .antMatchers(HttpMethod.DELETE, "/api/ingredients")
                  .hasAuthority("SCOPE_deleteIngredients")
                .antMatchers("/api//tacos", "/api//orders/**")
                  .permitAll()
                .antMatchers("/**")
                  .permitAll()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())

                .httpBasic()
                  .realmName("Taco Cloud")

                .and()
                  .logout()
                  .logoutSuccessUrl("/")

                .and()
                  .csrf()
                    .ignoringAntMatchers("/h2-console/**", "/api/**")

                .and()
                .headers()
                  .frameOptions()
                    .sameOrigin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepo) {
//        return username -> {
//            User user = userRepo.findByUsername(username);
//            if (user != null) return user;
//
//            throw new UsernameNotFoundException("User '" + username + "' not found");
//        };
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorizeHttpRequest -> {
//            authorizeHttpRequest.antMatchers("/design", "/orders").hasRole("USER")
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/", "/**").permitAll();
//        });
//        http.headers().frameOptions().disable()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                .and()
//                    .logout()
//                    .logoutSuccessUrl("/");
//        http.csrf().disable();
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> {
//            web.ignoring()
//                    .antMatchers("/h2-console/**");
//        };
//    }

}
