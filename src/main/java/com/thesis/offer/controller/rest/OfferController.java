package com.thesis.offer.controller.rest;

import com.thesis.offer.dto.offer.ExtendedOfferDto;
import com.thesis.offer.service.offer.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public List<ExtendedOfferDto> getOffers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                            @RequestParam(value = "page", required = false, defaultValue = "20") Integer size) {
        return offerService.getOffers(page, size);
    }

    @GetMapping("/{offerId}")
    public List<ExtendedOfferDto> getOffers(@PathVariable("offerId") Long offerId,
                                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                            @RequestParam(value = "page", required = false, defaultValue = "20") Integer size) {
        return offerService.getOffers(page, size);
    }
}
