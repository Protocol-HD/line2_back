package line2.line2_back.review.controller;

import line2.line2_back.review.model.ReviewDtoInput;
import line2.line2_back.review.service.ReviewService;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService reviewService;

    @Override
    @PostMapping("/v1/review")
    public SystemMessage add(@RequestBody ReviewDtoInput reviewDtoInput) {
        try {
            log.info("ReviewController add Review({}) start", reviewDtoInput);
            return reviewService.add(reviewDtoInput);
        } catch (Exception e) {
            log.error("ReviewController add Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 등록 실패")
                    .build();
        } finally {
            log.info("ReviewController add Review end");
        }
    }

    @Override
    @PutMapping("/v1/review")
    public SystemMessage edit(@RequestBody ReviewDtoInput reviewDtoInput) {
        try {
            log.info("ReviewController edit Review({}) start", reviewDtoInput);
            return reviewService.edit(reviewDtoInput);
        } catch (Exception e) {
            log.error("ReviewController edit Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 수정 실패")
                    .build();
        } finally {
            log.info("ReviewController edit Review end");
        }
    }

    @Override
    @DeleteMapping("/v1/review/{id}")
    public SystemMessage deleteById(@PathVariable Long id) {
        try {
            log.info("ReviewController delete by id Review(id: {}) start", id);
            return reviewService.deleteById(id);
        } catch (Exception e) {
            log.error("ReviewController delete by id Review failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("리뷰 삭제 실패")
                    .build();
        } finally {
            log.info("ReviewController delete by id Review end");
        }
    }
}
