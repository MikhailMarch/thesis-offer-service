package com.thesis.offer.service.product;

import com.thesis.offer.dto.graphql.ExtendedProduct;
import com.thesis.offer.model.CustomerProductLike;
import com.thesis.offer.repository.CustomerProductLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GqlProductServiceImpl implements GqlProductService {

    private final CustomerProductLikeRepository customerProductLikeRepository;

    @Override
    public ExtendedProduct getFavorite(Long userId) {
        var offerProduct = customerProductLikeRepository.findAllByUserIdOrderByDateCreated(userId, PageRequest.ofSize(1))
                .getContent().stream().findFirst().map(CustomerProductLike::getProduct).orElse(null);

        if (offerProduct == null) {
            return null;
        }

        return new ExtendedProduct(offerProduct.getProductId());
    }
}
