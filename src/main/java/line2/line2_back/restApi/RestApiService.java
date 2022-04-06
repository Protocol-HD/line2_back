package line2.line2_back.restApi;

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
    // String userServer = "http://openjdk2:8080";
    // String homeServer = "http://openjdk3:8080";
    String userServer = "http://localhost:8081";
    String homeServer = "http://localhost:8082";

    public User getUserById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = userServer + "/user/v1/user/" + Long.toString(id);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        log.info("{}", response);
        return response.getBody();
    }

    public Home getHomeById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = homeServer + "/home/v1/home/not_dto/" + Long.toString(id);
        Home home = restTemplate.getForObject(url, Home.class);
        log.info("{}", home);
        return home;
    }

    public Room getRoomById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = homeServer + "/home/v1/room/" + Long.toString(id);
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);
        log.info("{}", response);
        return response.getBody();
    }
}
