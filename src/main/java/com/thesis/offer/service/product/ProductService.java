package com.thesis.offer.service.product;

import com.thesis.offer.dto.product.ExtendedProductDto;

public interface ProductService {

    ExtendedProductDto getProduct(Long productId);

    ExtendedProductDto getFavoriteProduct(Long userId);
}
