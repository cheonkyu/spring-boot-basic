package simple.app.core.security

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;

@Configuration
public class SecurityConfigration {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csp ->
                csp.disable()
            }
            .headers { header ->
                header
                    .frameOptions { it.sameOrigin() }
                    .xssProtection { xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)}
                    .contentSecurityPolicy { cps -> cps.policyDirectives("script-src 'self'") }
            }

        return http.build();
    }
}