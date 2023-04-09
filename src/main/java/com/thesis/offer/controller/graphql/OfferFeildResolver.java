package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.thesis.offer.dto.graphql.Offer;
import com.thesis.offer.dto.graphql.Product;
import com.thesis.offer.service.dataloader.OfferProductLoader;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
@RequiredArgsConstructor
public class OfferFeildResolver {

    @DgsData(parentType = "Offer")
    public CompletableFuture<List<Product>> products(DgsDataFetchingEnvironment environment) {
        Offer offer = environment.getSource();
        return environment.<Long, List<Product>>getDataLoader(OfferProductLoader.class)
                .load(offer.getId());
    }
}
