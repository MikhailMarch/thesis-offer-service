package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;
import org.springframework.lang.Nullable;

import java.util.List;

public interface OfferService {

    List<OfferDto> getOffers(@Nullable String user);
}
