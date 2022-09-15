package sayilir.coder.server.manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import sayilir.coder.server.manager.enumeration.Status;
import sayilir.coder.server.manager.model.Server;
import sayilir.coder.server.manager.repository.ServerRepository;

import java.util.Arrays;

import static sayilir.coder.server.manager.enumeration.Status.*;

@SpringBootApplication
public class ServerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository) {
        return args -> {
            serverRepository.save(new Server(
                    null,
                    "192.168.1.160",
                    "Ubuntu/Linux",
                    "16 Gb",
                    "Personal PC",
                    "http://localhost:8080/server/image/server_image_1.png",
                    SERVER_UP
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.58",
                    "Fedora/Linux",
                    "16 Gb",
                    "Dell Tower",
                    "http://localhost:8080/server/image/server_image_2.png",
                    SERVER_DOWN
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.21",
                    "MS 2008",
                    "32 Gb",
                    "Web Server",
                    "http://localhost:8080/server/image/server_image_3.png",
                    SERVER_UP
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.16",
                    "Red Hat/Linux",
                    "64 Gb",
                    "Mail Server",
                    "http://localhost:8080/server/image/server_image_4.png",
                    SERVER_DOWN
            ));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
                "Access-Control-Allow-Origin",
                "Content-Type",
                "Accept",
                "Jwt-Token",
                "Authorization",
                "Origin, Accept",
                "X-Requested-With",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin",
                "Content-Type",
                "Accept",
                "Jwt-Token",
                "Authorization",
                "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials",
                "FileName"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD", "PATCH"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);


    }

}
