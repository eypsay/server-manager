package sayilir.coder.server.manager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sayilir.coder.server.manager.Utulities.EmailCheck;
import sayilir.coder.server.manager.enumeration.Status;
import sayilir.coder.server.manager.model.Server;
import sayilir.coder.server.manager.repository.ServerRepository;
import sayilir.coder.server.manager.service.ServerService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private final ServerRepository serverRepository;


    @Override
    public Server create(Server server) {
        log.info("Saving new server:{}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP:{}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(1000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by id:{", id);

        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server:{}", server.getName());

        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server: by id: {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean checkEmail(String email) {
        EmailCheck emailCheck = new EmailCheck();
        return emailCheck.checkEmail(email);
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server_image_1.png", "server_image_2.png", "server_image_3.png", "server_image_4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toString();
    }

}
