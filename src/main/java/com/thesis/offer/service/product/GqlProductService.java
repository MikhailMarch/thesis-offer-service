package com.thesis.offer.service.product;

import com.thesis.offer.dto.graphql.ExtendedProduct;

public interface GqlProductService {

    ExtendedProduct getFavorite(Long userId);
}
