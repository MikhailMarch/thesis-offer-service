package com.thesis.offer.controller;

import com.thesis.offer.OfferServiceApplicationTests;
import com.thesis.offer.dto.OfferProductDto;
import com.thesis.offer.model.Offer;
import com.thesis.offer.model.OfferProduct;
import com.thesis.offer.repository.OfferRepository;
import com.thesis.offer.service.OfferServiceImpl;
import com.thesis.offer.service.feign.ProductClient;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;

public class ProductOfferControllerTest extends OfferServiceApplicationTests {

    @MockBean
    OfferRepository offerRepository;

    @MockBean
    ProductClient productClient;

    @Autowired
    OfferServiceImpl offerService;

    @BeforeEach
    void setUp() {
        Mockito.when(offerRepository.findAllOrderByOrder(any())).thenReturn(
                List.of(Offer.builder()
                                .id(1L)
                                .title("some")
                                .products(List.of(
                                        OfferProduct.builder()
                                                .id(1L)
                                                .productId(1L)
                                                .build(),
                                        OfferProduct.builder()
                                                .id(2L)
                                                .productId(2L)
                                                .build(),
                                        OfferProduct.builder()
                                                .id(3L)
                                                .productId(3L)
                                                .build()
                                ))
                        .build())
        );
        Mockito.when(productClient.getProducts(anyList())).thenReturn(List.of(
                OfferProductDto.builder()
                        .id(1L)
                        .rating(2.3)
                        .sellPrice(1)
                        .build(),
                OfferProductDto.builder()
                        .id(2L)
                        .rating(2.3)
                        .sellPrice(1)
                        .build(),
                OfferProductDto.builder()
                        .id(3L)
                        .rating(2.3)
                        .sellPrice(1)
                        .build()
        ));
    }

    @Test
    void testOfferController() {
        var offers = offerService.getOffers(0, 10);

        MatcherAssert.assertThat(offers, isNotNull());
    }
}
