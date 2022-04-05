package line2.line2_back.review.service;

import line2.line2_back.restApi.RestApiService;
import line2.line2_back.review.model.Review;
import line2.line2_back.review.model.ReviewDtoInput;
import line2.line2_back.review.repository.ReviewRepository;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestApiService restApiService;

    @Override
    public SystemMessage add(ReviewDtoInput reviewDtoInput) {
        try {
            log.info("ReviewService add Review({}) start", reviewDtoInput);
            reviewRepository.save(Review.builder()
                    .id(reviewDtoInput.getReviewId())
                    .review(reviewDtoInput.getReview())
                    .star(reviewDtoInput.getStar())
                    .home(restApiService.getHomeById(reviewDtoInput.getHomeId()))
                    .user(restApiService.getUserById(reviewDtoInput.getUserId()))
                    .build());
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 등록 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService add Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 등록 실패")
                    .build();
        } finally {
            log.info("ReviewService add Review end");
        }
    }

    @Override
    public SystemMessage edit(ReviewDtoInput reviewDtoInput) {
        try {
            log.info("ReviewService edit Review({}) start", reviewDtoInput);
            reviewRepository.save(Review.builder()
                    .id(reviewDtoInput.getReviewId())
                    .review(reviewDtoInput.getReview())
                    .star(reviewDtoInput.getStar())
                    .home(restApiService.getHomeById(reviewDtoInput.getHomeId()))
                    .user(restApiService.getUserById(reviewDtoInput.getUserId()))
                    .build());
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 수정 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService edit Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 수정 실패")
                    .build();
        } finally {
            log.info("ReviewService edit Review end");
        }
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("ReviewService delete by id Review(id: {}) start", id);
            reviewRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("리뷰 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("ReviewService delete by id Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 삭제 실패")
                    .build();
        } finally {
            log.info("ReviewService delete by id Review end");
        }
    }
}
