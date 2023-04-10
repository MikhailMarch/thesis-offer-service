package com.thesis.offer.controller.rest;

import com.thesis.offer.dto.product.ExtendedProductDto;
import com.thesis.offer.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/product")
@RequiredArgsConstructor
public class UserProductController {

    private final ProductService productService;

    @GetMapping
    public ExtendedProductDto getProduct(@RequestParam("productId") Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/user")
    public ExtendedProductDto getFavoriteProduct(@RequestParam("userId") Long userId) {
        return productService.getFavoriteProduct(userId);
    }
}
