package com.thesis.offer.controller;

import com.thesis.offer.OfferServiceApplicationTests;
import com.thesis.offer.dto.product.OfferProductDto;
import com.thesis.offer.model.Offer;
import com.thesis.offer.model.OfferProduct;
import com.thesis.offer.service.feign.FeedbackClient;
import com.thesis.offer.service.feign.ProductClient;
import com.thesis.offer.service.offer.OfferServiceImpl;
import com.thesis.offer.service.product.ProductServiceImpl;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

@Transactional
public class ProductOfferControllerTest extends OfferServiceApplicationTests {

    @Autowired
    EntityManager entityManager;

    @MockBean
    ProductClient productClient;

    @MockBean
    FeedbackClient feedbackClient;

    @Autowired
    OfferServiceImpl offerService;

    @Autowired
    ProductServiceImpl productService;

    Random random = new Random();

    Offer offer;

    @BeforeEach
    void setUp() {
        txStart();

        var offer = getOffer();
        entityManager.persist(offer);

        var products = new ArrayList<OfferProduct>();
        for (int i = 0; i < 3; i++) {
            var product = getOfferProduct(offer);
            entityManager.persist(product);
            products.add(product);
        }

        offer.setProducts(products);
        entityManager.persist(offer);

        this.offer = offer;

        txCommit();

        Mockito.when(productClient.getProducts(anyList())).thenReturn(
                products.stream().map(product -> OfferProductDto.builder()
                        .id(product.getProductId())
                        .rating(2.3)
                        .sellPrice(1)
                        .build())
                        .collect(Collectors.toList()));

        Mockito.when(feedbackClient.getFeedbacks(any())).thenReturn(List.of());
    }

    @AfterEach
    void cleanUp() {
//        txStart();
//
//
//        this.offer.getProducts()
//                .forEach(p -> entityManager.remove(p));
//        entityManager.remove(offer);
//
//        txCommit();
    }

    @Test
    void testOfferController() {
        txStart();
        var offers = offerService.getOffers(0, 10);

        MatcherAssert.assertThat(offers, notNullValue());

        var extractedOffer = offers.get(0);

        MatcherAssert.assertThat(offer.getTitle(), is(extractedOffer.getTitle()));
        MatcherAssert.assertThat(offer.getProducts().size(), is(extractedOffer.getProductDtoList().size()));
    }

    @Test
    void testProductController() {
        txStart();

        var existingProduct = this.offer.getProducts().get(0);
        var product = productService.getProduct(existingProduct.getProductId());

        MatcherAssert.assertThat(product.getId(), is(existingProduct.getProductId()));
        MatcherAssert.assertThat(product.getOffer().getTitle(), is(this.offer.getTitle()));
    }

    Offer getOffer() {
        return Offer.builder()
                .title("some")
                .ordering(random.nextInt())
                .build();
    }

    OfferProduct getOfferProduct(Offer offer) {
        return OfferProduct.builder()
                .productId(random.nextLong())
                .offer(offer)
                .ordering(random.nextInt())
                .build();
    }

    protected static void txStart() {
        if (!TestTransaction.isActive()) {
            TestTransaction.start();
        }
    }

    protected static void txCommit() {
        if (TestTransaction.isActive()) {
            TestTransaction.flagForCommit();
            TestTransaction.end();
        }
    }
}
