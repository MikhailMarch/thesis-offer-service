package com.thesis.offer.service.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.thesis.offer.dto.graphql.Offer;
import com.thesis.offer.model.view.ProductOfferView;
import com.thesis.offer.repository.OfferProductRepository;
import lombok.RequiredArgsConstructor;
import org.dataloader.MappedBatchLoader;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "offersByProductIdLoader")
@RequiredArgsConstructor
public class ExtendedProductOfferLoader implements MappedBatchLoader<Long, Offer> {

    private final OfferProductRepository offerProductRepository;

    @Override
    public CompletionStage<Map<Long, Offer>> load(Set<Long> keys) {
        var offers = offerProductRepository.getProductOffers(keys, ProductOfferView.class);

        return CompletableFuture.completedFuture(offers.stream()
                .collect(Collectors.toMap(ProductOfferView::getProductId, view -> new Offer(view.getOfferId(), view.getTitle()))));
    }
}
