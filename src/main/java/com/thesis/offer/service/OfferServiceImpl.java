package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;
import com.thesis.offer.dto.OfferProductDto;
import com.thesis.offer.model.Offer;
import com.thesis.offer.model.OfferProduct;
import com.thesis.offer.repository.OfferRepository;
import com.thesis.offer.service.feign.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ProductClient productClient;

    public List<OfferDto> getOffers(Integer page,
                                    Integer size) {

        var offers = offerRepository.findAllOrderByOrder(PageRequest.of(page, size));

        var products = offers.stream()
                .map(Offer::getProducts)
                .flatMap(List::stream)
                .toList();

        var productIds = products.stream()
                .map(OfferProduct::getId)
                .toList();

        if (productIds.isEmpty()) {
            return offers.stream()
                    .map(offer -> makeOfferDto(offer, List.of()))
                    .collect(Collectors.toList());
        }

        var productOffersMap = products.stream()
                .collect(Collectors.toMap(OfferProduct::getProductId, product -> product.getOffer().getId()));

        var productDtos = productClient.getProducts(productIds);

        var productDtosOffersMap = productDtos.stream()
                .collect(Collectors.groupingBy(product -> productOffersMap.get(product.getId()), Collectors.toList()));
        // not implemented
        return offers.stream()
                .map(offer -> makeOfferDto(offer, productDtosOffersMap.get(offer.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public OfferDto getOffer(Long offerId,
                             Integer page,
                             Integer size) {

        var offer = offerRepository.findById(offerId)
                .orElseThrow();

        var productIds = offer.getProducts()
                .stream()
                .map(OfferProduct::getProductId)
                .toList();

        if (productIds.isEmpty()) {
            return makeOfferDto(offer, List.of());
        }

        var products = productClient.getProducts(productIds);

        return makeOfferDto(offer, products);
    }

    private OfferDto makeOfferDto(Offer offer, List<OfferProductDto> productDtoList) {
        return OfferDto.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .productDtoList(productDtoList)
                .build();
    }
}