package com.thesis.offer.controller.rest;

import com.thesis.offer.dto.OfferDto;
import com.thesis.offer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public List<OfferDto> getOffers(@RequestParam("userId") Long userId) {
        return offerService.getOffers(String.valueOf(userId));
    }
}
