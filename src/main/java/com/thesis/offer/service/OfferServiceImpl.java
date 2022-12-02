package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    public OfferDto getOffer(@Nullable String user) {
        // not implemented
        return null;
    }
}
