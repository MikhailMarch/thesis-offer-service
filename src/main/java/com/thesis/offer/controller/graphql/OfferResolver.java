package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.thesis.offer.dto.OfferDto;
import com.thesis.offer.service.OfferService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class OfferResolver {

    private final OfferService offerService;

    @DgsQuery
    public List<OfferDto> getOffers(@InputArgument String user,
                                    DgsDataFetchingEnvironment env) {
        return offerService.getOffers(user);
    }
}
