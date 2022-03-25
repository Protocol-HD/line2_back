package line2.line2_back.user.controller;

import line2.line2_back.user.model.User;
import line2.line2_back.user.service.UserService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    @PostMapping("/v1/user")
    public SystemMessage add(@RequestBody User user) {
        try {
            log.info("UserController add User({}) start", user);
            return userService.add(user);
        } catch (Exception e) {
            log.error("UserController add User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 등록 실패")
                    .build();
        } finally {
            log.info("UserController add User end");
        }
    }

    @Override
    @PutMapping("/v1/user")
    public SystemMessage edit(@RequestBody User user) {
        try {
            log.info("UserController edit User({}) start", user);
            return userService.edit(user);
        } catch (Exception e) {
            log.error("UserController edit User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 수정 실패")
                    .build();
        } finally {
            log.info("UserController edit User end");
        }
    }

    @Override
    @GetMapping("/v1/user/{id}")
    public User findById(@PathVariable Long id) {
        try {
            log.info("UserController find by id User(id: {}) start", id);
            return userService.findById(id);
        } catch (Exception e) {
            log.error("UserController find by id User failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("UserController find by id User end");
        }
    }

    @Override
    @DeleteMapping("/v1/user/{id}")
    public SystemMessage deleteById(@PathVariable Long id) {
        try {
            log.info("UserController delete by id User(id: {}) start", id);
            return userService.deleteById(id);
        } catch (Exception e) {
            log.error("UserController delete by id User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 삭제 실패")
                    .build();
        } finally {
            log.info("UserController delete by id User end");
        }
    }
}
