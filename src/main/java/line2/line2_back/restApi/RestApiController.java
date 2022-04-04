package line2.line2_back.restApi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import line2.line2_back.restApi.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class RestApiController {
    private final RestApiService restApiService;

    @GetMapping("/test")
    public User test() {
        return restApiService.getUserById(1L);
    }
}
