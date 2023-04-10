package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.thesis.offer.dto.graphql.ExtendedProduct;
import com.thesis.offer.service.product.GqlProductService;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class FavoriteResolver {

    private final GqlProductService gqlProductService;

    @DgsQuery
    public ExtendedProduct getFavorite(@InputArgument Integer userId,
                                       DgsDataFetchingEnvironment env) {
        return gqlProductService.getFavorite(userId.longValue());
    }
}
