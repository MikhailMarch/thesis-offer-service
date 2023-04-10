package com.thesis.offer.service.offer;

import com.thesis.offer.dto.offer.ExtendedOfferDto;

import java.util.List;

public interface OfferService {

    List<ExtendedOfferDto> getOffers(Integer page,
                                     Integer size);

    ExtendedOfferDto getOffer(Long offerId,
                              Integer page,
                              Integer size);
}
