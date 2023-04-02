package com.thesis.offer.service.offer;

import com.thesis.offer.dto.graphql.Offer;
import com.thesis.offer.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
        var offers = offerRepository.findAllOrderByOrder(PageRequest.of(page, size));
        return offers.stream()
                .map(this::makeOffer)
                .collect(Collectors.toList());
    }

    private Offer makeOffer(com.thesis.offer.model.Offer offer) {
        return Offer.builder()
                .id(offer.getId())
                .title(offer.getTitle())
                .build();
    }
}
