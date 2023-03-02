package com.thesis.offer.service.feign;

import com.thesis.offer.dto.OfferProductDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${services.product.url}",
             name = "product-client")
public interface ProductClient {

    List<OfferProductDto> getProducts(@RequestParam("productIds") List<Long> productIds);
}
