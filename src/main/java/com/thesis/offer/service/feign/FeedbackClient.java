package com.thesis.offer.service.feign;

import com.thesis.offer.dto.feedback.ProductFeedbackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${services.feedback}",
             name = "feedback-feign-client")
public interface FeedbackClient {

    @GetMapping("/feedback/product")
    List<ProductFeedbackDto> getFeedbacks(@RequestParam("productId") Long productId);
}
