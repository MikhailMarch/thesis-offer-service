package com.thesis.offer.controller.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.thesis.offer.dto.graphql.ExtendedProduct;

import java.util.Map;

@DgsComponent
public class EntityFetcher {

    @DgsEntityFetcher(name = "ExtendedProduct")
    public ExtendedProduct product(Map<String, Object> values,
                                   DgsDataFetchingEnvironment environment) {
        return new ExtendedProduct(Long.parseLong(String.valueOf(values.get("id"))));
    }
}
