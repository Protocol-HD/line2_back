package line2.line2_back.review.service;

import line2.line2_back.review.model.ReviewDtoInput;
import line2.line2_back.systemMessage.SystemMessage;

public interface ReviewService {
    SystemMessage add(ReviewDtoInput reviewDtoInput);

    SystemMessage edit(ReviewDtoInput reviewDtoInput);

    SystemMessage deleteById(Long id);
}
