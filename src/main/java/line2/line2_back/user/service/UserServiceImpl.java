package line2.line2_back.user.service;

import line2.line2_back.user.model.User;
import line2.line2_back.user.repository.UserRepository;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public SystemMessage add(User user) {
        try {
            log.info("UserService add User({}) start", user);
            userRepository.save(user);
            return SystemMessage.builder()
                    .code(1)
                    .message("유저 등록 성공")
                    .build();
        } catch (Exception e) {
            log.error("UserService add User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 등록 실패")
                    .build();
        } finally {
            log.info("UserService add User end");
        }
    }

    @Override
    public SystemMessage edit(User user) {
        try {
            log.info("UserService edit User({}) start", user);
            userRepository.save(user);
            return SystemMessage.builder()
                    .code(1)
                    .message("유저 수정 성공")
                    .build();
        } catch (Exception e) {
            log.error("UserService edit User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 수정 실패")
                    .build();
        } finally {
            log.info("UserService edit User end");
        }
    }

    @Override
    public User findById(Long id) {
        try {
            log.info("UserService find by id User(id: {}) start", id);
            return userRepository.findById(id).get();
        } catch (Exception e) {
            log.error("UserService find by id User failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("UserService find by id User end");
        }
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("UserService delete by id User(id: {}) start", id);
            userRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("유저 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("UserService delete by id User failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("유저 삭제 실패")
                    .build();
        } finally {
            log.info("UserService delete by id User end");
        }
    }
}
