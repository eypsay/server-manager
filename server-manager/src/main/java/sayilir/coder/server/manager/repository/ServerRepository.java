package sayilir.coder.server.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sayilir.coder.server.manager.model.Server;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);

    Server findByName(String name);
}
