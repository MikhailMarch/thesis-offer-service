package com.thesis.offer.service.offer;

import com.thesis.offer.dto.graphql.Offer;
import com.thesis.offer.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GqlOfferServiceImpl implements GqlOfferService {

    private final OfferRepository offerRepository;

    @Override
    public List<Offer> getOffers(Integer page,
                                 Integer size) {
        var offers = offerRepository.findAll(PageRequest.of(page, size, Sort.by("ordering")));
        return offers.stream()
                .map(this::makeOffer)
                .collect(Collectors.toList());
    }

    @Override
    public Offer getOffer(Long offerId,
                          Integer page,
                          Integer size) {
        var offer = offerRepository.findById(offerId)
                .orElseThrow();
        return makeOffer(offer);
    }

    private Offer makeOffer(com.thesis.offer.model.Offer offer) {
        return Offer.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .build();
    }
}
