package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;

import java.util.List;

public interface OfferService {

    List<OfferDto> getOffers(Integer page,
                             Integer size);

    OfferDto getOffer(Long offerId,
                      Integer page,
                      Integer size);
}
