package ng.first.app.be.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	@Bean
	public CorsFilter corsFilter() {
		/* CorsConfiguration */
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		corsConfiguration.setAllowedMethods(Arrays.asList(RequestMethod.GET.name(), RequestMethod.POST.name(), RequestMethod.DELETE.name()));
		corsConfiguration.setMaxAge(1800L);
		/* UrlBasedCorsConfigurationSource*/
		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
		corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		/* CorsFilter */
		CorsFilter corsFilter = new CorsFilter(corsConfigurationSource);
		return corsFilter;
	}
}
