package line2.line2_back.review.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ReviewDtoInput {
    private Long reviewId;
    private String review;
    private int star;
    private Long homeId;
    private Long userId;
}
