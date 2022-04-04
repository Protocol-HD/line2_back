package line2.line2_back.restApi;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import line2.line2_back.restApi.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestApiService {
    public User getUserById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://openjdk2:9090/manage/v1/user/" + Long.toString(id);
        // String url = "http://localhost:9090/manage/v1/user/" + Long.toString(id);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        log.info("{}", response.getBody());
        return response.getBody();
    }
}
