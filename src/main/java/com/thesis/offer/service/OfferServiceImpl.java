package com.thesis.offer.service;

import com.thesis.offer.dto.OfferDto;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    public List<OfferDto> getOffers(@Nullable String user) {
        // not implemented
        return null;
    }
}
