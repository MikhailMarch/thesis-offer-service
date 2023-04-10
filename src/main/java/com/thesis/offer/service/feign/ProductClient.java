package com.thesis.offer.service.feign;

import com.thesis.offer.dto.product.OfferProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${services.product}",
             name = "product-feign-client")
public interface ProductClient {

    @GetMapping("/getProducts")
    List<OfferProductDto> getProducts(@RequestParam("productIds") List<Long> productIds);
}
