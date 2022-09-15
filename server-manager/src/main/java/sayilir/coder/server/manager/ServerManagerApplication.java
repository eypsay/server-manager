package sayilir.coder.server.manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sayilir.coder.server.manager.enumeration.Status;
import sayilir.coder.server.manager.model.Server;
import sayilir.coder.server.manager.repository.ServerRepository;

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
                    "http://localhost:8080/server/images/server_image_1.png",
                    SERVER_UP
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.58",
                    "Fedora/Linux",
                    "16 Gb",
                    "Dell Tower",
                    "http://localhost:8080/server/images/server_image_2.png",
                    SERVER_DOWN
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.21",
                    "MS 2008",
                    "32 Gb",
                    "Web Server",
                    "http://localhost:8080/server/images/server_image_3.png",
                    SERVER_UP
            ));
            serverRepository.save(new Server(
                    null,
                    "192.168.1.16",
                    "Red Hat/Linux",
                    "64 Gb",
                    "Mail Server",
                    "http://localhost:8080/server/images/server_image_4.png",
                    SERVER_DOWN
            ));
        };
    }

}
