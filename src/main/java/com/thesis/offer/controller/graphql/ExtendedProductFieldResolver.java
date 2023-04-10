package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.thesis.offer.dto.graphql.Product;
import com.thesis.offer.model.Offer;
import com.thesis.offer.service.dataloader.ExtendedProductOfferLoader;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@DgsComponent
@RequiredArgsConstructor
public class ExtendedProductFieldResolver {

    @DgsData(parentType = "ExtendedProduct")
    public CompletableFuture<Offer> offer(DgsDataFetchingEnvironment environment) {
        Product product = environment.getSource();

        return environment.<Long, Offer>getDataLoader(ExtendedProductOfferLoader.class)
                .load(product.getId());
    }
}
