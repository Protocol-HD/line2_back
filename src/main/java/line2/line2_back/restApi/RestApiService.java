package line2.line2_back.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import line2.line2_back.restApi.models.Home;
import line2.line2_back.restApi.models.Room;
import line2.line2_back.restApi.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestApiService {
    @Value("${user-server-url}")
    String userServer;

    @Value("${home-server-url}")
    String homeServer;

    private final RestTemplate restTemplate;

    public User getUserById(Long id) {
        String url = userServer + "/user/v1/user/" + Long.toString(id);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        log.info("{}", response);
        return response.getBody();
    }

    public Home getHomeById(Long id) {
        String url = homeServer + "/home/v1/home/not_dto/" + Long.toString(id);
        Home home = restTemplate.getForObject(url, Home.class);
        log.info("{}", home);
        return home;
    }

    public Room getRoomById(Long id) {
        String url = homeServer + "/home/v1/room/" + Long.toString(id);
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);
        log.info("{}", response);
        return response.getBody();
    }

    public List<Room> getRoomsByUserId(Long id) {
        String url = homeServer + "/home/v1/home/calendar/" + Long.toString(id);
        ResponseEntity<List<Room>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Room>>() {
                });
        log.info("{}", response);
        return response.getBody();
    }
}
