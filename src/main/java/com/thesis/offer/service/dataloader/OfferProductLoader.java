package com.thesis.offer.service.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.thesis.offer.dto.graphql.Product;
import com.thesis.offer.model.OfferProduct;
import com.thesis.offer.repository.OfferProductRepository;
import lombok.RequiredArgsConstructor;
import org.dataloader.MappedBatchLoader;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "productIdsByOfferIds")
@RequiredArgsConstructor
public class OfferProductLoader implements MappedBatchLoader<Long, List<Product>> {

    private final OfferProductRepository offerProductRepository;

    @Override
    public CompletionStage<Map<Long, List<Product>>> load(Set<Long> offerIds) {
        var products = offerProductRepository.findAllByOfferIdIn(offerIds);

        return CompletableFuture.completedFuture(
                products.stream()
                    .sorted(Comparator.comparing(OfferProduct::getOrdering))
                    .collect(Collectors.groupingBy(
                            product -> product.getOffer().getId(),
                            LinkedHashMap::new,
                            Collectors.mapping(product -> new Product(product.getProductId()), Collectors.toList()))));
    }
}
