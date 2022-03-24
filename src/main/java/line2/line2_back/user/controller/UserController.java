package line2.line2_back.user.controller;

import line2.line2_back.user.model.User;
import line2.line2_back.systemMessage.SystemMessage;

public interface UserController {
    SystemMessage add(User user);

    SystemMessage edit(User user);

    User findById(Long id);

    SystemMessage deleteById(Long id);
}
