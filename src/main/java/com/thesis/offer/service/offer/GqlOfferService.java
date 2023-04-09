package com.thesis.offer.service.offer;

import com.thesis.offer.dto.graphql.Offer;

import java.util.List;

public interface GqlOfferService {

    List<Offer> getOffers(Integer page,
                          Integer size);

    Offer getOffer(Long offerId,
                         Integer page,
                         Integer size);
}
