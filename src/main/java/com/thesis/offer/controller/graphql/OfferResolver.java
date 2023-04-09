package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.thesis.offer.dto.graphql.Offer;
import com.thesis.offer.service.offer.GqlOfferService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class OfferResolver {

    private final GqlOfferService offerService;

    @DgsQuery
    public List<Offer> getOffers(@InputArgument Integer page,
                                 @InputArgument Integer size,
                                 DgsDataFetchingEnvironment env) {
        return offerService.getOffers(page, size);
    }

    @DgsQuery
    public Offer getOffer(@InputArgument Long offerId,
                          @InputArgument Integer page,
                          @InputArgument Integer size,
                          DgsDataFetchingEnvironment env) {
        return offerService.getOffer(offerId, page, size);
    }
}
