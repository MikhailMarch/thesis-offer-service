package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;
import org.springframework.lang.Nullable;

public interface OfferService {

    OfferDto getOffer(@Nullable String user);
}
