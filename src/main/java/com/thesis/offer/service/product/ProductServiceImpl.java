package com.thesis.offer.service.product;

import com.thesis.offer.dto.offer.OfferDto;
import com.thesis.offer.dto.product.ExtendedProductDto;
import com.thesis.offer.model.CustomerProductLike;
import com.thesis.offer.model.Offer;
import com.thesis.offer.repository.CustomerProductLikeRepository;
import com.thesis.offer.repository.OfferProductRepository;
import com.thesis.offer.service.feign.FeedbackClient;
import com.thesis.offer.service.feign.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final FeedbackClient feedbackClient;
    private final ProductClient productClient;

    private final OfferProductRepository offerProductRepository;
    private final CustomerProductLikeRepository customerProductLikeRepository;

    @Override
    public ExtendedProductDto getProduct(Long productId) {
        var offerProduct = offerProductRepository.findByProductId(productId)
                .orElseThrow();

        var productDto = productClient.getProducts(List.of(offerProduct.getProductId()))
                .stream().findFirst().orElseThrow();

        var feedbacks = feedbackClient.getFeedbacks(offerProduct.getProductId());

        return ExtendedProductDto.builder()
                .id(productId)
                .rating(productDto.getRating())
                .sellPrice(productDto.getSellPrice())
                .feedbacks(feedbacks)
                .offer(makeOffer(offerProduct.getOffer()))
                .build();
    }

    @Override
    public ExtendedProductDto getFavoriteProduct(Long userId) {
        var offerProduct = customerProductLikeRepository.findAllByUserIdOrderByDateCreated(userId, PageRequest.ofSize(1))
                .getContent().stream().findFirst().map(CustomerProductLike::getProduct).orElse(null);

        if (offerProduct == null) {
            return null;
        }

        var productDto = productClient.getProducts(List.of(offerProduct.getProductId()))
                .stream().findFirst().orElseThrow();

        var feedbacks = feedbackClient.getFeedbacks(offerProduct.getProductId());

        return ExtendedProductDto.builder()
                .id(offerProduct.getProductId())
                .rating(productDto.getRating())
                .sellPrice(productDto.getSellPrice())
                .feedbacks(feedbacks)
                .offer(makeOffer(offerProduct.getOffer()))
                .build();
    }

    private OfferDto makeOffer(Offer offer) {
        return OfferDto.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .build();
    }
}
