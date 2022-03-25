package line2.line2_back.review.controller;

import line2.line2_back.review.model.ReviewDtoInput;
import line2.line2_back.systemMessage.SystemMessage;

public interface ReviewController {
    SystemMessage add(ReviewDtoInput reviewDtoInput);

    SystemMessage edit(ReviewDtoInput reviewDtoInput);

    SystemMessage deleteById(Long id);
}
