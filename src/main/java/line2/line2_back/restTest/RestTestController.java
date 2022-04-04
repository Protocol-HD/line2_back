package line2.line2_back.restTest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RestTestController {
    private final RestTestService restTestService;

    @GetMapping("/test")
    public String test() {
        return restTestService.test();
    }
}
